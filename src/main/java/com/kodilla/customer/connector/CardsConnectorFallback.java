package com.kodilla.customer.connector;

import com.kodilla.customer.dto.CardsDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
@Slf4j
public class CardsConnectorFallback implements CardsConnector{
    @Override
    public List<CardsDto> getCards(Long customerId) {
        log.warn("Could not get cards for customer{}", customerId);
        return Collections.emptyList();
    }
}
