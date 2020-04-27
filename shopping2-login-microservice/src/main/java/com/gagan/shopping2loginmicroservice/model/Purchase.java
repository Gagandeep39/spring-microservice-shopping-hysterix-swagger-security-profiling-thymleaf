package com.gagan.shopping2loginmicroservice.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author Gagandeep
 * @date 27-04-2020
 * @time 08:24
 */

@Entity
@Table(name = "purchase")
@Getter
@Setter
@NoArgsConstructor
public class Purchase {

    @Id
    @Column(name = "purchase_id")
    private Integer purchaseId;
    @Column(name = "total")
    private Integer total;
    @Column(name = "timestamp")
    private Long timestamp;

    @OneToOne(fetch = FetchType.EAGER)
    @MapsId
    private ShoppingCart shoppingCart;

}
