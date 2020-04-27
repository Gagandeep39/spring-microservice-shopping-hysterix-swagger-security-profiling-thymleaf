package com.gagan.shopping2cartmicroservice.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author Gagandeep
 * @date 26-04-2020
 * @time 22:29
 */


@Entity
@Table(name = "cart_item")
@Getter
@Setter
@NoArgsConstructor
@ApiModel(value = "Cart Item - To store product detail that was added to cart")
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cart_item_id")
    @ApiModelProperty(value = "Cart Item ID")
    private Integer cartItemId;

    @Column(name = "quantity")
    @ApiModelProperty(value = "Quantity")
    private Integer quantity;

    @OneToOne
    @JoinColumn(name = "product_details_id")
    @ApiModelProperty(value = "Product Details Mapping")
    private ProductDetails productDetails;

    @ManyToOne
    @JoinColumn(name = "cart_id")
    @ApiModelProperty(value = "Back Reference to the cart it belongs")
    @JsonBackReference
    private ShoppingCart cart;


}
