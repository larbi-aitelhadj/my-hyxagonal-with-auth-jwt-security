
CREATE TABLE PRODUIT(
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255),
    price DOUBLE,
    description VARCHAR(255)
);

INSERT INTO PRODUIT(name, price, description)
values('PC', 9875.36, 'description PC'),
('Smartphone', 7456.12, 'description Smartphone');
