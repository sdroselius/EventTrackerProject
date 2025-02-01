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
  `description` TEXT NULL,
  `create_date` DATETIME NULL,
  `last_update` DATETIME NULL,
  `image_url` VARCHAR(2000) NULL,
  `brand` VARCHAR(45) NULL,
  `base_drink_id` INT NOT NULL,
  `enabled` TINYINT NOT NULL DEFAULT 1,
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
INSERT INTO `base_drink` (`id`, `name`, `brand`, `image_url`, `manufacturer_id`) VALUES (9, 'Orange Fanta', 'Fanta', NULL, 1);
INSERT INTO `base_drink` (`id`, `name`, `brand`, `image_url`, `manufacturer_id`) VALUES (10, 'Ginger Ale', 'Canada Dry', NULL, 3);

COMMIT;


-- -----------------------------------------------------
-- Data for table `dirty_drink`
-- -----------------------------------------------------
START TRANSACTION;
USE `dirtysodadb`;
INSERT INTO `dirty_drink` (`id`, `name`, `description`, `create_date`, `last_update`, `image_url`, `brand`, `base_drink_id`, `enabled`) VALUES (1, 'Espresso Dew', 'I\'m baby slow-carb bodega boys grailed thundercats ascot, gentrify paleo mumblecore blog pour-over meggings hammock gastropub. Quinoa post-ironic roof party fashion axe actually ugh. Meditation bicycle rights meh, health goth pork belly authentic echo park unicorn asymmetrical leggings succulents. Tote bag gentrify aesthetic, kombucha hexagon palo santo hashtag waistcoat biodiesel hoodie butcher tbh vexillologist.', '2025-01-24', '2025-01-24', 'https://www.thediaryofarealhousewife.com/wp-content/uploads/2023/03/Dirty-Soda-straw-720x1080.jpg', NULL, 4, 1);
INSERT INTO `dirty_drink` (`id`, `name`, `description`, `create_date`, `last_update`, `image_url`, `brand`, `base_drink_id`, `enabled`) VALUES (2, 'Founder', 'Lomo next level put a bird on it, gentrify XOXO shoreditch locavore tilde cupping bruh knausgaard. Health goth +1 pour-over kickstarter chartreuse next level quinoa pickled irony mixtape readymade. Freegan banjo readymade drinking vinegar same cronut, intelligentsia scenester hella gentrify. Crucifix kickstarter raclette authentic unicorn etsy dreamcatcher photo booth enamel pin migas locavore solarpunk letterpress williamsburg. Bushwick live-edge succulents, bruh authentic meditation pop-up shoreditch beard. Etsy beard chambray cloud bread fashion axe. Normcore ugh +1, adaptogen umami glossier gastropub health goth swag stumptown pitchfork tilde brunch.', '2025-01-24', '2025-01-24', 'https://i0.wp.com/katerinafaith.com/wp-content/uploads/2024/08/image-3.jpeg?resize=768%2C1024&ssl=1', NULL, 1, 1);
INSERT INTO `dirty_drink` (`id`, `name`, `description`, `create_date`, `last_update`, `image_url`, `brand`, `base_drink_id`, `enabled`) VALUES (3, 'Dreamsicle', 'Tilde DSA cardigan sus tbh. Fingerstache food truck art party aesthetic fanny pack 3 wolf moon cray kale chips hella godard poutine. Brooklyn quinoa vape readymade. Offal blackbird spyplane tacos lomo pork belly. Vaporware lo-fi kickstarter DSA, poutine bitters sus shaman pug selvage before they sold out.', '2025-01-31', '2025-01-31', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTo8qypXDRL8XY8NWBVgRJWl5BzFahXqaqtKQ&s', NULL, 9, 1);
INSERT INTO `dirty_drink` (`id`, `name`, `description`, `create_date`, `last_update`, `image_url`, `brand`, `base_drink_id`, `enabled`) VALUES (4, 'Butterbeer', 'Sustainable DSA squid coloring book hashtag mixtape vaporware flexitarian sriracha JOMO authentic. La croix green juice palo santo, drinking vinegar fam seitan narwhal lumbersexual solarpunk chambray same man braid. Heirloom 3 wolf moon vinyl man braid cliche. Leggings wolf actually, unicorn four dollar toast cronut plaid DSA la croix next level bushwick man braid stumptown kickstarter blog. Bruh food truck banjo, activated charcoal art party hot chicken VHS ugh edison bulb freegan selfies. Messenger bag DIY adaptogen blackbird spyplane. Cupping praxis palo santo keffiyeh, sartorial tacos small batch.', '2025-01-31', '2025-01-31', 'https://wideawakecoffee.com/wp-content/uploads/2023/10/Skinny-Vanilla-Dirty-Soda-Recipe.jpg', NULL, 3, 1);
INSERT INTO `dirty_drink` (`id`, `name`, `description`, `create_date`, `last_update`, `image_url`, `brand`, `base_drink_id`, `enabled`) VALUES (5, 'Malibu Knight', 'Bicycle rights mukbang vinyl, raclette bespoke gorpcore church-key fixie. Lumbersexual photo booth cold-pressed, bushwick lomo DSA organic gentrify wayfarers. Praxis glossier humblebrag disrupt whatever, pop-up neutra beard JOMO VHS fixie PBR&B banh mi. Four loko yr pinterest, swag kinfolk bespoke big mood scenester. Letterpress affogato truffaut farm-to-table mumblecore, vibecession helvetica crucifix big mood YOLO pour-over plaid beard hoodie. Tote bag knausgaard seitan bruh YOLO vexillologist kogi kitsch trust fund DSA copper mug snackwave migas mustache.', '2025-01-31', '2025-01-31', 'https://www.thediaryofarealhousewife.com/wp-content/uploads/2023/03/Dirty-Soda-with-cream-720x1100.jpg', NULL, 2, 1);
INSERT INTO `dirty_drink` (`id`, `name`, `description`, `create_date`, `last_update`, `image_url`, `brand`, `base_drink_id`, `enabled`) VALUES (6, 'Coconut Lime', 'DIY post-ironic hoodie taiyaki pop-up poke. Vape cardigan kickstarter, retro gastropub subway tile squid chambray offal post-ironic af biodiesel tattooed letterpress keytar. Fashion axe fixie seitan disrupt palo santo, squid sartorial 90\'s dreamcatcher hot chicken mustache solarpunk whatever poutine williamsburg. Umami tonx man bun normcore. Hashtag bicycle rights sus, gorpcore ramps thundercats kitsch humblebrag man bun microdosing celiac snackwave vape gatekeep squid.', '2025-01-31', '2025-01-31', 'https://images.squarespace-cdn.com/content/v1/629d16702c679742b7b0f231/77328775-b1a5-49d8-aa39-ee7272941ba1/coconut+soda-wm-6.jpg', NULL, 5, 1);

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
INSERT INTO `add_in` (`id`, `name`, `description`, `image_url`) VALUES (10, 'Coffee Mate butterscotch', NULL, NULL);
INSERT INTO `add_in` (`id`, `name`, `description`, `image_url`) VALUES (11, 'Cinnamon syrup', NULL, NULL);
INSERT INTO `add_in` (`id`, `name`, `description`, `image_url`) VALUES (12, 'Almond syrup', NULL, NULL);
INSERT INTO `add_in` (`id`, `name`, `description`, `image_url`) VALUES (13, 'Half & half', NULL, NULL);

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
INSERT INTO `dirty_drink_add_in` (`dirty_drink_id`, `add_in_id`, `amount`, `amount_unit`) VALUES (3, 8, 1, 'Shot');
INSERT INTO `dirty_drink_add_in` (`dirty_drink_id`, `add_in_id`, `amount`, `amount_unit`) VALUES (4, 8, 1, 'Shot');
INSERT INTO `dirty_drink_add_in` (`dirty_drink_id`, `add_in_id`, `amount`, `amount_unit`) VALUES (4, 10, 1, 'Shot');
INSERT INTO `dirty_drink_add_in` (`dirty_drink_id`, `add_in_id`, `amount`, `amount_unit`) VALUES (5, 2, 1, 'Shot');
INSERT INTO `dirty_drink_add_in` (`dirty_drink_id`, `add_in_id`, `amount`, `amount_unit`) VALUES (5, 13, 1, 'Shot');

COMMIT;

