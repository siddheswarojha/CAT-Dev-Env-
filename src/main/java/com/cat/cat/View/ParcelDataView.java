package com.cat.cat.View;

import com.cat.cat.Model.ParcelData;
import org.bson.types.ObjectId;

import java.time.LocalDate;

public class ParcelDataView {



    private Long orderId;
    private String name;
    private String itemType;
    private String startLocation;
    private String currentLocation;
    private LocalDate expectedDeliveryDate;
    private String status;
    private String deliveryLocation;

    public ParcelDataView(ParcelData pd)
    {

        this.orderId=pd.getOrderId();
        this.name =pd.getName();
        this.itemType=pd.getItemType();
        this.startLocation=pd.getStartLocation();
        this.currentLocation=pd.getCurrentLocation();
        this.expectedDeliveryDate=pd.getExpectedDeliveryDate();
        this.status=pd.getStatus();
        this.deliveryLocation= pd.getDeliveryLocation();
    }



    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
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

}
