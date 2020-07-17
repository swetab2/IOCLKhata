package com.god.ioclkhata.NetworkCall;

import com.god.ioclkhata.Model.ConsumerRecord;
import com.god.ioclkhata.Model.CreditModel;
import com.god.ioclkhata.Model.RecordModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface Api {

    @FormUrlEncoded
    @POST("iocl/ioclpost.php")
    Call<RecordModel> userRegister(
            @Field("cname") String cname,
            @Field("cno") String cno,
            @Field("ccount") String ccount,
            @Field("paidamount") String paidamount,
            @Field("mno") String mno,
            @Field("credit") String credit

    );


    @FormUrlEncoded
    @POST("iocl/cdetails.php ")
    Call<List<ConsumerRecord>> getConsumerRecord(
            @Field("allcontent") String consumerRecord
    );

    @FormUrlEncoded
    @POST("iocl/ioclcredit.php ")
    Call<List<CreditModel>> getCredit(
            @Field("credit") String credit
    );
}
