package com.qfedu.vo;

import com.qfedu.pojo.User;

public class VoUser extends User {

    private String role;

    private String rid;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
        this.rid = rid;
    }
}
