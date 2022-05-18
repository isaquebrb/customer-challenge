create table if not exists address   (
    id bigint primary key,
    street varchar(255),
    number integer,
    district varchar(255),
    city varchar(255),
    state varchar(255),
    country varchar(255),
    zip_code varchar(255),
    created_at timestamp default current_timestamp,
    updated_at timestamp
);

create table if not exists customer (
    id bigint primary key,
    name varchar(100) not null,
    age integer,
    email varchar(255) not null,
    celphone varchar(50),
    phone varchar(50),
    address_id bigint,
    created_at timestamp default current_timestamp,
    updated_at timestamp,
    constraint fk_address foreign key(address_id) references address(id)
);