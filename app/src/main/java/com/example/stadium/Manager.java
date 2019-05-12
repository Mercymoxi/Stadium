package com.example.stadium;

import org.litepal.crud.DataSupport;

public class Manager extends DataSupport {

    private int id,manager_n;
    private String manager_name,manager_account,manager_ps;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getManager_n() {
        return manager_n;
    }

    public void setManager_n(int manager_n) {
        this.manager_n = manager_n;
    }

    public String getManager_account() {
        return manager_account;
    }

    public void setManager_account(String manager_account) {
        this.manager_account = manager_account;
    }

    public String getManager_name() {
        return manager_name;
    }

    public void setManager_name(String manager_name) {
        this.manager_name = manager_name;
    }

    public String getManager_ps() {
        return manager_ps;
    }

    public void setManager_ps(String manager_ps) {
        this.manager_ps = manager_ps;
    }
}
