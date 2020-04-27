package com.gagan.shopping2loginmicroservice.service.implementation;

import com.gagan.shopping2loginmicroservice.model.*;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Gagandeep
 * @date 27-04-2020
 * @time 19:50
 */

@Service
public class CircuitBreakerService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${url.service.product}")
    private String productServiceUrl;


    @Value("${url.service.cart}")
    private String cartServiceUrl;


    @Value("${url.service.purchase}")
    private String purchaseUrl;

    @HystrixCommand(fallbackMethod = "fetchProductFallBackMethod")
    public List<Product> fetchProductsFromService() {
        List<Product> products = Arrays.asList(restTemplate.getForEntity(productServiceUrl + "/products", Product[].class).getBody());
        return products;
    }

    public List<Product> fetchProductFallBackMethod(){
        ProductDetails productDetails = getProductDetails();
        productDetails.setName("Product Service is down");
        Product product = new Product();
        product.setProductDetails(productDetails);
        product.setId(0);
        return Arrays.asList(product);
    }

    @HystrixCommand(fallbackMethod = "cartFallbackMethod")
    public ShoppingCart fetchShoppingCart(Integer customerId) {
        return restTemplate.postForObject(cartServiceUrl + "/shoppingcart/" + customerId, "", ShoppingCart.class);
    }

    public ShoppingCart cartFallbackMethod(Integer customerId){
        return getShoppingCart();
    }


    @HystrixCommand(fallbackMethod = "purchaseServiceFetchByCustomer")
    public List<Purchase> fetchCustomerFromPurchaseService(Integer customerId) {
        return Arrays.asList(restTemplate.getForEntity( purchaseUrl+ "/purchases/customer/" + customerId, Purchase[].class).getBody());
    }

    public List<Purchase> purchaseServiceFetchByCustomer(Integer customerId){
        Purchase purchase = new Purchase();
        purchase.setPurchaseId(0);
        purchase.setTotal(0);
        purchase.setTimestamp(System.currentTimeMillis());
        purchase.setShoppingCart(getShoppingCart());
        return Arrays.asList(purchase);
    }

    public ProductDetails getProductDetails(){
        ProductDetails productDetails = new ProductDetails();
        productDetails.setName("Cart Service is Down");
        productDetails.setCategory("Try again later");
        productDetails.setProductId(0);
        productDetails.setPrice(0);
        return productDetails;
    }

    public ShoppingCart getShoppingCart(){
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setCartId(0);
        shoppingCart.setStatus("Cart Service Is Down");
        List<CartItem> cartItems = new ArrayList<>();
        CartItem cartItem = new CartItem();
        cartItem.setCartItemId(0);
        cartItem.setQuantity(0);
        cartItem.setProductDetails(getProductDetails());
        cartItems.add(cartItem);
        shoppingCart.setCartItems(cartItems);
        return shoppingCart;
    }
}
