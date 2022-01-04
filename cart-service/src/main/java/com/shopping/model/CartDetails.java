package com.shopping.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

	@Document(collection = "cart")
	public class CartDetails {
		@Id
		private String cartId;
		private String totalPrice;
		
		public CartDetails() {
	
		}

			public CartDetails(String string, String string2) {
			super();
			this.cartId = string;
			this.totalPrice = string2;
		}



		@Override
			public String toString() {
				return "CartDetails [cartId=" + cartId + ", totalPrice=" + totalPrice + "]";
			}

		
		public String getCartId() {
			return cartId;
		}



		public void setCartId(String cartId) {
			this.cartId = cartId;
		}



		public String getTotalPrice() {
			return totalPrice;
		}



		public void setTotalPrice(String totalPrice) {
			this.totalPrice = totalPrice;
		}
	
		
		
	}	
		