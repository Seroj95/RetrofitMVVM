package com.example.myapplication.api;

import com.example.myapplication.pojo.EmployeResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiService {
    @GET("testTask.json")
    Observable<EmployeResponse> getEmployees();

}
