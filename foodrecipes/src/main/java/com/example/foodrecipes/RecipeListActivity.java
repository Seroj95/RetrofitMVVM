package com.example.foodrecipes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.foodrecipes.models.Recipe;
import com.example.foodrecipes.request.RecipeApi;
import com.example.foodrecipes.request.ServiceGeneration;
import com.example.foodrecipes.request.response.RecipeResponse;
import com.example.foodrecipes.request.response.RecipeSearchResponse;
import com.example.foodrecipes.util.Constans;
import com.example.foodrecipes.viewmodels.RecipeListViewModel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RecipeListActivity extends BaseActivity {
    private static final String TAG = "RecipeListActivity";
    private RecipeListViewModel mrecipeListViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_list);
        mrecipeListViewModel= ViewModelProviders.of(this).get(RecipeListViewModel.class);
        subscrideObservice();
//findViewById(R.id.test).setOnClickListener(new View.OnClickListener() {
//    @Override
//    public void onClick(View v) {
//        if (mProgressBar.getVisibility()==View.VISIBLE){
//        }
//        else {
//            showProgresBar(true);
//        }
//        testRetrofitRequest();

//    }
//});

    }
    private void subscrideObservice(){
        mrecipeListViewModel.getRecipe().observe(this, new Observer<List<Recipe>>() {
            @Override
            public void onChanged(List<Recipe> recipes) {

            }
        });
    }
    private  void testRetrofitRequest(){
        RecipeApi recipeApi = ServiceGeneration.getRecipeApi();
//        Call<RecipeSearchResponse> responseCall=recipeApi
//                .searchRecipe(Constans.API_KEY,
//                        "chiken breast",
//                        "1");
//        responseCall.enqueue(new Callback<RecipeSearchResponse>() {
//            @Override
//            public void onResponse(Call<RecipeSearchResponse> call, Response<RecipeSearchResponse> response) {
//                Log.d(TAG, "onResponse: server response"+response.toString());
//
//                if(response.code()==200){
//                    Log.d(TAG, "onResponse:body "+response.body().toString());
//                    List<Recipe> recipes=new ArrayList<>(response.body().getRecipes());
//                    for (Recipe recipe:recipes){
//                        Log.d(TAG, "onResponse: "+recipe.getTitle());
//                    }
//
//                }else {
//                    try {
//                        Log.d(TAG, "onResponse: "+response.errorBody().string());
//
//                    }catch (IOException e){
//                        e.printStackTrace();
//                    }
//                }
//            }
//
//            @Override
//            public void onFailure(Call<RecipeSearchResponse> call, Throwable t) {
//
//            }
//        });




        Call<RecipeResponse> responseCall=recipeApi
                .getRecipe(Constans.API_KEY,
                        "37859"
                      );
        responseCall.enqueue(new Callback<RecipeResponse>() {
            @Override
            public void onResponse(Call<RecipeResponse> call, Response<RecipeResponse> response) {
                Log.d(TAG, "onResponse: server"+response.toString());
                if (response.code()==200){
                    Log.d(TAG, "onResponse:body "+response.body().toString());
                    Recipe recipe=response.body().getRecipe();
                    Log.d(TAG, "onResponse: Reserv"+recipe.toString());
                }
            }

            @Override
            public void onFailure(Call<RecipeResponse> call, Throwable t) {

            }
        });


    }
}
