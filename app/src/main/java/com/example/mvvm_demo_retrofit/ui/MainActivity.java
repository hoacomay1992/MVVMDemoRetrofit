package com.example.mvvm_demo_retrofit.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.mvvm_demo_retrofit.R;
import com.example.mvvm_demo_retrofit.adapter.MovieListAdapter;
import com.example.mvvm_demo_retrofit.databinding.ActivityMainBinding;
import com.example.mvvm_demo_retrofit.model.MovieModel;
import com.example.mvvm_demo_retrofit.viewmodel.MovieListViewModel;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    private List<MovieModel> movieList;
    private MovieListAdapter adapter;
    private MovieListViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        viewModel = ViewModelProviders.of(this).get(MovieListViewModel.class);
        viewModel.init();
        LinearLayoutManager layoutManager = new GridLayoutManager(this, 2);
        binding.recycleView.setLayoutManager(layoutManager);
        adapter = new MovieListAdapter(this, movieList);
        binding.recycleView.setAdapter(adapter);
        viewModel.getMovieListData().observe(this, new Observer<List<MovieModel>>() {
            @Override
            public void onChanged(List<MovieModel> movieModels) {
                if (movieModels != null) {
                    movieList = new ArrayList<>();
                    movieList = movieModels;
                    Log.d("CCC", movieList.get(0).getImage());
                    adapter.setMovieList(movieList);
                    binding.noResultTv.setVisibility(View.GONE);
                } else {
                    binding.noResultTv.setVisibility(View.VISIBLE);
                }
            }
        });
        viewModel.movieDataCallback();
    }
}