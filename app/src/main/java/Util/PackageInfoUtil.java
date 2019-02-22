package Util;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * PackageInfo Util
 */
public final class PackageInfoUtil {

    /**
     * プロジェクト内からActivity一覧を取得.
     *
     * @return
     */
    public static List<ActivityInfo> getActivityInfoArray(@NonNull Context context) {
        _CodeUtil.nonNull(new Object[]{context});

        List<ActivityInfo> retActivityInfoArray = new ArrayList<>();

        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), PackageManager.GET_ACTIVITIES);
            retActivityInfoArray = new ArrayList<>(Arrays.asList(packageInfo.activities));
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

        return retActivityInfoArray;
    }
}
