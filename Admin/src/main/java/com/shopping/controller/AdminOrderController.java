package com.shopping.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.shopping.models.OrderModel;

@RestController
@RequestMapping("/admin")
public class AdminOrderController {
	@Autowired
	private RestTemplate restTemplate;

	// For adding Order
	@PostMapping("/addorder")
	public String addOrder(@RequestBody OrderModel order) {
		return restTemplate.postForObject("http://ORDER-SERVICE/order/addorder", order, String.class);

	}

	/*
	 * // For updating Order
	 * 
	 * @PutMapping("/updateorder/{id}") public String
	 * updateaddress(@PathVariable("id") int id, @RequestBody OrderModel order) {
	 * HttpHeaders headers = new HttpHeaders();
	 * headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	 * HttpEntity<OrderModel> entity = new HttpEntity<OrderModel>(order, headers);
	 * 
	 * return restTemplate.exchange("http://localhost:8082/order/update/" + id,
	 * HttpMethod.PUT, entity, String.class) .getBody(); }
	 */

	// for Deleting Order

	@DeleteMapping("/cancelorder/{id}")
	public String

			deleteorder(@PathVariable("id") int id) {
		restTemplate.delete("http://ORDER-SERVICE/order/delete/" + id, String.class);
		return "Your Order is successfully Canceled " + id;
	}
	/*
	 * //Reading orders By id
	 * 
	 * @GetMapping("/getallorders/{id}") public OrderModel getOrderById
	 * (@PathVariable("id") int id) { return
	 * restTemplate.getForObject("http://localhost:8082/order/getallorders/" +id ,
	 * OrderModel.class);
	 * 
	 * }
	 */
		
		
		//Reading All orders 
		@GetMapping("/getallorders") 
		public String getallOrder() 
		{
		   return restTemplate.getForObject("http://ORDER-SERVICE/order/allorders", String.class);
		  
		  }

}
