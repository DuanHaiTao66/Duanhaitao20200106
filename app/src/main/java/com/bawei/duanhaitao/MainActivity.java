package com.bawei.duanhaitao;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.duanhaitao.adapter.LeftAdapter;
import com.bawei.duanhaitao.adapter.RightAdapter;
import com.bawei.duanhaitao.base.BaseActivity;
import com.bawei.duanhaitao.cretract.ShopCretract;
import com.bawei.duanhaitao.enity.LeftBean;
import com.bawei.duanhaitao.enity.RightBean;
import com.bawei.duanhaitao.presenter.ShopPresenterImpl;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

import static androidx.recyclerview.widget.LinearLayoutManager.*;

public class MainActivity extends BaseActivity<ShopPresenterImpl> implements ShopCretract.ShopView {


    @BindView(R.id.RvLeft)
    RecyclerView RvLeft;
    @BindView(R.id.RvRight)
    RecyclerView RvRight;
    private Unbinder bind;

    @Override
    protected ShopPresenterImpl initPresenter() {
        return new ShopPresenterImpl();
    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Subscribe
    public void MainThread(String s){
        Map<String,Object>map = new HashMap<>();
        map.put("category",s);
        map.put("count",5);
        map.put("page",1);
        presenter.rightShow(map);
    }
    @Override
    protected void initData() {
        presenter.leftShow();
        Map<String,Object>map = new HashMap<>();
        map.put("category","生活");
        map.put("count",5);
        map.put("page",1);
        presenter.rightShow(map);
    }

    @SuppressLint("WrongConstant")
    @Override
    protected void initView() {
        bind = ButterKnife.bind(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(VERTICAL);
        RvLeft.setLayoutManager(linearLayoutManager);
        RvRight.setLayoutManager(new GridLayoutManager(this,2));

    }

    @Override
    protected int initLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void leftSuccess(Object obj) {
        if(obj instanceof LeftBean){
            LeftBean leftBean = (LeftBean) obj;
            List<String> category = leftBean.getCategory();
            LeftAdapter adapter = new LeftAdapter(category,this);
            RvLeft.setAdapter(adapter);

        }
    }

    @Override
    public void leftFilter(String msg) {

    }

    @Override
    public void rightSuccess(Object obj) {

        if (obj instanceof RightBean){
            RightBean rightBean = (RightBean) obj;
            List<RightBean.DataBean> data = rightBean.getData();
            RightAdapter adapter = new RightAdapter(data,this);
            RvRight.setAdapter(adapter);
        }
    }

    @Override
    public void rightFilter(String msg) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        bind.unbind();
        EventBus.getDefault().unregister(this);
    }
}
