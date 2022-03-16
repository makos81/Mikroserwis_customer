package com.kodilla.customer.service;

import com.kodilla.customer.dto.AccountDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;

import java.math.BigDecimal;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureStubRunner(
        stubsMode = StubRunnerProperties.StubsMode.LOCAL,
        ids = {
                "com.kodilla:minibank:+:stubs:9000"
        }
)
class ProductServiceTest {
    @Autowired
    private ProductService productService;

    @Test
    void findCustomerAccounts() {
        //Given
        Long customerId = 1L;

        //When
        List<AccountDto> accounts = productService.findCustomerAccounts(customerId);
//
//        //Then
        assertEquals(1, accounts.size());
        assertEquals("08897810189710581776778244", accounts.get(0).getNrb());
        assertEquals("PLN" ,accounts.get(0).getCurrency());
        assertEquals(BigDecimal.valueOf(100).setScale(2) ,accounts.get(0).getAvailableFunds());
    }

}
