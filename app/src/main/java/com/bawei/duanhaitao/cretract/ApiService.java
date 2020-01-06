package com.bawei.duanhaitao.cretract;
/*
 *@auther:段海涛
 *@Date: 2020-01-06
 *@Time:9:35
 *@Description:${DESCRIPTION}
 **/

import com.bawei.duanhaitao.enity.LeftBean;
import com.bawei.duanhaitao.enity.RightBean;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface ApiService {
    @GET("baweiapi/category")
    Observable<LeftBean>getLeftResponse();
    @GET("baweiapi/shopByCategory")
    Observable<RightBean>getRightResponse(@QueryMap Map<String,Object>map);


}
