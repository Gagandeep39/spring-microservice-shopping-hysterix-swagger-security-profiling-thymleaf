/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-04-22 22:16:07
 * @modify date 2020-04-22 22:16:07
 * @desc [description]
 */
package com.gagan.shopping2purchasemicroservice.model;


import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ErrorResponse {

	@ApiModelProperty("Error Status")
    private int status;
	@ApiModelProperty("Error message")
    private String message;
	@ApiModelProperty("Time stamp")
    private long timeStamp;

}