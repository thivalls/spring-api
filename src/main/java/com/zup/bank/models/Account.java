package com.zup.bank.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.br.CPF;

import lombok.Data;

@Data
@Entity
@Table(name="accounts")
public class Account {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	@NotBlank(message = "The name cannot be null or empty")
	private String name;
	
	@Column(unique = true, nullable = false)
	@NotBlank(message = "The email cannot be null or empty")
	@Email(message = "Invalid format of email")
	private String email;
	
	@Column(unique = true, nullable = false)
	@NotBlank(message = "The CPF cannot be null or empty")
	@CPF(message = "Invalid format or Invalid Document")
	private String cpf;
	
	@Column(nullable = false)
	@NotNull(message = "Birthday can not be null")
	private Date birthday;
	
	@CreationTimestamp
	private Date created_at;
	
	@UpdateTimestamp
	private Date updated_at;
}
