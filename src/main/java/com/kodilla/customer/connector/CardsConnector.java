package com.kodilla.customer.connector;

import com.kodilla.customer.dto.CardsDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "cards", fallback = CardsConnectorFallback.class)
public interface CardsConnector {
    @GetMapping("/v1/cards")
    List<CardsDto> getCards(@RequestParam("customerId") Long customerId);
}
