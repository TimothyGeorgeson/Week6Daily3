package com.example.consultants.week6daily3.model.data.room;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.consultants.week6daily3.model.GeofenceRecord;

import java.util.List;

import io.reactivex.Flowable;

@Dao
public interface GeofenceDao {

    @Insert
    void saveRecord(GeofenceRecord record);
    //
    @Query("Select * from GeofenceRecord")
    Flowable<List<GeofenceRecord>> getRecords();
}
