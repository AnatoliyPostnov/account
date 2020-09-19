DROP TABLE account_test.public.account;

CREATE TABLE account
(
    name varchar(255) not null,
    surname  varchar(255) not null,
    login  varchar(255) not null,
    password varchar(255) not null,
    age int8 not null,
    primary key (name)
);

INSERT INTO account_test.public.account(name, surname, login, password, age)
VALUES ('Nikita', 'Postnov', 'nic', '13680', 23);

INSERT INTO account_test.public.account(name, surname, login, password, age)
VALUES ('Anatoliy', 'Postnov', 'tol', '123456', 30);

INSERT INTO account_test.public.account(name, surname, login, password, age)
VALUES ('Sergey', 'Postnov', 'ser', '654321', 53);
