create schema FINAL_WORK;

create table FINAL_WORK.PRODUCTS(
    ID INTEGER NOT NULL,
    NAME VARCHAR(100) NOT NULL,
    PRICE DOUBLE NOT NULL,
    CATEGORY VARCHAR(50),
    DISCOUNT DOUBLE,
    DESCRIPTION VARCHAR(255)
);