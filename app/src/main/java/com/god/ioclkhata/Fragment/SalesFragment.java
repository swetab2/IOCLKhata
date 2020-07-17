package com.god.ioclkhata.Fragment;


import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.god.ioclkhata.Adapter.ConsumerRecordAdapter;
import com.god.ioclkhata.Constant;
import com.god.ioclkhata.Model.ConsumerRecord;
import com.god.ioclkhata.NetworkCall.Api;
import com.god.ioclkhata.NetworkCall.RetrofitClient;
import com.god.ioclkhata.ProgressBarAccess;
import com.god.ioclkhata.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A simple {@link Fragment} subclass.
 */
public class SalesFragment extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private ConsumerRecordAdapter adapterA;
    private Api apiAccess;
    private RetrofitClient retrofitClient;
    private ProgressDialog progressDialog;

    public SalesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_sales, container, false);


        recyclerView = v.findViewById(R.id.rcv);
        layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        //gridLayoutManager = new GridLayoutManager(getContext(), 2, GridLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(retrofitClient.BaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        apiAccess = retrofit.create(Api.class);

        try {
            Thread.sleep(200);
            consumerRecord();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        return v;
    }


    public void consumerRecord() {
        progressDialog = ProgressBarAccess.createProgressDialog(getActivity());
        Call<List<ConsumerRecord>> call = apiAccess.getConsumerRecord("0");
        call.enqueue(new Callback<List<ConsumerRecord>>() {
            @Override
            public void onResponse(Call<List<ConsumerRecord>> call, Response<List<ConsumerRecord>> response) {
                progressDialog.dismiss();
                final List<ConsumerRecord> modelList = response.body();

                //  Log.d(Constant.TAGS, "List :" + modelList.size());
              //  Log.d(Constant.TAGS, "BrandId :" + modelList.size());
                adapterA = new ConsumerRecordAdapter(getContext(), (ArrayList<ConsumerRecord>) modelList);
                recyclerView.setAdapter(adapterA);
            }

            @Override
            public void onFailure(Call<List<ConsumerRecord>> call, Throwable t) {

            }
        });
    }

}
