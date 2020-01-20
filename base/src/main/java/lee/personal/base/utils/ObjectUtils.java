package lee.personal.base.utils;

import android.os.Build;

import androidx.annotation.Nullable;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

/**
 * Created on 2020/1/20 15:09.
 * 对象对比 校验的工具类
 *
 * @author LEE
 */
@SuppressWarnings("unused")
public class ObjectUtils {

    @SuppressWarnings("EqualsReplaceableByObjectsCall")
    public static boolean equals(Object a, Object b) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            return Objects.equals(a, b);
        } else {
            return (a == b) || (a != null && a.equals(b));
        }
    }

    public static <T> T checkNotNull(T t, String message) {
        if (t == null) {
            throw new NullPointerException(message);
        }
        return t;
    }

    @SuppressWarnings("unchecked")
    public static <T> T cast(Object obj) {
        return (T) obj;
    }

    @NotNull
    public static <T> T get(T src, T def) {
        return src != null ? src : def;
    }
}
