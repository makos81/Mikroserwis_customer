package com.kodilla.customer.service;

import com.kodilla.customer.connector.CardsConnector;
import com.kodilla.customer.dto.CardsDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CardsProvider {
    private final CardsConnector cardsConnector;

    public List<CardsDto> getCards(Long customerId){
        return cardsConnector.getCards(customerId).stream()
                .map( cardsDto -> (
                        new CardsDto(
                                cardsDto.getCurrency(),
                                cardsDto.getAccountNumber(),
                                cardsDto.getBalance()
                        )
                )).collect(Collectors.toList());
    }
}
