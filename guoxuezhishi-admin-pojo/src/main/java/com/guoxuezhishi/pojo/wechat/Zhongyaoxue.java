package com.guoxuezhishi.pojo.wechat;

public class Zhongyaoxue {
    private Integer id;

    private String zhongyaoming;

    private String xingwei;

    private String guijing;

    private String zuoyong;

    private String fenlei;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getZhongyaoming() {
        return zhongyaoming;
    }

    public void setZhongyaoming(String zhongyaoming) {
        this.zhongyaoming = zhongyaoming == null ? null : zhongyaoming.trim();
    }

    public String getXingwei() {
        return xingwei;
    }

    public void setXingwei(String xingwei) {
        this.xingwei = xingwei == null ? null : xingwei.trim();
    }

    public String getGuijing() {
        return guijing;
    }

    public void setGuijing(String guijing) {
        this.guijing = guijing == null ? null : guijing.trim();
    }

    public String getZuoyong() {
        return zuoyong;
    }

    public void setZuoyong(String zuoyong) {
        this.zuoyong = zuoyong == null ? null : zuoyong.trim();
    }

    public String getFenlei() {
        return fenlei;
    }

    public void setFenlei(String fenlei) {
        this.fenlei = fenlei == null ? null : fenlei.trim();
    }

    @Override
    public String toString() {
        return "Zhongyaoxue{" +
                "id=" + id +
                ", zhongyaoming='" + zhongyaoming + '\'' +
                ", xingwei='" + xingwei + '\'' +
                ", guijing='" + guijing + '\'' +
                ", zuoyong='" + zuoyong + '\'' +
                ", fenlei='" + fenlei + '\'' +
                '}';
    }
}