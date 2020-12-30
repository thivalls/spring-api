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
import com.zup.bank.services.AccountService;

@RestController
@RequestMapping("/accounts")
public class AccountResource {

	@Autowired
	AccountService accountService;
	
	@GetMapping
	public List<Account> all() {
		return accountService.all();
	}
	
	@GetMapping("/{account}")
	public Optional<Account> show(@PathVariable("account") Long id) {
		return accountService.show(id);
	}
	
	@PostMapping
	@ResponseStatus(code=HttpStatus.CREATED)
	public Account store(@RequestBody Account account) {
		return accountService.store(account);
	}
	
	@PutMapping("/{account}")
	public Account update(@PathVariable("account") Long id, @RequestBody Account account) {
		return accountService.update(id, account);
	}
	
	@DeleteMapping("/{account}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void destroy(@PathVariable("account") Long id) {
		accountService.destroy(id);
	}
}
