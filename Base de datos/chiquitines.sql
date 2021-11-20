-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema chiquitines
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema chiquitines
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `chiquitines` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `chiquitines` ;

-- -----------------------------------------------------
-- Table `chiquitines`.`contactenos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `chiquitines`.`contactenos` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombres_apellidos` VARCHAR(45) NOT NULL,
  `correo` VARCHAR(45) NOT NULL,
  `mensaje` VARCHAR(300) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `chiquitines`.`cursos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `chiquitines`.`cursos` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `descripcion` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 9
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `chiquitines`.`materias`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `chiquitines`.`materias` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `chiquitines`.`noticias`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `chiquitines`.`noticias` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `fecha` DATETIME NOT NULL,
  `ruta` VARCHAR(400) NOT NULL,
  `descripcion` VARCHAR(300) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `chiquitines`.`roles`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `chiquitines`.`roles` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `descripcion` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `chiquitines`.`usuarios`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `chiquitines`.`usuarios` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nick_name` VARCHAR(45) NOT NULL,
  `contraseña` VARCHAR(45) NOT NULL,
  `nombres` VARCHAR(45) NOT NULL,
  `apellidos` VARCHAR(45) NOT NULL,
  `roles_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `nick_name_UNIQUE` (`nick_name` ASC) VISIBLE,
  INDEX `rol_idx` (`roles_id` ASC) VISIBLE,
  CONSTRAINT `roles_id`
    FOREIGN KEY (`roles_id`)
    REFERENCES `chiquitines`.`roles` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `chiquitines`.`recursos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `chiquitines`.`recursos` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `ruta` VARCHAR(400) NOT NULL,
  `materias_id` INT NOT NULL,
  `cursos_id` INT NOT NULL,
  `usuarios_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `materia_idx` (`materias_id` ASC) VISIBLE,
  INDEX `curso_idx` (`cursos_id` ASC) VISIBLE,
  INDEX `fk_recursos_usuarios1_idx` (`usuarios_id` ASC) VISIBLE,
  CONSTRAINT `cursos_id`
    FOREIGN KEY (`cursos_id`)
    REFERENCES `chiquitines`.`cursos` (`id`),
  CONSTRAINT `usuarios_id`
    FOREIGN KEY (`usuarios_id`)
    REFERENCES `chiquitines`.`usuarios` (`id`),
  CONSTRAINT `materias_id`
    FOREIGN KEY (`materias_id`)
    REFERENCES `chiquitines`.`materias` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

INSERT INTO cursos(descripcion)
VALUES  
('Pre Kinder'),
('Kinder'),
('Transicion'),
('Primero'),
('Segundo'),
('Tercero'),
('Cuarto'),
('Quinto');

INSERT INTO materias(nombre)
VALUES  
('Matematicas'),
('Español'),
('Sociales'),
('Musica'),
('Ingles');

INSERT INTO roles(descripcion)
VALUES  
('Administrador'),
('Docente');

INSERT INTO usuarios(nick_name, contraseña, nombres, apellidos, roles_id)
VALUES  
('admin','admin','Administrador', 'Chiquitines', 1);


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
