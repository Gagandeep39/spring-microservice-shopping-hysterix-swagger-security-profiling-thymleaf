package com.gagan.shopping2productmicroservice.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

/**
 * @author Gagandeep
 * @date 26-04-2020
 * @time 19:34
 */

@Entity
@Table(name = "product_details")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class ProductDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "product_id")
    @ApiModelProperty(name = "Product ID")
    private Integer productId;

    @Column
    @ApiModelProperty(name = "Product Price")
    private Integer price;

    @Column(name = "product_name")
    @ApiModelProperty(name = "Product Name")
    private String name;

    @Column(name = "product_category")
    @ApiModelProperty(name = "Product Category")
    private String category;

}
