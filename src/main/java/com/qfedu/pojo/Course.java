package com.qfedu.pojo;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Course {
    private Integer id;
    private String name;
    private Integer flag;
    private Integer week;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createdate;
    private Integer typeId;
    private Type type;

    public Course(Integer id, String name, Integer flag, Integer week, Date createdate, Integer typeId, Type type) {
        this.id = id;
        this.name = name;
        this.flag = flag;
        this.week = week;
        this.createdate = createdate;
        this.typeId = typeId;
        this.type = type;
    }

    public Course() {

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

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", flag=" + flag +
                ", week=" + week +
                ", createdate=" + createdate +
                ", typeId=" + typeId +
                ", type=" + type +
                '}';
    }
}
