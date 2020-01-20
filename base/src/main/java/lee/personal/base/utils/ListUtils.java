package lee.personal.base.utils;

import java.util.Collection;
import java.util.Map;

/**
 * Created on 2020/1/20 15:09.
 * list/map 工具类
 *
 * @author LEE
 */
@SuppressWarnings("unused")
public class ListUtils {

    public static boolean isEmpty(Collection c) {
        return c == null || c.size() == 0;
    }

    public static boolean isEmpty(Map map) {
        return map == null || map.size() == 0;
    }
}
