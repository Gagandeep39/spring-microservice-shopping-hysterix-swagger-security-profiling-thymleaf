/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-04-22 19:43:53
 * @modify date 2020-04-22 19:43:53
 * @desc User Entity
 */
package com.gagan.shopping2cartmicroservice.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonBackReference;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.util.Collection;

/**
 * Stores User credentials
 * Inherited by Customer 
 *  @see Customer
 */
@Entity
@Table(name = "user")
@Getter
@Setter
@Inheritance(strategy = InheritanceType.JOINED)
@ApiModel(value = "Store user credentials")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    @ApiModelProperty(value = "Cart Item ID")
    protected Integer id;

    @Column(name = "password", nullable = false)
    @Length(min = 5, message = "*Your password must have at least 5 characters")
    @NotEmpty(message = "*Please provide your password")
    @ApiModelProperty(value = "Cart Item ID")
    protected String password;

    @Column(name = "username", nullable = false, unique = true)
    @Length(min = 5, message = "*Your username must have at least 5 characters")
    @NotEmpty(message = "*Please provide your password")
    @ApiModelProperty(value = "Cart Item ID")
    protected String username;

    @Column(name = "active", nullable = false)
    @ApiModelProperty(value = "Whether user is enabled or disabled (1 or 0)")
    protected int active;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonBackReference
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    @ApiModelProperty(value = "Roles assigned to a user")
    protected Collection<Role> roles;


}