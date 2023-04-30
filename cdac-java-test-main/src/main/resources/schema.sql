


CREATE TABLE customers (
    id BIGINT AUTO_INCREMENT,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    PRIMARY KEY(id)
);


CREATE TABLE mobile_Numbers (
    id BIGINT AUTO_INCREMENT,
    number VARCHAR(50),
    customer_id INT,
    PRIMARY KEY (id),
    FOREIGN KEY (customer_id) REFERENCES customers(id) on delete cascade on update cascade
);