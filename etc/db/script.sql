-- create database real_estate_management;
use real_estate_management;

DROP TABLE IF EXISTS `users` ;

CREATE TABLE IF NOT EXISTS `users` (
  `email` VARCHAR(60) NOT NULL,
  `password` VARCHAR(20) NOT NULL,
  `first_name` VARCHAR(45) NULL DEFAULT NULL,
  `last_name` VARCHAR(45) NULL DEFAULT NULL,
  `street_nr` VARCHAR(10) NULL DEFAULT NULL,
  `street` VARCHAR(50) NULL DEFAULT NULL,
  `city` VARCHAR(20) NULL DEFAULT NULL,
  `district` VARCHAR(20) NULL DEFAULT NULL,
  `country` VARCHAR(25) NULL DEFAULT NULL,
  `phone` VARCHAR(14) NULL DEFAULT NULL,
  `role` VARCHAR(15) NULL DEFAULT NULL,
  PRIMARY KEY (`email`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;