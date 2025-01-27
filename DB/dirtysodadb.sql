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
-- Table `manufacturer`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `manufacturer` ;

CREATE TABLE IF NOT EXISTS `manufacturer` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `logo_image_url` VARCHAR(2000) NULL,
  `website_url` VARCHAR(2000) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `base_drink`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `base_drink` ;

CREATE TABLE IF NOT EXISTS `base_drink` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `brand` VARCHAR(45) NULL,
  `image_url` VARCHAR(2000) NULL,
  `manufacturer_id` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_base_drink_manufacturer1_idx` (`manufacturer_id` ASC) VISIBLE,
  CONSTRAINT `fk_base_drink_manufacturer1`
    FOREIGN KEY (`manufacturer_id`)
    REFERENCES `manufacturer` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


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
  `brand` VARCHAR(45) NULL,
  `base_drink_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_dirty_drink_base_drink_idx` (`base_drink_id` ASC) VISIBLE,
  CONSTRAINT `fk_dirty_drink_base_drink`
    FOREIGN KEY (`base_drink_id`)
    REFERENCES `base_drink` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `add_in`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `add_in` ;

CREATE TABLE IF NOT EXISTS `add_in` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `description` VARCHAR(45) NULL,
  `image_url` VARCHAR(2000) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dirty_drink_add_in`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dirty_drink_add_in` ;

CREATE TABLE IF NOT EXISTS `dirty_drink_add_in` (
  `dirty_drink_id` INT NOT NULL,
  `add_in_id` INT NOT NULL,
  `amount` DOUBLE NULL,
  `amount_unit` VARCHAR(45) NULL,
  PRIMARY KEY (`dirty_drink_id`, `add_in_id`),
  INDEX `fk_dirty_drink_has_add_in_add_in1_idx` (`add_in_id` ASC) VISIBLE,
  INDEX `fk_dirty_drink_has_add_in_dirty_drink1_idx` (`dirty_drink_id` ASC) VISIBLE,
  CONSTRAINT `fk_dirty_drink_has_add_in_dirty_drink1`
    FOREIGN KEY (`dirty_drink_id`)
    REFERENCES `dirty_drink` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_dirty_drink_has_add_in_add_in1`
    FOREIGN KEY (`add_in_id`)
    REFERENCES `add_in` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
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
-- Data for table `manufacturer`
-- -----------------------------------------------------
START TRANSACTION;
USE `dirtysodadb`;
INSERT INTO `manufacturer` (`id`, `name`, `logo_image_url`, `website_url`) VALUES (1, 'Coca Cola', NULL, NULL);
INSERT INTO `manufacturer` (`id`, `name`, `logo_image_url`, `website_url`) VALUES (2, 'PepsiCo', NULL, NULL);
INSERT INTO `manufacturer` (`id`, `name`, `logo_image_url`, `website_url`) VALUES (3, 'Keurig Dr. Pepper', NULL, NULL);

COMMIT;


-- -----------------------------------------------------
-- Data for table `base_drink`
-- -----------------------------------------------------
START TRANSACTION;
USE `dirtysodadb`;
INSERT INTO `base_drink` (`id`, `name`, `brand`, `image_url`, `manufacturer_id`) VALUES (1, 'Diet Coke', NULL, NULL, 1);
INSERT INTO `base_drink` (`id`, `name`, `brand`, `image_url`, `manufacturer_id`) VALUES (2, 'Sprite', NULL, NULL, 1);
INSERT INTO `base_drink` (`id`, `name`, `brand`, `image_url`, `manufacturer_id`) VALUES (3, 'Root Beer', 'Dad\'s', NULL, NULL);
INSERT INTO `base_drink` (`id`, `name`, `brand`, `image_url`, `manufacturer_id`) VALUES (4, 'Mountain Dew', NULL, NULL, 2);
INSERT INTO `base_drink` (`id`, `name`, `brand`, `image_url`, `manufacturer_id`) VALUES (5, 'Dr. Pepper', NULL, NULL, 3);
INSERT INTO `base_drink` (`id`, `name`, `brand`, `image_url`, `manufacturer_id`) VALUES (6, 'Diet Dr. Pepper', NULL, NULL, 3);
INSERT INTO `base_drink` (`id`, `name`, `brand`, `image_url`, `manufacturer_id`) VALUES (7, 'Squirt', NULL, NULL, 3);
INSERT INTO `base_drink` (`id`, `name`, `brand`, `image_url`, `manufacturer_id`) VALUES (8, 'Diet Pepsi', NULL, NULL, 2);

COMMIT;


-- -----------------------------------------------------
-- Data for table `dirty_drink`
-- -----------------------------------------------------
START TRANSACTION;
USE `dirtysodadb`;
INSERT INTO `dirty_drink` (`id`, `name`, `description`, `create_date`, `last_update`, `image_url`, `brand`, `base_drink_id`) VALUES (1, 'Espresso Dew', NULL, '2025-01-24', '2025-01-24', NULL, NULL, 4);
INSERT INTO `dirty_drink` (`id`, `name`, `description`, `create_date`, `last_update`, `image_url`, `brand`, `base_drink_id`) VALUES (2, 'Founder', NULL, '2025-01-24', '2025-01-24', NULL, NULL, 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `add_in`
-- -----------------------------------------------------
START TRANSACTION;
USE `dirtysodadb`;
INSERT INTO `add_in` (`id`, `name`, `description`, `image_url`) VALUES (1, 'Heavy cream', NULL, NULL);
INSERT INTO `add_in` (`id`, `name`, `description`, `image_url`) VALUES (2, 'Coconut syrup', NULL, NULL);
INSERT INTO `add_in` (`id`, `name`, `description`, `image_url`) VALUES (3, 'Lime juice', NULL, NULL);
INSERT INTO `add_in` (`id`, `name`, `description`, `image_url`) VALUES (4, 'Lime wedge', NULL, NULL);
INSERT INTO `add_in` (`id`, `name`, `description`, `image_url`) VALUES (5, 'Vanilla syrup', NULL, NULL);
INSERT INTO `add_in` (`id`, `name`, `description`, `image_url`) VALUES (6, 'Coffee Mate original', NULL, NULL);
INSERT INTO `add_in` (`id`, `name`, `description`, `image_url`) VALUES (7, 'Coffee Mate hazelnut', NULL, NULL);
INSERT INTO `add_in` (`id`, `name`, `description`, `image_url`) VALUES (8, 'Coffee Mate french vanilla', NULL, NULL);
INSERT INTO `add_in` (`id`, `name`, `description`, `image_url`) VALUES (9, 'Espresso', NULL, NULL);

COMMIT;


-- -----------------------------------------------------
-- Data for table `dirty_drink_add_in`
-- -----------------------------------------------------
START TRANSACTION;
USE `dirtysodadb`;
INSERT INTO `dirty_drink_add_in` (`dirty_drink_id`, `add_in_id`, `amount`, `amount_unit`) VALUES (1, 9, 1, 'Shot');
INSERT INTO `dirty_drink_add_in` (`dirty_drink_id`, `add_in_id`, `amount`, `amount_unit`) VALUES (2, 1, 1, 'Shot');
INSERT INTO `dirty_drink_add_in` (`dirty_drink_id`, `add_in_id`, `amount`, `amount_unit`) VALUES (2, 2, 1, 'Shot');
INSERT INTO `dirty_drink_add_in` (`dirty_drink_id`, `add_in_id`, `amount`, `amount_unit`) VALUES (2, 4, 1, NULL);

COMMIT;

