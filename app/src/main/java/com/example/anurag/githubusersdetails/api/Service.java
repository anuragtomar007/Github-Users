package com.example.anurag.githubusersdetails.api;

import com.example.anurag.githubusersdetails.model.Item;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Service {

    @GET("/users")
    Call<List<Item>> getItem();


}
