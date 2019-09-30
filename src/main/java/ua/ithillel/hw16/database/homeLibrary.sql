CREATE DATABASE  IF NOT EXISTS `homeLibrary`
USE `homeLibrary`

DROP TABLE IF EXISTS `Actor`;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `Actor` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fullName` varchar(45) DEFAULT NULL,
  `birthday` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

LOCK TABLES `Actor` WRITE;
INSERT INTO `Actor` VALUES (1,'Fred di','1957'),(2,' Nelly po','1969'),(3,'Trup trup','1954'),(4,' Ghost casper','2000'),(5,'Chipolino dereviashka','2019');
UNLOCK TABLES;

DROP TABLE IF EXISTS `Director`;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `Director` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fullName` varchar(45) DEFAULT NULL,
  `birthday` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

LOCK TABLES `Director` WRITE;
INSERT INTO `Director` VALUES (1,'Greg Co',1937);
UNLOCK TABLES;

DROP TABLE IF EXISTS `Film`;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `Film` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `titleOfFilm` varchar(45) DEFAULT NULL,
  `releaseDate` varchar(45) DEFAULT NULL,
  `releaseCountry` varchar(45) DEFAULT NULL,
  `DirectorID` int(11) NOT NULL,
  PRIMARY KEY (`id`,`DirectorID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

LOCK TABLES `Film` WRITE;
INSERT INTO `Film` VALUES (1,'Poroshok','2020','Kharkov',1),(2,'Chelovek Chelovechishe','2025','Chuguev',1),(3,'Kharkovskiy man Pauk','2019','Kiev',1);
UNLOCK TABLES;


DROP TABLE IF EXISTS `Movie`;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `Movie` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `FilmID` varchar(45) NOT NULL,
  `ActorID` varchar(45) NOT NULL,
  PRIMARY KEY (`id`,`FilmID`,`ActorID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

LOCK TABLES `Movie` WRITE;
INSERT INTO `Movie` VALUES (1,'1','1'),(2,'1','2'),(3,'1','3'),(4,'2','3'),(5,'2','4'),(6,'3','5');
UNLOCK TABLES;
