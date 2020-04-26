package com.gagan.shopping2cartmicroservice.repository;

import com.gagan.shopping2cartmicroservice.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Gagandeep
 * @date 26-04-2020
 * @time 22:37
 */

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Integer> {
    List<CartItem> findByCartCartId(Integer cart_cartId);
}
