package com.zup.bank.interfaces;

import java.util.List;
import java.util.Optional;

import com.zup.bank.models.Account;

public interface IAccountService {
	public List<Account> all();
	public Optional<Account> show(long id);
	public Account store(Account account);
	public Account update(long id, Account account);
	public void destroy(long id);
}
