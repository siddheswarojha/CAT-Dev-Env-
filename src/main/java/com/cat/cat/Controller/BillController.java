package com.cat.cat.Controller;

import com.cat.cat.Services.BillingServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/v1/cat")
public class BillController {


    @Autowired
    private BillingServices billingServices;


    @PostMapping("/generateBill/{orderId}")
    public String setBilling(@PathVariable String orderId)
    {
        try {
            return billingServices.setBilling(orderId);
        } catch (Exception e) {
            System.out.println("exception at bill controller");
        }

        return "error";
    }
}
