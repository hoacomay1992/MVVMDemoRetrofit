package com.example.mvvm_demo_retrofit.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.mvvm_demo_retrofit.model.MovieModel;
import com.example.mvvm_demo_retrofit.repositories.Repositories;

import java.util.List;

public class MovieListViewModel extends AndroidViewModel {
    private Repositories repositories;
    private LiveData<List<MovieModel>> movieListData;

    public MovieListViewModel(@NonNull Application application) {
        super(application);
    }

    public void init() {
        repositories = new Repositories();
        movieListData = repositories.getMovieListData();
    }

    public void movieDataCallback() {
        repositories.movieDataCalback();
    }

    public LiveData<List<MovieModel>> getMovieListData() {
        return movieListData;
    }
}
