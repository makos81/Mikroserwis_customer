package com.kodilla.customer.controller;

import com.google.gson.Gson;
import com.kodilla.customer.dto.CustomerInfoDto;
import com.kodilla.customer.service.MiniBankCustomerInfoService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

@WebMvcTest(CustomerController.class)
public class CustomerControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private MiniBankCustomerInfoService miniBankCustomerInfoService;

//    @Test
//    public void shouldReturnCustomerWhenExists() throws Exception {
//        when(miniBankCustomerInfoService.getCustomer(2L)).thenReturn(createCustomerInfoDto());
//        mockMvc.perform(MockMvcRequestBuilders.get("/customer/2"))
//                .andExpect(MockMvcResultMatchers.status().is(200))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(2))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.firstName").value("testName"))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.lastName").value("testLastName"));
//    }
//
//    @Test
//    public void shouldNotReturnCustomerWhenDoNotExists() throws Exception {
//        mockMvc.perform(MockMvcRequestBuilders.get("/customer/2"))
//                .andExpect(MockMvcResultMatchers.jsonPath("$").doesNotExist());
//    }
//
//    @Test
//    public void shouldCallSaveRepository() throws Exception {
//        Gson gson = new Gson();
//        String messageWithCustomerDto = gson.toJson(createCustomerInfoDto(), CustomerInfoDto.class);
//        mockMvc.perform(
//                MockMvcRequestBuilders
//                        .post("/customer/addCustomer")
//                        .content(messageWithCustomerDto)
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .characterEncoding("UTF-8")
//        );
//        Mockito.verify(miniBankCustomerInfoService, times(1)).addCustomer(any());
//
//    }

    private CustomerInfoDto createCustomerInfoDto() {
        return CustomerInfoDto.builder()
                .id(2L)
                .firstName("testName")
                .lastName("testLastName")
                .build();
    }
}
