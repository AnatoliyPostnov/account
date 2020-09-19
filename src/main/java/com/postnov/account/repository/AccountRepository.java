package com.postnov.account.repository;

import com.postnov.account.entity.Account;

public interface AccountRepository {

    void createAccount();

    Account finedAccountByName(String name);

    Account updateAccountSurname(Account account, String surname);

}
