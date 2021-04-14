package com.tyss.springCoreProject.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Login {
	@Id
	private String userName;
	@Column
	private String password;

	@Column
	private String confirmPassword;

}
