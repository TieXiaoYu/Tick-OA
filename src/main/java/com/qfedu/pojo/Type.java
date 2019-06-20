package com.qfedu.pojo;


public class Type {
    private  Integer cid;
    private String tname;

    public Type(Integer cid, String tname) {
        this.cid = cid;
        this.tname = tname;
    }

    public Type() {

    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    @Override
    public String toString() {
        return "Type{" +
                "cid=" + cid +
                ", tname='" + tname + '\'' +
                '}';
    }
}
