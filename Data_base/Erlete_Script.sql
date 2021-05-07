CREATE DATABASE erlete_db;

CREATE table Expense(
    id_expense int primary key autoincrement,
    description varchar(255),
    price float,
    expense_type varchar(50)
)

CREATE table Can(
    id_can int primary key autoincrement,
    capacity int,
    availability boolean,
    last_use date
)
CREATE table Partner(
    DNI varchar(15) primary key,
    name varchar(30),
    surname varchar(30),
    email varchar(50),
    password varchar(255),
    IBAN varchar(30),
    phone varchar(15),
    name varchar(100)
)
create table Partership_fee(
    partner_DNI varchar(15) primary key,
    year int primary key,
    fee_charged boolean,
    CONSTRAINT fk_partBazkideDNI FOREIGN KEY (partner_DNI) REFERENCES Partner(DNI) 
)
create table Production_fee(
    partner_DNI varchar(15) primary key,
    month varchar(15) primary key,
    year int primary key,
    total_price float,
    CONSTRAINT fk_prodBazkideDNI FOREIGN KEY (partner_DNI) REFERENCES Partner(DNI)
)
create table Room_booking(
    id_booking int primary key autoincrement,
    partner_DNI varchar(15),
    book_date date,    
    extracted_quantity int,
    CONSTRAINT fk_bookBazkideDNI FOREIGN KEY (partner_DNI) REFERENCES Partner(DNI)
)
create table Extraction(
    id_booking int primary key,
    extracted_quantity int,
    CONSTRAINT fk_extIdBooking FOREIGN KEY (partner_DNI) REFERENCES Partner(DNI)
)
