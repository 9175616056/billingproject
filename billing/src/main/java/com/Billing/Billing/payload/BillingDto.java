package com.Billing.Billing.payload;

import lombok.Data;

@Data
public class BillingDto {

    private int id;
    private int invoicenumber;
    private String taxes;
    private String description;
}
