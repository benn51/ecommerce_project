DROP TABLE  IF EXISTS order_catagory;
DROP TABLE  IF EXISTS orders;

DROP TABLE  IF EXISTS shoes;
DROP TABLE  IF EXISTS phones;
DROP TABLE  IF EXISTS catagory;

DROP TABLE  IF EXISTS cloths;

DROP TABLE  IF EXISTS customers;



CREATE TABLE catagory (
  catagory_pk int NOT NULL AUTO_INCREMENT,
  catagory_id varchar(45) NOT NULL,
  catagory_type enum('PERSONAL_WEAR','ELECTRONICS','BEDDING','OTHER') NOT NULL,
  PRIMARY KEY (catagory_pk)
  );

CREATE TABLE shoes (
  shoes_pk int NOT NULL AUTO_INCREMENT,
  shoe_id varchar(45) NOT NULL,
  shoe_color varchar(45) NOT NULL,
  shoe_size varchar(45) NOT NULL,
  price int NOT NULL,
  catagory varchar(45) NOT NULL DEFAULT 'PERSONAL_WEAR',
  PRIMARY KEY (shoes_pk)
);



CREATE TABLE cloths (
  cloth_pk int NOT NULL AUTO_INCREMENT,
  cloth_id varchar(45) NOT NULL,
  cloth_size int NOT NULL,
  cloth_color varchar(45) NOT NULL,
  cloth_price int NOT NULL,
  catagory varchar(45) NOT NULL DEFAULT 'PERSONAL_WEAR',
  PRIMARY KEY (cloth_pk)
  );

  CREATE TABLE phones (
  phone_pk int NOT NULL AUTO_INCREMENT,
  phone_id varchar(45) NOT NULL,
  phone_color varchar(45) NOT NULL,
  phone_memory int NOT NULL,
  phone_price int NOT NULL,
  catagory varchar(45) DEFAULT 'ELECTRONICS',
  PRIMARY KEY (phone_pk)
  );

  CREATE TABLE customers (
  customer_pk int NOT NULL AUTO_INCREMENT,
  customer_id varchar(45) NOT NULL,
  FIrst_name varchar(45) NOT NULL,
  last_name varchar(45) NOT NULL,
  Phone varchar(45) DEFAULT NULL,
  PRIMARY KEY (customer_pk)
  );

CREATE TABLE orders (
  order_pk int NOT NULL AUTO_INCREMENT,
  customer_fk int NOT NULL,
  shoes_fk int NOT NULL,
  cloths_fk int NOT NULL,
  phones_fk int NOT NULL,
  price int NOT NULL,
  PRIMARY KEY (order_pk),
  CONSTRAINT orders_ibfk_1 FOREIGN KEY (customer_fk) REFERENCES customers (customer_pk) ON DELETE CASCADE,
  CONSTRAINT orders_ibfk_2 FOREIGN KEY (shoes_fk) REFERENCES shoes (shoes_pk) ON DELETE CASCADE,
  CONSTRAINT orders_ibfk_3 FOREIGN KEY (cloths_fk) REFERENCES cloths (cloth_pk) ON DELETE CASCADE,
  CONSTRAINT orders_ibfk_4 FOREIGN KEY (phones_fk) REFERENCES phones (phone_pk) ON DELETE CASCADE
);
CREATE TABLE order_catagory (
  catagory_fk Integer NOT NULL,
  order_fk int  NOT NULL,
  FOREIGN KEY (catagory_fk) REFERENCES catagory (catagory_pk) ON DELETE CASCADE,
  FOREIGN KEY (order_fk) REFERENCES orders (order_pk) ON DELETE CASCADE
);







