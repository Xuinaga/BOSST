CREATE DATABASE erlete_db;

USE erlete_db;

CREATE table Expense(
    id_expense int primary key AUTO_INCREMENT,
    description varchar(255),
    price float,
    expense_type varchar(50)
);

CREATE table Can(
    id_can int primary key AUTO_INCREMENT,
    capacity int,
    availability boolean,
    last_use date
);
CREATE table Partner(
    DNI varchar(15) primary key,
    name varchar(30),
    surname varchar(30),
    email varchar(50),
    password varchar(255),
    IBAN varchar(30),
    phone varchar(15),
    address varchar(100)
);
create table Partnership_fee(
    partner_DNI varchar(15),
    year int,
    fee_charged boolean,
	PRIMARY KEY(partner_DNI, year),
    CONSTRAINT fk_partBazkideDNI FOREIGN KEY (partner_DNI) REFERENCES Partner(DNI) 
);
create table Production_fee(
    partner_DNI varchar(15),
    month varchar(15),
    year int ,
	PRIMARY KEY(partner_DNI, month, year),
    total_price float,
    CONSTRAINT fk_prodBazkideDNI FOREIGN KEY (partner_DNI) REFERENCES Partner(DNI)
);
create table Room_booking(
    id_booking int primary key AUTO_INCREMENT,
    partner_DNI varchar(15),
    book_date date,    
    extracted_quantity int,
    CONSTRAINT fk_bookBazkideDNI FOREIGN KEY (partner_DNI) REFERENCES Partner(DNI)
);
