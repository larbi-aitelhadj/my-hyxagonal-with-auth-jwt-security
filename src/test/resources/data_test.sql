CREATE SCHEMA IF NOT EXISTS db_test;

USE db_test;

CREATE TABLE IF NOT EXISTS produit (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    price DOUBLE,
    description VARCHAR(255)
);

INSERT INTO produit (name, price, description) VALUES
    ('PC', 26235.36, 'Description 1'),
    ('Téléphone', 9863.00, 'Description 2');