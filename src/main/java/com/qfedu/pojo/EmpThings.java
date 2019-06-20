package com.qfedu.pojo;

import java.util.Date;


public class EmpThings {

    private Integer id;
    private String info;
    private String type;
    private String startname;
    private String startno;
    private Date startdate;
    private Date enddate;
    private int days;
    private Integer pid;
    private int flag;

    private String startDateStr;
    private String endDateStr;

    public String getStartDateStr() {
        return startDateStr;
    }

    public void setStartDateStr(String startDateStr) {
        this.startDateStr = startDateStr;
    }

    public String getEndDateStr() {
        return endDateStr;
    }

    public void setEndDateStr(String endDateStr) {
        this.endDateStr = endDateStr;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStartname() {
        return startname;
    }

    public void setStartname(String startname) {
        this.startname = startname;
    }

    public String getStartno() {
        return startno;
    }

    public void setStartno(String startno) {
        this.startno = startno;
    }

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "EmpThings{" +
                "id=" + id +
                ", info='" + info + '\'' +
                ", type='" + type + '\'' +
                ", startname='" + startname + '\'' +
                ", startno='" + startno + '\'' +
                ", startdate=" + startdate +
                ", enddate=" + enddate +
                ", days=" + days +
                ", pid=" + pid +
                ", flag=" + flag +
                ", startDateStr='" + startDateStr + '\'' +
                ", endDateStr='" + endDateStr + '\'' +
                '}';
    }
}
