package com.kodilla.customer.controller;

import com.kodilla.customer.dto.AccountDto;
import com.kodilla.customer.dto.CardsDto;
import com.kodilla.customer.dto.CustomerInfoDto;
import com.kodilla.customer.dto.GetCustomerProductsResponse;
import com.kodilla.customer.service.CardsService;
import com.kodilla.customer.service.MiniBankCustomerInfoService;
import com.kodilla.customer.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
@Slf4j
public class CustomerController {
    private final MiniBankCustomerInfoService miniBankCustomerInfoService;
    private final ProductService productService;
    private final MiniBankCustomerInfoService customerService;
    private final CardsService cardsService;

    @GetMapping("/{idCustomer}")
    public ResponseEntity<CustomerInfoDto> getCustomer(@PathVariable Long idCustomer) {
        return ResponseEntity.ok(miniBankCustomerInfoService.getCustomer(idCustomer));
    }

    @PostMapping(value = "addCustomer")
    public void addCustomer(@RequestBody CustomerInfoDto customerInfoDto) {
        miniBankCustomerInfoService.addCustomer(customerInfoDto);
    }

    @GetMapping("/{customerId}/products")
    public GetCustomerProductsResponse getCustomerProducts(@PathVariable Long customerId) {
        CustomerInfoDto customerInfoDto = customerService.getCustomer(customerId);
        log.info("getting customer products info for customerId {} ", customerId);
        List<AccountDto> customerAccounts = productService.findCustomerAccounts(customerId);
        log.info("getting cards information for customeId{} ", customerId);
        List<CardsDto> cardsDtos = cardsService.getCards(customerId);

        return GetCustomerProductsResponse.builder()
                .customerId(customerInfoDto.getId())
                .fullName(customerInfoDto.getFirstName() + " " + customerInfoDto.getLastName())
                .accounts(customerAccounts)
                .cards(cardsDtos)
                .build();
    }
}
