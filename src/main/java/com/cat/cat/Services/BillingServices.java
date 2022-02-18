package com.cat.cat.Services;


import com.aspose.cells.*;
import com.cat.cat.Model.BillData;
import com.cat.cat.Model.ParcelData;
import com.cat.cat.Repository.BillRepository;
import com.cat.cat.Repository.ParcelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Service
public class BillingServices {

    @Autowired
    private ParcelRepository parcelRepository;

    @Autowired
    private BillRepository billRepository;



    @Transactional
    public String setBilling(String orderId) throws Exception {

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

/*

start
 */

                System.out.println("starting pdf creation successfully");

//                Workbook workbook = new Workbook();
//                Worksheet worksheet = workbook.getWorksheets().get(0);
////                String fileName = billData.toString();
////                String content = new String(Files.readAllBytes(Paths.get(fileName)));
//
//                String content = new String(billData.toString());
//                System.out.println(billData);
//
//                JsonLayoutOptions layoutOptions = new JsonLayoutOptions();
//                layoutOptions.setArrayAsTable(true);
//                JsonUtility.importData(content, worksheet.getCells(), 0, 0, layoutOptions);
//                workbook.save("output.pdf", SaveFormat.AUTO);

                System.out.println("reached pdf creation successfully");

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
