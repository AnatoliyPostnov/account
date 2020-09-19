package com.postnov.account.repository.impl;

import com.postnov.account.entity.Account;
import com.postnov.account.repository.AccountRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AccountRepositoryImpl implements AccountRepository {

    private static Logger logger = LoggerFactory.getLogger(AccountRepositoryImpl.class);

    private final JdbcTemplate jdbcTemplate;

    public AccountRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        createAccount();
    }

    @Override
    public void createAccount() {
        String createAccountQuery = "create table account\n" +
                "(\n" +
                "    name     varchar(255) not null,\n" +
                "    surname  varchar(255) not null,\n" +
                "    login  varchar(255) not null,\n" +
                "    password varchar(255) not null,\n" +
                "    age int8 not null,\n" +
                "    primary key (name)\n" +
                ")";
        try {
            jdbcTemplate.execute(createAccountQuery);
        } catch (BadSqlGrammarException ex) {
            logger.info("[x]...Account table already exist");
        }
    }

    @Override
    public Account finedAccountByName(String name) {
        return jdbcTemplate.query(String.format("SELECT * FROM account ac WHERE ac.name='%s'", name),
                rs -> {
                    rs.next();
                    return new Account(
                            rs.getString("name"),
                            rs.getString("surname"),
                            rs.getString("login"),
                            rs.getString("password"),
                            Integer.parseInt(rs.getString("age")));
                });
    }

    @Override
    public Account updateAccountSurname(Account account, String surname) {
        jdbcTemplate.update(String.format("UPDATE account SET surname='%s' WHERE name='%s'", surname, account.getName()));
        return finedAccountByName(account.getName());
    }
}
