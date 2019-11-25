package com.example.myapplication.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class EmployeResponse {
    @SerializedName("response")
    @Expose
    private List<Employe> response = null;

    public List<Employe> getResponse() {
        return response;
    }

    public void setResponse(List<Employe> response) {
        this.response = response;
    }
}
