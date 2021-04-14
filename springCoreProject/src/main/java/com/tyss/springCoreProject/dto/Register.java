package com.tyss.springCoreProject.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Register  implements Serializable{
	
	@Id
	private String userName ;
	
	
	@Column
	private String  password;

	
	@Column
	private String confirmPassword;

}
