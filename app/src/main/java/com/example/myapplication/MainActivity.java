package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.myapplication.adapters.EmployeAdapter;
import com.example.myapplication.api.ApiFactory;
import com.example.myapplication.api.ApiService;
import com.example.myapplication.pojo.Employe;
import com.example.myapplication.pojo.EmployeResponse;

import java.util.ArrayList;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {
private RecyclerView recyclerViewEmployes;
private EmployeAdapter adapter;
   private Disposable disposable;
   private CompositeDisposable compositeDisposable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerViewEmployes=findViewById(R.id.recyclerViewEmployes);

        adapter=new EmployeAdapter();
        adapter.setEmployes(new ArrayList<Employe>());
        recyclerViewEmployes.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewEmployes.setAdapter(adapter);
//        List<Employe> employes=new ArrayList<>();
//        Employe employe1=new Employe();
//        Employe employe2=new Employe();
//        employe1.setName("Seroj");
//        employe2.setName("Poxos");
//        employe1.setLName("Grigoryan");
//        employe2.setLName("Poxosyan");
//        employes.add(employe1);
//        employes.add(employe2);
//        adapter.setEmployes(employes);

        ApiFactory apiFactory=ApiFactory.getInstance();
       ApiService apiService=apiFactory.getApiService();
       compositeDisposable=new CompositeDisposable();
  disposable= apiService.getEmployees().subscribe(Schedulers.io())
            .observen(AndroidSchedulers.mainThread())
            .subscribe(new Consumer<EmployeResponse>() {
                @Override
                public void accept(EmployeResponse employeResponse) throws Exception {
adapter.setEmployes(employeResponse.getResponse());
                }
            }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                Toast.makeText(MainActivity.this, "Oshibka dany", Toast.LENGTH_SHORT).show();
            }
        });
  compositeDisposable.add(disposable);


    }

    @Override
    protected void onDestroy() {
        if (compositeDisposable != null){
            compositeDisposable.dispose();
        }
        super.onDestroy();
    }
}
