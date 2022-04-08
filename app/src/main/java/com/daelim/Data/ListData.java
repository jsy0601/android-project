package com.daelim.Data;

public class ListData {
    private String name, phone;
    private boolean b;

    public ListData(String name, String phone, boolean b) {
        this.name = name;
        this.phone = phone;
        this.b = b;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isB() {
        return b;
    }

    public void setB(boolean b) {
        this.b = b;
    }
}
