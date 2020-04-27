package com.gagan.shopping2cartmicroservice.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Collection;

/**
 * @author Gagandeep
 * @date 26-04-2020
 * @time 09:33
 */

@Entity
@Table(name = "role")
@Getter
@Setter
@NoArgsConstructor
@ToString
@ApiModel(value = "Roles available for assignma=en to user")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "role_id")
    @ApiModelProperty(value = "Role ID")
    private Integer id;

    @Column(name = "role", unique = true)
    @ApiModelProperty(value = "Name of role eg. ROLE_USER")
    private String role;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "roles", fetch = FetchType.EAGER)
    @ApiModelProperty(value = "User Mapping")
    private Collection<User> users;

}
