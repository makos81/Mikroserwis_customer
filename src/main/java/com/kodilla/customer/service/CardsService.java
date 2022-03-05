package com.kodilla.customer.service;

import com.kodilla.customer.dto.CardsDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CardsService {
    private final CardsProvider cardsProvider;

    public List<CardsDto> getCards(Long customerId){
        return cardsProvider.getCards(customerId);
    }

}
