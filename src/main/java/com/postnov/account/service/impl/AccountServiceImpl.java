package com.postnov.account.service.impl;

import com.postnov.account.entity.Account;
import com.postnov.account.repository.AccountRepository;
import com.postnov.account.service.AccountService;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public Account getAccountByName(String name) {
        return accountRepository.finedAccountByName(name);
    }

    @Override
    public Account updateAccountSurname(Account account, String surname) {
        return accountRepository.updateAccountSurname(account, surname);
    }
}
