drop table if exists users;

create table users (
    id UUID PRIMARY KEY,
    name VARCHAR(256) NOT NULL,
    username VARCHAR(20) NOT NULL,
    password VARCHAR(20) NOT NULL,
    role int
    );

drop table if exists invoices;
create table invoices (
    id UUID PRIMARY KEY,
    company_name VARCHAR(256) ,
    amount NUMERIC(38, 2),
    user_id UUID,
    FOREIGN KEY(user_id) REFERENCES users(id)
    );
