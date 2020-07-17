package com.god.ioclkhata.Fragment;


import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.fragment.app.Fragment;

import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.god.ioclkhata.Model.RecordModel;
import com.god.ioclkhata.NetworkCall.RetrofitClient;
import com.god.ioclkhata.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class DashBoardFragment extends Fragment {
    private EditText consumer_no, consumer_name, c_count, amount_paid, mo_no, amount_credit;
    private Button submit;


    public DashBoardFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_dash_board, container, false);
        consumer_no = v.findViewById(R.id.c_no);
        consumer_name = v.findViewById(R.id.c_name);
        c_count = v.findViewById(R.id.c_count);
        amount_paid = v.findViewById(R.id.amount_paid);
        mo_no = v.findViewById(R.id.m_no);
        amount_credit = v.findViewById(R.id.amount_credit);
        submit = v.findViewById(R.id.submit_bnt);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                long start = System.currentTimeMillis();
                try {
                    Thread.sleep(2000);
                    userdetails();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });

        return v;
    }

    public void userdetails() {
        String cno = consumer_no.getText().toString().trim();
        String cname = consumer_name.getText().toString().trim();
        String ccount = c_count.getText().toString().trim();
        String amountpaid = amount_paid.getText().toString().trim();
        String mno = mo_no.getText().toString().trim();
        String amountcredit = amount_credit.getText().toString().trim();
        init(cno, cname, ccount, amountpaid, mno, amountcredit);

    }

    public void init(String str_cname, String strCno, String str_ccount, String str_amtpaid, String str_mno, String str_amtcredit) {

        Call<RecordModel> call = RetrofitClient.getInstance().getApi().userRegister(str_cname, strCno, str_ccount, str_amtpaid, str_mno, str_amtcredit);
        call.enqueue(new Callback<RecordModel>() {
            @Override
            public void onResponse(Call<RecordModel> call, Response<RecordModel> response) {
                RecordModel tModel = response.body();
                Toast.makeText(getActivity(), tModel.getMessage(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<RecordModel> call, Throwable t) {
                Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }






}
