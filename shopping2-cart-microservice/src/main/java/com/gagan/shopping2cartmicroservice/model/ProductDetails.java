package com.gagan.shopping2cartmicroservice.model;

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
    private Integer productId;
    @Column
    private Integer price;
    @Column(name = "product_name")
    private String name;
    @Column(name = "product_category")
    private String category;
}
