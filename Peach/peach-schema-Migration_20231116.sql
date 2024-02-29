-- Supprime la clé étrangère de la table rental
ALTER TABLE peach.rental DROP FOREIGN KEY fk_rental_inventory;

-- Crée la table state dans la base de données peach
CREATE TABLE peach.state (
    id INT AUTO_INCREMENT PRIMARY KEY,
    valeurs INT NOT NULL,
    libelle VARCHAR(255) NOT NULL
);

-- Ajoute la colonne state_id à la table inventory dans la base de données peach
ALTER TABLE peach.inventory ADD COLUMN state_id INT;

-- Ajoute la contrainte de clé étrangère à la table inventory dans la base de données peach
ALTER TABLE peach.inventory ADD CONSTRAINT fk_inventory_state FOREIGN KEY (state_id) REFERENCES peach.state(id);
