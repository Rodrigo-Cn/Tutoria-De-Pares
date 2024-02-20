-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: javadb
-- ------------------------------------------------------
-- Server version	8.0.35

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
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `nome` varchar(50) NOT NULL,
  `idade` int DEFAULT NULL,
  `email` varchar(80) NOT NULL,
  `senha` varchar(60) NOT NULL,
  `id` int NOT NULL AUTO_INCREMENT,
  `curso` varchar(60) DEFAULT NULL,
  `semestre` int DEFAULT NULL,
  `matricula` varchar(20) DEFAULT NULL,
  `tipo_de_deficiencia` varchar(40) DEFAULT NULL,
  `cargo` varchar(30) DEFAULT NULL,
  `tipo_de_usuario` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `matricula` (`matricula`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES ('Danielle Britadeira',NULL,'dani@gmail.com','dani123',1,NULL,NULL,NULL,NULL,NULL,1),('Rodrigo Costa',NULL,'rodrigo@gmail.com','rodrigo123',2,NULL,NULL,'2022gbi0007',NULL,NULL,3),('Samuel',NULL,'samuel@gmail.com','samuel123',3,NULL,NULL,'2022gbi0008',NULL,NULL,3),('Igor Souza',NULL,'igor@gmail.com','igor123',4,'Ads',3,'2022gbi0009',NULL,NULL,2),('Fernanda Fernandes',NULL,'fernanda@gmail.com','fernanda123',5,NULL,NULL,NULL,NULL,NULL,1),('Fernanda Alves',NULL,'fernandinha@gmail.com','fernanda123',6,NULL,NULL,'41341234heahzh',NULL,NULL,3),('Zeca',25,'admin1@gmail.com','1234',7,NULL,NULL,NULL,NULL,'Algum',4),('Admin2',NULL,'admin2@gmail.com','1234',8,NULL,NULL,NULL,NULL,NULL,4),('admin3',NULL,'admin3@gmail.com','1234',9,NULL,NULL,NULL,NULL,NULL,4),('Jailton ',NULL,'jailtinho@gmail.com','jailton123',10,NULL,NULL,'2010009gbi123',NULL,NULL,3),('Leticia Ferreira',NULL,'leticia@gmail.com','leticia123',11,NULL,NULL,'tejshdbethwa',NULL,NULL,2);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-02-19 23:02:13
