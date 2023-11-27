CREATE DATABASE  IF NOT EXISTS `incidentes` /*!40100 DEFAULT CHARACTER SET utf8mb3 COLLATE utf8mb3_spanish_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `incidentes`;
-- MySQL dump 10.13  Distrib 8.0.30, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: incidentes
-- ------------------------------------------------------
-- Server version	8.0.30

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
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cliente` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `cuit` bigint DEFAULT NULL,
  `domicilio` varchar(255) COLLATE utf8mb3_spanish_ci DEFAULT NULL,
  `email` varchar(255) COLLATE utf8mb3_spanish_ci DEFAULT NULL,
  `razon_social` varchar(255) COLLATE utf8mb3_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (1,30123452338,'pueyrredon 2738','candelaria@gmail.com','candelaria sa'),(4,30237843938,'colon 338','miracielo@gmail.com','miracielo sa');
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `clientes_servicios`
--

DROP TABLE IF EXISTS `clientes_servicios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `clientes_servicios` (
  `id_cliente` bigint NOT NULL,
  `id_servicio` bigint NOT NULL,
  PRIMARY KEY (`id_cliente`,`id_servicio`),
  KEY `FKqs910c1d8sej4ydp3tyb99sfa` (`id_servicio`),
  CONSTRAINT `FKnqu10xybdufncmbrpwx3p9nns` FOREIGN KEY (`id_cliente`) REFERENCES `cliente` (`id`),
  CONSTRAINT `FKqs910c1d8sej4ydp3tyb99sfa` FOREIGN KEY (`id_servicio`) REFERENCES `servicios` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clientes_servicios`
--

LOCK TABLES `clientes_servicios` WRITE;
/*!40000 ALTER TABLE `clientes_servicios` DISABLE KEYS */;
INSERT INTO `clientes_servicios` VALUES (1,1),(1,4),(4,5),(4,6);
/*!40000 ALTER TABLE `clientes_servicios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `especialidad`
--

DROP TABLE IF EXISTS `especialidad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `especialidad` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `nombre_especialidad` varchar(255) COLLATE utf8mb3_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `especialidad`
--

LOCK TABLES `especialidad` WRITE;
/*!40000 ALTER TABLE `especialidad` DISABLE KEYS */;
INSERT INTO `especialidad` VALUES (1,'redes'),(2,'seguridad informatica'),(3,'soporte tecnico'),(4,'infraestructura servidores'),(5,'desarrollo software');
/*!40000 ALTER TABLE `especialidad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `incidente`
--

DROP TABLE IF EXISTS `incidente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `incidente` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `descripcion_problema` varchar(255) COLLATE utf8mb3_spanish_ci DEFAULT NULL,
  `estado` tinyint DEFAULT NULL,
  `fecha_hora_terminara` datetime(6) DEFAULT NULL,
  `fecha_incidente` date DEFAULT NULL,
  `hora_estimada_tecnico` time(6) DEFAULT NULL,
  `hora_incidente` time(6) DEFAULT NULL,
  `fk_cliente` bigint NOT NULL,
  `fk_tecnico` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKcscpdpxpeeu8rhln5tjk636qq` (`fk_cliente`),
  KEY `FKb50wdlij1gpeb4uncps4e14vr` (`fk_tecnico`),
  CONSTRAINT `FKb50wdlij1gpeb4uncps4e14vr` FOREIGN KEY (`fk_tecnico`) REFERENCES `tecnico` (`id`),
  CONSTRAINT `FKcscpdpxpeeu8rhln5tjk636qq` FOREIGN KEY (`fk_cliente`) REFERENCES `cliente` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `incidente`
--

LOCK TABLES `incidente` WRITE;
/*!40000 ALTER TABLE `incidente` DISABLE KEYS */;
INSERT INTO `incidente` VALUES (4,'no se puede acceder a la aplicacion  ',3,'2023-11-27 11:12:11.858633','2023-11-25','16:12:10.634000','20:12:10.634000',4,1),(7,'falla al querer actualizar datos  ',3,'2023-11-29 11:49:57.774354','2023-11-25','16:49:57.550000','20:49:57.550000',1,2),(8,'falla al dar de alta usuario, problemas de coneccion  ',3,'2023-11-28 05:28:52.982729','2023-11-26','10:28:52.960000','14:28:52.960000',1,2),(9,'falla aplicacion tango ',3,'2023-11-28 05:46:37.312348','2023-11-26','10:46:37.292000','14:46:37.292000',4,3),(10,'no se pueden generar informes ',3,'2023-11-30 05:53:46.310617','2023-11-26','10:53:46.294000','14:53:46.294000',1,4),(11,'no se puede acceder a la aplicacion cuando se actualiza un usuario',3,'2023-11-28 08:32:17.550218','2023-11-26','13:32:17.475000','17:32:17.475000',1,4),(12,'no se puede acceder a la aplicacion ',3,'2023-11-27 20:33:39.080854','2023-11-26','13:33:39.075000','17:33:39.075000',1,4);
/*!40000 ALTER TABLE `incidente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `incidente_problema`
--

DROP TABLE IF EXISTS `incidente_problema`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `incidente_problema` (
  `incidente_id` bigint NOT NULL,
  `problema_id` bigint NOT NULL,
  PRIMARY KEY (`incidente_id`,`problema_id`),
  KEY `FKnjqwuipgxm8imgmc8ydc8l3mv` (`problema_id`),
  CONSTRAINT `FKbrwort95xakq27sn13t79tq6f` FOREIGN KEY (`incidente_id`) REFERENCES `incidente` (`id`),
  CONSTRAINT `FKnjqwuipgxm8imgmc8ydc8l3mv` FOREIGN KEY (`problema_id`) REFERENCES `tipo_problema` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `incidente_problema`
--

LOCK TABLES `incidente_problema` WRITE;
/*!40000 ALTER TABLE `incidente_problema` DISABLE KEYS */;
INSERT INTO `incidente_problema` VALUES (7,1),(10,1),(4,2),(7,2),(8,2),(9,2),(10,2),(11,2),(12,2),(4,3),(8,3),(9,3),(11,3);
/*!40000 ALTER TABLE `incidente_problema` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `servicios`
--

DROP TABLE IF EXISTS `servicios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `servicios` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `nombre_servicio` varchar(255) COLLATE utf8mb3_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `servicios`
--

LOCK TABLES `servicios` WRITE;
/*!40000 ALTER TABLE `servicios` DISABLE KEYS */;
INSERT INTO `servicios` VALUES (1,'redes'),(4,'seguridad informatica'),(5,'aplicaciones'),(6,'soporte tecnico');
/*!40000 ALTER TABLE `servicios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tecnico`
--

DROP TABLE IF EXISTS `tecnico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tecnico` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `email` varchar(255) COLLATE utf8mb3_spanish_ci DEFAULT NULL,
  `nombre_completo` varchar(255) COLLATE utf8mb3_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tecnico`
--

LOCK TABLES `tecnico` WRITE;
/*!40000 ALTER TABLE `tecnico` DISABLE KEYS */;
INSERT INTO `tecnico` VALUES (1,'luci@gmail.com','Luciana Contrera'),(2,'carlos@gmail.com','Carlos Montaner'),(3,'lucas@gmail.com','Lucas Alderete'),(4,'lucasC@gmail.com','Lucas Campos');
/*!40000 ALTER TABLE `tecnico` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tecnico_especialidad`
--

DROP TABLE IF EXISTS `tecnico_especialidad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tecnico_especialidad` (
  `id_tecnico` bigint NOT NULL,
  `especialidad_id` bigint NOT NULL,
  PRIMARY KEY (`id_tecnico`,`especialidad_id`),
  KEY `FK2ycbvwetrpqhbb7li5rhps2p7` (`especialidad_id`),
  CONSTRAINT `FK2ycbvwetrpqhbb7li5rhps2p7` FOREIGN KEY (`especialidad_id`) REFERENCES `especialidad` (`id`),
  CONSTRAINT `FK93noqwuf29guv7i5o1so7vt72` FOREIGN KEY (`id_tecnico`) REFERENCES `tecnico` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tecnico_especialidad`
--

LOCK TABLES `tecnico_especialidad` WRITE;
/*!40000 ALTER TABLE `tecnico_especialidad` DISABLE KEYS */;
INSERT INTO `tecnico_especialidad` VALUES (2,1),(3,1),(4,1),(1,2),(1,3),(2,3),(3,3),(4,3),(2,4),(3,4),(4,4),(1,5),(3,5),(4,5);
/*!40000 ALTER TABLE `tecnico_especialidad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_problema`
--

DROP TABLE IF EXISTS `tipo_problema`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tipo_problema` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `complegidad` tinyint DEFAULT NULL,
  `descripcion_problema` varchar(255) COLLATE utf8mb3_spanish_ci DEFAULT NULL,
  `horas_maxima_resolucion` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_problema`
--

LOCK TABLES `tipo_problema` WRITE;
/*!40000 ALTER TABLE `tipo_problema` DISABLE KEYS */;
INSERT INTO `tipo_problema` VALUES (1,0,'funcionamiento de aplicacion ',36),(2,1,'problemas coneccion ',24),(3,2,'altas y bajas usuarios ',12);
/*!40000 ALTER TABLE `tipo_problema` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_problema_especialidad`
--

DROP TABLE IF EXISTS `tipo_problema_especialidad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tipo_problema_especialidad` (
  `id_problema` bigint NOT NULL,
  `id_especialidades` bigint NOT NULL,
  KEY `FKcxued0p5ff7xdbvpwia1lfb7e` (`id_especialidades`),
  KEY `FKdqy27xto1vqxiidn79nm9i1ad` (`id_problema`),
  CONSTRAINT `FKcxued0p5ff7xdbvpwia1lfb7e` FOREIGN KEY (`id_especialidades`) REFERENCES `especialidad` (`id`),
  CONSTRAINT `FKdqy27xto1vqxiidn79nm9i1ad` FOREIGN KEY (`id_problema`) REFERENCES `tipo_problema` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_problema_especialidad`
--

LOCK TABLES `tipo_problema_especialidad` WRITE;
/*!40000 ALTER TABLE `tipo_problema_especialidad` DISABLE KEYS */;
INSERT INTO `tipo_problema_especialidad` VALUES (1,1),(1,4),(1,3),(2,4),(2,3),(3,5),(3,3);
/*!40000 ALTER TABLE `tipo_problema_especialidad` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-11-26 21:04:49
