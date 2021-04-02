-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema lemurdb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `lemurdb` ;

-- -----------------------------------------------------
-- Schema lemurdb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `lemurdb` DEFAULT CHARACTER SET utf8 ;
USE `lemurdb` ;

-- -----------------------------------------------------
-- Table `lemur`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `lemur` ;

CREATE TABLE IF NOT EXISTS `lemur` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

SET SQL_MODE = '';
DROP USER IF EXISTS lemuruser@localhost;
SET SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';
CREATE USER 'lemuruser'@'localhost' IDENTIFIED BY 'lemuruser';

GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE * TO 'lemuruser'@'localhost';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `lemur`
-- -----------------------------------------------------
START TRANSACTION;
USE `lemurdb`;
INSERT INTO `lemur` (`id`, `name`) VALUES (1, 'Lena');

COMMIT;

