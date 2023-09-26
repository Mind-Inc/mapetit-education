package com.mindinc.edu.rest.beckn.model.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PaymentParams {
    @JsonProperty("transaction_id")
    private String transactionId;

    private String amount;
    private String currency;
    @JsonProperty("bank_code")
    private String bankCode;
    @JsonProperty("bank_account_number")
    private String bankAccountNumber;
    @JsonProperty("virtual_payment_address")
    private String virtualPaymentAddress;
    @JsonProperty("source_bank_code")
    private String sourceBankCode;
    @JsonProperty("source_bank_account_number")
    private String sourceBankAccountNumber;
    @JsonProperty("source_virtual_payment_address")
    private String sourceVirtualPaymentAddress;
}
