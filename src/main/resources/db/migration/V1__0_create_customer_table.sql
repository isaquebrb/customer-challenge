create table if not exists customer (
    id bigint primary key,
    name varchar(100) not null,
    age integer,
    email varchar(255) not null unique,
    cellphone varchar(50),
    phone varchar(50),
    created_at timestamp default current_timestamp not null,
    updated_at timestamp,
    active boolean
);

create table if not exists address   (
    id bigint primary key,
    street varchar(255),
    number integer,
    district varchar(255),
    city varchar(255),
    state varchar(255),
    country varchar(255),
    zip_code varchar(255),
    customer_id bigint,
    created_at timestamp default current_timestamp not null,
    updated_at timestamp,
    constraint fk_customer foreign key(customer_id) references customer(id)
);

create sequence customer_id_seq;
create sequence address_id_seq;