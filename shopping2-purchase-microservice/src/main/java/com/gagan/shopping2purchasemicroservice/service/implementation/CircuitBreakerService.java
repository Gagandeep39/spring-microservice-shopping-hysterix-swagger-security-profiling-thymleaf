/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-04-29 20:12:27
 * @modify date 2020-04-29 20:12:27
 * @desc [description]
 */
package com.gagan.shopping2purchasemicroservice.service.implementation;

import com.gagan.shopping2purchasemicroservice.model.ShoppingCart;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CircuitBreakerService {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private ShoppingCart dummyCart;
    
    @Value("${url.service.product}")
    private String productUrl;
    @Value("${url.service.cart}")
    private String cartUrl;
    
    @HystrixCommand(fallbackMethod = "fallbackUpdateCartStatus")
	public String updateCartStatus(Integer cartId) {
        restTemplate.put(cartUrl+ "/shoppingcart/" + cartId +"/" + "Completed", "", String.class);
		return "Update";
    }
    
    public String fallbackUpdateCartStatus(Integer cartId) {
		return "Errror";
	}

    @HystrixCommand(fallbackMethod = "fallbackFetchShoppingCart")
	public ShoppingCart fetchShoppingCart(Integer shopingCartId) {
		return restTemplate.getForObject(cartUrl +"/shoppingcart/" + shopingCartId, ShoppingCart.class);
    }
    
    public ShoppingCart fallbackFetchShoppingCart(Integer shopingCartId) {
		return dummyCart;
	}


}