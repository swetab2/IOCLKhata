package com.god.ioclkhata.Model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CreditModel {

    @SerializedName("consumer_name")
    @Expose
    private String consumerName;
    @SerializedName("consumer_no")
    @Expose
    private String consumerNo;
    @SerializedName("cylinder_count")
    @Expose
    private String cylinderCount;
    @SerializedName("contact_no")
    @Expose
    private String contactNo;
    @SerializedName("amount_credit")
    @Expose
    private String amountCredit;
    @SerializedName("refid")
    @Expose
    private String refid;

    public String getConsumerName() {
        return consumerName;
    }

    public void setConsumerName(String consumerName) {
        this.consumerName = consumerName;
    }

    public String getConsumerNo() {
        return consumerNo;
    }

    public void setConsumerNo(String consumerNo) {
        this.consumerNo = consumerNo;
    }

    public String getCylinderCount() {
        return cylinderCount;
    }

    public void setCylinderCount(String cylinderCount) {
        this.cylinderCount = cylinderCount;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getAmountCredit() {
        return amountCredit;
    }

    public void setAmountCredit(String amountCredit) {
        this.amountCredit = amountCredit;
    }

    public String getRefid() {
        return refid;
    }

    public void setRefid(String refid) {
        this.refid = refid;
    }

}
