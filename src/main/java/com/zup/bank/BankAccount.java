package com.zup.bank;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class BankAccount {
	@Id
	private Long id;
	
	@Column
	private String name;
	
	@Column
	private String cpf;
	
	@Column
	private Date birthday;
}
