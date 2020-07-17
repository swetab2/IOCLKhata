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
import com.god.ioclkhata.Model.ConsumerRecord;
import com.god.ioclkhata.Model.RecordModel;
import com.god.ioclkhata.R;

import java.util.ArrayList;
import java.util.List;

public class ConsumerRecordAdapter extends RecyclerView.Adapter<ConsumerRecordAdapter.MyViewHolder> {


    private Context context;
    private ArrayList<ConsumerRecord> modellist;


    public ConsumerRecordAdapter(Context context, ArrayList<ConsumerRecord> modellist) {
        this.context = context;
        this.modellist = modellist;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.model_cusomer, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final ConsumerRecord tmodel = modellist.get(position);
        holder.consumer_name.setText(tmodel.getConsumerName());
        holder.consumer_no.setText(tmodel.getConsumerNo());
        holder.cylinder_count.setText(tmodel.getCylinderCount());
        holder.paid_amount.setText(tmodel.getPaidAmount());
        holder.contact_no.setText(tmodel.getContactNo());
        // holder.amount_credit.setText(tmodel.getAmountCredit());

        //  ; Log.d(Constant.TAGS, " PaidAmount :" + tmodel.getAmountCredit())


    }


    @Override
    public int getItemCount() {
        return modellist.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView consumer_name, consumer_no, cylinder_count, paid_amount, contact_no, amount_credit, time_date;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            consumer_name = itemView.findViewById(R.id.m_name);
            consumer_no = itemView.findViewById(R.id.m_no);
            cylinder_count = itemView.findViewById(R.id.m_cylinder_count);
            paid_amount = itemView.findViewById(R.id.m_amt_paid);
            contact_no = itemView.findViewById(R.id.m_contact_no);
            //  amount_credit = itemView.findViewById(R.id.m_amt_credit);
            time_date = itemView.findViewById(R.id.m_time_date);
        }
    }
}
