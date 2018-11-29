package com.example.consultants.week6daily3.model.data;

import android.annotation.SuppressLint;
import android.arch.persistence.room.Room;
import android.content.Context;

import com.example.consultants.week6daily3.model.GeofenceRecord;
import com.example.consultants.week6daily3.model.data.room.GeofenceDao;
import com.example.consultants.week6daily3.model.data.room.GeofenceDatabase;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class LocalDataSource {

    Context context;
    GeofenceDao geofenceDao;
    GeofenceDatabase geofenceDatabase;

    public LocalDataSource(Context context) {
        this.context = context;
        geofenceDatabase = Room.databaseBuilder(context, GeofenceDatabase.class, "Geofence-Database")
                .fallbackToDestructiveMigration().build();
        geofenceDao = geofenceDatabase.geofenceDao();
    }

    public void saveFenceHist(final GeofenceRecord record) {

        Completable.fromAction(new Action() {
            @Override
            public void run() {
                geofenceDao.saveRecord(record);
            }
        })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe();
    }

    @SuppressLint("CheckResult")
    public void getFenceHist(final Callback callback) {
        geofenceDao.getRecords()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<List<GeofenceRecord>>() {
                    @Override
                    public void accept(List<GeofenceRecord> records) throws Exception {
                        callback.onFenceData(records);
                    }
                });
    }

    public interface Callback {
        void onFenceData(List<GeofenceRecord> records);
    }
}
