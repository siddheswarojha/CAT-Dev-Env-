package com.cat.cat.Model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;


@Document(collection = "billData")
@Component
public class BillData {

    @Id
    private ObjectId _id;
    private Long orderId;
    private String price;
    private String itemType;
    private String taxation;
    private String discount;
    private String finalAmount;

    public ObjectId get_id() {
        return _id;
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public String getTaxation() {
        return taxation;
    }

    public void setTaxation(String taxation) {
        this.taxation = taxation;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getFinalAmount() {
        return finalAmount;
    }

    public void setFinalAmount(String finalAmount) {
        this.finalAmount = finalAmount;
    }



    public BillData(Long orderId,
                    String price,
                    String itemType,
                    String taxation,
                    String discount,
                    String finalAmount) {
        this.orderId = orderId;
        this.price = price;
        this.itemType = itemType;
        this.taxation = taxation;
        this.discount = discount;
        this.finalAmount = finalAmount;
    }



    public BillData(ObjectId _id,
                    Long orderId,
                    String price,
                    String itemType,
                    String taxation,
                    String discount,
                    String finalAmount) {
        this._id = _id;
        this.orderId = orderId;
        this.price = price;
        this.itemType = itemType;
        this.taxation = taxation;
        this.discount = discount;
        this.finalAmount = finalAmount;
    }

    public BillData(){

    }



}
