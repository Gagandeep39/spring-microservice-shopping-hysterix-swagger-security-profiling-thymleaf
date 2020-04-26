package com.gagan.shopping2cartmicroservice.repository;

import com.gagan.shopping2cartmicroservice.model.ShoppingCart;
import org.hibernate.sql.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Gagandeep
 * @date 26-04-2020
 * @time 22:37
 */
@Repository
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Integer> {
    @Query("select s from ShoppingCart s where s.customer.id=?1 order by s.cartId desc")
    List<ShoppingCart> findLatestCart(Integer userId);

    @Query("select s from ShoppingCart s where s.customer.id=?1")
    List<ShoppingCart> findByUserId(Integer userId);

}
