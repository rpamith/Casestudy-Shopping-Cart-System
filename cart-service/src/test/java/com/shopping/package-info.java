package com.shopping;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.shopping.model.CartDetails;
import com.shopping.repository.CartRepository;
import com.shopping.service.CartService;

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
    private CartRepository cartRepository;
	@Autowired
    private CartService cartService;
	@BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }
    @Test
    public void getCartTest() {
    	when(cartRepository.findAll()).thenReturn(Stream
                .of(new CartDetails("7143","99")).collect(Collectors.toList()));
        assertEquals(1,cartService.getCartDetails().size());
    }
    }
