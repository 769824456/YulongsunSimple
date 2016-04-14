package win.yulongsun.yulongsunsimple.net.manager;

import java.io.File;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import win.yulongsun.yulongsunsimple.bean.NewsList;
import win.yulongsun.yulongsunsimple.common.App;
import win.yulongsun.yulongsunsimple.net.service.ZhiHuService;

/**
 * @Project YulongsunSimple
 * @Packate win.yulongsun.yulongsunsimple.net.manager
 * @Author yulongsun
 * @Email yulongsun@gmail.com
 * @Date 2016/4/14
 * @Version 1.0.0
 * @Description
 */
public class RetrofitManager {


    public static final  String       BASE_ZHIHU_URL = "http://news-at.zhihu.com/api/4/";
    private static final int          CONNECT_TIME   = 15;
    private static final int          CACHE_SIZE     = 1024 * 1024 * 100;
    private static       OkHttpClient sOkHttpClient  = null;
    private              ZhiHuService mZhiHuService  = null;

    public static RetrofitManager builder() {
        return new RetrofitManager();
    }

    public RetrofitManager() {

        initOkHttpClient();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_ZHIHU_URL)
                .client(sOkHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        mZhiHuService = retrofit.create(ZhiHuService.class);


    }

    /*初始化OkHttp3*/
    private void initOkHttpClient() {
        if (sOkHttpClient == null) {
            synchronized (RetrofitManager.class) {
                if (sOkHttpClient == null) {
                    Cache httpCache = new Cache(new File(App.getContext().getCacheDir(), "HttpCache"), CACHE_SIZE);
                    sOkHttpClient = new OkHttpClient.Builder()
                            .cache(httpCache)
//                            .addInterceptor()
                            .connectTimeout(CONNECT_TIME, TimeUnit.SECONDS)
                            .build();
                }
            }
        }
    }


    /*获取最新新闻*/
    public Observable<NewsList> getLatestNews() {
        return mZhiHuService.getLatestNews();
    }
}
