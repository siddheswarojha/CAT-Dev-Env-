package com.cat.cat.Services;



import com.cat.cat.Model.BillData;
import com.cat.cat.Model.ParcelData;
import com.cat.cat.Repository.BillRepository;
import com.cat.cat.Repository.ParcelRepository;
import com.cat.cat.View.ParcelDataView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.*;


@Service
public class TrackingServices {

    @Autowired
    private ParcelRepository parcelRepository;




    @Autowired
    public TrackingServices(ParcelRepository parcelRepository) {

        this.parcelRepository = parcelRepository;
    }


    public List<ParcelDataView> getAllTrackingData() {

        List<ParcelData> parcelData = parcelRepository.findAll();
        List<ParcelDataView> responses = new ArrayList<>();
        for (ParcelData pd:parcelData){
            ParcelDataView parcelResponse = new ParcelDataView(pd);
            responses.add(parcelResponse);
        }
        return responses;
    }

    public Optional<ParcelData> getParticularTrackingDetail(String orderId) {
//        boolean checkDataWithOrderId = parcelRepository.existsById(orderId);
//        if(!checkDataWithOrderId)
//        {
//            throw new IllegalStateException("No Such Order Id Found");
//        }
//        return parcelRepository.findById(orderId);

        Optional<ParcelData> parcelOptional = parcelRepository.findParcelDataByOrderId(orderId);

        if(!parcelOptional.isPresent())
        {
            throw new IllegalStateException("Parcel Not Found");

        }
        return parcelRepository.findParcelDataByOrderId(orderId);

    }

    public String setTrackingDetail(Map<String,String> parcelData) {

      String orderId =   generateOrderId();

//        Optional<ParcelData> parcelOptional = parcelRepository.findParcelDataByOrderId(Long.valueOf(parcelData.get("orderId")));
//
//        if(parcelOptional.isPresent())
//        {
//            throw new IllegalStateException("OrderId should be Unique");
//
//        }

        ParcelData pd = new ParcelData();
        pd.setOrderId(orderId);
        pd.setStatus(parcelData.get("status"));
        pd.setItemType(parcelData.get("itemType"));
        pd.setCurrentLocation(parcelData.get("currentLocation"));
        pd.setDeliveryLocation(parcelData.get("deliveryLocation"));
        pd.setStartLocation(parcelData.get("startLocation"));
        pd.setName(parcelData.get("name"));
        pd.setExpectedDeliveryDate(LocalDate.parse(parcelData.get("expectedDeliveryDate")));

        parcelRepository.save(pd);
        return orderId;
    }

    private String generateOrderId() {

        Random rd = new Random();
        String id = String.valueOf(rd.nextInt(10000));
//        String id = String.valueOf(Math.random(0,1000000));
        Optional<ParcelData> parcelOptional = parcelRepository.findParcelDataByOrderId(id);

        if(parcelOptional.isPresent())
        {
           generateOrderId();

        }
        else
        {
            return id;
        }
        return id;


    }

    public String cancelDelivery(String orderId) {

        Optional<ParcelData> parcelOptional = parcelRepository.findParcelDataByOrderId(orderId);

        if(!parcelOptional.isPresent())
        {
            throw new IllegalStateException("OrderId not found!!");

        }

        parcelRepository.deleteParcelDataByOrderId(orderId);
        return "Order Canceled";
    }

    @Transactional
    public void deliveryCompleted(String orderId, String status) {
        ParcelData parcelData= parcelRepository.findParcelDataByOrderId(orderId)
                .orElseThrow(()->new IllegalStateException("Parcel Not Found"));

        if(!Objects.equals(parcelData.getStatus(),status))
        {

            System.out.println("STATUS UPDATED");
            parcelData.setStatus(status);
            parcelRepository.save(parcelData);
            System.out.println(status);
        }


    }



//    public void completedDelivery(Long orderId) {
//
//        Optional<ParcelData> parcelOptional = parcelRepository.findParcelDataByOrderId(orderId);
//
//        if(!parcelOptional.isPresent())
//        {
//            throw new IllegalStateException("OrderId not found!!");
//
//        }
//
//        parcelRepository.deleteParcelDataByOrderId(orderId);
//    }
}

