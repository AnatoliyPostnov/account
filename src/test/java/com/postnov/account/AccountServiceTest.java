package com.postnov.account;

import com.postnov.account.entity.Account;
import com.postnov.account.repository.AccountRepository;
import com.postnov.account.service.AccountService;
import com.postnov.account.service.impl.AccountServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.context.jdbc.Sql;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AccountServiceTest {

    @Mock
    AccountRepository accountRepository;

    private AccountService accountService;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        accountService = new AccountServiceImpl(accountRepository);
    }

    @Test
    @Sql(value = {"/drop_account_before.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    public void getAccountByNameTest() {
        when(accountRepository.finedAccountByName("Nikita")).thenReturn(ConstForTest.TEST_ACCOUNT);
        Account accountResult = accountService.getAccountByName(ConstForTest.TEST_NAME);
        assertEquals(ConstForTest.TEST_ACCOUNT, accountResult);
    }

    @Test
    @Sql(value = {"/drop_account_before.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    public void updateAccountSurnameTest() {
        when(accountRepository.updateAccountSurname(ConstForTest.TEST_ACCOUNT, ConstForTest.TEST_SURNAME)).thenReturn(ConstForTest.TEST_ACCOUNT_OTHER_SURNAME);
        Account accountResult = accountService.updateAccountSurname(ConstForTest.TEST_ACCOUNT, ConstForTest.TEST_SURNAME);
        assertEquals(ConstForTest.TEST_ACCOUNT_OTHER_SURNAME, accountResult);
    }
}
