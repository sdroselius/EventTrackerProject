-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema divelogdb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `divelogdb` ;

-- -----------------------------------------------------
-- Schema divelogdb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `divelogdb` DEFAULT CHARACTER SET utf8 ;
USE `divelogdb` ;

-- -----------------------------------------------------
-- Table `country`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `country` ;

CREATE TABLE IF NOT EXISTS `country` (
  `country_code` CHAR(2) NOT NULL,
  `name` VARCHAR(45) NULL,
  `image_url` VARCHAR(2000) NULL,
  `flag_image_url` VARCHAR(2000) NULL,
  PRIMARY KEY (`country_code`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `destination`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `destination` ;

CREATE TABLE IF NOT EXISTS `destination` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NULL,
  `description` TEXT NULL,
  `image_url` VARCHAR(2000) NULL,
  `country_country_code` CHAR(2) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_destination_country1_idx` (`country_country_code` ASC) VISIBLE,
  CONSTRAINT `fk_destination_country1`
    FOREIGN KEY (`country_country_code`)
    REFERENCES `country` (`country_code`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `user` ;

CREATE TABLE IF NOT EXISTS `user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(100) NOT NULL,
  `enabled` TINYINT NOT NULL,
  `role` VARCHAR(45) NULL,
  `first_name` VARCHAR(45) NULL,
  `last_name` VARCHAR(45) NULL,
  `about_me` TEXT NULL,
  `profile_image_url` VARCHAR(45) NULL,
  `create_date` DATETIME NULL,
  `last_update` DATETIME NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `username_UNIQUE` (`username` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dive_site`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dive_site` ;

CREATE TABLE IF NOT EXISTS `dive_site` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NULL,
  `description` TEXT NULL,
  `latitude` DOUBLE NULL,
  `longitude` DOUBLE NULL,
  `destination_id` INT NOT NULL,
  `create_date` DATETIME NULL,
  `last_update` DATETIME NULL,
  `added_by_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_dive_site_destination1_idx` (`destination_id` ASC) VISIBLE,
  INDEX `fk_dive_site_user1_idx` (`added_by_id` ASC) VISIBLE,
  CONSTRAINT `fk_dive_site_destination1`
    FOREIGN KEY (`destination_id`)
    REFERENCES `destination` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_dive_site_user1`
    FOREIGN KEY (`added_by_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dive`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dive` ;

CREATE TABLE IF NOT EXISTS `dive` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(45) NULL,
  `dive_date` DATE NULL,
  `time_in` TIME NULL,
  `time_out` TIME NULL,
  `decompress_minutes` INT NULL,
  `notes` TEXT NULL,
  `maximum_depth_meters` INT NULL,
  `weight_kilograms` DECIMAL(3) NULL,
  `dive_site_id` INT NOT NULL,
  `create_date` DATETIME NULL,
  `last_update` DATETIME NULL,
  `user_id` INT NOT NULL,
  `wildlife_seen` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_dive_dive_site_idx` (`dive_site_id` ASC) VISIBLE,
  INDEX `fk_dive_user1_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `fk_dive_dive_site`
    FOREIGN KEY (`dive_site_id`)
    REFERENCES `dive_site` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_dive_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

SET SQL_MODE = '';
DROP USER IF EXISTS glubglub@localhost;
SET SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
CREATE USER 'glubglub'@'localhost' IDENTIFIED BY 'glubglub';

GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE * TO 'glubglub'@'localhost';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `country`
-- -----------------------------------------------------
START TRANSACTION;
USE `divelogdb`;
INSERT INTO `country` (`country_code`, `name`, `image_url`, `flag_image_url`) VALUES ('mx', 'Mexico', NULL, NULL);
INSERT INTO `country` (`country_code`, `name`, `image_url`, `flag_image_url`) VALUES ('bz', 'Belize', NULL, NULL);
INSERT INTO `country` (`country_code`, `name`, `image_url`, `flag_image_url`) VALUES ('hn', 'Honduras', NULL, NULL);
INSERT INTO `country` (`country_code`, `name`, `image_url`, `flag_image_url`) VALUES ('bs', 'Bahamas', NULL, NULL);

COMMIT;


-- -----------------------------------------------------
-- Data for table `destination`
-- -----------------------------------------------------
START TRANSACTION;
USE `divelogdb`;
INSERT INTO `destination` (`id`, `name`, `description`, `image_url`, `country_country_code`) VALUES (1, 'Cozumel', 'Cozumel is an island and municipality in the Caribbean Sea off the eastern coast of Mexico\'s Yucatán Peninsula, opposite Playa del Carmen. It is separated from the mainland by the Cozumel Channel and is close to the Yucatán Channel. The municipality is part of the state of Quintana Roo, Mexico.\n\nScuba diving is one of Cozumel\'s primary attractions, mainly due to the coral reef on the western shore of Cozumel. These coral reefs are protected from the open ocean by the island\'s natural geography. ', 'https://www.islandlifemexico.com/wp-content/uploads/2022/04/Cozumel-Map.png', 'mx');
INSERT INTO `destination` (`id`, `name`, `description`, `image_url`, `country_country_code`) VALUES (2, 'Nassau', 'New Providence is the most populous island in The Bahamas, containing more than 70% of the total population. On the eastern side of the island is the national capital city of Nassau. Nearly three quarters of The Bahamas\'s population lives in New Providence.', 'https://stuartcove.com/wp-content/uploads/2020/04/divebahamas.jpg', 'bs');
INSERT INTO `destination` (`id`, `name`, `description`, `image_url`, `country_country_code`) VALUES (3, 'Lighthouse Reef', 'Lighthouse Reef is an atoll in the Caribbean Sea, the easternmost part of the Belize Barrier Reef and one of its three atolls, the other two being Turneffe Atoll and Glover\'s Reef.\n\nThe reef is one of the best developed and healthiest reefs in the Caribbean, \"with an emergent fringing reef, a sloping fore reef with a coral rimmed shelf edge, vertical coral walls, and numerous patch reefs in the shallow central lagoon.\"\n\nLighthouse Reef is known as a snorkelling and diving destination, considered one of the best dive sites in Belize and the whole Caribbean. Notable diving locations are Half Moon Caye Wall, Long Caye Aquarium (\"The Aquarium\"), Silver Caves, Tres Cocos, and West Point. In addition to these coral reefs, it is also home to the Great Blue Hole.', 'https://upload.wikimedia.org/wikipedia/commons/6/61/Great_Blue_Hole.jpg', 'bz');
INSERT INTO `destination` (`id`, `name`, `description`, `image_url`, `country_country_code`) VALUES (4, 'Islas de Bahia', 'The Bay Islands (Spanish: Islas de la Bahía) is a group of islands off the Caribbean coast of Honduras. Collectively, the islands form one of the 18 departments of Honduras. The departmental capital is Coxen Hole, on the island of Roatán.\n\nThe Bay Islands serve \"as the major anchor site for Honduras\'s growing tourism industry, accounting for approximately 28% of all tourism arrivals.\"\n\nIslander men frequently join on with the merchant marine or work on international cruise ships for several months of the year. This low-key existence began to change starting in the late 1960s, when tourists discovered the islands’ reefs, beaches, and funky culture.', 'https://upload.wikimedia.org/wikipedia/commons/thumb/b/bd/Guanaja_Honduras.jpg/500px-Guanaja_Honduras.jpg', 'hn');

COMMIT;


-- -----------------------------------------------------
-- Data for table `user`
-- -----------------------------------------------------
START TRANSACTION;
USE `divelogdb`;
INSERT INTO `user` (`id`, `username`, `password`, `enabled`, `role`, `first_name`, `last_name`, `about_me`, `profile_image_url`, `create_date`, `last_update`) VALUES (1, 'admin', 'test', 1, 'ADMIN', 'Site', 'Administrator', NULL, NULL, '2025-05-05', '2025-05-05');
INSERT INTO `user` (`id`, `username`, `password`, `enabled`, `role`, `first_name`, `last_name`, `about_me`, `profile_image_url`, `create_date`, `last_update`) VALUES (2, 'diverdan', 'test', 1, NULL, 'Diver', 'Dan', NULL, NULL, NULL, NULL);
INSERT INTO `user` (`id`, `username`, `password`, `enabled`, `role`, `first_name`, `last_name`, `about_me`, `profile_image_url`, `create_date`, `last_update`) VALUES (3, 'jacques', 'test', 1, NULL, 'Jacques', 'Cousteau', NULL, NULL, NULL, NULL);

COMMIT;


-- -----------------------------------------------------
-- Data for table `dive_site`
-- -----------------------------------------------------
START TRANSACTION;
USE `divelogdb`;
INSERT INTO `dive_site` (`id`, `name`, `description`, `latitude`, `longitude`, `destination_id`, `create_date`, `last_update`, `added_by_id`) VALUES (1, 'Great Blue Hole', 'Deep reef sinkhole', 17.315278, -87.026111, 3, '2025-05-05', '2025-05-05', 1);
INSERT INTO `dive_site` (`id`, `name`, `description`, `latitude`, `longitude`, `destination_id`, `create_date`, `last_update`, `added_by_id`) VALUES (2, 'Palancar Reef', NULL, 20.343889, -87.026111, 1, '2025-05-05', '2025-05-05', 1);
INSERT INTO `dive_site` (`id`, `name`, `description`, `latitude`, `longitude`, `destination_id`, `create_date`, `last_update`, `added_by_id`) VALUES (3, 'Shark Arena', 'Shark cages and bait', 24.958634, -77.527732, 2, '2025-05-05', '2025-05-05', 2);
INSERT INTO `dive_site` (`id`, `name`, `description`, `latitude`, `longitude`, `destination_id`, `create_date`, `last_update`, `added_by_id`) VALUES (4, 'James Bond Wrecks', 'Movie sets from Thunderball', 25.005915, -77.556090, 2, '2025-05-05', '2025-05-05', 2);
INSERT INTO `dive_site` (`id`, `name`, `description`, `latitude`, `longitude`, `destination_id`, `create_date`, `last_update`, `added_by_id`) VALUES (5, 'Palancar Caves', 'Reef wall with swim-throughs', 20.322743, -87.041980, 1, '2025-05-05', '2025-05-05', 2);
INSERT INTO `dive_site` (`id`, `name`, `description`, `latitude`, `longitude`, `destination_id`, `create_date`, `last_update`, `added_by_id`) VALUES (6, 'Palancar Gardens', 'Drift over sandy reef', 20.3323808, -87.024476, 1, '2025-05-05', '2025-05-05', 2);
INSERT INTO `dive_site` (`id`, `name`, `description`, `latitude`, `longitude`, `destination_id`, `create_date`, `last_update`, `added_by_id`) VALUES (7, 'Bayman Bay Drop', 'Deep wall', 16.470808, -85.925476, 4, '2025-05-05', '2025-05-05', 2);
INSERT INTO `dive_site` (`id`, `name`, `description`, `latitude`, `longitude`, `destination_id`, `create_date`, `last_update`, `added_by_id`) VALUES (8, 'Jado Trader', 'Wreck dive', 16.407409, -85.876753, 4, '2025-05-05', '2025-05-05', 2);

COMMIT;


-- -----------------------------------------------------
-- Data for table `dive`
-- -----------------------------------------------------
START TRANSACTION;
USE `divelogdb`;
INSERT INTO `dive` (`id`, `title`, `dive_date`, `time_in`, `time_out`, `decompress_minutes`, `notes`, `maximum_depth_meters`, `weight_kilograms`, `dive_site_id`, `create_date`, `last_update`, `user_id`, `wildlife_seen`) VALUES (1, 'Blue hole', '2001-06-06', '9:35', '10:10', 5, NULL, 32, 8.5, 1, '2025-05-05', '2025-05-05', 2, NULL);
INSERT INTO `dive` (`id`, `title`, `dive_date`, `time_in`, `time_out`, `decompress_minutes`, `notes`, `maximum_depth_meters`, `weight_kilograms`, `dive_site_id`, `create_date`, `last_update`, `user_id`, `wildlife_seen`) VALUES (2, 'Palancar Reef (tank 1)', '2001-07-07', '9:05', '09:45', 10, NULL, 40, 8.0, 2, '2025-05-05', '2025-05-05', 2, NULL);
INSERT INTO `dive` (`id`, `title`, `dive_date`, `time_in`, `time_out`, `decompress_minutes`, `notes`, `maximum_depth_meters`, `weight_kilograms`, `dive_site_id`, `create_date`, `last_update`, `user_id`, `wildlife_seen`) VALUES (3, 'Palancar swim thru', '2001-07-07', '11:40', '12:22', 9, NULL, 28, NULL, 5, '2025-05-05', '2025-05-05', 2, NULL);
INSERT INTO `dive` (`id`, `title`, `dive_date`, `time_in`, `time_out`, `decompress_minutes`, `notes`, `maximum_depth_meters`, `weight_kilograms`, `dive_site_id`, `create_date`, `last_update`, `user_id`, `wildlife_seen`) VALUES (4, 'Shark attack', '2010-08-08', '13:34', '14:15', 5, NULL, 19, NULL, 3, '2025-05-05', '2025-05-05', 2, NULL);
INSERT INTO `dive` (`id`, `title`, `dive_date`, `time_in`, `time_out`, `decompress_minutes`, `notes`, `maximum_depth_meters`, `weight_kilograms`, `dive_site_id`, `create_date`, `last_update`, `user_id`, `wildlife_seen`) VALUES (5, 'Plane wrecks ', '2010-08-09', '9:32', '10:15', 8, NULL, 21, NULL, 4, '2025-05-05', '2025-05-05', 2, NULL);

COMMIT;

