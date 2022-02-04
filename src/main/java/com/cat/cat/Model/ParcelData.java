package com.cat.cat.Model;


import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;
import java.time.LocalDate;




@Document(collection = "cat")
@Component
@Getter
@Setter
public class ParcelData {

    @Id
    private ObjectId _id;
    private Long orderId;
    private String name;
    private String itemType;
    private String startLocation;
    private String currentLocation;
    private LocalDate expectedDeliveryDate;
    private String status;



    public ParcelData(Long orderId,
                      String name,
                      String itemType,
                      String startLocation,
                      String currentLocation,
                      LocalDate expectedDeliveryDate,
                      String status,
                      String deliveryLocation) {
        this.orderId = orderId;
        this.name = name;
        this.itemType = itemType;
        this.startLocation = startLocation;
        this.currentLocation = currentLocation;
        this.expectedDeliveryDate = expectedDeliveryDate;
        this.status = status;
        this.deliveryLocation = deliveryLocation;
    }

    private String deliveryLocation;

    public ParcelData(ObjectId _id,
                      Long orderId,
                      String name,
                      String itemType,
                      String startLocation,
                      String currentLocation,
                      LocalDate expectedDeliveryDate,
                      String status,
                      String deliveryLocation) {
        this._id = _id;
        this.orderId = orderId;
        this.name = name;
        this.itemType = itemType;
        this.startLocation = startLocation;
        this.currentLocation = currentLocation;
        this.expectedDeliveryDate = expectedDeliveryDate;
        this.status = status;
        this.deliveryLocation = deliveryLocation;
    }

    public ParcelData(){}





}
