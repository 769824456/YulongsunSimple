package win.yulongsun.yulongsunlib.utils;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.widget.ImageView;

import com.bumptech.glide.DrawableRequestBuilder;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;

/**
 * @Project YulongsunSimple
 * @Packate win.yulongsun.yulongsunlib.utils
 * @Author yulongsun
 * @Email yulongsun@gmail.com
 * @Date 2016/4/13
 * @Version 1.0.0
 * @Description 图片加载类
 */
public class ImageLoadManager {

    private static volatile ImageLoadManager       sImageLoadManager;
    private                 RequestManager         requestManager;
    private                 DrawableRequestBuilder builder;

    public static ImageLoadManager getInstance() {
        if (sImageLoadManager == null) {
            synchronized (ImageLoadManager.class) {
                ImageLoadManager loadManager = sImageLoadManager;
                if (loadManager == null) {
                    loadManager = new ImageLoadManager();
                    sImageLoadManager = loadManager;
                }
            }
        }
        return sImageLoadManager;
    }

    ///////////////////////////////////////////////////////////////////////////
    // with
    ///////////////////////////////////////////////////////////////////////////

    public ImageLoadManager with(Context context) {
        requestManager = Glide.with(context);
        return this;
    }

    public ImageLoadManager with(Activity activity) {
        requestManager = Glide.with(activity);
        return this;
    }

    public ImageLoadManager with(FragmentActivity fragmentActivity) {
        requestManager = Glide.with(fragmentActivity);
        return this;
    }

    public ImageLoadManager with(Fragment fragment) {
        requestManager = Glide.with(fragment);
        return this;
    }

    public ImageLoadManager with(android.app.Fragment fragment) {
        requestManager = Glide.with(fragment);
        return this;
    }


    ///////////////////////////////////////////////////////////////////////////
    // load
    ///////////////////////////////////////////////////////////////////////////

    public ImageLoadManager load(String url) {
        builder = requestManager.load(url).diskCacheStrategy(DiskCacheStrategy.ALL);
        return this;
    }

    public ImageLoadManager load(int resId) {
        builder = requestManager.load(resId).diskCacheStrategy(DiskCacheStrategy.ALL);
        return this;
    }

    public ImageLoadManager load(Uri uri) {
        builder = requestManager.load(uri).diskCacheStrategy(DiskCacheStrategy.ALL);
        return this;
    }

    public ImageLoadManager needLruCache(boolean needLruCache) {
        builder = builder.skipMemoryCache(!needLruCache);
        return this;
    }

    public ImageLoadManager setListener(RequestListener listener) {
//        builder = builder.listener(listener);
        return this;
    }


    public ImageLoadManager setSize(int width, int height) {
        builder = builder.override(width, height);
        return this;
    }

    public ImageLoadManager fitCenter() {
        builder = builder.fitCenter();
        return this;
    }

    public ImageLoadManager centerCrop() {
        builder = builder.centerCrop();
        return this;
    }

    public ImageLoadManager setLoading(int resId) {
        builder = builder.placeholder(resId);
        return this;
    }

    public ImageLoadManager setError(int resId) {
        builder = builder.error(resId);
        return this;
    }

    public void into(ImageView imageView) {
        builder.into(imageView);
    }

    public void into(GlideDrawableImageViewTarget target) {
        builder.into(target);
    }

//    public void load(String url, ImageView imageView, boolean needLruCache){
//        requestManager.load(url).skipMemoryCache(needLruCache).diskCacheStrategy(DiskCacheStrategy.ALL).into(imageView);
//    }
//
//    public void load(String url, ImageView imageView){
//        load(url, imageView, false);
//    }
//
//    public void load(String url, ImageView imageView, int width, int height, boolean needLruCache){
//        requestManager.load(url).override(width, height).skipMemoryCache(needLruCache).diskCacheStrategy(DiskCacheStrategy.ALL).into(imageView);
//    }
//
//    public void load(String url, ImageView imageView, int width, int height){
//        load(url, imageView, width, height, false);
//    }

}
