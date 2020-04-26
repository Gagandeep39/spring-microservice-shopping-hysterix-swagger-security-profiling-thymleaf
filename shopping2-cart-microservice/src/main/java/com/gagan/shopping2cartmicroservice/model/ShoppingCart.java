package com.gagan.shopping2cartmicroservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Gagandeep
 * @date 26-04-2020
 * @time 22:22
 */

@Entity
@Table(name = "cart")
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties
public class ShoppingCart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cart_id")
    private Integer cartId;

    @Column(name = "status")
    private String status;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH}, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private Customer customer;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL)
    private List<CartItem> cartItems = new ArrayList<>();

    public void addItemToCart(CartItem cartItem){
        cartItems.add(cartItem);
    }

    public void removeItemFromCart(Integer cartItemId){
        cartItems = cartItems.stream().filter(cartItem -> cartItem.getCartItemId()!=cartItemId).collect(Collectors.toList());
    }
}
