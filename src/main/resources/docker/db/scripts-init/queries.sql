/**
* Database Bakery
* @autor Diego Armando Bravo Sanabria
*
*/

SHOW GRANTS;
SHOW GRANTS FOR CURRENT_USER;
SHOW GRANTS FOR CURRENT_USER();

CREATE DATABASE IF NOT EXISTS 'bakery';

USE 'bakery';

CREATE TABLE IF NOT EXISTS `category` (
  `id_category` bigint(20) NOT NULL AUTO_INCREMENT,
  `id_category_parent` bigint(20) DEFAULT NULL,
  `name` varchar(100) CHARACTER SET utf8 NOT NULL,
  `description` varchar(500) CHARACTER SET utf8 DEFAULT NULL,
  `image1` varchar(500) DEFAULT 'https://images.pexels.com/photos/1907642/pexels-photo-1907642.jpeg',
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `created_by` varchar(50) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`id_category`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


CREATE TABLE IF NOT EXISTS `product` (
  `id_product` bigint(20) NOT NULL AUTO_INCREMENT,
  `id_category` bigint(20) DEFAULT NULL,
  `name` varchar(100) CHARACTER SET utf8 NOT NULL,
  `description` varchar(45) CHARACTER SET utf8 NOT NULL,
  `price` decimal(19,4) NOT NULL,
  `image1` varchar(500) CHARACTER SET utf8 DEFAULT NULL,
  `image2` varchar(500) CHARACTER SET utf8 DEFAULT NULL,
  `image3` varchar(500) CHARACTER SET utf8 DEFAULT NULL,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `created_by` varchar(45) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`id_product`),
  KEY `id_category_idx` (`id_category`),
  CONSTRAINT `fk_product_category` FOREIGN KEY (`id_category`) REFERENCES `category` (`id_category`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;




/**
* DATA
*/

INSERT INTO `bakery`.`category` (`id_category_parent`, `name`, `description`,`created_by`) VALUES ( NULL, 'test 001', 'test', 'test');
INSERT INTO `bakery`.`category` (`id_category_parent`, `name`, `description`,`created_by`) VALUES ( NULL, 'pan de mesa', 'Panes para ocasiones formales', 'usuario1');
INSERT INTO `bakery`.`category` (`id_category_parent`, `name`, `description`,`created_by`) VALUES ( NULL, 'pan dulce', 'Panes con frutas o dulces', 'usuario1');
INSERT INTO `bakery`.`category` (`id_category_parent`, `name`, `description`,`created_by`) VALUES ( NULL, 'postres', 'Postres', 'usuario1');
INSERT INTO `bakery`.`category` (`id_category_parent`, `name`, `description`,`created_by`) VALUES ( NULL, 'bebidas', 'Bebidas frias y calientes', 'usuario1');
INSERT INTO `bakery`.`category` (`id_category_parent`, `name`, `description`,`created_by`) VALUES ( 4, 'jugos naturales', '', 'usuario1');

