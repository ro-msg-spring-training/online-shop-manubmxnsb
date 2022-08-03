create table if not exists supplier(
    id int primary key auto_increment,
    name varchar(255));

create table if not exists product_category(
    id int primary key auto_increment,
    name varchar(255),
    description varchar(255));

create table if not exists product(
    id int primary key auto_increment,
    name varchar(255),
    description varchar(255),
    price double,
    weight double,
    image_url varchar(255),
    product_category_id int,
    constraint fk_product_category foreign key (product_category_id) references product_category(id),
    supplier_id int,
    constraint fk_supplier foreign key (supplier_id) references supplier(id));

create table if not exists customer(
    id int primary key auto_increment,
    firstname varchar(255),
    lastname varchar(255),
    username varchar(255),
    password varchar(255),
    email_address varchar(255)
    );

create table if not exists location(
    id int primary key auto_increment,
    name varchar(255),
    address_country varchar(255),
    address_city varchar(255),
    address_county varchar(255),
    address_street varchar(255)
    );

create table if not exists revenue(
    id int primary key auto_increment,
    location_id int,
    constraint fk_location foreign key (location_id) references location(id),
    date_d date,
    sum double
    );

create table if not exists placed_order(
    id int primary key auto_increment,
    shipped_from_id int,
    constraint fk_shipped_from foreign key (shipped_from_id) references location(id),
    customer_id int,
    constraint fk_customer foreign key (customer_id) references customer(id),
    created_at datetime,
    address_country varchar(255),
    address_city varchar(255),
    address_county varchar(255),
    address_street varchar(255));

create table if not exists stock(
    id int primary key auto_increment,
    product_id int,
    constraint fk_product foreign key (product_id) references product(id),
    location_id int,
    constraint fk_location_stock foreign key (location_id) references location(id),
    quantity int,
    constraint unique_stock unique (product_id,location_id)
    );

create table if not exists order_detail(
    id int primary key auto_increment,
    product_id int,
    constraint fk_product_order_detail foreign key (product_id) references product(id),
    order_id int,
    constraint fk_order foreign key (order_id) references placed_order(id),
    quantity int,
    constraint unique_order_detail unique (product_id,order_id)
    );

insert into product_category(name, description) values ( 'laptop', 'electronics category - laptops' );

insert into supplier(name) values ( 'dell' );

insert into product(name, description, price, weight, image_url, product_category_id, supplier_id)
values ( 'my first product', 'amazing', 1000, 200, 'url', 1, 1 );