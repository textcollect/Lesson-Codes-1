-- MySQL Script generated by MySQL Workbench
-- Wed Apr 26 11:19:51 2023
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema courseservice2
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `courseservice2` ;

-- -----------------------------------------------------
-- Schema courseservice2
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `courseservice2` DEFAULT CHARACTER SET utf8 ;
USE `courseservice2` ;

-- -----------------------------------------------------
-- Table `courseservice2`.`Country`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `courseservice2`.`Country` (
  `idCountry` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `countryCode` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idCountry`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `courseservice2`.`Student`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `courseservice2`.`Student` (
  `idStudent` INT NOT NULL,
  `firstName` VARCHAR(45) NOT NULL,
  `lastName` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `address` VARCHAR(45) NOT NULL,
  `birthDate` DATETIME NOT NULL,
  `nationality` INT NOT NULL,
  PRIMARY KEY (`idStudent`),
  INDEX `nationality_idx` (`nationality` ASC) VISIBLE,
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE,
  CONSTRAINT `nationality`
    FOREIGN KEY (`nationality`)
    REFERENCES `courseservice2`.`Country` (`idCountry`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `courseservice2`.`Course`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `courseservice2`.`Course` (
  `idCourseCode` VARCHAR(20) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `credit` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`idCourseCode`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `courseservice2`.`Course_Student`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `courseservice2`.`Course_Student` (
  `idStudent` INT NOT NULL,
  `idCourseCode` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`idStudent`, `idCourseCode`),
  INDEX `fk_Course_Student_Course1_idx` (`idCourseCode` ASC) VISIBLE,
  CONSTRAINT `fk_Course_Student_idStudent`
    FOREIGN KEY (`idStudent`)
    REFERENCES `courseservice2`.`Student` (`idStudent`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Course_Student_Course1`
    FOREIGN KEY (`idCourseCode`)
    REFERENCES `courseservice2`.`Course` (`idCourseCode`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `courseservice2`.`Module`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `courseservice2`.`Module` (
  `idModuleCode` VARCHAR(20) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `idCourseCode` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`idModuleCode`, `idCourseCode`),
  INDEX `fk_moduleCode_idx` (`idCourseCode` ASC) VISIBLE,
  CONSTRAINT `fk_courseCode`
    FOREIGN KEY (`idCourseCode`)
    REFERENCES `courseservice2`.`Course` (`idCourseCode`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
