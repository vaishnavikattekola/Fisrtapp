package com.example.fisrtapp.Retrofit;

//import com.example.fisrtapp.Datum;
import com.example.fisrtapp.ModelClass;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiInterface {
    @POST("Sample")
//    Call<ModelClass>getModelClass();


    Call<ModelClass> getModelclass(@Body JsonObject getModelclass);


    
}
