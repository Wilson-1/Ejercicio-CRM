CREATE VIEW invoice_view AS
SELECT 1.*, c.full_name
FROM invoice i JOIN customer c
ON c.id =1. customer_id