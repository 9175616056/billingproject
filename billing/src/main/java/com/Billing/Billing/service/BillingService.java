package com.Billing.Billing.service;

import com.Billing.Billing.payload.BillingDto;

public interface BillingService {

     BillingDto createBill(long patientId,BillingDto billingDto);
}
