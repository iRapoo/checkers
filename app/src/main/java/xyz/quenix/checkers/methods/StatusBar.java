package xyz.quenix.checkers.methods;

import android.app.Activity;
import android.graphics.Color;
import android.os.Build;
import android.view.View;
import android.view.WindowManager;

public class StatusBar {

    public static void setStatusBarTransparent(Activity activity) {
        activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        activity.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        activity.getWindow().setStatusBarColor(Color.TRANSPARENT);
    }

    public static void setLightStatusBar(Activity activity, int bgColor) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            int flags = activity.getWindow().getDecorView().getSystemUiVisibility();
            flags |= View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
            activity.getWindow().getDecorView().setSystemUiVisibility(flags);
            activity.getWindow().setStatusBarColor(bgColor);
        }
    }

    public static void clearLightStatusBar(Activity activity, int bgColor) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            int flags = activity.getWindow().getDecorView().getSystemUiVisibility();
            flags = flags ^ View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
            activity.getWindow().getDecorView().setSystemUiVisibility(flags);
            activity.getWindow().setStatusBarColor(bgColor);
        }
    }

    public static void setBundleBlack(Activity activity) {
        clearLightStatusBar(activity, Color.TRANSPARENT);
        setStatusBarTransparent(activity);
    }

    public static void setBundleWhite(Activity activity) {
        clearLightStatusBar(activity, Color.TRANSPARENT);
    }

}
