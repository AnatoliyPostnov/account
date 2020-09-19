package com.postnov.account.entity;

import java.util.Objects;

public class Account {

    private String name;

    private String surname;

    private String login;

    private String password;

    private Integer age;

    public Account(String name, String surname, String login, String password, Integer age) {
        this.name = name;
        this.surname = surname;
        this.login = login;
        this.password = password;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(name, account.name) &&
                Objects.equals(surname, account.surname) &&
                Objects.equals(login, account.login) &&
                Objects.equals(password, account.password) &&
                Objects.equals(age, account.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, login, password, age);
    }
}
