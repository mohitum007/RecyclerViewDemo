package com.mohitum.recyclerviewdemo.presentation;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.mohitum.recyclerviewdemo.R;
import com.mohitum.recyclerviewdemo.models.UsersResponse;
import com.mohitum.recyclerviewdemo.api.ApiClient;
import com.mohitum.recyclerviewdemo.api.IApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recVwDemo;

    private IApiInterface apiService;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recVwDemo = (RecyclerView) findViewById(R.id.recVwDemo);

        apiService = ApiClient.getClient().create(IApiInterface.class);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(MainActivity.this);
        recVwDemo.setLayoutManager(mLayoutManager);

        getPapersData();
    }


    private void getPapersData(){
        progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setMessage("Loading, please wait...");
        progressDialog.setCancelable(false);
        progressDialog.setIndeterminate(true);
        progressDialog.show();
        Call<UsersResponse> call = apiService.getDemoUsers("2");
        call.enqueue(new Callback<UsersResponse>() {
            @Override
            public void onResponse(Call<UsersResponse> call, Response<UsersResponse> response) {
                if(progressDialog != null && progressDialog.isShowing()){
                    progressDialog.dismiss();
                }
                UsersResponse usersResponse = response.body();

                DemoAdapter adapter = new DemoAdapter(MainActivity.this, usersResponse.getData());
                recVwDemo.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<UsersResponse> call, Throwable t) {
                if(progressDialog != null && progressDialog.isShowing()){
                    progressDialog.dismiss();
                }
                Log.e(getString(R.string.app_name), t.getMessage());
            }
        });
    }

}
