package com.cat.cat.Services;



import com.cat.cat.Model.ParcelData;
import com.cat.cat.Repository.ParcelRepository;
import com.cat.cat.View.ParcelDataView;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;


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

    public Optional<ParcelData> getParticularTrackingDetail(Long orderId) {
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

    public void setTrackingDetail(ParcelData parcelData) {
        Optional<ParcelData> parcelOptional = parcelRepository.findParcelDataByOrderId(parcelData.getOrderId());

        if(parcelOptional.isPresent())
        {
            throw new IllegalStateException("OrderId should be Unique");

        }



        parcelRepository.save(parcelData);
    }

    public void cancelDelivery(Long orderId) {

        Optional<ParcelData> parcelOptional = parcelRepository.findParcelDataByOrderId(orderId);

        if(!parcelOptional.isPresent())
        {
            throw new IllegalStateException("OrderId not found!!");

        }

        parcelRepository.deleteParcelDataByOrderId(orderId);
    }

    @Transactional
    public void deliveryCompleted(Long orderId, String status) {
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

