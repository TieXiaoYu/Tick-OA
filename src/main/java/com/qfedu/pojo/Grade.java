package com.qfedu.pojo;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Grade {
    private Integer id;
    private String name;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createdate;
    private Integer flag;
    private Integer week;
    private  String location;
    private Integer cid;
    private Integer count;
    private Course course;


    public Grade(Integer id, String name, Date createdate, Integer flag, Integer week, String location, Integer cid, Integer count, Course course) {
        this.id = id;
        this.name = name;
        this.createdate = createdate;
        this.flag = flag;
        this.week = week;
        this.location = location;
        this.cid = cid;
        this.count = count;
        this.course = course;
    }

    public Grade() {

    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public Integer getWeek() {
        return week;
    }

    public void setWeek(Integer week) {
        this.week = week;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "Grade{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", createdate=" + createdate +
                ", flage=" + flag +
                ", week=" + week +
                ", location='" + location + '\'' +
                ", cid=" + cid +
                ", count=" + count +
                ", course=" + course +
                '}';
    }
}
