package com.zup.bank.models;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="accounts")
public class Account {
	@Id
	private Long id;
	
	@Column
	private String name;
	
	@Column
	private String cpf;
	
	@Column
	private Date birthday;
}
