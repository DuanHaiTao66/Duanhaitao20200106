package com.bawei.duanhaitao.presenter;
/*
 *@auther:段海涛
 *@Date: 2020-01-06
 *@Time:9:22
 *@Description:${DESCRIPTION}
 **/

import com.bawei.duanhaitao.base.BasePresenter;
import com.bawei.duanhaitao.cretract.ShopCretract;
import com.bawei.duanhaitao.moudel.ShopMoudelImpl;

import java.util.Map;

public class ShopPresenterImpl extends BasePresenter<ShopCretract.ShopView>implements ShopCretract.ShopPresenter {

    private ShopMoudelImpl moudel;

    @Override
    protected void initMoudel() {
        moudel = new ShopMoudelImpl();
    }

    @Override
    public void leftShow() {
        moudel.leftShow(new ShopCretract.ShopMoudel.LeftCallBack() {
            @Override
            public void leftSuccess(Object obj) {
                getView().leftSuccess(obj);
            }

            @Override
            public void leftFilter(String msg) {
                getView().leftFilter(msg);
            }
        });
    }

    @Override
    public void rightShow(Map<String, Object> map) {
        moudel.rightShow(map, new ShopCretract.ShopMoudel.RightCallBack() {
            @Override
            public void rightSuccess(Object obj) {
                getView().rightSuccess(obj);
            }

            @Override
            public void rightFilter(String msg) {
                getView().rightFilter(msg);
            }
        });
    }
}
