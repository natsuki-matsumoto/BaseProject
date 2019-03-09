package Temp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.dycas.baseproject.R;

import Util.LogUtil;

/**
 * 基底クラスとするActivity
 */
public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        LogUtil.methodCall();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
    }

    @Override
    protected void onStart() {
        LogUtil.methodCall();
        super.onStart();
    }

    @Override
    protected void onRestart() {
        LogUtil.methodCall();
        super.onRestart();
    }

    @Override
    protected void onResume() {
        LogUtil.methodCall();
        super.onResume();
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        LogUtil.methodCall();
        super.onWindowFocusChanged(hasFocus);
    }

    @Override
    protected void onPause() {
        LogUtil.methodCall();
        super.onPause();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        LogUtil.methodCall();
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onStop() {
        LogUtil.methodCall();
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        LogUtil.methodCall();
        super.onDestroy();
    }
}
