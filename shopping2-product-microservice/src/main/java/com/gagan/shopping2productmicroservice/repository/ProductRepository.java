package com.gagan.shopping2productmicroservice.repository;

import com.gagan.shopping2productmicroservice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Gagandeep
 * @date 26-04-2020
 * @time 19:42
 */

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    @Query("SELECT p from Product p where p.productDetails.category=?1")
    public List<Product> findProductsByCategory(String category);
}
