package test.hook.debug.xp.utils;

public class Log {
    public static void ix(String msg) {
        com.github.kyuubiran.ezxhelper.Log.ix(msg, null);
    }

    public static void ex(String msg, Throwable e) {
        com.github.kyuubiran.ezxhelper.Log.ex(msg, e);
    }

    public static void ex(String msg) {
        com.github.kyuubiran.ezxhelper.Log.ex(msg, null);
    }

    public static void dx(String msg) {
        com.github.kyuubiran.ezxhelper.Log.dx(msg, null);
    }

    public static void wx(String msg) {
        com.github.kyuubiran.ezxhelper.Log.wx(msg, null);
    }
}
