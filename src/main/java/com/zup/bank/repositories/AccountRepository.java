package com.zup.bank.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zup.bank.models.Account;

public interface AccountRepository extends JpaRepository<Account, Long>{
	Account findByEmail(String email);
	Account findByCpf(String cpf);
}
