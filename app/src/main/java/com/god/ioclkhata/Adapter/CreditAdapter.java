package com.god.ioclkhata.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.god.ioclkhata.Constant;
import com.god.ioclkhata.Model.CreditModel;
import com.god.ioclkhata.R;
import java.util.ArrayList;


public class CreditAdapter extends RecyclerView.Adapter<CreditAdapter.MyViewHolder> {

    private Context context;
    private ArrayList<CreditModel> modellist;
    private TextView credit_amount;


    public CreditAdapter(Context context, ArrayList<CreditModel> modellist) {
        this.context = context;
        this.modellist = modellist;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.credit, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        int total = 0;
        CreditModel tmodel = modellist.get(position);
        holder.s_consumer_name.setText(tmodel.getConsumerName());
        holder.s_consumer_no.setText(tmodel.getConsumerNo());
        holder.s_cylinder_count.setText(tmodel.getCylinderCount());
        holder.s_amount_credit.setText(tmodel.getAmountCredit());
        //  Log.d(Constant.TAGS, " model  :" + tmodel.getAmountCredit());
        int credit = Integer.parseInt(tmodel.getAmountCredit());
        //   credit_amount.setText("hello");
        sum(tmodel);
    }

    // Log.d(Constant.TAGS, " credit sum :" + sum("",tmodel));
    public void sum( CreditModel tmodel) {
        int credit = Integer.parseInt(tmodel.getAmountCredit());
        int total_sum = 0;
        for (int i = 0; i < modellist.size(); i++) {
            CreditModel cm = modellist.get(i);
            int price = Integer.parseInt(cm.getAmountCredit());
            total_sum += price;
            Log.d(Constant.TAGS, " credit sum by swetabh :" + total_sum);
        }
    }
    @Override
    public int getItemCount() {
        return modellist.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView s_consumer_name, s_consumer_no, s_cylinder_count, s_contact_no, s_amount_credit, s_time_date;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            s_consumer_name = itemView.findViewById(R.id.ms_name);
            s_consumer_no = itemView.findViewById(R.id.ms_no);
            s_cylinder_count = itemView.findViewById(R.id.ms_cylinder_count);
            s_contact_no = itemView.findViewById(R.id.ms_contact_no);
            s_amount_credit = itemView.findViewById(R.id.ms_amt_credit);
            s_time_date = itemView.findViewById(R.id.ms_time_date);
        }
    }
}
