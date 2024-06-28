package com.app.trainbooking.database;
public class user {
    private int id;
    private String name,password,email,addresss;

    public user(int id, String name, String password,String email) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email=email;

    }


    public void setId(int id) {
        this.id = id;
    }

    public void setAge(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getAge() {
        return password;
    }

    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }

}
