package dhu.cst.zjm.encryptmvp.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by zjm on 2017/2/24.
 */

public abstract class BaseActivity extends AppCompatActivity {

    protected abstract int getContentViewLayoutId();

    protected abstract void injectDependences();

    protected abstract void initButterKnife(Bundle savedInstanceState);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentViewLayoutId());
        injectDependences();
        initButterKnife(savedInstanceState);
    }
}
