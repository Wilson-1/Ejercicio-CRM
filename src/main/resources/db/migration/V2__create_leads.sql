-- V2_leads.sql
CREATE TABLE IF NOT EXISTS leads (
                                     id SERIAL PRIMARY KEY,
                                     name VARCHAR(255) NOT NULL,
    status VARCHAR(50) NOT NULL DEFAULT 'new',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    customer_id BIGINT,
    source VARCHAR(255) NOT NULL,
    FOREIGN KEY (customer_id) REFERENCES customer(id) ON DELETE CASCADE
    );

-- Crear índice para la columna customer_id en leads
CREATE INDEX IF NOT EXISTS idx_leads_customer_id ON leads(customer_id);

-- Insertar datos iniciales en la tabla leads
INSERT INTO leads (name, status, customer_id, source)
VALUES ('Lead 1', 'active', 1, 'Website');
