package com.grs.dto;

import lombok.Data;

@Data
public class UserDTO {

	private String userName;
	private String firstName;
	private String lastName;
	private String email;
	private long mobile;
	private String password;
	private String confirmPassword;
	private String city;
	private String dob;
	private String dose1;
	private String dose2;
}
