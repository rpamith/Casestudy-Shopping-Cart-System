package com.shopping.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.shopping.exception.ApiRequestException;
import com.shopping.models.CartDetails;
import com.shopping.models.OrderModel;
import com.shopping.models.Product;
import com.shopping.repository.ProductRepository;
import com.shopping.service.ProductService;

@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("/product")
public class ProductController {
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private ProductService productService;

	@Autowired
	private ProductRepository productRepository;

	@PostMapping("/addproduct")
	public void addProduct(
			@RequestParam("pId") int pId,
			@RequestParam("pName") String pName,
			@RequestParam("pType") String pType,
			@RequestParam("pCategory") String pCategory,
			@RequestParam("pPrice") String pPrice,
			@RequestParam("pDescription") String pDescription,
			@RequestParam("pImg") MultipartFile pImg
			) throws IOException
	{
		Product product = new Product();
		product.setpId(pId);
		product.setpName(pName);
		product.setpType(pType);
		product.setpCategory(pCategory);
		product.setpPrice(pPrice);
		product.setpDescription(pDescription);
		product.setpImg(new Binary(BsonBinarySubType.BINARY, pImg.getBytes()));
		
		productService.addProduct(product);
	}
	
	
	// for creating/adding Product
//	@PostMapping("addproduct")
//	public Product saveProduct(@RequestBody Product product) {
//		return productService.addProduct(product);
//	}

	// Reading all Product
	
	  @GetMapping("/allproduct") public List<Product> findAllProduct() { return
	  productService.getProduct(); }
	 

	// Reading Product by Id
	@GetMapping("/allproduct/{id}")
	public Optional<Product> getProductById(@PathVariable int id) throws ApiRequestException {
		return Optional.of(productRepository.findById(id)
				.orElseThrow(() -> new ApiRequestException("PRODUCT NOT FOUND WITH THIS ID ::")));
	}

	// Updating User Data by Id
	@PutMapping("/update/{id}")
	public ResponseEntity<Object> updateProduct(@PathVariable int id, @RequestBody Product product) {
		boolean isProductExist = productRepository.existsById(id);
		if (isProductExist) {
			productRepository.save(product);
			return new ResponseEntity<Object>("product updated successfully with id " + id, HttpStatus.OK);
		} else {
			throw new ApiRequestException("CAN NOT UPDATE AS PRODUCT NOT FOUND WITH THIS ID ::");
		}

	}

	// Deleting User Data by Id
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Object> deleteProduct(@PathVariable int id) {
		boolean isProductExist = productRepository.existsById(id);
		if (isProductExist) {
			productService.deleteById(id);
			return new ResponseEntity<Object>("product deleted with id" + id, HttpStatus.OK);
		} else {
			throw new ApiRequestException("CAN NOT DELETE AS PRODUCT NOT FOUND WITH THIS ID ::");
		}

	}
//For adding Order
	@PostMapping("/addorder")
	public String addOrder(@RequestBody OrderModel order) {
		return restTemplate.postForObject("http://ORDER-SERVICE/order/addorder", order, String.class);

	}
//For updating Order
	@PutMapping("/updateorder/{id}")
	   public String updateaddress(@PathVariable("id")  int id, @RequestBody OrderModel order) {
	      HttpHeaders headers = new HttpHeaders();
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      HttpEntity<OrderModel> entity = new HttpEntity<OrderModel>(order,headers);
	      
	      return restTemplate.exchange(
	    		  "http://ORDER-SERVICE/order/update/"+id, HttpMethod.PUT, entity, String.class).getBody();
	   }
		  
		  
		  
				  
				  // for Deleting Order
				  
				  
				  
				  @DeleteMapping("/cancelorder/{id}") public String

	deleteorder(@PathVariable("id") int id) {
				  restTemplate.delete("http://ORDER-SERVICE/order/delete/" +id, String.class);
				  return "Your Order is successfully Canceled " + id; }
				  
				// For Adding Cart

					@PostMapping("/addcart")
					public String addCart(@RequestBody CartDetails cartDetails) {
						return restTemplate.postForObject("http://CART-SERVICE/cartDetails/addcart", cartDetails, String.class);

					}
					//for updating cart
					@PutMapping("/updatecart/{id}")
					   public String updatecart(@PathVariable("id")  int id, @RequestBody CartDetails cartDetails ) {
					      HttpHeaders headers = new HttpHeaders();
					      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
					      HttpEntity<CartDetails> entity = new HttpEntity<CartDetails>(cartDetails,headers);
					      
					      return restTemplate.exchange(
					    		  "http://CART-SERVICE/cartDetails/update/"+id, HttpMethod.PUT, entity, String.class).getBody();
					   }

					// for Deleting Cart

					@DeleteMapping("/cancelcart/{id}")
					public String deletecartDetails(@PathVariable("id") int id) {
						restTemplate.delete("http://CART-SERVICE/cartDetails/delete/" + id, String.class);
						return "Your cartdetails is successfully Canceled " + id;
					}

}
