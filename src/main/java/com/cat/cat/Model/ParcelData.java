package com.cat.cat.Model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import java.time.LocalDate;




@Document(collection = "cat")
@Component
public class ParcelData {

    @Id
    private Long _id;
    private String name;
    private String itemType;
    private String startLocation;
    private String currentLocation;
    private LocalDate expectedDeliveryDate;
    private String status;
    private String deliveryLocation;

    public Long getOrderId() {
        return _id;
    }

    public void setOrderId(Long _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public String getStartLocation() {
        return startLocation;
    }

    public void setStartLocation(String startLocation) {
        this.startLocation = startLocation;
    }

    public String getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(String currentLocation) {
        this.currentLocation = currentLocation;
    }

    public LocalDate getExpectedDeliveryDate() {
        return expectedDeliveryDate;
    }

    public void setExpectedDeliveryDate(LocalDate expectedDeliveryDate) {
        this.expectedDeliveryDate = expectedDeliveryDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDeliveryLocation() {
        return deliveryLocation;
    }

    public void setDeliveryLocation(String deliveryLocation) {
        this.deliveryLocation = deliveryLocation;
    }




    public ParcelData(Long _id,
                      String name,
                      String itemType,
                      String startLocation,
                      String currentLocation,
                      LocalDate expectedDeliveryDate,
                      String status,
                      String deliveryLocation) {
        this._id = _id;
        this.name = name;
        this.itemType = itemType;
        this.startLocation = startLocation;
        this.currentLocation = currentLocation;
        this.expectedDeliveryDate = expectedDeliveryDate;
        this.status = status;
        this.deliveryLocation = deliveryLocation;
    }

    private ParcelData()
    {}

    public ParcelData(
                      String name,
                      String itemType,
                      String startLocation,
                      String currentLocation,
                      LocalDate expectedDeliveryDate,
                      String status,
                      String deliveryLocation) {
        this.name = name;
        this.itemType = itemType;
        this.startLocation = startLocation;
        this.currentLocation = currentLocation;
        this.expectedDeliveryDate = expectedDeliveryDate;
        this.status = status;
        this.deliveryLocation = deliveryLocation;
    }


}