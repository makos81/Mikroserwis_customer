package com.kodilla.customer.controller;

import com.kodilla.customer.dto.CustomerInfoDto;
import com.kodilla.customer.service.MiniBankCustomerInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomerController {
    private final MiniBankCustomerInfoService miniBankCustomerInfoService;

    @GetMapping("/{idCustomer}")
    public ResponseEntity<CustomerInfoDto> getCustomer(@PathVariable Long idCustomer) {
        return ResponseEntity.ok(miniBankCustomerInfoService.getCustomer(idCustomer));
    }

    @PostMapping(value = "addCustomer")
    public void addCustomer(@RequestBody CustomerInfoDto customerInfoDto) {
        miniBankCustomerInfoService.addCustomer(customerInfoDto);
    }
}
