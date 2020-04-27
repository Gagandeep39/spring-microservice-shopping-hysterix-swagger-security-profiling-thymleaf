package com.gagan.shopping2purchasemicroservice.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

/**
 * @author Gagandeep
 * @date 26-04-2020
 * @time 19:31
 */

@Entity
@Table(name = "product")
@Getter
@Setter
@NoArgsConstructor
@ToString
@ApiModel(value = "Stores reference to original product and quantity of that product")
public class Product {

    @Id
    @Column(name = "product_id")
    @ApiModelProperty(value = "Product ID")
    private Integer id;

    @Column(name = "stock")
    @ApiModelProperty(value = "Available Stocks")
    private Integer stock;

    @OneToOne(fetch = FetchType.EAGER)
    @ApiModelProperty(value = "Product Details Mappings, has same id as product details")
    @MapsId
    private ProductDetails productDetails;
}
