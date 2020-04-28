package com.gagan.shopping2cartmicroservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@ApiModel(value = "To shoreCart Items")
public class ShoppingCart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cart_id")
    @ApiModelProperty(value = "Cart Item ID")
    private Integer cartId;

    @Column(name = "status")
    @ApiModelProperty(value = "Cart Purchase Status")
    private String status;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH}, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    @ApiModelProperty(value = "Back refrence to customer")
    private Customer customer;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL)
    @ApiModelProperty(value = "Reference to the ites belojgignt o the cart")
    private List<CartItem> cartItems = new ArrayList<>();

    public void addItemToCart(CartItem cartItem){
        cartItems.add(cartItem);
    }

    public void removeItemFromCart(Integer cartItemId){
        cartItems = cartItems.stream().filter(cartItem -> cartItem.getCartItemId()!=cartItemId).collect(Collectors.toList());
    }
}