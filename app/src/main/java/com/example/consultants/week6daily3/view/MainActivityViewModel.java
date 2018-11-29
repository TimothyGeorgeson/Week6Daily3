package com.example.consultants.week6daily3.view;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.example.consultants.week6daily3.model.GeofenceRecord;
import com.example.consultants.week6daily3.model.data.GeofenceRepository;
import com.example.consultants.week6daily3.model.data.LocalDataSource;

import java.util.List;

public class MainActivityViewModel extends AndroidViewModel {

    public static final String TAG = MainActivityViewModel.class.getSimpleName() + "_TAG";

    private GeofenceRepository geofenceRepository;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        geofenceRepository = new GeofenceRepository(new LocalDataSource(application.getApplicationContext()));
    }

    public LiveData<List<GeofenceRecord>> getRecords() {
        return geofenceRepository.getRecords();
    }

}
