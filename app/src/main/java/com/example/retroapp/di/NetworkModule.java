package com.example.retroapp.di;

import com.example.retroapp.MyWebService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class NetworkModule {

    String BASE_URL ="https://api.github.com/";

    @Singleton
    @Provides
    Retrofit provideRetrofit() {
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    @Singleton
    @Provides
    MyWebService provideMyWebService(Retrofit retrofit)
    {
        return retrofit.create(MyWebService.class);
    }
}
