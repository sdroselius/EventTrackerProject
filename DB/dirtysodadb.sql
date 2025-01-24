-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema dirtysodadb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `dirtysodadb` ;

-- -----------------------------------------------------
-- Schema dirtysodadb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `dirtysodadb` DEFAULT CHARACTER SET utf8 ;
USE `dirtysodadb` ;

-- -----------------------------------------------------
-- Table `dirty_drink`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dirty_drink` ;

CREATE TABLE IF NOT EXISTS `dirty_drink` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `description` VARCHAR(45) NULL,
  `create_date` DATETIME NULL,
  `last_update` DATETIME NULL,
  `image_url` VARCHAR(2000) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

SET SQL_MODE = '';
DROP USER IF EXISTS sodadrinker@localhost;
SET SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
CREATE USER 'sodadrinker'@'localhost' IDENTIFIED BY 'sodadrinker';

GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE * TO 'sodadrinker'@'localhost';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `dirty_drink`
-- -----------------------------------------------------
START TRANSACTION;
USE `dirtysodadb`;
INSERT INTO `dirty_drink` (`id`, `name`, `description`, `create_date`, `last_update`, `image_url`) VALUES (1, 'Espresso Dew', NULL, '2025-01-24', '2025-01-24', NULL);

COMMIT;

