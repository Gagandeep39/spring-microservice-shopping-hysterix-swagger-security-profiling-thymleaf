package com.gagan.shopping2productmicroservice.model;

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
public class Product {

    @Id
    @Column(name = "product_id")
    private Integer id;

    @Column(name = "stock")
    private Integer stock;

    @OneToOne(fetch = FetchType.EAGER)
    @MapsId
    private ProductDetails productDetails;
}
