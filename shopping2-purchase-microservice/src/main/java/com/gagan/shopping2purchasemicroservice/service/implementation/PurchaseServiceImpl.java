package com.gagan.shopping2purchasemicroservice.service.implementation;

import com.gagan.shopping2purchasemicroservice.model.*;
import com.gagan.shopping2purchasemicroservice.repository.PurchaseRepository;
import com.gagan.shopping2purchasemicroservice.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author Gagandeep
 * @date 27-04-2020
 * @time 08:34
 */

@Service
public class PurchaseServiceImpl implements PurchaseService {

    @Value("${url.service.product}")
    private String productUrl;
    @Value("${url.service.cart}")
    private String cartUrl;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private PurchaseRepository purchaseRepository;

    @Autowired
    private CircuitBreakerService circuitBreakerService;

    @Autowired
    private Purchase dummyPurchase;

    @Override
    public Purchase makePurchase(Integer shopingCartId) throws Exception {
        ShoppingCart shoppingCart = circuitBreakerService.fetchShoppingCart(shopingCartId);
        if (shoppingCart==null) throw new Exception("Shopping Cart Not Found");
        if (shoppingCart.getStatus().equals("Completed"))
            throw new Exception("Already Checked Out");
        if(shoppingCart.getCartId()==0) return dummyPurchase;
        validateQuantity(shoppingCart.getCartItems());

        int amount = 0;
        List<CartItem> cartItems = shoppingCart.getCartItems();
        for (CartItem cartItem : cartItems) {
            amount += cartItem.getQuantity() * cartItem.getProductDetails().getPrice();
            restTemplate.put(productUrl + "/products/stock/" + cartItem.getProductDetails().getProductId() + "/" + cartItem.getQuantity(), "", Product.class);
        }
        shoppingCart.setStatus("Completed");
        Purchase purchase = new Purchase();
        purchase.setShoppingCart(shoppingCart);
        purchase.setTimestamp(System.currentTimeMillis());
        purchase.setTotal(amount);
        purchase.setPurchaseId(shoppingCart.getCartId());

        String status = circuitBreakerService.updateCartStatus(shoppingCart.getCartId());
        // Returning dummy object on service npt responding
        if(status.equals("Error")) return dummyPurchase;
        purchaseRepository.save(purchase);
        return purchase;
    }

    private void validateQuantity(List<CartItem> cartItems) throws Exception {
        for (CartItem cartItem : cartItems) {
            Product product = restTemplate.getForObject(productUrl + "/products/" + cartItem.getProductDetails().getProductId(), Product.class);
            if (product.getStock() < cartItem.getQuantity())
                throw new Exception("Not Enough Products");
        }
    }

    @Override
    public List<Purchase> fetchAllCustomerPurchase(Integer customerId) {
        return purchaseRepository.fetchAllCustomerPurchase(customerId);
    }
}
