package test.hook.debug.xp;

import android.view.View;

import com.github.kyuubiran.ezxhelper.ClassUtils;
import com.github.kyuubiran.ezxhelper.HookFactory;
import com.github.kyuubiran.ezxhelper.Log;

import java.lang.reflect.Method;
import java.util.Collections;

import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedHelpers;

public class DisableAd {
    /**
     * 国际版3.33.6i出现Banner广告，拦截广告加载
     */
    public static void interceptAd(ClassLoader classLoader) {
        try {
            Class<?> impl = ClassUtils.loadClass("com.fitness.banner.export.BannerImpl", classLoader);
            for (Method method : impl.getDeclaredMethods()) {
                if (method.getName().startsWith("getBannerListAsync")) {
                    HookFactory.createMethodHook(method, hookFactory -> hookFactory.replace(methodHookParam -> null));
                } else if (method.getName().startsWith("getBannerList")) {
                    HookFactory.createMethodHook(method, hookFactory -> hookFactory.replace(methodHookParam -> Collections.emptyList()));
                }
            }
        } catch (ClassNotFoundException e) {
            Log.e("Failed to disable ad", e);
        }
    }

    public static void disableReport(ClassLoader classLoader) {
        try {
            Class<?> reportImpl = ClassUtils.loadClass("com.xiaomi.fitness.statistics.OnetrackImpl", classLoader);
            for (Method method : reportImpl.getDeclaredMethods()) {
                if (!"reportData".equals(method.getName())) {
                    continue;
                }
                HookFactory.createMethodHook(method, hookFactory -> hookFactory.replace(methodHookParam -> null));
            }

        } catch (ClassNotFoundException e) {
            Log.e("Failed to disable report", e);
        }
    }

    /**
     * 隐藏蚂蚁阿福横幅
     *
     * @param classLoader
     */
    public static void hideAqView(ClassLoader classLoader) {
        Class<?> AqViewClass;
        try {
            AqViewClass = classLoader.loadClass("com.xiaomi.fitness.view.AqView");
        } catch (ClassNotFoundException e) {
            return;
        }
        XposedHelpers.findAndHookMethod("com.xiaomi.fitness.util.ExtUtilKt", classLoader, "visible", android.view.View.class, new XC_MethodHook() {
            @Override
            protected void beforeHookedMethod(XC_MethodHook.MethodHookParam param) throws Throwable {
                super.beforeHookedMethod(param);
                if (((View) param.args[0]).getClass().equals(AqViewClass)) param.setResult(null);
            }
        });
    }
}
