package com.gagan.shopping2productmicroservice.model;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Api("Error Response")
public class ErrorResponse {

	@ApiModelProperty(value = "Error Staus")
    private int status;
	@ApiModelProperty(value = "Error Message")
    private String message;
	@ApiModelProperty(value = "Timestamp")
    private long timeStamp;

}