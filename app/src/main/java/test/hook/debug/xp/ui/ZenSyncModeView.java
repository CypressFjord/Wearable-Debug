package test.hook.debug.xp.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

import test.hook.debug.xp.Res;

public class ZenSyncModeView {
    private final View view;
    private final RadioButton radioNoHook;
    private final RadioButton radioOldSync;
    private final RadioButton radioNewSync;
//    private final Button btnCheck;
//    private final XSharedPreferences xSharedPreferences;

    private ZenSyncModeView(View view) {
        this.view = view;
        this.radioNoHook = view.findViewById(Res.radio_no_hook);
        this.radioOldSync = view.findViewById(Res.radio_old_sync);
        this.radioNewSync = view.findViewById(Res.radio_new_sync);
//        this.btnCheck = view.findViewById(Res.btn_check);
//        this.xSharedPreferences = new XSharedPreferences(BuildConfig.APPLICATION_ID, "wearable_debug_preferences");
//        this.radioNoHook.setOnClickListener(v -> {
////            xSharedPreferences.
//            writeZenSyncMode(v.getContext(), 0);
//        });
//        this.radioOldSync.setOnClickListener(v -> {
//            writeZenSyncMode(v.getContext(), 1);
//        });
//        this.radioNewSync.setOnClickListener(v -> {
//            writeZenSyncMode(v.getContext(), 2);
//        });
//        this.btnCheck.setOnClickListener(v -> {
//
//        });

    }

    public static ZenSyncModeView create(Context context) {
        return new ZenSyncModeView(LayoutInflater.from(context).inflate(Res.zen_sync_mode, null));
    }

    public View getView() {
        return view;
    }

//    public static DialogInterface.OnClickListener saveListener = (dialog, which) -> {
//        int value=0;
//        if (this.radioNoHook.isChecked()) value=0;
//        else if (this.radioOldSync.isChecked()) value=1;
//        else if (this.radioNewSync.isChecked()) value=2;
//        this.writeZenSyncMode(this.getContext(), value);
//    };

    public int getSelectedMode() {
        if (this.radioNoHook.isChecked()) return 0;
        else if (this.radioOldSync.isChecked()) return 1;
        else if (this.radioNewSync.isChecked()) return 2;
        return 0;
    }

    public void putZenSyncMode(int mode) {
        switch (mode) {
            case 0:
                this.radioNoHook.setChecked(true);
                break;
            case 1:
                this.radioOldSync.setChecked(true);
                break;
            case 2:
                this.radioNewSync.setChecked(true);
        }
    }

}
