package com.zup.bank.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zup.bank.interfaces.IAccountService;
import com.zup.bank.models.Account;
import com.zup.bank.repositories.AccountRepository;

@Service
public class AccountService implements IAccountService {
	
	@Autowired
	AccountRepository accountRepository;
	
	@Override
	public List<Account> all() {
		return accountRepository.findAll();
	}

	@Override
	public Optional<Account> show(long id) {
		return accountRepository.findById(id);
	}

	@Override
	public Account store(Account account) {
		return accountRepository.save(account);
	}

	@Override
	public Account update(long id, Account account) {
		account.setId(id);
		return accountRepository.save(account);
	}

	@Override
	public void destroy(long id) {
		Optional<Account> account = accountRepository.findById(id);
		if(account.isPresent()) {
			accountRepository.deleteById(id);
		}
	}

}