package com.gagan.shopping2loginmicroservice.service.implementation;

import com.gagan.shopping2loginmicroservice.model.CartItem;
import com.gagan.shopping2loginmicroservice.model.ProductDetails;
import com.gagan.shopping2loginmicroservice.model.ShoppingCart;
import com.gagan.shopping2loginmicroservice.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author Gagandeep
 * @date 27-04-2020
 * @time 02:17
 */

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private CircuitBreakerService circuitBreakerService;

    @Value("${url.service.cart}")
    private String cartServiceUrl;

    @Override
    public ShoppingCart saveItemToCart(Integer cartId, Integer productId) {
        ProductDetails productDetails = new ProductDetails();
        productDetails.setProductId(productId);
        CartItem cartItem = new CartItem();
        cartItem.setQuantity(1);
        cartItem.setProductDetails(productDetails);
        ShoppingCart shoppingCart = restTemplate.postForObject(cartServiceUrl + "/shoppingcartitem/" + cartId, cartItem, ShoppingCart.class);
        return shoppingCart;
    }

    @Override
    public ShoppingCart removeItemFromCart(Integer cartId, Integer cartItemId) {
        restTemplate.delete(cartServiceUrl + "/shoppingcartitem/"  +cartId + "/"+ cartItemId);
        return null;
    }

    @Override
    public ShoppingCart createOrFetchCart(Integer customerId) {
        ShoppingCart shoppingCart = circuitBreakerService.fetchShoppingCart(customerId);
        return shoppingCart;
    }
}
