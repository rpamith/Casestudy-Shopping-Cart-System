package com.shopping.customerservice.Repository;


import com.shopping.service.CustomerService;

import com.shopping.model.CustomerDetails;
import com.shopping.repository.CustomerRepository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
class CustomerRepositoryTest {
    @MockBean
    private CustomerRepository customerRepository;
    @Autowired
    private CustomerService customerService;
    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    public void getCustomerTest() {
    	
    	
    	when(customerRepository.findAll()).thenReturn(Stream
                .of(new CustomerDetails( "4","Amit","amit@gmail.com","8234567890","amitAddress","345")).collect(Collectors.toList()));
        assertEquals(1,customerService.getCustomerDetails().size());
    }

    }