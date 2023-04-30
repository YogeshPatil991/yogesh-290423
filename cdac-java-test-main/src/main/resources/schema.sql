


CREATE TABLE customers (
    id INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(50),
    last_name VARCHAR(50)
);


CREATE TABLE mobile_Numbers (
    id INT PRIMARY KEY AUTO_INCREMENT,
    number VARCHAR(50),
    customer_id INT,
    FOREIGN KEY (customer_id) REFERENCES customers(id)
);