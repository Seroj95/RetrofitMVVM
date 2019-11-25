package com.example.myapplication.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.pojo.Employe;

import java.util.List;

public class EmployeAdapter extends RecyclerView.Adapter <EmployeAdapter.EmployeViewHolder>{
private List<Employe> employes;

    public EmployeAdapter() {
    }

    public EmployeAdapter(List<Employe> employes) {
        this.employes = employes;
    }

    public List<Employe> getEmployes() {
        return employes;
    }

    public void setEmployes(List<Employe> employes) {
        this.employes = employes;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public EmployeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

       View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.employe_item, parent, false);
        return new EmployeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EmployeViewHolder holder, int position) {
Employe employe=employes.get(position);
holder.textViewName.setText(employe.getName());
holder.textViewLastName.setText(employe.getLName());
    }

    @Override
    public int getItemCount() {
        return employes.size();
    }


    class EmployeViewHolder extends RecyclerView.ViewHolder{
private TextView textViewName;
private  TextView textViewLastName;

        public EmployeViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewName=itemView.findViewById(R.id.textViewName);
            textViewLastName=itemView.findViewById(R.id.textViewLastName);
        }
    }
}
