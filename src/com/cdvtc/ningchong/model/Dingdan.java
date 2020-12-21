package com.cdvtc.ningchong.model;

import java.util.Date;

public class Dingdan {
    protected int ddid;
    protected User user;
    protected String ddzt;
    protected Date ddtime;

    public int getDdid() {
        return ddid;
    }

    public void setDdid(int ddid) {
        this.ddid = ddid;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getDdzt() {
        return ddzt;
    }

    public void setDdzt(String ddzt) {
        this.ddzt = ddzt;
    }

    public Date getDdtime() {
        return ddtime;
    }

    public void setDdtime(Date ddtime) {
        this.ddtime = ddtime;
    }
}
