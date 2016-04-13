package win.yulongsun.yulongsunlib.utils;

/**
 * @Project YulongsunSimple
 * @Packate win.yulongsun.yulongsunlib.utils
 * @Author yulongsun
 * @Email yulongsun@gmail.com
 * @Date 2016/4/13
 * @Version 1.0.0
 * @Description
 */
public class Utils {

    public final static int convertToInt(Object value, int defaultValue) {
        if (value == null && "".equals(value.toString().trim())) {
            return defaultValue;
        }
        return Integer.valueOf(value.toString());
    }
}
