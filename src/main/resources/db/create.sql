SET MODE PostgreSQL;

CREATE TABLE IF NOT EXISTS items (
id int PRIMARY KEY auto_increment,
 name VARCHAR,
 address VARCHAR,
 zipcode VARCHAR,
 phone VARCHAR,
 price DOUBLE,
 isOnSale BOOLEAN
);

CREATE TABLE IF NOT EXISTS catitems (
id int PRIMARY KEY auto_increment,
name VARCHAR,
description VARCHAR,
price FLOAT,
purchasedat TIMESTAMP,
itemid INTEGER,
);

CREATE TABLE IF NOT EXISTS  dogitems (
id int PRIMARY KEY auto_increment,
name VARCHAR,
description VARCHAR,
price FLOAT,
purchasedat TIMESTAMP,
itemid INTEGER,


);

CREATE TABLE IF NOT EXISTS smanimitems (
id int PRIMARY KEY auto_increment,
name VARCHAR,
description VARCHAR,
price DOUBLE,
purchasedat TIMESTAMP,
itemid INTEGER,


);

CREATE TABLE IF NOT EXISTS items_catitems (
id int PRIMARY KEY auto_increment,


);

CREATE TABLE IF NOT EXISTS items_dogitems (
id int PRIMARY KEY auto_increment,

);

CREATE TABLE IF NOT EXISTS items_smanimitems (
id int PRIMARY KEY auto_increment,

);

--CREATE TABLE IF NOT EXISTS shoes(
--    id int PRIMARY KEY auto_increment,
--    name VARCHAR,
--    description VARCHAR,
--    price DOUBLE,
--    cattype VARCHAR,
--    dogType VARCHAR,
--    smanimtype VARCHAR,
--    onsale BOOLEAN,
--    createdAt TIMESTAMP
--);