package com.guoxuezhishi.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author: jiang
 * @date: 2019/9/4
 */
@Component
@ConfigurationProperties(prefix = "remotecommand")
@PropertySource(value = "ssh.properties")
public class SshBeanProp {
    private String zhifudevip;
    private String zhifuuatip;
    private String tingcheuatip;
    private int port;
    private String cgdgw;
    private String cgdgw123;
    private String cgdgwst;
    private String gsdpay;
    private String gsdpay123;
    private String gsdpayst;

    public String getZhifudevip() {
        return zhifudevip;
    }

    public void setZhifudevip(String zhifudevip) {
        this.zhifudevip = zhifudevip;
    }

    public String getZhifuuatip() {
        return zhifuuatip;
    }

    public void setZhifuuatip(String zhifuuatip) {
        this.zhifuuatip = zhifuuatip;
    }

    public String getTingcheuatip() {
        return tingcheuatip;
    }

    public void setTingcheuatip(String tingcheuatip) {
        this.tingcheuatip = tingcheuatip;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getCgdgw() {
        return cgdgw;
    }

    public void setCgdgw(String cgdgw) {
        this.cgdgw = cgdgw;
    }

    public String getCgdgw123() {
        return cgdgw123;
    }

    public void setCgdgw123(String cgdgw123) {
        this.cgdgw123 = cgdgw123;
    }

    public String getCgdgwst() {
        return cgdgwst;
    }

    public void setCgdgwst(String cgdgwst) {
        this.cgdgwst = cgdgwst;
    }

    public String getGsdpay() {
        return gsdpay;
    }

    public void setGsdpay(String gsdpay) {
        this.gsdpay = gsdpay;
    }

    public String getGsdpay123() {
        return gsdpay123;
    }

    public void setGsdpay123(String gsdpay123) {
        this.gsdpay123 = gsdpay123;
    }

    public String getGsdpayst() {
        return gsdpayst;
    }

    public void setGsdpayst(String gsdpayst) {
        this.gsdpayst = gsdpayst;
    }
}
