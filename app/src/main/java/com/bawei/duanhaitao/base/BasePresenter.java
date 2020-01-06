package com.bawei.duanhaitao.base;
/*
 *@auther:段海涛
 *@Date: 2020-01-06
 *@Time:9:09
 *@Description:${DESCRIPTION}
 **/

import com.bawei.duanhaitao.cretract.IBaseView;

import java.lang.ref.WeakReference;

public abstract class BasePresenter<V extends IBaseView> {
    public WeakReference<V>weakReference;
    public BasePresenter() {
        initMoudel();
    }
    public void attach(V v){
        weakReference = new WeakReference<>(v);
    }
    public void deatch(){
        if (weakReference!=null){
            weakReference.clear();
            weakReference = null;
        }
    }
    protected abstract void initMoudel();
    public V getView(){
        V v = weakReference.get();
        return v;
    }
}
