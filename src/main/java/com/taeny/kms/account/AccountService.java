package com.taeny.kms.account;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AccountService {

	PasswordEncoder passwordEncoder;
	AccountRepository accountRepository;

    public Optional<Account> findById(Integer seq) {
		return this.accountRepository.findById(seq);
    }
	public Optional<Account> findByUserId(String userId) {
		return this.accountRepository.findAccountByUserId(userId);
	}

	public Account save(Account account) {
		account.setPassword(passwordEncoder.encode(account.getPassword()));
		return this.accountRepository.save(account);
	}

	public void deleteAll() {
    	this.accountRepository.deleteAll();
	}

	public List<Account> findAll() {
    	return accountRepository.findAll();
	}

}
