package com.kodilla.customer.service;

import com.kodilla.customer.connector.AccountsConnector;
import com.kodilla.customer.dto.AccountDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AccountsProvider {
    private final AccountsConnector accountsConnector;

    public List<AccountDto> getCustomerAccounts(Long customerId) {
        return accountsConnector.getAccounts(customerId)
                .getAccounts()
                .stream()
                .map(account -> new AccountDto(
                        account.getNrb(),
                        account.getCurrency(),
                        account.getAvailableFunds()))
                .collect(Collectors.toList());
    }

}
