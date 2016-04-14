package win.yulongsun.yulongsunsimple.net.service;

import retrofit2.http.GET;
import rx.Observable;
import win.yulongsun.yulongsunsimple.bean.NewsList;

/**
 * @Project YulongsunSimple
 * @Packate win.yulongsun.yulongsunsimple.net.service
 * @Author yulongsun
 * @Email yulongsun@gmail.com
 * @Date 2016/4/14
 * @Version 1.0.0
 * @Description
 */
public interface ZhiHuService {

    @GET("stories/latest") Observable<NewsList> getLatestNews();


}
