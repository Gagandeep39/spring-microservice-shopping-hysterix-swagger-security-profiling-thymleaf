package com.gagan.shopping2productmicroservice.model;

import io.swagger.annotations.Api;
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
@Api("Product Info")
public class Product {

    @Id
    @Column(name = "product_id")
    @ApiModelProperty(value = "Product ID")
    private Integer id;

    @Column(name = "stock")
    @ApiModelProperty(name = "Stock")
    private Integer stock;

    @OneToOne(fetch = FetchType.EAGER)
    @MapsId
    @ApiModelProperty(name = "Reference to product details")
    private ProductDetails productDetails;
}
