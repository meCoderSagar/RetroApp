package com.example.retroapp.di;

import com.example.retroapp.MyWebService;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = NetworkModule.class)
public interface AppComponent {
    MyWebService getMyWebService();
}
