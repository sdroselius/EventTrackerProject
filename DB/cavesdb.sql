-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema cavesdb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `cavesdb` ;

-- -----------------------------------------------------
-- Schema cavesdb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `cavesdb` DEFAULT CHARACTER SET utf8 ;
USE `cavesdb` ;

-- -----------------------------------------------------
-- Table `cave`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cave` ;

CREATE TABLE IF NOT EXISTS `cave` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NOT NULL,
  `create_date` DATETIME NULL,
  `last_update` DATETIME NULL,
  `image_url` VARCHAR(2000) NULL,
  `description` VARCHAR(45) NULL,
  `enabled` TINYINT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

SET SQL_MODE = '';
DROP USER IF EXISTS spelunker@localhost;
SET SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
CREATE USER 'spelunker'@'localhost' IDENTIFIED BY 'spelunker';

GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE * TO 'spelunker'@'localhost';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `cave`
-- -----------------------------------------------------
START TRANSACTION;
USE `cavesdb`;
INSERT INTO `cave` (`id`, `name`, `create_date`, `last_update`, `image_url`, `description`, `enabled`) VALUES (1, 'Mammoth Cave', '2024-09-06', '2024-09-06', NULL, NULL, 1);

COMMIT;

