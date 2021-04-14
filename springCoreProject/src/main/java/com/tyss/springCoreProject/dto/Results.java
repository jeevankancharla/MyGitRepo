package com.tyss.springCoreProject.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Results {
	
	@Column
	private int id;
	@Id
	@Column
	private Date time_Date;
	@Column
	private int marks;
	@Column
	private int percentage;
	


}
