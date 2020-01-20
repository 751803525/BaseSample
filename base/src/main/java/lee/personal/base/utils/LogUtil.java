package lee.personal.base.utils;

import android.util.Log;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Created on 2020/1/20 15:09.
 * 日志工具类
 *
 * @author LEE
 */
@SuppressWarnings("unused")
public class LogUtil {

    public enum Level {
        /**
         * 全部输出
         */
        VERBOSE(2),
        DEBUG(3),
        INFO(4),
        WARN(5),
        ERROR(6),
        /**
         * 全部不输出
         */
        ASSERT(10);
        private int level;

        Level(int level) {
            this.level = level;
        }
    }

    public static Level level = Level.VERBOSE;

    public static boolean canLog(Level l) {
        return !(level.level > l.level);
    }


    public static void v(Serializable s) {
        if (level.level > Level.VERBOSE.level) return;
        Log.v(defaultTag(), s.toString());
    }

    public static void v(String tag, Serializable s) {
        if (level.level > Level.VERBOSE.level) return;
        Log.v(tag, s.toString());
    }

    public static void d(Serializable s) {
        if (level.level > Level.DEBUG.level) return;
        Log.d(defaultTag(), s.toString());
    }

    public static void d(String tag, Serializable s) {
        if (level.level > Level.DEBUG.level) return;
        Log.d(tag, s.toString());
    }

    public static void i(Serializable s) {
        if (level.level > Level.INFO.level) return;
        Log.i(defaultTag(), s.toString());
    }

    public static void i(String tag, Serializable s) {
        if (level.level > Level.INFO.level) return;
        Log.i(tag, s.toString());
    }

    public static void w(Serializable s) {
        if (level.level > Level.WARN.level) return;
        Log.w(defaultTag(), s.toString());
    }

    public static void w(String tag, Serializable s) {
        if (level.level > Level.WARN.level) return;
        Log.w(tag, s.toString());
    }

    public static void e(Serializable s) {
        if (level.level > Level.ERROR.level) return;
        Log.e(defaultTag(), s.toString());
    }

    public static void e(String tag, Serializable s) {
        if (level.level > Level.ERROR.level) return;
        Log.e(tag, s.toString());
    }


    public static void print(Map map) {
        if (level.level > Level.INFO.level) return;
        if (map == null || map.size() == 0) return;
        StringBuilder builder = new StringBuilder();
        for (Object o : map.keySet()) {
            builder.append(o)
                    .append("=")
                    .append(map.get(o))
                    .append("\n");
        }
        i(map.size());
        i(builder);
    }

    public static void print(Collection c) {
        if (level.level > Level.INFO.level) return;
        if (c == null || c.size() == 0) return;
        StringBuilder builder = new StringBuilder();
        Object[] a = c.toArray();
        int length = a.length;
        for (int i = 0; i < length; i++) {
            builder.append(i)
                    .append("=")
                    .append(a[i])
                    .append("\n");
        }
        i(length);
        i(builder);
    }

    public static class Hex {
        public static void w(String tag, byte[] bytes) {
            LogUtil.i(tag, toHexString(bytes));
        }

        public static void i(String tag, byte[] bytes) {
            LogUtil.i(tag, toHexString(bytes));
        }

        public static void i(String tag, List<Byte> bytes) {
            LogUtil.i(tag, toHexString(bytes));
        }

        public static void d(String tag, byte[] bytes) {
            LogUtil.i(tag, toHexString(bytes));
        }

        public static String toHexString(byte[] bytes) {
            String[] arr = new String[bytes.length];
            for (int i = 0; i < bytes.length; i++) {
                String hex = Integer.toHexString(bytes[i] & 0xFF).toUpperCase();
                if (hex.length() == 1) {
                    hex = '0' + hex;
                }
                arr[i] = "0x" + hex;
            }
            return Arrays.toString(arr);
        }

        public static String toHexString(List<Byte> bytes) {
            String[] arr = new String[bytes.size()];
            for (int i = 0; i < bytes.size(); i++) {
                String hex = Integer.toHexString(bytes.get(i) & 0xFF).toUpperCase();
                if (hex.length() == 1) {
                    hex = '0' + hex;
                }
                arr[i] = "0x" + hex;
            }
            return Arrays.toString(arr);
        }
    }

    private static String defaultTag() {
        StackTraceElement[] trace = Thread.currentThread().getStackTrace();
        for (int i = 1; i < trace.length; i++) {
            String className = trace[i].getClassName();
            if (!StringUtils.equals(className, Thread.class.getName()) &&
                    !StringUtils.equals(className, LogUtil.class.getName())) {
                return className;
            }
        }
        return LogUtil.class.getName();
    }
}
