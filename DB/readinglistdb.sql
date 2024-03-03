-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema readinglistdb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `readinglistdb` ;

-- -----------------------------------------------------
-- Schema readinglistdb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `readinglistdb` DEFAULT CHARACTER SET utf8 ;
USE `readinglistdb` ;

-- -----------------------------------------------------
-- Table `author`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `author` ;

CREATE TABLE IF NOT EXISTS `author` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `full_name` VARCHAR(80) NOT NULL,
  `image_url` VARCHAR(2000) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `book`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `book` ;

CREATE TABLE IF NOT EXISTS `book` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(120) NOT NULL,
  `description` TEXT NULL DEFAULT NULL,
  `cover_image_url` TEXT NULL DEFAULT NULL,
  `pages` INT(11) NULL DEFAULT NULL,
  `last_finished` DATE NULL DEFAULT NULL,
  `enabled` TINYINT(4) NOT NULL,
  `create_date` DATETIME NULL DEFAULT NULL,
  `last_update` DATETIME NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `book_author`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `book_author` ;

CREATE TABLE IF NOT EXISTS `book_author` (
  `book_id` INT(11) NOT NULL,
  `author_id` INT(11) NOT NULL,
  PRIMARY KEY (`book_id`, `author_id`),
  INDEX `fk_book_has_author_author1_idx` (`author_id` ASC),
  INDEX `fk_book_has_author_book_idx` (`book_id` ASC),
  CONSTRAINT `fk_book_has_author_book`
    FOREIGN KEY (`book_id`)
    REFERENCES `book` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_book_has_author_author1`
    FOREIGN KEY (`author_id`)
    REFERENCES `author` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

SET SQL_MODE = '';
DROP USER IF EXISTS booknerd@localhost;
SET SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
CREATE USER 'booknerd'@'localhost' IDENTIFIED BY 'booknerd';

GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE * TO 'booknerd'@'localhost';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `author`
-- -----------------------------------------------------
START TRANSACTION;
USE `readinglistdb`;
INSERT INTO `author` (`id`, `full_name`, `image_url`) VALUES (1, '- Author Unknown -', NULL);
INSERT INTO `author` (`id`, `full_name`, `image_url`) VALUES (2, 'Herman Melville', 'https://upload.wikimedia.org/wikipedia/commons/1/1d/Herman_Melville_1860.jpg');
INSERT INTO `author` (`id`, `full_name`, `image_url`) VALUES (3, 'Douglas R. Hofstater', 'https://upload.wikimedia.org/wikipedia/commons/thumb/2/24/Hofstadter2002.jpg/398px-Hofstadter2002.jpg');
INSERT INTO `author` (`id`, `full_name`, `image_url`) VALUES (4, 'Patrick O\'Brian', 'https://upload.wikimedia.org/wikipedia/commons/thumb/2/27/Patrick45.jpg/440px-Patrick45.jpg');
INSERT INTO `author` (`id`, `full_name`, `image_url`) VALUES (5, 'John LeCarre', 'https://upload.wikimedia.org/wikipedia/commons/thumb/8/8e/John_le_Carre.jpg/440px-John_le_Carre.jpg');

COMMIT;


-- -----------------------------------------------------
-- Data for table `book`
-- -----------------------------------------------------
START TRANSACTION;
USE `readinglistdb`;
INSERT INTO `book` (`id`, `title`, `description`, `cover_image_url`, `pages`, `last_finished`, `enabled`, `create_date`, `last_update`) VALUES (1, 'Moby Dick', 'The sailor Ishmael\'s narrative of the maniacal quest of Ahab, captain of the whaling ship Pequod, for vengeance against Moby Dick, the giant white sperm whale that bit off his leg on the ship\'s previous voyage. A contribution to the literature of the American Renaissance, Moby-Dick was published to mixed reviews, was a commercial failure, and was out of print at the time of the author\'s death in 1891. Its reputation as a Great American Novel was established only in the 20th century, after the 1919 centennial of its author\'s birth. William Faulkner said he wished he had written the book himself, and D. H. Lawrence called it \"one of the strangest and most wonderful books in the world\" and \"the greatest book of the sea ever written\". Its opening sentence, \"Call me Ishmael\", is among world literature\'s most famous.', 'https://upload.wikimedia.org/wikipedia/commons/3/36/Moby-Dick_FE_title_page.jpg', 635, NULL, 1, '2024-01-05 00:00:00', '2024-01-05 00:00:00');
INSERT INTO `book` (`id`, `title`, `description`, `cover_image_url`, `pages`, `last_finished`, `enabled`, `create_date`, `last_update`) VALUES (2, 'Godel, Escher, Bach: an Eternal Golden Braid', 'By exploring common themes in the lives and works of logician Kurt Gödel, artist M. C. Escher, and composer Johann Sebastian Bach, the book expounds concepts fundamental to mathematics, symmetry, and intelligence. Through short stories, illustrations, and analysis, the book discusses how systems can acquire meaningful context despite being made of \"meaningless\" elements. It also discusses self-reference and formal rules, isomorphism, what it means to communicate, how knowledge can be represented and stored, the methods and limitations of symbolic representation, and even the fundamental notion of \"meaning\" itself.', 'https://upload.wikimedia.org/wikipedia/en/8/8b/Godel%2C_Escher%2C_Bach_%28first_edition%29.jpg', 777, NULL, 1, '2024-01-05 00:00:00', '2024-01-05 00:00:00');
INSERT INTO `book` (`id`, `title`, `description`, `cover_image_url`, `pages`, `last_finished`, `enabled`, `create_date`, `last_update`) VALUES (3, 'Metamagical Themas', 'An eclectic collection of articles that Douglas Hofstadter wrote for the popular science magazine Scientific American during the early 1980s. The anthology was published in 1985 by Basic Books.\n\nThe volume is substantial in size and contains extensive notes concerning responses to the articles and other information relevant to their content. (One of the notes—page 65—suggested memetics for the study of memes.)\n\nMajor themes include: self-reference in memes, language, art and logic; discussions of philosophical issues important in cognitive science/AI; analogies and what makes something similar to something else (specifically what makes, for example, an uppercase letter \'A\' recognizable as such); and lengthy discussions of the work of Robert Axelrod on the prisoner\'s dilemma, as well as the idea of superrationality.\n\nThe concept of superrationality, and its relevance to the Cold War, environmental issues and such, is accompanied by notes on experiments conducted by the author at the time. Another notable feature is the inclusion of two dialogues in the style of those appearing in Gödel, Escher, Bach. Ambigrams are mentioned.\n\nThere are three articles centered on the Lisp programming language, in which Hofstadter first details the language itself, and then shows how it relates to Gödel\'s incompleteness theorem. Two articles are devoted to Rubik\'s Cube and similar puzzles. Many chapters open with an illustration of an extremely abstract alphabet, yet one which is still gestaltly recognizable as such.\n\nThe game of Nomic was first introduced to the public in this column, in June 1982, when excerpts from a book (still unpublished at the time) by the game\'s creator Peter Suber were printed and discussed.\n\n', 'https://upload.wikimedia.org/wikipedia/en/7/7a/Metamagical_Themas.jpg', 852, NULL, 1, '2024-01-05 00:00:00', '2024-01-05 00:00:00');
INSERT INTO `book` (`id`, `title`, `description`, `cover_image_url`, `pages`, `last_finished`, `enabled`, `create_date`, `last_update`) VALUES (4, 'The Unknown Shore', 'It is the story of two friends, Jack Byron and Tobias Barrow, who sail aboard HMS Wager as part of the voyage around the world led by Anson in 1740. Their ship did not make it all the way around the world, unlike the flagship. The novel is a fictionalised version of actual events which occurred during the Wager Mutiny.', 'https://upload.wikimedia.org/wikipedia/en/f/ff/PatrickOBrian_TheUknownShore.jpg', 320, NULL, 1, '2024-01-05 00:00:00', '2024-01-05 00:00:00');
INSERT INTO `book` (`id`, `title`, `description`, `cover_image_url`, `pages`, `last_finished`, `enabled`, `create_date`, `last_update`) VALUES (5, 'Tinker Tailor Soldier Spy', 'It follows the endeavours of taciturn, aging spymaster George Smiley to uncover a Soviet mole in the British Secret Intelligence Service. The novel has received critical acclaim for its complex social commentary—and, at the time, relevance, following the defection of Kim Philby. It has been adapted into both a television series and a film, and remains a staple of the spy fiction genre.', 'https://upload.wikimedia.org/wikipedia/en/1/13/JohnLeCarre_TinkerTailorSoldierSpy.jpg', 355, NULL, 1, '2024-01-05 00:00:00', '2024-01-05 00:00:00');

COMMIT;


-- -----------------------------------------------------
-- Data for table `book_author`
-- -----------------------------------------------------
START TRANSACTION;
USE `readinglistdb`;
INSERT INTO `book_author` (`book_id`, `author_id`) VALUES (1, 2);
INSERT INTO `book_author` (`book_id`, `author_id`) VALUES (2, 3);
INSERT INTO `book_author` (`book_id`, `author_id`) VALUES (3, 3);
INSERT INTO `book_author` (`book_id`, `author_id`) VALUES (4, 4);
INSERT INTO `book_author` (`book_id`, `author_id`) VALUES (5, 5);

COMMIT;

