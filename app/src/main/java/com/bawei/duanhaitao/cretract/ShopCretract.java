package com.bawei.duanhaitao.cretract;
/*
 *@auther:段海涛
 *@Date: 2020-01-06
 *@Time:9:15
 *@Description:${DESCRIPTION}
 **/

import java.util.Map;

public interface ShopCretract {
    interface ShopView extends IBaseView{
        void leftSuccess(Object obj);
        void leftFilter(String msg);

        void rightSuccess(Object obj);
        void rightFilter(String msg);
    }
    interface ShopMoudel{
        void leftShow(LeftCallBack callBack);
        interface LeftCallBack{
            void leftSuccess(Object obj);
            void leftFilter(String msg);
        }
        void rightShow(Map<String,Object>map, RightCallBack callBack);
        interface RightCallBack{
            void rightSuccess(Object obj);
            void rightFilter(String msg);
        }
    }
     interface ShopPresenter{
         void leftShow();
         void rightShow(Map<String,Object>map);
     }

}
