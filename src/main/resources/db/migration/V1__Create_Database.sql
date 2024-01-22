CREATE TABLE ACCOUNT
(
    ID       NUMBER GENERATED ALWAYS AS IDENTITY NOT NULL,
    Username VARCHAR(20)                         NOT NULL,
    Password VARCHAR(255)                        NOT NULL,
    Address  VARCHAR(30)                         NOT NULL,
    CONSTRAINT PK_Account PRIMARY KEY (ID)
);
CREATE TABLE ROLE
(
    ID         NUMBER GENERATED ALWAYS AS IDENTITY NOT NULL,
    Account_Id NUMBER                              NOT NULL,
    Authority  VARCHAR(20)                         NOT NULL,
    CONSTRAINT Role_FK FOREIGN KEY (Account_Id) REFERENCES ACCOUNT (ID)
);
CREATE TABLE PRODUCT
(
    ID          NUMBER GENERATED ALWAYS AS IDENTITY NOT NULL,
    Name        VARCHAR(20)                         NOT NULL,
    DESCRIPTION VARCHAR(255)                        NOT NULL,
    Category    VARCHAR(20)                         NOT NULL,
    Quantity    INT                                 NOT NULL,
    CONSTRAINT PK_Product PRIMARY KEY (ID)
);
CREATE TABLE CART
(
    ID         NUMBER GENERATED ALWAYS AS IDENTITY NOT NULL,
    Account_Id NUMBER                              NOT NULL,
    CONSTRAINT Account_Fk FOREIGN KEY (Account_Id) REFERENCES ACCOUNT (ID)
);
CREATE TABLE CART_ITEMS
(
    Account_Id NUMBER NOT NULL REFERENCES ACCOUNT (ID),
    Product_Id NUMBER NOT NULL REFERENCES PRODUCT (ID),
    CONSTRAINT Pk_CartItems PRIMARY KEY (Account_Id, Product_Id)
);
