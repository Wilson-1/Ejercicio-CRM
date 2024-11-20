-- V1_init.sql
CREATE TABLE IF NOT EXISTS customer (
                                        id SERIAL PRIMARY KEY,
                                        name VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL
    );

-- Insertar datos iniciales en la tabla customer
INSERT INTO customer (name, email)
VALUES ('John Doe', 'john.doe@example.com');
