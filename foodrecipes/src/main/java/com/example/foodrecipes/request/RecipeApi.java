package com.example.foodrecipes.request;

import com.example.foodrecipes.request.response.RecipeResponse;
import com.example.foodrecipes.request.response.RecipeSearchResponse;

import java.lang.ref.SoftReference;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RecipeApi {
    //Serach
    @GET("api/search")
    Call<RecipeSearchResponse> searchRecipe(
            @Query("key")String key,//serachic heto ? key
            @Query("q")String query,//&q=
            @Query("page")String page//&page=
    );
//Get Recipe Request
    @GET("api/get")
    Call<RecipeResponse> getRecipe(
            @Query("key")String key,
            @Query("rId") String recipe_id
            );

}
