package com.kodilla.customer.service;

import com.kodilla.customer.db.MiniBankCustomerInfoRepository;
import com.kodilla.customer.domain.CustomerInfo;
import com.kodilla.customer.dto.CustomerInfoDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class MiniBankCustomerInfoService {
    private final ModelMapper modelMapper;
    private final MiniBankCustomerInfoRepository miniBankCustomerInfoRepository;

    public CustomerInfoDto getCustomer(Long idCustomer){
        CustomerInfo customerInfo = miniBankCustomerInfoRepository.findById(idCustomer).orElseThrow(
                ()-> new ResponseStatusException(HttpStatus.BAD_REQUEST));

        return modelMapper.map(customerInfo, CustomerInfoDto.class);
    }

    public void addCustomer(CustomerInfoDto customerInfoDto){
        CustomerInfo customerInfo = customerInfoDto==null ? null : modelMapper.map(customerInfoDto, CustomerInfo.class);
        miniBankCustomerInfoRepository.save(customerInfo);
    }
}
