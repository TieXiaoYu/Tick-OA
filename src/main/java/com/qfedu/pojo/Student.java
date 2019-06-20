package com.qfedu.pojo;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Student {
    private String no;
    private String name;
    private String sex;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;
    private String cardno;
    private String school;
    private String education;
    private String phone;
    private String email;
    private Integer flag;
    private String introno;
    private String qq;
    private Integer gid;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createdate;
    private String photo;
    private String tno;
    private Grade grade;

    public Student(String no, String name, String sex, Date birthday, String cardno, String school, String education, String phone, String email, Integer flag, String introno, String qq, Integer gid, Date createdate, String photo, String tno, Grade grade) {
        this.no = no;
        this.name = name;
        this.sex = sex;
        this.birthday = birthday;
        this.cardno = cardno;
        this.school = school;
        this.education = education;
        this.phone = phone;
        this.email = email;
        this.flag = flag;
        this.introno = introno;
        this.qq = qq;
        this.gid = gid;
        this.createdate = createdate;
        this.photo = photo;
        this.tno = tno;
        this.grade = grade;
    }

    public Student() {

    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getCardno() {
        return cardno;
    }

    public void setCardno(String cardno) {
        this.cardno = cardno;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIntrono() {
        return introno;
    }

    public void setIntrono(String introno) {
        this.introno = introno;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getTno() {
        return tno;
    }

    public void setTno(String tno) {
        this.tno = tno;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "no='" + no + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", birthday=" + birthday +
                ", cardno='" + cardno + '\'' +
                ", school='" + school + '\'' +
                ", education='" + education + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", flag=" + flag +
                ", introno='" + introno + '\'' +
                ", qq='" + qq + '\'' +
                ", gid=" + gid +
                ", createdate=" + createdate +
                ", photo='" + photo + '\'' +
                ", tno='" + tno + '\'' +
                ", grade=" + grade +
                '}';
    }
}
