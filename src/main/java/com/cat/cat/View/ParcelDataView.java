package com.cat.cat.View;

import com.cat.cat.Model.ParcelData;
import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;

import java.time.LocalDate;


@Getter
@Setter
public class ParcelDataView {



    private String orderId;
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

}
