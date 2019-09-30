package com.hillel.library.entity;

public class Abonent {

    private int id;
    private int phone;
    private String lastname;
    private Role role;
    private String password;

    public Abonent() {
    }

    public Abonent(int id, int phone, String lastname, Role role, String password) {
        this.id = id;
        this.phone = phone;
        this.lastname = lastname;
        this.role = role;
        this.password = password;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Abonent [id=" + id + ", phone=" + phone + ", lastname=" + lastname + ", role=" + role + ", password="
                + password + "]";
    }

}