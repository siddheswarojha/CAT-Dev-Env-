package com.cat.cat.Controller;


import com.cat.cat.Model.BillData;
import com.cat.cat.Model.ParcelData;
import com.cat.cat.Services.BillingServices;
import com.cat.cat.Services.TrackingServices;
import com.cat.cat.View.ParcelDataView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/cat")
public class MainController {

    @Autowired
    private TrackingServices trackingServices;

    @Autowired
    private BillingServices billingServices;


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


    @DeleteMapping("/cancelDelivery/{orderId}")

    public void cancelDelivery(@PathVariable("orderId") Long orderId)
    {
        trackingServices.cancelDelivery(orderId);
    }


//    @DeleteMapping("/deliveryCompleted/{orderId}")
//
//    public void completedDelivery(@PathVariable("orderId") Long orderId)
//    {
//        trackingServices.completedDelivery(orderId);
//    }


    @PutMapping("/deliveryCompleted/{orderId}")
    public void deliveryCompleted(@PathVariable("orderId") Long orderId,
                                  @RequestParam(required = false) String status)
    {
        trackingServices.deliveryCompleted(orderId,status);

    }




    @PostMapping("/generateBill/{orderId}")
    public void setBilling(@PathVariable Long orderId)
    {
        billingServices.setBilling(orderId);
    }




}
