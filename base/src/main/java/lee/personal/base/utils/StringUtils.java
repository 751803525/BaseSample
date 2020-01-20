package lee.personal.base.utils;


/**
 * Created on 2020/1/20 15:10.
 * string 工具类
 *
 * @author LEE
 */
@SuppressWarnings("unused")
public class StringUtils {

    @SuppressWarnings("EqualsReplaceableByObjectsCall")
    public static boolean equals(String a, String b) {
        return (a == b) || (a != null && a.equals(b));
    }

    public static boolean isEmpty(CharSequence str) {
        return str == null || str.length() == 0;
    }

    public static String get(String... args) {
        for (String arg : args) {
            if (!isEmpty(arg)) {
                return arg;
            }
        }
        return "";
    }
}
