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
import android.widget.TextView;

import com.god.ioclkhata.Adapter.ConsumerRecordAdapter;
import com.god.ioclkhata.Adapter.CreditAdapter;
import com.god.ioclkhata.Constant;
import com.god.ioclkhata.Model.ConsumerRecord;
import com.god.ioclkhata.Model.CreditModel;
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
public class CreditFragment extends Fragment {


    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private CreditAdapter adapterA;
    private Api apiAccess;
    private RetrofitClient retrofitClient;
    private ProgressDialog progressDialog;
    private ArrayList<CreditModel> modellist;
    private TextView credit_amount;
    private CreditModel tmodel;


    public CreditFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_credit, container, false);


        recyclerView = v.findViewById(R.id.rcv);
        layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        //gridLayoutManager = new GridLayoutManager(getContext(), 2, GridLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        credit_amount = v.findViewById(R.id.tv_amt_credit);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(retrofitClient.BaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        apiAccess = retrofit.create(Api.class);
        try {
            Thread.sleep(200);
            credit();
            //   sum(tmodel);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return v;
    }


    public void sum(CreditModel tmodel) {
        int credit = Integer.parseInt(tmodel.getAmountCredit());
        int total_sum = 0;
        for (int i = 0; i < modellist.size(); i++) {
            CreditModel cm = modellist.get(i);
            int price = Integer.parseInt(cm.getAmountCredit());
            total_sum += price;
            Log.d(Constant.TAGS, " credit sum by swetabh :" + total_sum);
            credit_amount.setText(total_sum);
        }
    }

    public void credit() {
        progressDialog = ProgressBarAccess.createProgressDialog(getActivity());
        Call<List<CreditModel>> call = apiAccess.getCredit("0");
        call.enqueue(new Callback<List<CreditModel>>() {
            @Override
            public void onResponse(Call<List<CreditModel>> call, Response<List<CreditModel>> response) {
                progressDialog.dismiss();
                final List<CreditModel> modelList = response.body();

                // modelList.add(tmodel);
                // credit_amount.setText((CharSequence) modelList.get(Integer.parseInt(tmodel.getAmountCredit())));
                // Log.d(Constant.TAGS, "price :" + modelList.add(tmodel.getAmountCredit());
                //        credit_amount.setText(modelList.size());

                credit_amount.setText(Integer.toString(modelList.size()));
                adapterA = new CreditAdapter(getContext(), (ArrayList<CreditModel>) modelList);
                recyclerView.setAdapter(adapterA);
            }

            @Override
            public void onFailure(Call<List<CreditModel>> call, Throwable t) {

            }
        });

    }

}
