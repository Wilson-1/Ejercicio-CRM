-- V3_activity.sql
CREATE TABLE IF NOT EXISTS activity (
                                        id SERIAL PRIMARY KEY,
                                        description VARCHAR(255) NOT NULL,
    date TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    lead_id BIGINT,
    FOREIGN KEY (lead_id) REFERENCES leads(id) ON DELETE CASCADE
    );

-- Crear índice para la columna lead_id en activity
CREATE INDEX IF NOT EXISTS idx_activity_lead_id ON activity(lead_id);

-- Insertar datos iniciales en la tabla activity
INSERT INTO activity (description, lead_id)
VALUES ('Follow-up call', 1);
