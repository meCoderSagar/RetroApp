package com.example.retroapp;


import com.example.retroapp.model.Post;

import java.util.List;

import io.reactivex.Observable;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public interface MyWebService {
    String FEED ="repositories/19438/issues";


    @GET(FEED)
    Observable<List<Post>> getPosts();

}
