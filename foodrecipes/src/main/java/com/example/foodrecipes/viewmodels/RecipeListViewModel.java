package com.example.foodrecipes.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.foodrecipes.models.Recipe;
import com.example.foodrecipes.repository.RecipeRepository;

import java.util.List;

public class RecipeListViewModel extends ViewModel {
//    private MutableLiveData<List<Recipe>>mRecipes=new MutableLiveData<>();
    private RecipeRepository mRecipeRepository;
    public RecipeListViewModel() {
        mRecipeRepository=RecipeRepository.getInstance();
    }
    public LiveData<List<Recipe>> getRecipe(){
        return mRecipeRepository.getRecipe();
    }

}

//16 prcelem  skel17