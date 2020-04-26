package com.gagan.shopping2productmicroservice.repository;

import com.gagan.shopping2productmicroservice.model.ProductDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Gagandeep
 * @date 26-04-2020
 * @time 19:52
 */

@Repository
public interface ProductDetailsRepository extends JpaRepository<ProductDetails, Integer> {

}
