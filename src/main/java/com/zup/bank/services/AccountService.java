package com.zup.bank.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zup.bank.exceptions.ResourceNotFoundException;
import com.zup.bank.interfaces.IAccountService;
import com.zup.bank.models.Account;
import com.zup.bank.repositories.AccountRepository;

@Service
public class AccountService implements IAccountService {
	
	@Autowired
	AccountRepository accountRepository;
	
	@Override
	public List<Account> all() { return accountRepository.findAll(); }

	@Override
	public Optional<Account> show(long id) {
		checkAccountExists(id);
		return accountRepository.findById(id);
	}

	@Override
	public Account store(Account account) {
		checkCreateEmailExists(account.getEmail());
		checkCreateCpfExists(account.getCpf());
		return accountRepository.save(account);
	}

	@Override
	public Account update(long id, Account account) {
		checkAccountExists(id);
		checkUpdateEmailExists(id, account);
		checkUpdateCpfExists(id, account);
		account.setId(id);
		return accountRepository.save(account);
	}

	@Override
	public void destroy(long id) {
		checkAccountExists(id);
		Optional<Account> account = accountRepository.findById(id);
		if(account.isPresent()) {
			accountRepository.deleteById(id);
		}
	}
	
	public void checkAccountExists(long id) {
		Optional<Account> account = accountRepository.findById(id);
		if(!account.isPresent()) {
			throw new ResourceNotFoundException("This account does not exists.");
		}
	}
	
	public void checkCreateEmailExists(String email) {
		Account account = accountRepository.findByEmail(email);
		if(account != null) {
			throw new ResourceNotFoundException("This email alread exists.");
		}
	}
	
	public void checkCreateCpfExists(String cpf) {
		Account account = accountRepository.findByCpf(cpf);
		if(account != null) {
			throw new ResourceNotFoundException("This cpf alread exists.");
		}
	}
	
	public void checkUpdateEmailExists(long id, Account account) {
		Account accountExist = accountRepository.findByEmail(account.getEmail());
		if(accountExist != null && accountExist.getId() != id) {
			 	throw new ResourceNotFoundException("This email alread exists.");
			
		}
	}
	
	public void checkUpdateCpfExists(long id, Account account) {
		Account accountExist = accountRepository.findByCpf(account.getCpf());
		if(accountExist != null && accountExist.getId() != id) {
			throw new ResourceNotFoundException("This cpf alread exists.");
		}
	}

}
