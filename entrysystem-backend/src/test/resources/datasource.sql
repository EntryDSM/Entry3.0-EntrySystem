-- MySQL Script generated by MySQL Workbench
-- Sun Aug  5 02:29:31 2018
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema entry
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema entry
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `entry` DEFAULT CHARACTER SET utf8 ;
USE `entry` ;

-- -----------------------------------------------------
-- Table `entry`.`admin`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `entry`.`admin` (
  `admin_id` VARCHAR(32) NOT NULL,
  `name` VARCHAR(20) NOT NULL,
  `admin_type` ENUM('ROOT', 'ADMINISTRATION', 'QNA', 'INTERVIEW') NOT NULL DEFAULT 'INTERVIEW',
  `email` VARCHAR(50) CHARACTER SET 'utf8' COLLATE 'utf8_bin' NULL DEFAULT NULL,
  `password` VARCHAR(200) CHARACTER SET 'utf8' COLLATE 'utf8_bin' NULL DEFAULT NULL,
  PRIMARY KEY (`admin_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_bin;


-- -----------------------------------------------------
-- Table `entry`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `entry`.`user` (
  `user_id` VARCHAR(32) CHARACTER SET 'utf8' COLLATE 'utf8_bin' NOT NULL,
  `created_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `email` VARCHAR(50) CHARACTER SET 'utf8' COLLATE 'utf8_bin' NOT NULL,
  `password` VARCHAR(100) CHARACTER SET 'utf8' COLLATE 'utf8_bin' NOT NULL,
  `graduate_type` ENUM('WILL', 'DONE', 'GED') NOT NULL DEFAULT 'WILL',
  PRIMARY KEY (`user_id`),
  UNIQUE INDEX `UK_user_email` (`email` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_bin;


-- -----------------------------------------------------
-- Table `entry`.`ged_grade`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `entry`.`ged_grade` (
  `user_id` VARCHAR(32) CHARACTER SET 'utf8' COLLATE 'utf8_bin' NOT NULL,
  `grade` DOUBLE NOT NULL,
  `conversion_score` DOUBLE UNSIGNED NOT NULL DEFAULT 0.0,
  `attendance_score` INT(10) UNSIGNED NOT NULL DEFAULT 15,
  `volunteer_score` DOUBLE UNSIGNED NOT NULL DEFAULT 0.0,
  `final_score` DOUBLE UNSIGNED NOT NULL DEFAULT 0.0,
  PRIMARY KEY (`user_id`),
  CONSTRAINT `FK_ged_grade_user_id`
    FOREIGN KEY (`user_id`)
    REFERENCES `entry`.`user` (`user_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_bin;


-- -----------------------------------------------------
-- Table `entry`.`grade_info`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `entry`.`grade_info` (
  `user_id` VARCHAR(32) CHARACTER SET 'utf8' COLLATE 'utf8_bin' NOT NULL,
  `is_pass` TINYINT(1) NOT NULL DEFAULT '1',
  `score` ENUM('A', 'B', 'C', 'D', 'E', 'F') NULL DEFAULT NULL,
  `semester` INT(10) NOT NULL,
  `subject` ENUM('KOREAN', 'MATHEMATICS', 'SOCIAL', 'HISTORY', 'SCIENCE', 'TECH', 'ENGLISH') CHARACTER SET 'utf8' COLLATE 'utf8_bin' NOT NULL,
  PRIMARY KEY (`user_id`, `semester`, `subject`),
  CONSTRAINT `FK_grade_info_user_id`
    FOREIGN KEY (`user_id`)
    REFERENCES `entry`.`user` (`user_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_bin;


-- -----------------------------------------------------
-- Table `entry`.`graduate_grade`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `entry`.`graduate_grade` (
  `user_id` VARCHAR(32) CHARACTER SET 'utf8' COLLATE 'utf8_bin' NOT NULL,
  `first_grade` DOUBLE UNSIGNED NOT NULL DEFAULT 0.0,
  `second_grade` DOUBLE UNSIGNED NOT NULL DEFAULT 0.0,
  `third_grade` DOUBLE UNSIGNED NOT NULL DEFAULT 0.0,
  `conversion_score` DOUBLE UNSIGNED NOT NULL DEFAULT 0.0,
  `attendance_score` INT(10) UNSIGNED NOT NULL DEFAULT 0,
  `volunteer_score` DOUBLE UNSIGNED NOT NULL DEFAULT 0.0,
  `final_score` DOUBLE UNSIGNED NOT NULL DEFAULT 0.0,
  `volunteer_time` INT(10) UNSIGNED NOT NULL DEFAULT 0,
  `period_cut` INT(10) UNSIGNED NOT NULL DEFAULT 0,
  `full_cut` INT(10) UNSIGNED NOT NULL DEFAULT 0,
  `late` INT(10) UNSIGNED NOT NULL DEFAULT 0,
  `early_leave` INT(10) UNSIGNED NOT NULL DEFAULT 0,
  PRIMARY KEY (`user_id`),
  INDEX `FK_graduate_grade_user_id_idx` (`user_id` ASC),
  CONSTRAINT `FK_graduate_grade_user_id`
    FOREIGN KEY (`user_id`)
    REFERENCES `entry`.`user` (`user_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_bin;


-- -----------------------------------------------------
-- Table `entry`.`school`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `entry`.`school` (
  `code` VARCHAR(10) CHARACTER SET 'utf8' COLLATE 'utf8_bin' NOT NULL,
  `goverment` VARCHAR(20) CHARACTER SET 'utf8' COLLATE 'utf8_bin' NULL DEFAULT NULL,
  `name` VARCHAR(20) CHARACTER SET 'utf8' COLLATE 'utf8_bin' NULL DEFAULT NULL,
  `school_region` VARCHAR(20) CHARACTER SET 'utf8' COLLATE 'utf8_bin' NULL DEFAULT NULL,
  PRIMARY KEY (`code`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_bin;


-- -----------------------------------------------------
-- Table `entry`.`graduate_info`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `entry`.`graduate_info` (
  `user_id` VARCHAR(32) CHARACTER SET 'utf8' COLLATE 'utf8_bin' NOT NULL,
  `graduate_year` INT(10) UNSIGNED NOT NULL DEFAULT 2019,
  `school_code` VARCHAR(32) NOT NULL DEFAULT '',
  `school_name` VARCHAR(50) NOT NULL DEFAULT '',
  `student_number` VARCHAR(5) NOT NULL DEFAULT '',
  PRIMARY KEY (`user_id`),
  CONSTRAINT `FK_graduate_info_user_id`
    FOREIGN KEY (`user_id`)
    REFERENCES `entry`.`user` (`user_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `FK_graduate_info_school_code`
    FOREIGN KEY ()
    REFERENCES `entry`.`school` ()
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_bin;


-- -----------------------------------------------------
-- Table `entry`.`info`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `entry`.`info` (
  `user_id` VARCHAR(32) CHARACTER SET 'utf8' COLLATE 'utf8_bin' NOT NULL,
  `address_base` VARCHAR(100) NOT NULL DEFAULT '',
  `address_detail` VARCHAR(50) NOT NULL DEFAULT '',
  `admission` ENUM('NORMAL', 'MEISTER', 'SOCIAL') NOT NULL DEFAULT 'NORMAL',
  `admission_detail` ENUM('DEFAULT', 'BENEFICIARY', 'ONE_PARENT', 'CHA_UPPER', 'CHACHA_UPPER', 'FROM_NORTH', 'MULTI_CULTURE', ' NATIONAL_MERIT', 'SPECIAL_ADMISSION', 'ETC') NOT NULL DEFAULT 'DEFAULT',
  `created_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `exam_code` VARCHAR(6) CHARACTER SET 'utf8' COLLATE 'utf8_bin' NULL DEFAULT NULL,
  `img_path` VARCHAR(50) CHARACTER SET 'utf8' COLLATE 'utf8_bin' NULL DEFAULT NULL,
  `introduce` VARCHAR(1600) NOT NULL DEFAULT '',
  `my_tel` VARCHAR(15) NOT NULL DEFAULT '',
  `name` VARCHAR(20) NOT NULL DEFAULT '',
  `parent_name` VARCHAR(20) NOT NULL DEFAULT '',
  `parent_tel` VARCHAR(15) NOT NULL DEFAULT '',
  `region` TINYINT(1) NOT NULL DEFAULT '0',
  `sex` ENUM('FEMALE', 'MALE') NULL DEFAULT NULL,
  `study_plan` VARCHAR(1600) NOT NULL DEFAULT '',
  `updated_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `receipt_code` INT(3) NOT NULL AUTO_INCREMENT,
  `birth` DATETIME NOT NULL,
  UNIQUE INDEX `UK_info_exam_code` (`exam_code` ASC),
  PRIMARY KEY (`user_id`),
  UNIQUE INDEX `img_path_UNIQUE` (`img_path` ASC),
  UNIQUE INDEX `receipt_code_UNIQUE` (`receipt_code` ASC),
  CONSTRAINT `FK_info_user_id`
    FOREIGN KEY (`user_id`)
    REFERENCES `entry`.`user` (`user_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_bin;


-- -----------------------------------------------------
-- Table `entry`.`question`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `entry`.`question` (
  `question_id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `question_type` ENUM('APTITUDE', 'DEPTH', 'CODING') CHARACTER SET 'utf8' COLLATE 'utf8_bin' NOT NULL DEFAULT 'APTITUDE',
  `body` VARCHAR(1023) CHARACTER SET 'utf8' COLLATE 'utf8_bin' NULL DEFAULT NULL,
  `form` JSON NULL DEFAULT NULL,
  `title` VARCHAR(60) CHARACTER SET 'utf8' COLLATE 'utf8_bin' NULL DEFAULT NULL,
  PRIMARY KEY (`question_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_bin;


-- -----------------------------------------------------
-- Table `entry`.`interview_data`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `entry`.`interview_data` (
  `comment` VARCHAR(255) CHARACTER SET 'utf8' COLLATE 'utf8_bin' NULL DEFAULT NULL,
  `interview_score` INT(10) UNSIGNED NOT NULL,
  `interview_result` JSON NULL DEFAULT NULL,
  `take_interview` TINYINT(1) NULL DEFAULT '1',
  `admin_id` VARCHAR(32) NOT NULL,
  `question_id` INT(10) UNSIGNED NOT NULL,
  `user_id` VARCHAR(32) CHARACTER SET 'utf8' COLLATE 'utf8_bin' NOT NULL,
  INDEX `FK_interview_data_admin_id` (`admin_id` ASC),
  INDEX `FK_interview_data_question_id` (`question_id` ASC),
  INDEX `FK_interview_data_user_id_idx` (`user_id` ASC),
  PRIMARY KEY (`admin_id`, `user_id`, `question_id`),
  CONSTRAINT `FK_interview_data_question_id`
    FOREIGN KEY (`question_id`)
    REFERENCES `entry`.`question` (`question_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `FK_interview_data_admin_id`
    FOREIGN KEY (`admin_id`)
    REFERENCES `entry`.`admin` (`admin_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `FK_interview_data_user_id`
    FOREIGN KEY (`user_id`)
    REFERENCES `entry`.`user` (`user_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_bin;


-- -----------------------------------------------------
-- Table `entry`.`interview_final`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `entry`.`interview_final` (
  `final_score` INT(10) UNSIGNED NULL DEFAULT NULL,
  `user_id` VARCHAR(32) CHARACTER SET 'utf8' COLLATE 'utf8_bin' NOT NULL,
  INDEX `FK_interview_final_user_id_idx` (`user_id` ASC),
  PRIMARY KEY (`user_id`),
  CONSTRAINT `FK_interview_final_user_id`
    FOREIGN KEY (`user_id`)
    REFERENCES `entry`.`user` (`user_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_bin;


-- -----------------------------------------------------
-- Table `entry`.`temp_user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `entry`.`temp_user` (
  `email` VARCHAR(50) CHARACTER SET 'utf8' COLLATE 'utf8_bin' NOT NULL,
  `code` VARCHAR(32) CHARACTER SET 'utf8' COLLATE 'utf8_bin' NOT NULL,
  `password` VARCHAR(50) CHARACTER SET 'utf8' COLLATE 'utf8_bin' NOT NULL,
  PRIMARY KEY (`email`),
  UNIQUE INDEX `UK_user_code` (`code` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_bin;


-- -----------------------------------------------------
-- Table `entry`.`apply_status`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `entry`.`apply_status` (
  `user_id` VARCHAR(32) CHARACTER SET 'utf8' COLLATE 'utf8_bin' NOT NULL,
  `final_submit` TINYINT(1) NOT NULL DEFAULT 0,
  `pass_status` TINYINT(1) NOT NULL DEFAULT 0,
  `payment` TINYINT(1) NOT NULL DEFAULT 0,
  `receipt` TINYINT(1) NOT NULL DEFAULT 0,
  PRIMARY KEY (`user_id`),
  CONSTRAINT `FK_apply_status_user_id`
    FOREIGN KEY (`user_id`)
    REFERENCES `entry`.`user` (`user_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_bin;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;