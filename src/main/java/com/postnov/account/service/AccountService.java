package com.postnov.account.service;

import com.postnov.account.entity.Account;

public interface AccountService {

    Account getAccountByName(String name);

    Account updateAccountSurname(Account account, String surname);
}
