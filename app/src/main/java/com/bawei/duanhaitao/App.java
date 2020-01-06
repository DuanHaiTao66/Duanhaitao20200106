package com.bawei.duanhaitao;
/*
 *@auther:段海涛
 *@Date: 2020-01-06
 *@Time:10:53
 *@Description:${DESCRIPTION}
 **/

import android.app.Application;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.duanhaitao.greendao.DaoMaster;
import com.duanhaitao.greendao.DaoSession;
import com.duanhaitao.greendao.GreenDaoDao;

import java.util.ConcurrentModificationException;

public class App extends Application {
    public  Context context;
    public static DaoSession daoSession;
    public static GreenDaoDao greenDaoDao;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(context,"duanhaitao.db");
        SQLiteDatabase writableDatabase = devOpenHelper.getWritableDatabase();
        DaoMaster daoMaster = new DaoMaster(writableDatabase);
        daoSession = daoMaster.newSession();
        greenDaoDao = daoSession.getGreenDaoDao();
    }
}
