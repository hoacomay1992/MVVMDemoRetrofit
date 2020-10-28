package com.example.mvvm_demo_retrofit.network;

import com.example.mvvm_demo_retrofit.model.MovieModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIService {
    @GET("volley_array.json")
    Call<List<MovieModel>> getMovieList();
}
