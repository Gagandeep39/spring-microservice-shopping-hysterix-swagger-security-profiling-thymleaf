package com.gagan.shopping2purchasemicroservice.model;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
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
@Api("Purchase Model")
public class Purchase {

    @Id
    @Column(name = "purchase_id")
    @ApiModelProperty(value = "Purchase Id")
    private Integer purchaseId;

    @Column(name = "total")
    @ApiModelProperty(value = "Total")
    private Integer total;

    @Column(name = "timestamp")
    @ApiModelProperty(value = "Timestamp")
    private Long timestamp;

    @OneToOne(fetch = FetchType.EAGER)
    @MapsId
    @ApiModelProperty(value = "Shopping cart reference")
    private ShoppingCart shoppingCart;

}
