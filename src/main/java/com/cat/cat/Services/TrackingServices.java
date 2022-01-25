package com.cat.cat.Services;



import com.cat.cat.Model.ParcelData;
import com.cat.cat.Repository.ParcelRepository;
import com.cat.cat.View.ParcelDataView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
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
        boolean checkDataWithOrderId = parcelRepository.existsById(orderId);
        if(!checkDataWithOrderId)
        {
            throw new IllegalStateException("No Such Order Id Found");
        }
        return parcelRepository.findById(orderId);

    }
}
