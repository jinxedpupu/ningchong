package com.cdvtc.ningchong.model;

public class Chongwu {
    protected int cwid;
    protected int cwjiage;
    protected String cwbeizhu;
    protected String cwtupian;
    protected String sex;

    protected Cwniangling Cwnianling;
    protected Cwpinji Cwpinjia;
    protected Cwtixing Cwtixing;
    protected Cwpinzhong Cwpinzhong;

    public int getCwid() {
        return cwid;
    }

    public void setCwid(int cwid) {
        this.cwid = cwid;
    }

    public int getCwjiage() {
        return cwjiage;
    }

    public void setCwjiage(int cwjiage) {
        this.cwjiage = cwjiage;
    }

    public String getCwbeizhu() {
        return cwbeizhu;
    }

    public void setCwbeizhu(String cwbeizhu) {
        this.cwbeizhu = cwbeizhu;
    }

    public String getCwtupian() {
        return cwtupian;
    }

    public void setCwtupian(String cwtupian) {
        this.cwtupian = cwtupian;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Cwniangling getCwnianling() {
        return Cwnianling;
    }

    public void setCwnianling(Cwniangling cwnianling) {
        Cwnianling = cwnianling;
    }

    public Cwpinji getCwpinjia() {
        return Cwpinjia;
    }

    public void setCwpinjia(Cwpinji cwpinjia) {
        Cwpinjia = cwpinjia;
    }

    public Cwtixing getCwtixing() {
        return Cwtixing;
    }

    public void setCwtixing(Cwtixing cwtixing) {
        Cwtixing = cwtixing;
    }

    public Cwpinzhong getCwpinzhong() {
        return Cwpinzhong;
    }

    public void setCwpinzhong(Cwpinzhong cwpinzhong) {
        Cwpinzhong = cwpinzhong;
    }
}
