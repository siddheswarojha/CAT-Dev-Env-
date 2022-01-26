package com.cat.cat.Controller;


import com.cat.cat.Model.ParcelData;
import com.cat.cat.Services.TrackingServices;
import com.cat.cat.View.ParcelDataView;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/cat")
public class MainController {

    @Autowired
    private TrackingServices trackingServices;

    @GetMapping("/getTrackingDetails")
    public List<ParcelDataView> getAllTrackingDetail()
    {
       return trackingServices.getAllTrackingData();
    }



    @GetMapping("/getTrackingDetail/{orderId}")

    public Optional<ParcelData> getParticularTrackingDetail(@PathVariable("orderId") Long orderId)
    {
       return trackingServices.getParticularTrackingDetail(orderId);
    }


    @PostMapping("/saveTrackingDetail")
    public void setTrackingDetail(@RequestBody  ParcelData parcelData)
    {
        trackingServices.setTrackingDetail(parcelData);
    }






}
