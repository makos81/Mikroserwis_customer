package com.kodilla.customer.db;

import com.kodilla.customer.domain.CustomerInfo;
import org.springframework.data.repository.CrudRepository;

public interface MiniBankCustomerInfoRepository extends CrudRepository<CustomerInfo, Long> {
}
