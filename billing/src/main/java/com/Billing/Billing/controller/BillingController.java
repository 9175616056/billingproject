package com.Billing.Billing.controller;

import com.Billing.Billing.payload.BillingDto;
import com.Billing.Billing.service.BillingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Billing/billing")
public class BillingController {

    @Autowired
    private BillingService billingService;

    @PostMapping
    public ResponseEntity<BillingDto>created(@PathVariable("patientId")long patientId, @RequestBody BillingDto billingDto){
        return new ResponseEntity<>(billingService.createBill(patientId,billingDto), HttpStatus.CREATED);
    }
}
//    @PostMapping("/patient/{patientId}/billings")
//    public ResponseEntity<BillingDto>created(@PathVariable("patientId")long patientId, @RequestBody BillingDto billingDto){
//        return new ResponseEntity<>(billingService.createBill(patientId,billingDto), HttpStatus.CREATED);
//    }