package com.te.springboot.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.Data;

@Data
@Entity
@Table(name = "employee_info")
@JsonRootName("employee_info")
@JsonPropertyOrder({"id","name"})
@XmlRootElement(name = "employee_info")
public class EmployeeBean implements Serializable{
	
	@Id
	@Column
	@JsonProperty("emp_id")
	private int id;
	
	@Column
	private String name;
	
	@Column
	private Date dob;
	

	
	@Column
	private String password;
	
	

}
