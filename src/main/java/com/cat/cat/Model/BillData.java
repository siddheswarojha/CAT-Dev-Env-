package com.cat.cat.Model;

import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

@Getter
@Setter
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
