INSERT INTO peach.state (valeurs, libelle) VALUES (0, 'représente les films qui sont hors stock'), (1, 'représente les films qui sont en stock');

UPDATE peach.inventory SET state_id = (SELECT id FROM state WHERE valeurs = 1);