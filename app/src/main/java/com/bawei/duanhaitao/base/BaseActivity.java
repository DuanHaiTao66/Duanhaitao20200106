package com.bawei.duanhaitao.base;
/*
 *@auther:段海涛
 *@Date: 2020-01-06
 *@Time:9:12
 *@Description:${DESCRIPTION}
 **/

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bawei.duanhaitao.cretract.IBaseView;

public abstract class BaseActivity<P extends BasePresenter>extends AppCompatActivity implements IBaseView {
    public P presenter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(initLayout());
        presenter = initPresenter();
        if (presenter!=null) {
            presenter.attach(this);
        }
        initView();
        initData();
    }

    protected abstract P initPresenter();

    protected abstract void initData();

    protected abstract void initView();

    protected abstract int initLayout();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenter!=null) {
            presenter.deatch();
        }
    }
}
