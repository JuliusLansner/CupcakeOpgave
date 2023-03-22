-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `startcode` DEFAULT CHARACTER SET utf8mb3 ;
USE `startcode` ;

-- -----------------------------------------------------
-- Table `mydb`.`bund`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `startcode`.`bund` (
  `navn` VARCHAR(45) NOT NULL,
  `pris` INT NOT NULL,
  PRIMARY KEY (`navn`),
  UNIQUE INDEX `navn_UNIQUE` (`navn` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `mydb`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `startcode`.`user` (
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `role` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`username`),
  UNIQUE INDEX `username_UNIQUE` (`username` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `mydb`.`ordre`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `startcode`.`ordre` (
  `idordre` INT NOT NULL AUTO_INCREMENT,
  `user` VARCHAR(45) NOT NULL,
  `dato` TIMESTAMP NOT NULL,
  PRIMARY KEY (`idordre`),
  UNIQUE INDEX `idordre_UNIQUE` (`idordre` ASC) VISIBLE,
  INDEX `fk_ordre_user1_idx` (`user` ASC) VISIBLE,
  CONSTRAINT `fk_ordre_user1`
    FOREIGN KEY (`user`)
    REFERENCES `mydb`.`user` (`username`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `mydb`.`topping`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `startcode`.`topping` (
  `navn` VARCHAR(45) NOT NULL,
  `pris` INT NOT NULL,
  PRIMARY KEY (`navn`),
  UNIQUE INDEX `navn_UNIQUE` (`navn` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `mydb`.`produkt`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `startcode`.`produkt` (
  `idprodukt` INT NOT NULL AUTO_INCREMENT,
  `topping` VARCHAR(45) NOT NULL,
  `bund` VARCHAR(45) NOT NULL,
  `pris` INT NOT NULL,
  `ordreid` INT NOT NULL,
  PRIMARY KEY (`idprodukt`),
  UNIQUE INDEX `idprodukt_UNIQUE` (`idprodukt` ASC) VISIBLE,
  INDEX `fk_produkt_topping_idx` (`topping` ASC) VISIBLE,
  INDEX `fk_produkt_bund1_idx` (`bund` ASC) VISIBLE,
  INDEX `fk_produkt_ordre1_idx` (`ordreid` ASC) VISIBLE,
  CONSTRAINT `fk_produkt_bund1`
    FOREIGN KEY (`bund`)
    REFERENCES `mydb`.`bund` (`navn`),
  CONSTRAINT `fk_produkt_ordre1`
    FOREIGN KEY (`ordreid`)
    REFERENCES `mydb`.`ordre` (`idordre`),
  CONSTRAINT `fk_produkt_topping`
    FOREIGN KEY (`topping`)
    REFERENCES `mydb`.`topping` (`navn`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
