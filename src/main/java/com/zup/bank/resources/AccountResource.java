package com.zup.bank.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.zup.bank.models.Account;
import com.zup.bank.repositories.AccountRepository;

@RestController
@RequestMapping("/accounts")
public class AccountResource {

	@Autowired
	AccountRepository accountRepository;
	
	@GetMapping
	public List<Account> all() {
		return accountRepository.findAll();
	}
	
	@GetMapping("/{account}")
	public Optional<Account> show(@PathVariable("account") Long id) {
		return accountRepository.findById(id);
	}
	
	@PostMapping
	public Account store(@RequestBody Account account) {
		return accountRepository.save(account);
	}
	
	@PutMapping("/{product}")
	public Account update(@PathVariable("account") Long id, @RequestBody Account account) {
			account.setId(id);
			return accountRepository.save(account);
	}
	
	@DeleteMapping("/{account}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void destroy(@PathVariable("account") Long id) {
		Optional<Account> account = accountRepository.findById(id);
		if(account.isPresent()) {
			accountRepository.deleteById(id);
		}
	}
}
