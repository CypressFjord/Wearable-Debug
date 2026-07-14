package test.hook.debug.xp;

import android.content.res.Resources;

import com.github.kyuubiran.ezxhelper.EzXHelper;

import de.robv.android.xposed.callbacks.XC_InitPackageResources;
import test.hook.debug.R;

public class Res {
    public static int firmware_warning = -1;
    public static int firmware_warning_title = -1;
    public static int fail_watchface = -1;
    public static int fail_firmware = -1;
    public static int fail_log = -1;
    public static int success_log = -1;
    public static int main = -1;
    public static int options = -1;
    public static int zen_sync_mode = -1;
    public static int radio_no_hook = -1;
    public static int radio_old_sync = -1;
    public static int radio_new_sync = -1;
//    public static int btn_check = -1;

    public static void init(XC_InitPackageResources.InitPackageResourcesParam resparam) {
        Resources modRes = EzXHelper.getModuleRes();
        firmware_warning = resparam.res.addResource(modRes, R.string.firmware_warning);
        firmware_warning_title = resparam.res.addResource(modRes, R.string.firmware_warning_title);
        fail_watchface = resparam.res.addResource(modRes, R.string.fail_watchface);
        fail_firmware = resparam.res.addResource(modRes, R.string.fail_firmware);
        fail_log = resparam.res.addResource(modRes, R.string.fail_log);
        success_log = resparam.res.addResource(modRes, R.string.success_log);
        main = resparam.res.addResource(modRes, R.layout.wearable_main);
        options = resparam.res.addResource(modRes, R.id.wearable_options);
        zen_sync_mode = resparam.res.addResource(modRes, R.layout.zen_sync_mode);
        radio_no_hook = resparam.res.addResource(modRes, R.id.radio_no_hook);
        radio_old_sync = resparam.res.addResource(modRes, R.id.radio_old_sync);
        radio_new_sync = resparam.res.addResource(modRes, R.id.radio_new_sync);
//        btn_check = resparam.res.addResource(modRes, R.id.btn_check);
    }
}
