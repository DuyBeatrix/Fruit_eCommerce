create database fruittables;
use fruittables;

create table category 
(
	cate_id int AUTO_INCREMENT not null primary key,
    cate_name varchar(255) not null,
    cate_enable bit not null,
    cate_image text not null
);

create table supplier
(
	id int auto_increment not null primary key,
    sup_name text not null,
    sup_address text not null,
    awards text not null,
    sup_img text not null
);

create table product 
(
	id int auto_increment not null primary key,
    product_name varchar(255) not null,
    product_desc text not null,
    short_desc text not null,
    product_price double not null,
    quantity int not null,
    product_sales int null,
	product_hot bit null,
    exp_date date not null,
    create_date date not null,
    product_img text not null,
    supplier_id int,
    FOREIGN KEY (supplier_id) REFERENCES supplier(id),
    cate_id int,
    foreign key (cate_id) references category(cate_id)
);

create table roles
(
	id int auto_increment not null primary key,
    roles text not null
);

create table customer
(
	id int auto_increment not null primary key,
    cus_name varchar(255) null,
    usename text not null,
    password text not null,
    cus_phone text null,
    cus_email text null,
    cus_address text null,
    gender bit null,
    role_id int,
    foreign key (role_id) references roles(id)
);

create table orders
(
	id int auto_increment not null primary key,
    order_date date not null,
    total_price double not null,
    total_product double not null,
    address text not null,
    desc_order text not null,
    phone text not null,
    email text not null,
    customer_id int,
    delivery double not null,
    product_id int,
    foreign key (product_id) references product(id),
    foreign key (customer_id) references customer(id)
);

create table order_detail
(
	id int auto_increment not null primary key,
    total_piad double not null,
    delivery_status varchar(255) not null,
    order_id int,
    foreign key (order_id) references orders(id)
);

create table feedback 
(
	id int auto_increment not null primary key,
    content text not null,
    product_id int,
    customer_id int,
    foreign key (product_id) references product(id),
    foreign key (customer_id) references customer(id)
);

create table contact 
(
	id int auto_increment not null primary key,
    contact_email text not null,
    contact_phone char(20) not null,
    contact_address text not null
);

create table blog_type
(
	id int auto_increment not null primary key,
    type_name text not null
);

create table blog_detail
(
	id int auto_increment not null primary key,
    title text not null,
    content text not null,
    blog_img text not null,
    create_at date not null,
    blog_id int,
    customer_id int,
    foreign key (blog_id) references blog_type(id),
    foreign key (customer_id) references customer(id)
);
drop table product;
drop table feedback;
drop table orders;
drop table order_detail;
drop table supplier;
drop database fruittables;