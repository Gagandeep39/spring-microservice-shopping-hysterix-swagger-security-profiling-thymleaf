/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-04-22 20:12:59
 * @modify date 2020-04-22 20:12:59
 * @desc Customer Entity to store customer details
 */
package com.gagan.shopping2purchasemicroservice.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

/**
 * Customer Entity Inheriting from User
 * @see User It stores user credentials
 */
@Entity
@PrimaryKeyJoinColumn(name = "user_id")
@Getter
@Setter
@NoArgsConstructor
@ToString
@ApiModel(value = "Customer - Stores USer information")
public class Customer extends User {

    @Column(name = "name")
    @Length(min = 5, message = "*Your username must have at least 5 characters")
    @NotEmpty(message = "*Please provide a name")
    @ApiModelProperty(value = "Custmer Name")
    private String name;

    @Column(name = "address")
    @Length(min = 5, message = "*Your username must have at least 5 characters")
    @NotEmpty(message = "*Please provide an address")
    @ApiModelProperty(value = "Customer Address")
    private String address;

    @Column(name = "email")
    @Email(message = "Enter a Valid Email")
    @NotEmpty(message = "*Please provide an email")
    @ApiModelProperty(value = "Customer Email")
    private String email;

    @Column(name = "phone_number")
    @Length(min = 10, message = "*Your username must have at least 5 characters")
    @NotEmpty(message = "*Please provide your password")
    @ApiModelProperty(value = "Customer Phone number")
    private String phoneNumber;

}