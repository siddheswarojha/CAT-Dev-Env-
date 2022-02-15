package com.cat.cat.Services;


import com.cat.cat.Model.BillData;
import com.cat.cat.Model.ParcelData;
import com.cat.cat.Repository.BillRepository;
import com.cat.cat.Repository.ParcelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BillingServices {

    @Autowired
    private ParcelRepository parcelRepository;

    @Autowired
    private BillRepository billRepository;



    @Transactional
    public String setBilling(Long orderId) {

        System.out.println(orderId);

        ParcelData parcelData = parcelRepository.findParcelDataByOrderId(orderId)
                .orElseThrow(()->new IllegalStateException("Order Id Not Found!"));


        BillData billData=new BillData();

        billData.setItemType(parcelData.getItemType());
        billData.setOrderId(orderId);
        switch (billData.getItemType()) {
            case "fragile": {
                double price = 500.00;
                billData.setDiscount("20%");
                double discount = price * 0.2;
                double tax = price * 0.18;
                double amount = price + tax - discount;
                System.out.println(amount);
                billData.setPrice(String.valueOf(price));
                billData.setTaxation(String.valueOf(tax));
                billData.setFinalAmount(String.valueOf(amount));
                billRepository.save(billData);
                return "Success";

            }
            case "electronics": {
                double price = 300.00;
                billData.setDiscount("10%");
                double discount = price * 0.1;
                double tax = price * 0.18;
                double amount = price + tax - discount;
                System.out.println(amount);
                billData.setPrice(String.valueOf(price));
                billData.setTaxation(String.valueOf(tax));
                billData.setFinalAmount(String.valueOf(amount));
                billRepository.save(billData);
                return "Success";

            }
            case "Normal": {
                double price = 100.00;
                billData.setDiscount("15%");
                double discount = price * 0.15;
                double tax = price * 0.18;
                double amount = price + tax - discount;
                System.out.println(amount);
                billData.setPrice(String.valueOf(price));
                billData.setTaxation(String.valueOf(tax));
                billData.setFinalAmount(String.valueOf(amount));
                billRepository.save(billData);
                return "Success";

            }
        }

            return "something went wrong";


    }
}
