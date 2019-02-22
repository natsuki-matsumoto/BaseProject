package Util;

import android.util.Log;

/**
 * Log Util.
 */
public final class LogUtil {

    /** Logタグ. */
    private static final String TAG_EXCEPTION = "Exception";
    private static final String TAG_METHOD_CALL = "Method_Call";

    /**
     * private コンストラクタ.
     */
    private LogUtil() {
    }

    /**
     * Log.d
     *
     * @param tag
     * @param msg
     */
    public static void d(String tag, String msg) {
        Log.d(tag, String.format(getStackTraceInfo(), msg));
    }

    /**
     * Log.e
     *
     * @param tag
     * @param msg
     */
    public static void e(String tag, String msg) {
        Log.e(tag, String.format(getStackTraceInfo(), msg));
    }

    /**
     * Exception Log.
     *
     * @param e
     */
    public static void stackTrace(final Throwable e) {
        Log.i(TAG_EXCEPTION, String.format(getStackTraceInfo(), ""), e);
    }

    /**
     * method call Log.
     * メソッドの先頭で呼び出し.
     */
    public static void methodCall() {
        Log.i(TAG_METHOD_CALL, String.format(getStackTraceInfo(), ""));
    }

    /**
     * Stack Trace からlogに出力する文字列を取得.
     * Class名.メソッド名 - %s (caller).
     *
     * @return
     */
    private static String getStackTraceInfo() {
        StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[4];
        String fullName = stackTraceElement.getClassName(); // package名.クラス名
        String packageName = fullName.substring(0, fullName.lastIndexOf(".")); // package名
        String className = fullName.substring(fullName.lastIndexOf(".") + 1); // クラス名
        String classFileName = stackTraceElement.getFileName(); // クラスファイル名
        String methodName = stackTraceElement.getMethodName(); // メソッド名
        int lineNumber = stackTraceElement.getLineNumber(); // 行数

        String caller = String.format("(%s:%d)", classFileName, lineNumber); // caller
        return new StringBuffer(className).append(".").append(methodName).append(" - ").append("%s").append(" ").append(caller).toString();
    }
}
