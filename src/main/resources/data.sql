CREATE TABLE IF NOT EXISTS walletTransactions
(
    id       SERIAL PRIMARY KEY,
    amount   bigint,
    datetime datetime
);



CREATE TABLE IF NOT EXISTS wallet
(
    id      SERIAL PRIMARY KEY,
    balance bigint
);

INSERT INTO `crypto-wallet`.wallet(`id`, `balance`)
values (1, 1000);