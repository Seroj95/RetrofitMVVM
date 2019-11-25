package com.example.foodrecipes.request;

import com.example.foodrecipes.util.Constans;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceGeneration {
    private static Retrofit.Builder retrofitBulider=new Retrofit.Builder()
            .baseUrl(Constans.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create());


    private static Retrofit retrofit=retrofitBulider.build();
    private static RecipeApi recipeApi=retrofit.create(RecipeApi.class);
    public static RecipeApi getRecipeApi(){
        return recipeApi;
    }
}
