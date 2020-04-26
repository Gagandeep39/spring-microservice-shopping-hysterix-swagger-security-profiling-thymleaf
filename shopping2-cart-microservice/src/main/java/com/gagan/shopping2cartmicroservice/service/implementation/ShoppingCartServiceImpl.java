package com.gagan.shopping2cartmicroservice.service.implementation;

import com.gagan.shopping2cartmicroservice.model.CartItem;
import com.gagan.shopping2cartmicroservice.model.Customer;
import com.gagan.shopping2cartmicroservice.model.ShoppingCart;
import com.gagan.shopping2cartmicroservice.repository.ShoppingCartRepository;
import com.gagan.shopping2cartmicroservice.service.CartItemService;
import com.gagan.shopping2cartmicroservice.service.ShoppingCartService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Gagandeep
 * @date 26-04-2020
 * @time 22:59
 */

@Service
@Transactional
public class ShoppingCartServiceImpl implements ShoppingCartService {

    @Autowired
    private ShoppingCartRepository shoppingCartRepository;

    @Autowired
    private CartItemService cartItemService;

    Logger logger = LoggerFactory.getLogger(ShoppingCartServiceImpl.class);

    @Override
    public ShoppingCart addItemToCart(CartItem item, Integer cartId) {
        int quantity = item.getQuantity();
        int flag = 0;
        ShoppingCart cart = shoppingCartRepository.findById(cartId).get();
        for (int i=0; i<cart.getCartItems().size(); i++){
            if (cart.getCartItems().get(i).getProductDetails().getProductId() == item.getProductDetails().getProductId()){
                item = cart.getCartItems().get(i);
                item.setQuantity(item.getQuantity() + quantity);
                flag = 1;
            }
        }
        if(flag == 0){
            item.setCart(cart);
            item = cartItemService.saveCartItem(item);
            cart.addItemToCart(item);
        }
        shoppingCartRepository.save(cart);
        return cart;
    }

    @Override
    public ShoppingCart deleteItemFromCart(Integer cartItemId, Integer cartId) {
        ShoppingCart cart = shoppingCartRepository.findById(cartId).get();
        cart.removeItemFromCart(cartItemId);
        cartItemService.deleteCartItem(cartItemId);
        shoppingCartRepository.save(cart);
        return cart;
    }

    @Override
    public void deleteCart(Integer cartId) {
        ShoppingCart shoppingCart = shoppingCartRepository.getOne(cartId);
        shoppingCartRepository.delete(shoppingCart);
    }

    public ShoppingCart createCart(Integer customerId) {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setStatus("Shopping");
        Customer customer = new Customer();
        customer.setId(customerId);
        shoppingCart.setCustomer(customer);
        shoppingCartRepository.saveAndFlush(shoppingCart);
        logger.info(shoppingCart.getCustomer().getAddress());
        return shoppingCart;
    }

    @Override
    public List<ShoppingCart> fetchAllUserCart(Integer userId) {
        List<ShoppingCart> shoppingCarts = shoppingCartRepository.findByUserId(userId);
        return shoppingCarts;
    }

    @Override
    public ShoppingCart getLatestCartOrCreate(Integer customerId) {
        List<ShoppingCart> shoppingCarts = shoppingCartRepository.findLatestCart(customerId);
        if (shoppingCarts!=null && shoppingCarts.size()>0 && shoppingCarts.get(0).getStatus().equals("Shopping")) {
            return shoppingCarts.get(0);
        }else {
            return createCart(customerId);
        }
    }

    @Override
    public ShoppingCart fetchCartById(Integer cartId) {
        return shoppingCartRepository.findById(cartId).get();
    }
}
