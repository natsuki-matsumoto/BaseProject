package Util;

import android.support.annotation.NonNull;
import android.text.TextUtils;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Reflection(リフレクション) Util.
 *
 * リフレクション - クラス名・メソッド名などの文字列から、インスタンス生成,メソッド実行などが行える.
 */
public final class ReflectionUtil {

    /**
     * class名から引数なしのInstanceを作成.
     *
     * @param className クラス名
     * @return Instance
     */
    public static Object getInstanceFromClassName(@NonNull String className) {
        _CodeUtil.nonNull(new Object[]{className});

        Object retInstance = null;

        if (TextUtils.isEmpty(className)) {
            return null;
        }

        try {
            Class<?> aClass = Class.forName(className);
            retInstance = aClass.newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

        return retInstance;
    }

    /**
     * class名から引数ありのInstanceを作成.
     *
     * @param className クラス名
     * @param paramClassArray 引数のクラス型Array
     * @param params 引数Array
     * @return Instance
     */
    public static Object getInstanceFromClassName(@NonNull String className, @NonNull Class[] paramClassArray, @NonNull Object[] params) {
        Object retInstance = null;

        if (_CodeUtil.isNull(new Object[]{className, paramClassArray, params})) {
            return null;
        }

        try {
            Class<?> aClass = Class.forName(className);
            Constructor<?> constructor = aClass.getConstructor(paramClassArray);
            retInstance = constructor.newInstance(params);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        return retInstance;
    }
}
