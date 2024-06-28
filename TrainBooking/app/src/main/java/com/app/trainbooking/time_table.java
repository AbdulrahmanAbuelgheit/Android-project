package com.app.androidproject;

public class time_table {
    String id;

    String type,from,to;
    public time_table(String id, String type, String from, String to) {
        this.id = id;
        this.type = type;
        this.from = from;
        this.to = to;
    }

    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }
}
