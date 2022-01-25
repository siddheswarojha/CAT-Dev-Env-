package com.cat.cat.View;

import com.cat.cat.Model.ParcelData;

import java.time.LocalDate;

public class ParcelDataView {


    private Long _id;

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

    private String name;
    private String itemType;
    private String startLocation;
    private String currentLocation;
    private LocalDate expectedDeliveryDate;
    private String status;
    private String deliveryLocation;


    public ParcelDataView(ParcelData data)
    {
        this._id = data.getOrderId();
        this.name =data.getName();
        this.itemType= data.getItemType();
        this.startLocation = data.getStartLocation();
        this.currentLocation= data.getCurrentLocation();
        this.expectedDeliveryDate=data.getExpectedDeliveryDate();
        this.status=data.getStatus();
        this.deliveryLocation= data.getDeliveryLocation();
    }
}
