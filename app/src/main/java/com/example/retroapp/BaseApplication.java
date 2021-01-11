package com.example.retroapp;

import android.app.Application;

import com.example.retroapp.di.AppComponent;
import com.example.retroapp.di.DaggerAppComponent;


public class BaseApplication extends Application {

    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.create();
    }

    public MyWebService getMyWebService()
    {
        return appComponent.getMyWebService();
    }
    public AppComponent getAppComponent()
    {
        return appComponent;
    }
}
