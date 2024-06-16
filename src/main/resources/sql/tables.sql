
CREATE TABLE UserType (
                          ID int NOT NULL AUTO_INCREMENT,
                          TYPE_NAME VARCHAR(30),
                          PRIMARY KEY (ID)
);
CREATE TABLE Bank (
                      ID int NOT NULL AUTO_INCREMENT,
                      NAME VARCHAR(30) NOT NULL,
                      PHYSICAL_COMMISSION float,
                      JURIDICAL_COMMISSION float,
                      PRIMARY KEY (ID)
);
CREATE TABLE User (
                      ID int NOT NULL AUTO_INCREMENT,
                      USER_TYPE_ID int NOT NULL ,
                      USER_NAME VARCHAR(30) NOT NULL,
                      PRIMARY KEY (ID),
                      FOREIGN KEY (USER_TYPE_ID) REFERENCES UserType(ID)
);
CREATE TABLE Currency (
                          ID int NOT NULL AUTO_INCREMENT,
                          NAME VARCHAR(10) NOT NULL ,
                          PRIMARY KEY (ID)
);
CREATE TABLE Bank_Account (
                              ID int NOT NULL AUTO_INCREMENT,
                              BANK_ID int NOT NULL,
                              USER_ID int NOT NULL ,
                              CURRENCY_ID int NOT NULL ,
                              SUM float,
                              PRIMARY KEY (ID),
                              FOREIGN KEY (BANK_ID) REFERENCES Bank(ID),
                              FOREIGN KEY (USER_ID) REFERENCES User(ID),
                              FOREIGN KEY (CURRENCY_ID) REFERENCES Currency(ID)
);
CREATE TABLE Transaction (
                             ID int NOT NULL AUTO_INCREMENT,
                             SEND_ACCOUNT_ID int NOT NULL ,
                             GET_ACCOUNT_ID int NOT NULL ,
                             TRANSACTION_SUM float NOT NULL,
                             TRANSACTION_DATE DATETIME NOT NULL,
                             PRIMARY KEY (ID),
                             FOREIGN KEY (SEND_ACCOUNT_ID) REFERENCES Bank_Account(ID),
                             FOREIGN KEY (GET_ACCOUNT_ID) REFERENCES Bank_Account(ID)
);
CREATE TRIGGER AUTO_INCREMENT_TRANSACTION_DATE
    BEFORE INSERT ON Transaction
    FOR EACH ROW
    SET NEW.TRANSACTION_DATE=DATE_ADD(UTC_TIMESTAMP(),INTERVAL 3 HOUR);
insert into UserType values (1,'physical');
insert into UserType values (2,'juridical');

insert into Currency values (1,'BLR');
insert into Currency values (2,'RUB');
insert into Currency values (3,'USD');
insert into Currency values (4,'EUR');
insert into Currency values (5,'PLN');

insert into Bank values (1,'Alfa-bank',0.01,0.1);
insert into Bank values (2,'Priorbank',0.05,0.05);
insert into Bank values (3,'MTBank',0.1,0.01);
insert into Bank values (4,'Belarusbank',0.1,0.1);
insert into Bank values (5,'Belinvestbank',0.001,0.2);


insert into User(ID,USER_TYPE_ID,USER_NAME) values (1,1,'Oleg');
insert into User(ID,USER_TYPE_ID,USER_NAME) values (2,1,'Vasili');
insert into User(ID,USER_TYPE_ID,USER_NAME) values (3,1,'Gleb');
insert into User(ID,USER_TYPE_ID,USER_NAME) values (4,2,'Intexsoft');
insert into User(ID,USER_TYPE_ID,USER_NAME) values (5,2,'IBA');
insert into User(ID,USER_TYPE_ID,USER_NAME) values (6,2,'EPAM');

insert into Bank_Account(BANK_ID, USER_ID, CURRENCY_ID, SUM) values (1,1,4,50000);
insert into Bank_Account(BANK_ID, USER_ID, CURRENCY_ID, SUM) values (1,1,3,25000);
insert into Bank_Account(BANK_ID, USER_ID, CURRENCY_ID, SUM) values (2,2,1,5000);
insert into Bank_Account(BANK_ID, USER_ID, CURRENCY_ID, SUM) values (3,3,2,150000);
insert into Bank_Account(BANK_ID, USER_ID, CURRENCY_ID, SUM) values (4,4,5,50000000);
insert into Bank_Account(BANK_ID, USER_ID, CURRENCY_ID, SUM) values (5,5,1,170000);
insert into Bank_Account(BANK_ID, USER_ID, CURRENCY_ID, SUM) values (2,6,2,88000);
insert into Bank_Account(BANK_ID, USER_ID, CURRENCY_ID, SUM) values (4,5,5,512000);


insert into Transaction(SEND_ACCOUNT_ID, GET_ACCOUNT_ID, TRANSACTION_SUM) values (4,1,3000);
insert into Transaction(SEND_ACCOUNT_ID, GET_ACCOUNT_ID, TRANSACTION_SUM) values (5,2,200);
insert into Transaction(SEND_ACCOUNT_ID, GET_ACCOUNT_ID, TRANSACTION_SUM) values (6,3,2000);

