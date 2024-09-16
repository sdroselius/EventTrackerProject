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
-- Table `user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `user` ;

CREATE TABLE IF NOT EXISTS `user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(45) NULL,
  `password` VARCHAR(100) NULL,
  `enabled` TINYINT NULL,
  `role` VARCHAR(45) NULL,
  `first_name` VARCHAR(45) NULL,
  `last_name` VARCHAR(45) NULL,
  `about_me` TEXT NULL,
  `profile_image_url` VARCHAR(2000) NULL,
  `create_date` DATETIME NULL,
  `last_update` DATETIME NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `formation_type`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `formation_type` ;

CREATE TABLE IF NOT EXISTS `formation_type` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `description` TEXT NULL,
  `image_url` VARCHAR(2000) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


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
  `description` TEXT NULL,
  `enabled` TINYINT NULL DEFAULT 1,
  `primary_entrance_latitude` DOUBLE NULL,
  `primary_entrance_longitude` DOUBLE NULL,
  `added_by_id` INT NOT NULL,
  `formation_type_id` INT NOT NULL,
  `explored_length_km` DOUBLE NULL,
  `open_to_public` TINYINT NULL,
  `entrance_authority` VARCHAR(100) NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_cave_user_idx` (`added_by_id` ASC) VISIBLE,
  INDEX `fk_cave_formation_type1_idx` (`formation_type_id` ASC) VISIBLE,
  CONSTRAINT `fk_cave_user`
    FOREIGN KEY (`added_by_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_cave_formation_type1`
    FOREIGN KEY (`formation_type_id`)
    REFERENCES `formation_type` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cave_visit`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cave_visit` ;

CREATE TABLE IF NOT EXISTS `cave_visit` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `cave_id` INT NOT NULL,
  `user_id` INT NOT NULL,
  `title` VARCHAR(45) NULL,
  `date_in` DATE NULL,
  `time_in` TIME NULL,
  `date_out` VARCHAR(45) NULL,
  `time_out` VARCHAR(45) NULL,
  `vertical_depth_reached_meters` DOUBLE NULL,
  `vertical_depth_on_rope_meters` DOUBLE NULL,
  `notes` TEXT NULL,
  `create_date` DATETIME NULL,
  `last_update` DATETIME NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_cave_visit_cave1_idx` (`cave_id` ASC) VISIBLE,
  INDEX `fk_cave_visit_user1_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `fk_cave_visit_cave1`
    FOREIGN KEY (`cave_id`)
    REFERENCES `cave` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_cave_visit_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `trip_members`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `trip_members` ;

CREATE TABLE IF NOT EXISTS `trip_members` (
  `user_id` INT NOT NULL,
  `cave_visit_id` INT NOT NULL,
  PRIMARY KEY (`user_id`, `cave_visit_id`),
  INDEX `fk_user_has_cave_visit_cave_visit1_idx` (`cave_visit_id` ASC) VISIBLE,
  INDEX `fk_user_has_cave_visit_user1_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `fk_user_has_cave_visit_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_has_cave_visit_cave_visit1`
    FOREIGN KEY (`cave_visit_id`)
    REFERENCES `cave_visit` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
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
-- Data for table `user`
-- -----------------------------------------------------
START TRANSACTION;
USE `cavesdb`;
INSERT INTO `user` (`id`, `username`, `password`, `enabled`, `role`, `first_name`, `last_name`, `about_me`, `profile_image_url`, `create_date`, `last_update`) VALUES (1, 'admin', 'test', 1, NULL, 'Big', 'Boss', NULL, NULL, '2024-01-01', '2024-01-01');
INSERT INTO `user` (`id`, `username`, `password`, `enabled`, `role`, `first_name`, `last_name`, `about_me`, `profile_image_url`, `create_date`, `last_update`) VALUES (2, 'pitplunger', 'test', 1, NULL, 'Pete', 'Petromorph', NULL, NULL, '2024-06-06', '2024-06-06');

COMMIT;


-- -----------------------------------------------------
-- Data for table `formation_type`
-- -----------------------------------------------------
START TRANSACTION;
USE `cavesdb`;
INSERT INTO `formation_type` (`id`, `name`, `description`, `image_url`) VALUES (1, 'Karst', NULL, NULL);
INSERT INTO `formation_type` (`id`, `name`, `description`, `image_url`) VALUES (2, 'Lava Tube', NULL, NULL);
INSERT INTO `formation_type` (`id`, `name`, `description`, `image_url`) VALUES (3, 'Sea Cave', NULL, NULL);

COMMIT;


-- -----------------------------------------------------
-- Data for table `cave`
-- -----------------------------------------------------
START TRANSACTION;
USE `cavesdb`;
INSERT INTO `cave` (`id`, `name`, `create_date`, `last_update`, `image_url`, `description`, `enabled`, `primary_entrance_latitude`, `primary_entrance_longitude`, `added_by_id`, `formation_type_id`, `explored_length_km`, `open_to_public`, `entrance_authority`) VALUES (1, 'Mammoth Cave', '2024-09-06', '2024-09-06', 'https://www.nps.gov/common/uploads/cropped_image/primary/548B411E-AFC0-A309-265E19C32D8FD499.jpg?width=1600&quality=90&mode=crop', 'Mammoth Cave is the longest known cave system in the world, with over 405 miles (651 km) mapped. The cave system was formed by water dissolving carbonate rocks, creating sinkholes, tunnels, and underground rivers.', 1, 37.18758, -86.10357, 2, 1, 685.6, 1, 'National Park Service');
INSERT INTO `cave` (`id`, `name`, `create_date`, `last_update`, `image_url`, `description`, `enabled`, `primary_entrance_latitude`, `primary_entrance_longitude`, `added_by_id`, `formation_type_id`, `explored_length_km`, `open_to_public`, `entrance_authority`) VALUES (2, 'No such cave', NULL, NULL, NULL, NULL, 0, NULL, NULL, 1, 3, NULL, NULL, NULL);
INSERT INTO `cave` (`id`, `name`, `create_date`, `last_update`, `image_url`, `description`, `enabled`, `primary_entrance_latitude`, `primary_entrance_longitude`, `added_by_id`, `formation_type_id`, `explored_length_km`, `open_to_public`, `entrance_authority`) VALUES (3, 'Carlsbad Caverns', '2024-09-06', '2024-09-26', 'https://www.aarp.org/content/dam/aarp/travel/national-parks/2022/12/1140-carlsbad-caverns-entrance-path.jpg', 'The Natural Entrance is a path into the namesake Carlsbad Cavern. Stalactites cling to the roof of the Big Room, a huge underground chamber in the cavern.', 1, 32.1906420, -104.5033091, 2, 1, 63.5, 1, 'National Park Service');
INSERT INTO `cave` (`id`, `name`, `create_date`, `last_update`, `image_url`, `description`, `enabled`, `primary_entrance_latitude`, `primary_entrance_longitude`, `added_by_id`, `formation_type_id`, `explored_length_km`, `open_to_public`, `entrance_authority`) VALUES (4, 'Cave of the Winds', '2024-09-13', '2024-09-13', 'https://caveofthewinds.com/wp-content/uploads/2019/07/Cave-Hero-1.jpg', 'Cave of the Winds is a cave in the Pikes Peak region of Colorado. It is located just west of Colorado Springs on U.S. Highway 24, near the Manitou Cliff Dwellings. Tours of the complex of caves are given daily.', 1, 38.87274, -104.92071, 2, 1, 3.281172, 1, 'Cave of the Winds Mountain Park');
INSERT INTO `cave` (`id`, `name`, `create_date`, `last_update`, `image_url`, `description`, `enabled`, `primary_entrance_latitude`, `primary_entrance_longitude`, `added_by_id`, `formation_type_id`, `explored_length_km`, `open_to_public`, `entrance_authority`) VALUES (5, 'Groaning Cave', '2024-09-13', '2024-09-13', 'https://townsquare.media/site/507/files/2022/11/attachment-derek-bristol-youtube-5.jpg?w=780&q=75', 'The Groaning Cave is the longest cave in Colorado with nearly 15 miles of tunnels and is located in the White River National Forest in Garfield County.', 1, NULL, NULL, 2, 1, NULL, 0, 'White River National Forest');

COMMIT;


-- -----------------------------------------------------
-- Data for table `cave_visit`
-- -----------------------------------------------------
START TRANSACTION;
USE `cavesdb`;
INSERT INTO `cave_visit` (`id`, `cave_id`, `user_id`, `title`, `date_in`, `time_in`, `date_out`, `time_out`, `vertical_depth_reached_meters`, `vertical_depth_on_rope_meters`, `notes`, `create_date`, `last_update`) VALUES (1, 3, 2, 'Carlsbad vacation', '2020-02-02', '12:00', '2020-02-02', '16:00:00', 100, 0, 'BATS!!', NULL, NULL);

COMMIT;


-- -----------------------------------------------------
-- Data for table `trip_members`
-- -----------------------------------------------------
START TRANSACTION;
USE `cavesdb`;
INSERT INTO `trip_members` (`user_id`, `cave_visit_id`) VALUES (2, 1);

COMMIT;

