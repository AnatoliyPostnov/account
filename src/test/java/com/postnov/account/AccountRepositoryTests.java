package com.postnov.account;

import com.postnov.account.entity.Account;
import com.postnov.account.repository.AccountRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = AccountApplication.class)
class AccountRepositoryTests {

    @Autowired
    private AccountRepository accountRepository;

    @Test
    @Sql(value = {"/drop_account_before.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    void createAccountTest() {
        accountRepository.createAccount();
    }

    @Test
    @Sql(value = {"/create_account_data_before.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    void finedAccountByNameTest() {
        Account accountResult = accountRepository.finedAccountByName(ConstForTest.TEST_NAME);
        assertEquals(ConstForTest.TEST_ACCOUNT, accountResult);
    }

    @Test
    @Sql(value = {"/create_account_data_before.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    void updateAccountSurnameTest() {
        Account accountResult = accountRepository.updateAccountSurname(ConstForTest.TEST_ACCOUNT, ConstForTest.TEST_SURNAME);
        assertEquals(ConstForTest.TEST_ACCOUNT_OTHER_SURNAME, accountResult);
    }
}
