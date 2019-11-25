package com.example.foodrecipes.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.foodrecipes.models.Recipe;

import java.util.List;

public class RecipeRepository {

    private static RecipeRepository instance;
    private MutableLiveData<List<Recipe>> mRecipe;
    public  static RecipeRepository getInstance(){
        if (instance==null){
            instance=new RecipeRepository();
        }
        return instance;
    }
    private RecipeRepository(){
mRecipe=new MutableLiveData<>();
    }
    public LiveData<List<Recipe>> getRecipe(){

        return mRecipe;
    }
}
