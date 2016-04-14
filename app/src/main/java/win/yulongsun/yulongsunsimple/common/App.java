package win.yulongsun.yulongsunsimple.common;

import android.app.Application;
import android.content.Context;

/**
 * @Project YulongsunSimple
 * @Packate win.yulongsun.yulongsunsimple.common
 * @Author yulongsun
 * @Email yulongsun@gmail.com
 * @Date 2016/4/14
 * @Version 1.0.0
 * @Description
 */
public class App extends Application {
    private static Context sApplicationContext = null;

    @Override public void onCreate() {
        super.onCreate();
        sApplicationContext = this;
    }

    public static Context getContext() {
        return sApplicationContext;
    }
}