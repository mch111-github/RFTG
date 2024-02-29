--
-- Dumping data for table director
-- MLE DEBUT
SET NAMES utf8mb4;
SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';
SET @old_autocommit=@@autocommit;

USE peach;

SET AUTOCOMMIT=0;
INSERT INTO `director` (`firstname`, `lastname`, `nationality`)
VALUES
  ('John', 'Doe', 'American'),
  ('Alice', 'Smith', 'British'),
  ('Michael', 'Johnson', 'Canadian'),
  ('Sarah', 'Brown', 'Australian'),
  ('David', 'Lee', 'French'),
  ('Maria', 'Garcia', 'Spanish'),
  ('Andrea', 'Rossi', 'Italian'),
  ('Luis', 'Hernandez', 'Mexican'),
  ('Elena', 'Kovalenko', 'Russian'),
  ('Hiroshi', 'Suzuki', 'Japanese'),
  ('Ming', 'Chen', 'Chinese'),
  ('Klaus', 'Schmidt', 'German'),
  ('Sofia', 'Andersson', 'Swedish'),
  ('Lucas', 'Silva', 'Brazilian'),
  ('Anna', 'Nowak', 'Polish'),
  ('Ravi', 'Patel', 'Indian'),
  ('Eva', 'Müller', 'Austrian'),
  ('Javier', 'Fernandez', 'Spanish'),
  ('Yuki', 'Tanaka', 'Japanese'),
  ('Isabel', 'Lopez', 'Mexican'),
  ('Oksana', 'Kuznetsova', 'Russian'),
  ('Paul', 'Wilson', 'Irish'),
  ('Marta', 'Gomez', 'Colombian'),
  ('Alex', 'Chung', 'Korean'),
  ('Catherine', 'Dupont', 'French'),
  ('Vladimir', 'Ivanov', 'Russian'),
  ('Sophie', 'Lefebvre', 'Belgian'),
  ('Carlos', 'Rodriguez', 'Mexican'),
  ('Yusuke', 'Sato', 'Japanese'),
  ('Sara', 'Andersson', 'Swedish'),
  ('Luigi', 'Ricci', 'Italian'),
  ('Elizabeth', 'Williams', 'American'),
  ('Ahmed', 'Khan', 'Pakistani'),
  ('Larisa', 'Popescu', 'Romanian'),
  ('Antonio', 'Moreno', 'Spanish'),
  ('Lina', 'Kazemi', 'Iranian'),
  ('Ivan', 'Petrov', 'Russian'),
  ('Marta', 'Fernandez', 'Spanish'),
  ('Hans', 'Mueller', 'German'),
  ('Elsa', 'Larsson', 'Swedish'),
  ('Raul', 'Gonzalez', 'Mexican'),
  ('Masato', 'Nakamura', 'Japanese'),
  ('Emily', 'Smith', 'Canadian'),
  ('Jorge', 'Santos', 'Portuguese'),
  ('Andrey', 'Kuznetsov', 'Russian'),
  ('Helena', 'Makarova', 'Russian'),
  ('Alina', 'Stojanovic', 'Serbian'),
  ('Mohammed', 'Ali', 'Egyptian'),
  ('Anastasia', 'Ivanova', 'Russian'),
  ('Hugo', 'Gomez', 'Mexican'),
  ('Yasmin', 'Ahmed', 'Egyptian'),
  ('Olga', 'Andreeva', 'Russian'),
  ('Manuel', 'Ferreira', 'Portuguese'),
  ('Luca', 'Martinez', 'Spanish'),
  ('Isabella', 'Romano', 'Italian'),
  ('Jia', 'Chen', 'Chinese'),
  ('Sophia', 'Hernandez', 'Mexican'),
  ('Yoshihiro', 'Tanaka', 'Japanese'),
  ('Ingrid', 'Eriksson', 'Swedish'),
  ('John', 'Müller', 'German'),
  ('Elena', 'Ivanova', 'Russian'),
  ('Oscar', 'Rodriguez', 'Mexican'),
  ('Katerina', 'Papadopoulos', 'Greek'),
  ('Liam', 'Williams', 'British'),
  ('Camila', 'Santos', 'Brazilian'),
  ('Alessio', 'Conti', 'Italian'),
  ('Emil', 'Andersson', 'Swedish'),
  ('Svetlana', 'Volkova', 'Russian'),
  ('Sofia', 'Lopez', 'Mexican'),
  ('Carlos', 'Fernandez', 'Spanish'),
  ('Ryota', 'Kawasaki', 'Japanese'),
  ('Hanna', 'Kowalska', 'Polish'),
  ('Gabriel', 'Garcia', 'Spanish'),
  ('Katja', 'Hansen', 'Danish'),
  ('Ahmed', 'Rashid', 'Saudi'),
  ('Evelina', 'Andreeva', 'Russian'),
  ('Diego', 'Martinez', 'Spanish'),
  ('Léa', 'Dubois', 'French'),
  ('Viktor', 'Kovalenko', 'Ukrainian'),
  ('Olivia', 'Bianchi', 'Italian'),
  ('Artur', 'Kowalczyk', 'Polish'),
  ('Mariana', 'Silva', 'Brazilian'),
  ('Fedor', 'Ivanov', 'Russian'),
  ('Ines', 'Fernandez', 'Spanish'),
  ('Jens', 'Andersen', 'Danish'),
  ('Jasmin', 'Ali', 'Pakistani'),
  ('Natalia', 'Smirnova', 'Russian'),
  ('Lucas', 'Andersson', 'Swedish'),
  ('Mohammed', 'Khan', 'Pakistani'),
  ('Sophie', 'Dupont', 'French'),
  ('Gustavo', 'Rodriguez', 'Mexican'),
  ('Keiko', 'Yamamoto', 'Japanese'),
  ('Luis', 'Gomez', 'Spanish'),
  ('Mia', 'Andersson', 'Swedish'),
  ('Jakub', 'Novak', 'Czech'),
  ('Ali', 'Abdullah', 'Saudi'),
  ('Anna', 'Gonzalez', 'Mexican'),
  ('Nina', 'Petrova', 'Russian'),
  ('Samuel', 'Andrade', 'Portuguese'),
  ('Olga', 'Kozlova', 'Russian'),
  ('Federico', 'Rossi', 'Italian'),
  ('Petar', 'Ivanov', 'Bulgarian'),
  ('Amina', 'Zarif', 'Afghan'),
  ('Amir', 'Rahman', 'Bangladeshi'),
  ('Natalia', 'Cortez', 'Chilean'),
  ('Eduardo', 'López', 'Spanish'),
  ('Xiaohong', 'Li', 'Chinese'),
  ('Sergio', 'Alvarez', 'Spanish'),
  ('Magdalena', 'Nowak', 'Polish'),
  ('Dmitri', 'Petrov', 'Russian'),
  ('Aurelia', 'Popescu', 'Romanian'),
  ('Luca', 'Marini', 'Italian');

-- MLE FIN

--
-- Dumping data for table film_language
-- AMA DEBUT
DELETE FROM `film_language`;

INSERT INTO `film_language`
SELECT film_id,1,1 FROM film;

INSERT INTO `film_language`
SELECT film_id,2,1 FROM film;

INSERT INTO `film_language`
SELECT film_id,5,1 FROM film;
-- AMA FIN

-- GSA et TOT DEBUT
INSERT INTO `customer_category` (`customer_id`, `category_id`)  select customer_id, 1 from customer;
-- GSA et TOT FIN

-- ABO, FBI et EMO DEBUT
INSERT INTO `film_director` select film_id, 1 from film;

INSERT INTO `film_director` select film_id, 112 from film;
-- ABO, FBI et EMO FIN

COMMIT;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
SET autocommit=@old_autocommit;