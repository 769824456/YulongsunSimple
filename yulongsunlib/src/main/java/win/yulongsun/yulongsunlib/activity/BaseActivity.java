package win.yulongsun.yulongsunlib.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * @Project YulongsunSimple
 * @Packate win.yulongsun.yulongsunlib.activity
 * @Author yulongsun
 * @Email yulongsun@gmail.com
 * @Date 2016/4/13
 * @Version 1.0.0
 * @Description
 */
public abstract class BaseActivity extends AppCompatActivity {

    @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initViews();
        initListeners();
        initData();
    }

    /*初始化数据*/
    private void initData() {

    }

    /*初始化监听器*/
    private void initListeners() {

    }

    /*初始化界面*/
    private void initViews() {

    }
}
