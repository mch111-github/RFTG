Notice d'Intégration

Contexte: Dans le cadre du projet RFTG (raise from the graveyard) où on doit concevoir deux application qui tourne autour de la même BDD.
Une BDD MySQL pour le projet RFTG a été mis en place avant de récupérer le projet et des modifications ont été apportés à cette BDD qui s'appelle "sakila".
La BDD a été renommé en "peach" puis des migrations ont été réaliser donc en dessous vous avez la procédure d'Intégration de cette BDD avec les migrations.

Intégration de la base de données "Peach" avec les migrations sur MySQL Workbench:

Etape 1: Allez dans votre MySQL Workbench en local.

Etape 2: ouvrez un script vide.

Etape 3: Copiez tout le contenu du script du fichier sql "peach-schema-V1.1.sql" dans le script vide 
puis exécuter le script et vous avez la structur de la base de données qui se créer.

Etape 4: Ouvrez un autre scritp vide et Copiez le contenu du script du fichier sql "peach-data.sql" dans le script vide 
puis exécuter le script et vous avez les données de chaque tables qui se créer.

Etape 5.1: Ouvrez un autre scritp vide et Copiez le contenu du script du fichier sql "peach-schema-Migration_20231012.sql" dans le script vide et exécutez l'ensemble.

Etape 5.2: Ouvrez un autre scritp vide et Copiez le contenu du script du fichier sql "peach-data-Migration_20231012.sql" dans le script vide et exécutez l'ensemble.

Etape 6.1: Ouvrez un autre scritp vide et Copiez le contenu du script du fichier sql "peach-schema-Migration_20231116.sql" dans le script vide et exécutez l'ensemble.

Etape 6.2: Ouvrez un autre scritp vide et Copiez le contenu du script du fichier sql "peach-data-Migration_20231116.sql" dans le script vide et exécutez l'ensemble.

Etape 7: Ouvrez un autre scritp vide et Copiez le contenu du script du fichier sql "peach-schema-Migration_20240112.sql" dans le script vide et exécutez l'ensemble.

Etape 8: Ouvrez un autre scritp vide et Copiez le contenu du script du fichier sql "purge_film_contournement.sql" dans le script vide et exécutez l'ensemble.

Etape 9: Ouvrez un autre scritp vide et Copiez le contenu du script du fichier sql "peach-schema-Migration_20240125.sql" dans le script vide et exécutez l'ensemble.

Etape 9.1: Ouvrez un autre scritp vide et Copiez le contenu du script du fichier sql "peach-data-Migration_20240125.sql" dans le script vide et exécutez l'ensemble.