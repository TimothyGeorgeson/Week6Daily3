package com.example.consultants.week6daily3.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class GeofenceRecord {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo
    private String name;

    @ColumnInfo
    private String enterExit;

    @ColumnInfo
    private String time;

    public GeofenceRecord(String name, String enterExit, String time) {
        this.name = name;
        this.enterExit = enterExit;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEnterExit() {
        return enterExit;
    }

    public void setEnterExit(String enterExit) {
        this.enterExit = enterExit;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Geofence{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", enterExit='" + enterExit + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
