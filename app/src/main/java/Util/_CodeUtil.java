package Util;

/**
 * Classではなくコード関係のUtil
 */
public final class _CodeUtil {

    /**
     * NonNUllアノテーション 補助メソッド.
     * NonNullアノテーションを設定したパラメータに対してNullチェックを行った場合、
     * Code Inspectionで警告が出るため、その対応.
     *
     * http://yuki312.blogspot.com/2016/02/android-nonnull.html
     * https://techlife.cookpad.com/entry/2015/02/20/195000
     *
     * @param object @NonNullパラメータ.
     */
    public static void nonNull(Object object) {
        if (object == null) {
            throw new IllegalArgumentException("Engine must not be null.");
        }
    }

    public static void nonNull(Object[] objects) {
        if (objects == null
                || objects.length == 0) {
            return;
        }

        for (Object o : objects) {
            nonNull(o);
        }
    }

    /**
     * Nullチェック.
     *
     * @param object @NonNullパラメータ.
     * @return true:NullPointerException
     */
    public static boolean isNull(Object object) {
        try {
            nonNull(object);
        } catch (Exception e) {
            return true;
        }

        return false;
    }

    public static boolean isNull(Object[] objects) {
        try {
            nonNull(objects);
        } catch (Exception e) {
            return true;
        }

        return false;
    }
}
