package com.example.consultants.week6daily3.model.data.room;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.example.consultants.week6daily3.model.GeofenceRecord;

@Database(entities = GeofenceRecord.class, version = 1)
public abstract class GeofenceDatabase extends RoomDatabase {

    public abstract GeofenceDao geofenceDao();
}
