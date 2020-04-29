package com.gagan.shopping2purchasemicroservice.config;

import java.util.Arrays;
import java.util.Collections;

import com.gagan.shopping2purchasemicroservice.model.CartItem;
import com.gagan.shopping2purchasemicroservice.model.Customer;
import com.gagan.shopping2purchasemicroservice.model.Product;
import com.gagan.shopping2purchasemicroservice.model.ProductDetails;
import com.gagan.shopping2purchasemicroservice.model.Purchase;
import com.gagan.shopping2purchasemicroservice.model.ShoppingCart;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @author Gagandeep
 * @date 27-04-2020
 * @time 16:08
 */

@Configuration
public class BeanConfiguration {

    @Bean
    public Docket swaggerCongiguration() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                // .paths(PathSelectors.ant("/"))	// Will prevent some Paths from being Shown
                // .apis(RequestHandlerSelectors.basePackage("com.gagan"))
                .build()
                .apiInfo(apidetails());
    }

    /**
     * API Info
     * Name
     * Description
     * Version
     * Terms of Services
     * Contacts Info
     * License Info
     * Company URL
     * Addition Vender Info (Collections<VendorInfo> asd)
     */
    private ApiInfo apidetails() {
        return new ApiInfo(
                "Products API",
                "It Contains Information about the products that are managed via API",
                "1.0G",
                "My Terms of Services",
                new Contact("Gagandeep Singh", "github.com/gagandeep39", "singh.gagandeep3911@gmail.com"),
                "API license",
                "www.gagandeep.com",
                Collections.emptyList());
    }


    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

    @Bean
    public Purchase getPurchase(){
        Purchase purchase = new Purchase();
        purchase.setPurchaseId(0);
        purchase.setTimestamp(System.currentTimeMillis());
        purchase.setTotal(0);
        return purchase;
    }

    @Bean
    public ProductDetails getProductDetails(){
        ProductDetails details = new ProductDetails();
        details.setCategory("Product Service is Down");
        details.setName("Error Communicating to service");
        details.setPrice(0);
        details.setProductId(0);
        return details;
    }

    @Bean
    public Product getProduct(){
        Product product  = new Product();
        product.setId(0);
        product.setStock(0);
        product.setProductDetails(getProductDetails());
        return product;
    }

    @Bean
    public ShoppingCart getShoppingCart(){
        ShoppingCart cart = new ShoppingCart();
        cart.setCartId(0);
        cart.setStatus("Cart Service is Down");
        cart.setCustomer(getCustomer());
        cart.setCartItems(Arrays.asList(getCartItem()));
        return cart;
    }

    @Bean
    public CartItem getCartItem(){
        CartItem cartItem = new CartItem();
        cartItem.setCart(null);
        cartItem.setCartItemId(0);
        ProductDetails p = getProductDetails();
        p.setName("Cart Servic is downe");
        cartItem.setProductDetails(p);
        cartItem.setQuantity(0);
        return cartItem;
    }

    @Bean
    public Customer getCustomer(){
        Customer customer = new Customer();
        customer.setActive(0);
        customer.setName("Service is down");
        customer.setEmail("Try again Later");
        customer.setPhoneNumber("Error");
        customer.setUsername("Error");
        customer.setRoles(null);
        return customer;
    }

}
