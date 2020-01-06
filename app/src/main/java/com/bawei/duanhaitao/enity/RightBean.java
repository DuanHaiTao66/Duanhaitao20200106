package com.bawei.duanhaitao.enity;
/*
 *@auther:段海涛
 *@Date: 2020-01-06
 *@Time:9:25
 *@Description:${DESCRIPTION}
 **/

import java.util.List;

public class RightBean {

    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {


        private int goods_id;
        private String goods_english_name;
        private String currency_price;
        private String rank_price;
        private String goods_brokerage_per;
        private String service_price;
        private String shipping_price;
        private int is_recommended;
        private int is_on_sale;
        private String goods_name;
        private String goods_brief;
        private String weblink;
        private int is_promote;
        private String link_website;
        private String goods_thumb;
        private String percentage;
        private double total_goods_brokerage;
        private int is_favorited;
        private int isNew;

        public int getGoods_id() {
            return goods_id;
        }

        public void setGoods_id(int goods_id) {
            this.goods_id = goods_id;
        }

        public String getGoods_english_name() {
            return goods_english_name;
        }

        public void setGoods_english_name(String goods_english_name) {
            this.goods_english_name = goods_english_name;
        }

        public String getCurrency_price() {
            return currency_price;
        }

        public void setCurrency_price(String currency_price) {
            this.currency_price = currency_price;
        }

        public String getRank_price() {
            return rank_price;
        }

        public void setRank_price(String rank_price) {
            this.rank_price = rank_price;
        }

        public String getGoods_brokerage_per() {
            return goods_brokerage_per;
        }

        public void setGoods_brokerage_per(String goods_brokerage_per) {
            this.goods_brokerage_per = goods_brokerage_per;
        }

        public String getService_price() {
            return service_price;
        }

        public void setService_price(String service_price) {
            this.service_price = service_price;
        }

        public String getShipping_price() {
            return shipping_price;
        }

        public void setShipping_price(String shipping_price) {
            this.shipping_price = shipping_price;
        }

        public int getIs_recommended() {
            return is_recommended;
        }

        public void setIs_recommended(int is_recommended) {
            this.is_recommended = is_recommended;
        }

        public int getIs_on_sale() {
            return is_on_sale;
        }

        public void setIs_on_sale(int is_on_sale) {
            this.is_on_sale = is_on_sale;
        }

        public String getGoods_name() {
            return goods_name;
        }

        public void setGoods_name(String goods_name) {
            this.goods_name = goods_name;
        }

        public String getGoods_brief() {
            return goods_brief;
        }

        public void setGoods_brief(String goods_brief) {
            this.goods_brief = goods_brief;
        }

        public String getWeblink() {
            return weblink;
        }

        public void setWeblink(String weblink) {
            this.weblink = weblink;
        }

        public int getIs_promote() {
            return is_promote;
        }

        public void setIs_promote(int is_promote) {
            this.is_promote = is_promote;
        }

        public String getLink_website() {
            return link_website;
        }

        public void setLink_website(String link_website) {
            this.link_website = link_website;
        }

        public String getGoods_thumb() {
            return goods_thumb;
        }

        public void setGoods_thumb(String goods_thumb) {
            this.goods_thumb = goods_thumb;
        }

        public String getPercentage() {
            return percentage;
        }

        public void setPercentage(String percentage) {
            this.percentage = percentage;
        }

        public double getTotal_goods_brokerage() {
            return total_goods_brokerage;
        }

        public void setTotal_goods_brokerage(double total_goods_brokerage) {
            this.total_goods_brokerage = total_goods_brokerage;
        }

        public int getIs_favorited() {
            return is_favorited;
        }

        public void setIs_favorited(int is_favorited) {
            this.is_favorited = is_favorited;
        }

        public int getIsNew() {
            return isNew;
        }

        public void setIsNew(int isNew) {
            this.isNew = isNew;
        }
    }
}
