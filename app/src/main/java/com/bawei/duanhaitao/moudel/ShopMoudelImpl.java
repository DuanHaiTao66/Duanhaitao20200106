package com.bawei.duanhaitao.moudel;
/*
 *@auther:段海涛
 *@Date: 2020-01-06
 *@Time:9:22
 *@Description:${DESCRIPTION}
 **/

import com.bawei.duanhaitao.App;
import com.bawei.duanhaitao.GreenDao;
import com.bawei.duanhaitao.api.Api;
import com.bawei.duanhaitao.cretract.ApiService;
import com.bawei.duanhaitao.cretract.ShopCretract;
import com.bawei.duanhaitao.enity.LeftBean;
import com.bawei.duanhaitao.enity.RightBean;
import com.bawei.duanhaitao.util.RetrofitUtil;
import com.duanhaitao.greendao.GreenDaoDao;
import com.google.gson.Gson;

import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

public class ShopMoudelImpl implements ShopCretract.ShopMoudel {
    @Override
    public void leftShow(LeftCallBack callBack) {
        Retrofit retrofit = RetrofitUtil.getInstance().getRetrofit();
        ApiService apiService = retrofit.create(ApiService.class);
        Observable<LeftBean> observable = apiService.getLeftResponse();
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LeftBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(LeftBean leftBean) {
                        callBack.leftSuccess(leftBean);
                        GreenDaoDao greenDaoDao = App.daoSession.getGreenDaoDao();
                        Gson gson = new Gson();
                        String s = gson.toJson(leftBean);
                        GreenDao greenDao = new GreenDao(1l,"http://blog.zhaoliang5156.cn/baweiapi/category",s);
                        greenDaoDao.insertOrReplace(greenDao);

                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.leftFilter(e.getMessage());
                        GreenDaoDao greenDaoDao = App.daoSession.getGreenDaoDao();
                        GreenDao unique = greenDaoDao.queryBuilder().where(GreenDaoDao.Properties.Url.eq("http://blog.zhaoliang5156.cn/baweiapi/category")).unique();
                        Gson gson = new Gson();
                        String json = unique.getJson();
                        LeftBean leftBean = gson.fromJson(json, LeftBean.class);
                        callBack.leftSuccess(leftBean);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void rightShow(Map<String, Object> map, RightCallBack callBack) {
        Retrofit retrofit = RetrofitUtil.getInstance().getRetrofit();
        ApiService apiService = retrofit.create(ApiService.class);
        Observable<RightBean> observable = apiService.getRightResponse(map);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<RightBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(RightBean rightBean) {
                        callBack.rightSuccess(rightBean);
                        GreenDaoDao greenDaoDao = App.daoSession.getGreenDaoDao();
                        Gson gson = new Gson();
                        String s = gson.toJson(rightBean);
                        GreenDao greenDao = new GreenDao(2l,"http://blog.zhaoliang5156.cn/baweiapi/shopByCategory",s);
                        greenDaoDao.insertOrReplace(greenDao);
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.rightFilter(e.getMessage());
                        GreenDaoDao greenDaoDao = App.daoSession.getGreenDaoDao();
                        GreenDao unique = greenDaoDao.queryBuilder().where(GreenDaoDao.Properties.Url.eq("http://blog.zhaoliang5156.cn/baweiapi/shopByCategory")).unique();
                        Gson gson = new Gson();
                        String json = unique.getJson();
                        RightBean rightBean = gson.fromJson(json, RightBean.class);
                        callBack.rightSuccess(rightBean);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
