package lee.personal.base.utils;

import com.google.gson.Gson;

/**
 * Created on 2020/1/20 15:09.
 * gson 工具类
 *
 * @author LEE
 */
public class GsonUtils {

    private static final Gson gson = new Gson();

    public static String toJson(Object obj) {
        return gson.toJson(obj);
    }

    public static <T> T fromJson(String json, Class<T> clz) {
        return gson.fromJson(json, clz);
    }
}
