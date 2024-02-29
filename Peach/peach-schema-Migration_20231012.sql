USE peach;

SET NAMES utf8mb4;
SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

--
-- Table structure for table `role`
-- SRA DEBUT
CREATE TABLE role (
    role_id INT PRIMARY KEY,
    role_name VARCHAR(255) NOT NULL
);

ALTER TABLE customer
ADD COLUMN role_id INT;

-- Ajouter la contrainte de clé étrangère
ALTER TABLE customer
ADD CONSTRAINT FK_customer_role
FOREIGN KEY (role_id) REFERENCES role(role_id);

INSERT INTO role VALUES (1, 'Standard'),
(2, 'Administrateur');
UPDATE customer SET role_id = 1;
-- SRA FIN

-- ARO DEBUT
ALTER TABLE staff
ADD COLUMN role_id INT;

ALTER TABLE staff
ADD CONSTRAINT fk_staff_role
FOREIGN KEY (role_id) REFERENCES role(role_id);
-- ARO FIN

-- TOT DEBUT
ALTER TABLE `customer` 
ADD COLUMN `birthdate` DATE NULL AFTER `last_update`;
-- TOT FIN

--
-- Table structure for table `customer_category`
-- GSA

CREATE TABLE `customer_category` (
  `customer_id` smallint(5) unsigned NOT NULL,
  `category_id` tinyint(3) unsigned NOT NULL,
  PRIMARY KEY (`customer_id`,`category_id`),
  KEY `fk_customer_category_category` (`category_id`),
  CONSTRAINT `fk_customer_category_category_category` FOREIGN KEY (`category_id`) REFERENCES `category` (`category_id`) ON UPDATE CASCADE,
  CONSTRAINT `fk_customer_category_category` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`customer_id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Table structure for table `director`
-- MLE

CREATE TABLE `director` (
  `director_id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `firstname` VARCHAR(45) NULL,
  `lastname` VARCHAR(45) NULL,
  `nationality` VARCHAR(45) NULL,
  PRIMARY KEY (`director_id`)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8;

-- Table structure for table `film_director`
-- MLE

CREATE TABLE `film_director` (
  `film_id` SMALLINT UNSIGNED NOT NULL,
  `director_id` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`film_id`,`director_id`),
  KEY `fk_film_director_director` (`director_id`),
  CONSTRAINT `fk_film_director_director` FOREIGN KEY (`director_id`) REFERENCES `director` (`director_id`) ON UPDATE CASCADE,
  CONSTRAINT `fk_film_director_film` FOREIGN KEY (`film_id`) REFERENCES `film` (`film_id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Table structure for table `film_language`
-- AMA

CREATE TABLE `film_language` (
  `film_id` SMALLINT UNSIGNED NOT NULL,
  `language_id` TINYINT UNSIGNED NOT NULL,
  `original_language` boolean,
  PRIMARY KEY (`film_id`,`language_id`),
  CONSTRAINT `fk_film_language_film` FOREIGN KEY (`film_id`) REFERENCES `film` (`film_id`) ON UPDATE CASCADE,
  CONSTRAINT `fk_film_language_language` FOREIGN KEY (`language_id`) REFERENCES `language` (`language_id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- FBI DEBUT
ALTER TABLE `rental` 
ADD COLUMN `state` VARCHAR(45) NOT NULL DEFAULT 'À traiter' AFTER `last_update`;
-- FBI FIN

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;