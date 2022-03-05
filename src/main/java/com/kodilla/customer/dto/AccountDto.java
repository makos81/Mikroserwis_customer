package com.kodilla.customer.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccountDto {
    private String nrb;
    private String currency;
    private BigDecimal availableFunds;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private CustomerDto customerDto;

    public AccountDto(String nrb, String currency, BigDecimal availableFunds) {
        this.nrb = nrb;
        this.currency = currency;
        this.availableFunds = availableFunds;
    }
}
