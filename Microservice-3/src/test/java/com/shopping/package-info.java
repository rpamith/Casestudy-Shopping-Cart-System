package com.shopping;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.shopping.model.OrderModel;
import com.shopping.repository.OrderRepository;
import com.shopping.service.OrderService;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
class CustomerOrderTest {
    @MockBean
    private OrderRepository orderRepository;
    @Autowired
    private OrderService orderService;
	@BeforeEach
	    void setUp() {
	    }
	
	    @AfterEach
	    void tearDown() {
	    }
	    @Test
	    public void getCustomerTest() {
	    	
	    	
	    	when(orderRepository.findAll()).thenReturn(Stream
	                .of(new OrderModel("11","2021-12-28","13","2000","online","Declined","1")).collect(Collectors.toList()));
	        assertEquals(1,orderService.getOrders().size());
	    }
}
    