package com.bawei.duanhaitao;
/*
 *@auther:段海涛
 *@Date: 2020-01-06
 *@Time:10:54
 *@Description:${DESCRIPTION}
 **/

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;
@Entity
public class GreenDao {
    @Id
    private Long id;
    private String url;
    private String json;
    @Generated(hash = 1709906088)
    public GreenDao(Long id, String url, String json) {
        this.id = id;
        this.url = url;
        this.json = json;
    }
    @Generated(hash = 766040118)
    public GreenDao() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getUrl() {
        return this.url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public String getJson() {
        return this.json;
    }
    public void setJson(String json) {
        this.json = json;
    }
}
