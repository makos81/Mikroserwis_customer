package com.kodilla.customer.connector;

import com.kodilla.customer.dto.CustomerDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;

@FeignClient(name = "accounts", fallback = AccountsConnectorFallback.class)
public interface AccountsConnector {
    @GetMapping("/v1/accounts")
    CustomerDto getAccounts(@RequestParam("customerId") Long customerId);
}

@Component
@Slf4j
class AccountsConnectorFallback implements AccountsConnector {
    @Override
    public CustomerDto getAccounts(Long customerId) {
        log.warn("Can not get accounts for customer {} ", customerId);
        return new CustomerDto(Collections.emptyList());
    }
}