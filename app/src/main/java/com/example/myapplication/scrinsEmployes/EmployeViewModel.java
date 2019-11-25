package com.example.myapplication.scrinsEmployes;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.myapplication.data.AppDataBase;
import com.example.myapplication.pojo.Employe;

import java.util.List;

public class EmployeViewModel extends AndroidViewModel {
    private AppDataBase db;
    private LiveData<List<Employe>> employes;
    public EmployeViewModel(@NonNull Application application) {
        super(application);
        db=AppDataBase.getInstance(application);
        employes=db.employeDao().getAllEmployees();
    }

    public EmployeViewModel(@NonNull Application application, LiveData<List<Employe>> employes) {
        super(application);
        this.employes = employes;
    }
    public void insertEmployees(List<Employe>employes){

    }

}
