package win.yulongsun.yulongsunlib.net;

import java.io.Serializable;

/**
 * @Project YulongsunSimple
 * @Packate win.yulongsun.yulongsunlib.net
 * @Author yulongsun
 * @Email yulongsun@gmail.com
 * @Date 2016/4/13
 * @Version 1.0.0
 * @Description
 */
public class RequestParameter implements Serializable{
    private String name;
    private String value;

    public RequestParameter(String name, String value) {
        this.name = name;
        this.value = value;
    }

}
