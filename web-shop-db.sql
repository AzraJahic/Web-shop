-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
CREATE SCHEMA `web-shop` ;
CREATE USER 'hbstudent'@'localhost' IDENTIFIED BY 'hbstudent';
GRANT ALL PRIVILEGES ON *.* TO 'hbstudent'@'localhost';
--
-- Host: localhost    Database: web-shop
-- ------------------------------------------------------
-- Server version	8.0.22

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `client_msg`
--
USE `web-shop`;
DROP TABLE IF EXISTS `client_msg`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `client_msg` (
  `idClient_msg` int NOT NULL AUTO_INCREMENT,
  `clientName` varchar(45) NOT NULL,
  `clientLastName` varchar(45) NOT NULL,
  `clientPhoneNumber` varchar(45) NOT NULL,
  `clientEmail` varchar(45) NOT NULL,
  `clientMsg` varchar(1000) NOT NULL,
  PRIMARY KEY (`idClient_msg`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `client_msg`
--

LOCK TABLES `client_msg` WRITE;
/*!40000 ALTER TABLE `client_msg` DISABLE KEYS */;
INSERT INTO `client_msg` VALUES (8,'Test','Test','062013578','j_azrich@hotmail','Neka mesegge');
/*!40000 ALTER TABLE `client_msg` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `coupon`
--

DROP TABLE IF EXISTS `coupon`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `coupon` (
  `idCoupon` int NOT NULL AUTO_INCREMENT,
  `productId` int NOT NULL,
  `discountPercentage` int NOT NULL,
  PRIMARY KEY (`idCoupon`),
  KEY `productId` (`productId`),
  CONSTRAINT `coupon_ibfk_1` FOREIGN KEY (`productId`) REFERENCES `products` (`idProduct`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `coupon`
--

LOCK TABLES `coupon` WRITE;
/*!40000 ALTER TABLE `coupon` DISABLE KEYS */;
INSERT INTO `coupon` VALUES (1,2,10),(2,3,5),(3,4,5),(4,5,5);
/*!40000 ALTER TABLE `coupon` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `products`
--

DROP TABLE IF EXISTS `products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `products` (
  `idProduct` int NOT NULL,
  `productName` varchar(45) NOT NULL,
  `productDescribe` varchar(1000) NOT NULL,
  `productPrice` float NOT NULL,
  `isNew` tinyint DEFAULT '0',
  PRIMARY KEY (`idProduct`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `products`
--

LOCK TABLES `products` WRITE;
/*!40000 ALTER TABLE `products` DISABLE KEYS */;
INSERT INTO `products` VALUES (1,'Multifunkcionalna sprava za vjezbanje','Multifunkcionalna sprava za vjezbanje pravilni izbor je za svaki trening studio, kucnu teretanu ili komercijalnu teretanu. Naslon ce ojacati vase misice ledja. Curl i leptir stanica sluze za definiciju ramena i ruku, dok leg curl sluzi za vjezbanje gornjih i donjih dijelova bedara, a sajle za navlacenje jacaju cijelu skupinu misica ledja. ',2999.99,1),(2,'Kombinovana sprava za vjezbanje','Kombinovana sprava za vjezbanje idealan je alat za postizanje boljeg misicnog tonusa i snage gornjeg dijela tijela, misica trbuha, prsa, ledja i ruku. Bez potrebe za dodatnim utezima, ova sprava naglasak stavlja na vjezbanju samo s tezinom vlastitog tijela. Naravno, ako ste vec nadisli tu granicu, uvijek mozete iskoristiti dodatne utege kako biste intenzivirali trening.',1500.5,0),(3,'Visenamjenska sprava za vjezbanje','Vjezbajte ruke, ramena, trbusne misice, misice ledja i nogu uz visenamjensku spravu za vjezbanje. Zahvaljujuci mogucnosti rotacije, mozete izvoditi razne vjezbe poput zgibova, dipova ili podizanja nogu uz maksimalno opterecenje do 200 kg. 8 razlicitih hvatova takodjer garantuje raznolikost vjezbanja u minimalnom prostoru. ',900,0),(4,'Mini pokretna traka za trcanje','Jednostavna, sklopiva mini traka za trcanje ce poboljsati vasu svakodnevnicu i omoguciti vam da jednostavnom upotrebom poboljsate vasu kondiciju u udobnosti vlastitog doma. Maksimalna nosivost joj je do 100kg, a njena najveca prednost je da je lako sklopiva sto omogucava ustedu kucnog prostora.',700,0),(5,'Bicikl za vjezbanje','Ovaj cvrsti bicikl bit ce odlican izbor za vjezbanje kod kuce. Opremljen zamasnjakom, LCD racunarnim zaslonom i podesivim sjedalom, ovaj uspravni bicikl omogucit ce vam ucinkovito vjezbanje. ',720,0),(6,'Sprava za veslanje','Ova sprava za veslanje kombinuje tihi, prirodni i za zglobove stedljivi trening s visokom kvalitetom obrade i modernim dizajnom. Za optimalni monitoring treninga, sprava za veslanje raspolaze mini-racunarom i LCD zaslonom, koji prikazuje izvedbu, udaljenost, utrosene kalorije, kao i podeseni otpor. Nakon treninga spravu mozete, zahvaljujuci podnim kotacicima, vrlo lako spremiti. ',1800,1),(7,'Traka za hodanje','Ukoliko niste ljubitelj trcanja, nasa jednostavna traka za hodanje omogucit ce da hodanjem popravite svoju kondiciju i kardio ritam u udobnosti vlastitog doma. Maksimalna tezina nosivosti je 90kg. Traka za hodanje ima ugradjen racunar koji ce pratiti vrijeme kretanja, udaljenost koju ste napravili, brzinu koju ste postigli i kalorije koje ste pri tome izgubili.',699.99,0);
/*!40000 ALTER TABLE `products` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-01-18 14:53:21
