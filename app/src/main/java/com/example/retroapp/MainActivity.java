package com.example.retroapp;



import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;


import com.example.retroapp.adapter.PostAdapter;
import com.example.retroapp.di.NetworkModule;
import com.example.retroapp.model.Post;

import java.util.List;


import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;


public class MainActivity extends AppCompatActivity {

    MyWebService myWebService;
    RecyclerView recyclerView;
    Context context;
    ProgressBar progressBar;


    CompositeDisposable compositeDisposable = new CompositeDisposable();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar = findViewById(R.id.progressBar);
        context =MainActivity.this;
        checkInternetPermission();

    }

    private void finishInit() {
        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.hasFixedSize();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        BaseApplication baseApplication = (BaseApplication) getApplication();
        myWebService = baseApplication.getMyWebService();
        fetchdata();
    }

    private void checkInternetPermission() {
        ConnectivityManager cm = (ConnectivityManager) getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        if(activeNetwork!=null) {
            finishInit();
        }else {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {

                    if (!isFinishing()){
                        new AlertDialog.Builder(context)
                                .setTitle("No Internet Connection")
                                .setMessage("Please Check Your Internet Connection and Try again")
                                .setCancelable(false)
                                .setPositiveButton("Retry", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        checkInternetPermission();
                                    }
                                }).show();
                    }
                }
            });

        }

    }

    private void fetchdata() {
        compositeDisposable.add(myWebService.getPosts()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new Consumer<List<Post>>() {
            @Override
            public void accept(List<Post> posts){
                displayData(posts);
            }
        }));

    }

    public void displayData(List<Post> posts)
    {
        progressBar.setVisibility(View.GONE);
        PostAdapter adapter =new PostAdapter(this,posts);
        recyclerView.setAdapter(adapter);
    }


}