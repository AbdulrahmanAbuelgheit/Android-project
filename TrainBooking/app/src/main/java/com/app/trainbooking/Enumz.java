package com.app.trainbooking;

import java.util.ArrayList;

public enum Enumz {

    shebien("",1),
    menouf("",2),
    tanta("",3),
    cairo("",4),
    Alex("",5),
    sohag("",6),
    luxor("",7),
    giza("",8),
    mansoura("",9),
    minia("",10);
    private String name;
    private int id;
    private  static ArrayList<String>mes=new ArrayList<>();
    public static ArrayList<String>names(){
        for (Enumz e:Enumz.values()){
            mes.add(e.toString());
        }
        return mes;
    }
    private   Enumz(String x,int y) {
        this.id=y;
        this.name=x;

    }
    public void setName(String n){
        this.name=n;

    }
    public void setId(int i){
        this.id=i;

    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}

