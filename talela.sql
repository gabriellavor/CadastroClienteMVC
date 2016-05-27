SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema cadastro_clientes
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `cadastro_clientes` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `cadastro_clientes` ;

-- -----------------------------------------------------
-- Table `cadastro_clientes`.`clientes`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cadastro_clientes`.`clientes` ;

CREATE TABLE IF NOT EXISTS `cadastro_clientes`.`clientes` (
  `codigo` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `sexo` VARCHAR(1) NOT NULL,
  `soube_nos` VARCHAR(45) NOT NULL,
  `receber_notificacao` VARCHAR(1) NULL,
  PRIMARY KEY (`codigo`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
