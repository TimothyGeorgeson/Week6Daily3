package com.example.consultants.week6daily3.model.data;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import com.example.consultants.week6daily3.model.GeofenceRecord;

import java.util.List;

public class GeofenceRepository {
    public static final String TAG = GeofenceRepository.class.getSimpleName() + "_TAG";

    private MutableLiveData<List<GeofenceRecord>> listLiveData;
    private LocalDataSource localDataSource;

    public GeofenceRepository(LocalDataSource localDataSource) {
        this.localDataSource = localDataSource;
        listLiveData = new MutableLiveData<>();
    }

    public LiveData<List<GeofenceRecord>> getRecords() {

        //load from local source
        localDataSource.getFenceHist(new LocalDataSource.Callback() {
            @Override
            public void onFenceData(List<GeofenceRecord> records) {
                Log.d(TAG, "onSuccess: local");
                listLiveData.setValue(records);
            }
        });

        return listLiveData;
    }
}
