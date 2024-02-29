CREATE TRIGGER after_rental_insert
AFTER INSERT ON rental
FOR EACH ROW
UPDATE inventory
SET state_id = 1
WHERE inventory_id = NEW.inventory_id;
