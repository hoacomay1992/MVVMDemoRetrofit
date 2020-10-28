package com.example.mvvm_demo_retrofit.repositories;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.mvvm_demo_retrofit.model.MovieModel;
import com.example.mvvm_demo_retrofit.network.APIService;
import com.example.mvvm_demo_retrofit.network.RetrofitInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Repositories {
    private static final String BASE_URL = "https://velmm.com/apis/";
    private APIService apiService;
    private MutableLiveData<List<MovieModel>> movieListData;


    public Repositories() {
        movieListData = new MutableLiveData<>();
        apiService = RetrofitInstance.getRetrofitClient(BASE_URL).create(APIService.class);
    }

    public void movieDataCalback() {
        apiService.getMovieList().enqueue(new Callback<List<MovieModel>>() {
            @Override
            public void onResponse(Call<List<MovieModel>> call, Response<List<MovieModel>> response) {
                movieListData.postValue(response.body());
            }

            @Override
            public void onFailure(Call<List<MovieModel>> call, Throwable t) {
                movieListData.postValue(null);
            }
        });
    }

    public MutableLiveData<List<MovieModel>> getMovieListData() {
        return movieListData;
    }
}
