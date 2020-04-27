package com.gagan.shopping2cartmicroservice.model;

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
 * @time 19:34
 */

@Entity
@Table(name = "product_details")
@Getter
@Setter
@NoArgsConstructor
@ToString
@ApiModel(value = "Stores product related Information")
public class ProductDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "product_id")
    @ApiModelProperty(value = "Product ID")
    private Integer productId;
    @Column
    @ApiModelProperty(value = "Product Price")
    private Integer price;
    @Column(name = "product_name")
    @ApiModelProperty(value = "Product Name")
    private String name;
    @Column(name = "product_category")
    @ApiModelProperty(value = "Product Category")
    private String category;

}
