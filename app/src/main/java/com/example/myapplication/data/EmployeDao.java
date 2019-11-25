package com.example.myapplication.data;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.myapplication.pojo.Employe;

import java.util.List;

@Dao
public interface EmployeDao {
    @Query("SELECT *FROM employees")
    LiveData<List<Employe>>getAllEmployees();
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertEmployees(List<Employe>employes);
    @Query("DELETE FROM employees")
void deletAllEmploye();
}
