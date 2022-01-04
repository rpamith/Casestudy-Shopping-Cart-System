package com.shopping;

import com.shopping.models.Admin;
import com.shopping.repository.AdminRepository;
import com.shopping.service.AdminService;
import com.shopping.controller.AdminController;
import com.shopping.controller.AdminOrderController;
import com.shopping.exception.ApiExceptionHandler;
import com.shopping.exception.ApiRequestException;
import com.shopping.models.AdminAuthResponse;
import com.shopping.models.OrderModel;

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
class AdminApplicationTests {
	@MockBean
    private AdminRepository adminRepository;
    @Autowired
    private AdminService adminService;
    
    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {}

        @Test
        public void getAdminTest() {
        	
        	
        	when(adminRepository.findAll()).thenReturn(Stream
                    .of(new Admin("21","shraddha","sv041299@gmail.com","123")).collect(Collectors.toList()));
        	assertEquals(1,adminService.getAdmin().size());
        
    }
        
    }
