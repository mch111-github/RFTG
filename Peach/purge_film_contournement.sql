SELECT peach.film_actor.*, peach.film.film_id
FROM peach.film_actor 
					LEFT JOIN peach.film ON peach.film_actor.film_id = peach.film.film_id
WHERE peach.film.film_id IS NULL
;


-- Code pour supprimer tous les Films avec un id > 20 de la table 'film' :

SET FOREIGN_KEY_CHECKS=0;
DELETE FROM film WHERE film_id > 20;

-- Tables purgée :

-- film_actor :

DELETE FROM film_actor WHERE film_id > 20;

-- film_category : 

DELETE FROM film_category WHERE film_id > 20;

-- film_text :

DELETE FROM film_text WHERE film_id > 20;

-- film_director :

DELETE FROM film_director WHERE film_id > 20;

-- film_language :

DELETE FROM film_language WHERE film_id > 20;

-- inventory : 

DELETE FROM inventory WHERE film_id > 20;
SET FOREIGN_KEY_CHECKS=1;

-- Rental :

DELETE FROM rental
WHERE NOT EXISTS (
    SELECT 1
    FROM inventory
    WHERE rental.inventory_id = inventory.inventory_id
);
