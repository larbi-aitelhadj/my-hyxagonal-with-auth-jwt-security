
-- Create table within the schema
CREATE SCHEMA IF NOT EXISTS schema_test;  -- Ensure the schema exists

CREATE TABLE IF NOT EXISTS schema_test.produit (
    id INT PRIMARY KEY,
    name VARCHAR(255),
    price DOUBLE,
    description VARCHAR(255)
);

-- Insert sample data
INSERT INTO schema_test.produit (name, price, description) VALUES
    ('PC', 26235.36, 'Description 1'),
    ('Téléphone', 9863.00, 'Description 2');