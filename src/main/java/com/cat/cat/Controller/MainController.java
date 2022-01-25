package com.cat.cat.Controller;


import com.cat.cat.Services.TrackingServices;
import com.cat.cat.View.ParcelDataView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

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





}
