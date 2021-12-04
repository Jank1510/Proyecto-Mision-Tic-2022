-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema heroku_88ed9c2d70cf03f
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema heroku_88ed9c2d70cf03f
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `heroku_88ed9c2d70cf03f` DEFAULT CHARACTER SET latin1 ;
USE `heroku_88ed9c2d70cf03f`;

-- -----------------------------------------------------
-- Table `heroku_88ed9c2d70cf03f`.`contactenos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `heroku_88ed9c2d70cf03f`.`contactenos` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `nombres_apellidos` VARCHAR(45) NOT NULL,
  `correo` VARCHAR(45) NOT NULL,
  `mensaje` VARCHAR(300) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `heroku_88ed9c2d70cf03f`.`cursos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `heroku_88ed9c2d70cf03f`.`cursos` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `descripcion` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `descripcion_UNIQUE` (`descripcion` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `heroku_88ed9c2d70cf03f`.`materias`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `heroku_88ed9c2d70cf03f`.`materias` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `nombre_UNIQUE` (`nombre` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `heroku_88ed9c2d70cf03f`.`noticias`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `heroku_88ed9c2d70cf03f`.`noticias` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `titulo_noticia` VARCHAR(100) NOT NULL,
  `nombre_imagen` VARCHAR(100) NULL DEFAULT NULL,
  `fecha` DATE NOT NULL,
  `ruta` VARCHAR(400) NOT NULL,
  `descripcion` VARCHAR(300) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `heroku_88ed9c2d70cf03f`.`roles`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `heroku_88ed9c2d70cf03f`.`roles` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `descripcion` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `heroku_88ed9c2d70cf03f`.`usuarios`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `heroku_88ed9c2d70cf03f`.`usuarios` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `nick_name` VARCHAR(45) NOT NULL,
  `contraseña` VARCHAR(45) NOT NULL,
  `nombres` VARCHAR(45) NOT NULL,
  `apellidos` VARCHAR(45) NOT NULL,
  `roles_id` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `nick_name_UNIQUE` (`nick_name` ASC),
  INDEX `rol_idx` (`roles_id` ASC),
  CONSTRAINT `roles_id`
    FOREIGN KEY (`roles_id`)
    REFERENCES `heroku_88ed9c2d70cf03f`.`roles` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `heroku_88ed9c2d70cf03f`.`recursos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `heroku_88ed9c2d70cf03f`.`recursos` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre_recurso` VARCHAR(45) NOT NULL,
  `nombre_archivo` VARCHAR(45) NULL DEFAULT NULL,
  `tipo_archivo` VARCHAR(45) NULL DEFAULT NULL,
  `tamaño` LONGBLOB NULL DEFAULT NULL,
  `ruta` VARCHAR(400) NOT NULL,
  `materias_id` INT(11) NOT NULL,
  `cursos_id` INT(11) NOT NULL,
  `usuarios_id` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `materia_idx` (`materias_id` ASC),
  INDEX `curso_idx` (`cursos_id` ASC),
  INDEX `fk_recursos_usuarios1_idx` (`usuarios_id` ASC),
  CONSTRAINT `cursos_id`
    FOREIGN KEY (`cursos_id`)
    REFERENCES `heroku_88ed9c2d70cf03f`.`cursos` (`id`),
  CONSTRAINT `materias_id`
    FOREIGN KEY (`materias_id`)
    REFERENCES `heroku_88ed9c2d70cf03f`.`materias` (`id`),
  CONSTRAINT `usuarios_id`
    FOREIGN KEY (`usuarios_id`)
    REFERENCES `heroku_88ed9c2d70cf03f`.`usuarios` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

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
('Ciencias Naturales'),
('Sociales'),
('Religion'),
('Etica y Valores'),
('Ingles'),
('Informatica'),
('Castellano'),
('Geometria');

INSERT INTO roles(descripcion)
VALUES  
('Administrador'),
('Docente');

INSERT INTO usuarios(nick_name, contraseña, nombres, apellidos, roles_id)
VALUES  
('admin','admin','Administrador', 'Chiquitines', 1),
('profesor','123','Profesor', 'Prueba', 2);


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;