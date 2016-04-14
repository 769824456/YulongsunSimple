package win.yulongsun.yulongsunsimple;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;
import win.yulongsun.yulongsunsimple.bean.NewsList;
import win.yulongsun.yulongsunsimple.net.manager.RetrofitManager;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RetrofitManager.builder()
                .getLatestNews()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(new Action0() {
                    @Override public void call() {
                        Log.d(TAG, "call: doOnSubscribe");
                    }
                })
                .map(new Func1<NewsList, NewsList>() {
                    @Override public NewsList call(NewsList newsList) {
                        return newsList;
                    }
                })
                .subscribe(new Action1<NewsList>() {
                    @Override public void call(NewsList newsList) {
                        Log.d(TAG, "call: " + newsList.date);
                    }
                }, new Action1<Throwable>() {
                    @Override public void call(Throwable throwable) {
                        Log.d(TAG, "call: Throwable" + throwable.getMessage());
                    }
                });
    }
}
