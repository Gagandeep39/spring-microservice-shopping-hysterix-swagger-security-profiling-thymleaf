package com.gagan.shopping2purchasemicroservice.repository;

import com.gagan.shopping2purchasemicroservice.model.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Gagandeep
 * @date 27-04-2020
 * @time 08:31
 */

@Repository
public interface PurchaseRepository extends JpaRepository<Purchase, Integer> {

    @Query("select p from Purchase p where p.shoppingCart.customer.id=?1")
    public List<Purchase> fetchAllCustomerPurchase(Integer customerId);
}
