-- MySQL dump 10.13  Distrib 8.0.43, for Win64 (x86_64)
--
-- Host: localhost    Database: aeroclub
-- ------------------------------------------------------
-- Server version	8.0.43

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
-- Table structure for table `alquiler`
--

DROP TABLE IF EXISTS `alquiler`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `alquiler` (
  `id_alquiler` int NOT NULL AUTO_INCREMENT,
  `fecha_inicio` date NOT NULL,
  `hora_inicio` time DEFAULT NULL,
  `horasVuelo` int DEFAULT NULL,
  `estado` varchar(50) DEFAULT NULL,
  `costo_total` decimal(10,2) DEFAULT NULL,
  `id_usuario` int NOT NULL,
  `id_avion` int NOT NULL,
  PRIMARY KEY (`id_alquiler`),
  KEY `id_usuario` (`id_usuario`),
  KEY `id_avion` (`id_avion`),
  CONSTRAINT `alquiler_ibfk_1` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`),
  CONSTRAINT `alquiler_ibfk_2` FOREIGN KEY (`id_avion`) REFERENCES `avion` (`id_avion`)
) ENGINE=InnoDB AUTO_INCREMENT=69 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alquiler`
--

LOCK TABLES `alquiler` WRITE;
/*!40000 ALTER TABLE `alquiler` DISABLE KEYS */;
INSERT INTO `alquiler` VALUES (1,'2024-10-18','09:00:00',2,'Finalizado',400000.00,1,2),(2,'2024-12-07','14:00:00',2,'Finalizado',400000.00,1,4),(3,'2025-02-15','08:30:00',3,'Finalizado',750000.00,1,3),(4,'2025-05-03','10:00:00',2,'Finalizado',400000.00,1,2),(5,'2025-07-19','15:00:00',3,'Finalizado',750000.00,1,3),(6,'2025-10-11','09:00:00',3,'Finalizado',600000.00,1,4),(7,'2026-01-24','13:00:00',2,'Finalizado',400000.00,1,2),(8,'2026-04-18','08:00:00',3,'Finalizado',750000.00,1,3),(9,'2026-08-22','10:00:00',3,'Finalizado',750000.00,1,3),(10,'2026-09-30','14:00:00',3,'Finalizado',600000.00,1,4),(11,'2026-10-17','09:00:00',3,'Finalizado',750000.00,1,3),(12,'2024-11-02','08:00:00',2,'Finalizado',300000.00,2,1),(13,'2025-01-18','11:00:00',2,'Finalizado',400000.00,2,2),(14,'2025-04-12','09:30:00',3,'Finalizado',600000.00,2,4),(15,'2025-08-09','14:00:00',3,'Finalizado',750000.00,2,3),(16,'2025-11-22','10:00:00',2,'Finalizado',400000.00,2,2),(17,'2026-02-14','08:00:00',3,'Finalizado',750000.00,2,3),(18,'2026-05-30','15:00:00',2,'Finalizado',400000.00,2,2),(19,'2026-09-05','09:00:00',3,'Finalizado',600000.00,2,4),(20,'2026-10-04','10:00:00',3,'Pendiente',750000.00,2,3),(21,'2025-03-08','10:00:00',2,'Finalizado',300000.00,3,1),(22,'2025-06-21','14:00:00',2,'Finalizado',400000.00,3,2),(23,'2025-09-13','09:00:00',2,'Finalizado',400000.00,3,2),(24,'2026-01-10','15:00:00',2,'Finalizado',400000.00,3,2),(25,'2026-03-28','11:00:00',2,'Finalizado',300000.00,3,7),(26,'2026-07-11','16:00:00',2,'Finalizado',300000.00,3,7),(27,'2026-09-30','15:30:00',2,'Finalizado',300000.00,3,7),(28,'2026-10-25','10:00:00',2,'Pendiente',300000.00,3,7),(29,'2025-05-17','09:00:00',2,'Finalizado',300000.00,4,1),(30,'2025-09-06','14:00:00',2,'Finalizado',400000.00,4,2),(31,'2026-02-07','10:00:00',3,'Finalizado',600000.00,4,4),(32,'2026-06-13','08:00:00',2,'Finalizado',400000.00,4,2),(33,'2026-10-11','09:00:00',2,'Pendiente',400000.00,4,2),(34,'2024-09-28','08:00:00',3,'Finalizado',600000.00,5,4),(35,'2024-12-14','13:00:00',2,'Finalizado',400000.00,5,2),(36,'2025-02-22','09:00:00',3,'Finalizado',750000.00,5,3),(37,'2025-05-24','07:30:00',3,'Finalizado',750000.00,5,9),(38,'2025-07-12','06:00:00',3,'Finalizado',750000.00,5,9),(39,'2025-09-20','10:00:00',2,'Finalizado',400000.00,5,2),(40,'2025-11-15','08:00:00',3,'Finalizado',750000.00,5,9),(41,'2026-02-28','09:00:00',2,'Finalizado',500000.00,5,5),(42,'2026-05-09','07:00:00',3,'Finalizado',750000.00,5,9),(43,'2026-08-15','10:00:00',2,'Finalizado',500000.00,5,5),(44,'2026-10-03','07:00:00',3,'Pendiente',750000.00,5,9),(45,'2024-10-05','09:00:00',2,'Finalizado',400000.00,6,2),(46,'2024-12-21','10:00:00',2,'Finalizado',500000.00,6,5),(47,'2025-03-15','08:00:00',2,'Finalizado',60000.00,6,10),(48,'2025-06-07','07:00:00',3,'Finalizado',900000.00,6,13),(49,'2025-08-23','09:00:00',2,'Finalizado',500000.00,6,5),(50,'2025-11-08','10:00:00',2,'Finalizado',60000.00,6,10),(51,'2026-01-31','08:00:00',3,'Finalizado',900000.00,6,13),(52,'2026-04-25','09:00:00',2,'Finalizado',500000.00,6,5),(53,'2026-07-18','10:00:00',3,'Finalizado',90000.00,6,10),(54,'2026-09-12','07:00:00',3,'Finalizado',900000.00,6,13),(55,'2026-10-18','09:00:00',3,'Pendiente',900000.00,6,13),(56,'2026-10-06','18:18:00',1,'Finalizado',150000.00,1,7),(57,'2026-10-07','17:42:00',2,'Finalizado',300000.00,1,1),(58,'2026-10-07','17:42:00',2,'Finalizado',300000.00,1,1),(59,'2026-10-02','18:12:00',2,'Finalizado',400000.00,1,2),(60,'2026-10-06','14:28:00',3,'Finalizado',450000.00,1,7),(61,'2026-10-15','16:58:00',2,'Finalizado',300000.00,1,1),(62,'2026-10-22','17:40:00',1,'Finalizado',200000.00,1,2),(63,'2026-10-20','15:22:00',1,'Finalizado',150000.00,1,1),(64,'2026-11-03','23:46:00',1,'Pendiente',250000.00,1,5),(65,'2026-10-21','21:47:00',1,'Finalizado',200000.00,1,2),(66,'2026-10-28','18:45:00',1,'Pendiente',200000.00,1,2),(67,'2026-10-29','18:48:00',2,'Pendiente',300000.00,1,1),(68,'2026-10-28','16:56:00',1,'Pendiente',200000.00,1,2);
/*!40000 ALTER TABLE `alquiler` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `avion`
--

DROP TABLE IF EXISTS `avion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `avion` (
  `id_avion` int NOT NULL AUTO_INCREMENT,
  `modelo` varchar(50) NOT NULL,
  `matricula` varchar(50) NOT NULL,
  `precio_hora` decimal(10,2) DEFAULT NULL,
  `estado` varchar(50) DEFAULT 'Activo',
  `id_tipo_avion` int NOT NULL,
  PRIMARY KEY (`id_avion`),
  KEY `id_tipo_avion` (`id_tipo_avion`),
  CONSTRAINT `avion_ibfk_1` FOREIGN KEY (`id_tipo_avion`) REFERENCES `tipo_avion` (`id_tipo_avion`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `avion`
--

LOCK TABLES `avion` WRITE;
/*!40000 ALTER TABLE `avion` DISABLE KEYS */;
INSERT INTO `avion` VALUES (1,'PA-11','LV-YNG',150000.00,'Activo',1),(2,'Cessna 152','PG-395',200000.00,'Activo',1),(3,'Cessna 172','MH-G75',250000.00,'Mantenimiento',1),(4,'DA40-NG','HT-A42',200000.00,'Activo',1),(5,'TBM-930','KG-489',250000.00,'Activo',2),(6,'Citation-CJ4','LC-K94',400000.00,'Mantenimiento',2),(7,'Cap10','XY-937',150000.00,'Activo',4),(8,'Pitts','PT-234',200000.00,'Activo',8),(9,'AT802','LB-568',250000.00,'Activo',3),(10,'AS-33-ME','LH-531',30000.00,'Activo',5),(11,'DASH-7','CG-253',300000.00,'Activo',6),(12,'Aerostatico','GB-523',100000.00,'Mantenimiento',7),(13,'CL-415','BM-F34',300000.00,'Activo',9);
/*!40000 ALTER TABLE `avion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `curso`
--

DROP TABLE IF EXISTS `curso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `curso` (
  `id_curso` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `descripcion` text,
  `duracion` varchar(50) DEFAULT NULL,
  `horas_vuelo` int DEFAULT NULL,
  `costo` decimal(10,2) DEFAULT NULL,
  `id_tipo_licencia` int DEFAULT NULL,
  PRIMARY KEY (`id_curso`),
  KEY `id_tipo_licencia` (`id_tipo_licencia`),
  CONSTRAINT `id_tipo_licencia` FOREIGN KEY (`id_tipo_licencia`) REFERENCES `tipo_licencia` (`id_tipo_licencia`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `curso`
--

LOCK TABLES `curso` WRITE;
/*!40000 ALTER TABLE `curso` DISABLE KEYS */;
INSERT INTO `curso` VALUES (1,'Piloto Privado','Este es el curso mas comun el cual habilita al usuario a volar sin remuneracion aeronaves pequeñas para uso personal o recreativo',NULL,40,100000.00,1),(2,'Piloto Comercial','Habilita al usuario al transporte de personas remunerado',NULL,20,70000.00,2),(3,'Instructor de vuelo','Capacita al usuario a trabajar como instructor de futuros pilotos. Requiere poseer 300 horas de vuelo previas','6 Meses',NULL,150000.00,4),(4,'Piloto de planeador','Permite pilotar aeronaves sin motor',NULL,20,80000.00,6),(5,'Piloto Fumigador','Capacita al usuario a trabajar como piloto fumigador en el sector de pesticidas agricolas. Requiere 400 horas de vuelo previas','3 Meses',30,200000.00,7),(6,'Mecanico aeronautico','El usuario desarrolla habilidades y adquiere los conocimientos necesarios para el mantenimiento y reparacion de aeronaves pequeñas','2 años',NULL,500000.00,10);
/*!40000 ALTER TABLE `curso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `enseña`
--

DROP TABLE IF EXISTS `enseña`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `enseña` (
  `id_curso` int NOT NULL,
  `id_usuario` int NOT NULL,
  PRIMARY KEY (`id_curso`,`id_usuario`),
  KEY `id_usuario` (`id_usuario`),
  CONSTRAINT `enseña_ibfk_1` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`),
  CONSTRAINT `enseña_ibfk_2` FOREIGN KEY (`id_curso`) REFERENCES `curso` (`id_curso`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `enseña`
--

LOCK TABLES `enseña` WRITE;
/*!40000 ALTER TABLE `enseña` DISABLE KEYS */;
INSERT INTO `enseña` VALUES (1,1),(2,1),(3,1),(1,3),(3,3),(2,5),(5,5),(1,6),(2,6),(3,6),(4,6),(6,7);
/*!40000 ALTER TABLE `enseña` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `inscripcion`
--

DROP TABLE IF EXISTS `inscripcion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `inscripcion` (
  `fecha_inscripcion` date NOT NULL,
  `estado` varchar(50) DEFAULT NULL,
  `id_curso` int NOT NULL,
  `id_usuario` int NOT NULL,
  PRIMARY KEY (`id_curso`,`id_usuario`),
  KEY `id_usuario` (`id_usuario`),
  CONSTRAINT `inscripcion_ibfk_1` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`),
  CONSTRAINT `inscripcion_ibfk_2` FOREIGN KEY (`id_curso`) REFERENCES `curso` (`id_curso`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inscripcion`
--

LOCK TABLES `inscripcion` WRITE;
/*!40000 ALTER TABLE `inscripcion` DISABLE KEYS */;
INSERT INTO `inscripcion` VALUES ('2023-08-14','Finalizado',1,1),('2023-10-02','Finalizado',1,2),('2024-03-11','Finalizado',1,3),('2025-01-20','Finalizado',1,4),('2023-04-10','Finalizado',1,5),('2023-02-13','Finalizado',1,6),('2024-01-15','Finalizado',2,1),('2024-02-19','Finalizado',2,2),('2026-08-25','Cursando',2,3),('2023-09-18','Finalizado',2,5),('2023-07-10','Finalizado',2,6),('2024-04-08','Finalizado',3,1),('2024-05-13','Finalizado',3,2),('2024-08-05','Finalizado',3,3),('2024-01-08','Finalizado',3,5),('2023-11-06','Finalizado',3,6),('2026-08-20','Cursando',4,1),('2026-07-15','Cursando',4,5),('2024-02-05','Finalizado',4,6),('2026-09-10','Inscripto',5,2),('2024-03-04','Finalizado',5,5),('2026-08-03','Cursando',5,6),('2024-01-15','Finalizado',6,7);
/*!40000 ALTER TABLE `inscripcion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `licencia_usuario`
--

DROP TABLE IF EXISTS `licencia_usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `licencia_usuario` (
  `id_usuario` int NOT NULL,
  `id_tipo_licencia` int NOT NULL,
  PRIMARY KEY (`id_usuario`,`id_tipo_licencia`),
  KEY `id_tipo_licencia` (`id_tipo_licencia`),
  CONSTRAINT `licencia_usuario_ibfk_1` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`),
  CONSTRAINT `licencia_usuario_ibfk_2` FOREIGN KEY (`id_tipo_licencia`) REFERENCES `tipo_licencia` (`id_tipo_licencia`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `licencia_usuario`
--

LOCK TABLES `licencia_usuario` WRITE;
/*!40000 ALTER TABLE `licencia_usuario` DISABLE KEYS */;
INSERT INTO `licencia_usuario` VALUES (1,1),(2,1),(3,1),(4,1),(5,1),(6,1),(1,2),(2,2),(5,2),(6,2),(1,4),(2,4),(3,4),(5,4),(6,4),(3,5),(6,6),(5,7),(6,9),(7,10);
/*!40000 ALTER TABLE `licencia_usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_avion`
--

DROP TABLE IF EXISTS `tipo_avion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tipo_avion` (
  `id_tipo_avion` int NOT NULL AUTO_INCREMENT,
  `tipo` varchar(50) NOT NULL,
  `id_tipo_licencia` int DEFAULT NULL,
  PRIMARY KEY (`id_tipo_avion`),
  KEY `tipo_licencia` (`id_tipo_licencia`),
  CONSTRAINT `tipo_licencia` FOREIGN KEY (`id_tipo_licencia`) REFERENCES `tipo_licencia` (`id_tipo_licencia`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_avion`
--

LOCK TABLES `tipo_avion` WRITE;
/*!40000 ALTER TABLE `tipo_avion` DISABLE KEYS */;
INSERT INTO `tipo_avion` VALUES (1,'Privado',1),(2,'Comercial',2),(3,'Fumigador',7),(4,'Experimental',1),(5,'Planeador',6),(6,'Carga',3),(7,'Aerostato',8),(8,'Acrobatico',5),(9,'Apagafuegos',9);
/*!40000 ALTER TABLE `tipo_avion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_licencia`
--

DROP TABLE IF EXISTS `tipo_licencia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tipo_licencia` (
  `id_tipo_licencia` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `descripcion` text,
  PRIMARY KEY (`id_tipo_licencia`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_licencia`
--

LOCK TABLES `tipo_licencia` WRITE;
/*!40000 ALTER TABLE `tipo_licencia` DISABLE KEYS */;
INSERT INTO `tipo_licencia` VALUES (1,'Licencia de Piloto Privado','Este es el tipo de licencia de piloto más común emitida por la FAA. Para obtenerla, debe acumular un mínimo de 35 horas de vuelo en diversas condiciones. Además, debe aprobar los exámenes teóricos y prácticos de la FAA, y poseer una licencia de conducir válida. Con una licencia de piloto privado, estará autorizado a volar solo o acompañado. Sin embargo, no podrá recibir remuneración por volar ni por transportar pasajeros.'),(2,'Licencia de Piloto Comercial','Autoriza a trabajar como piloto profesional y realizar vuelos remunerados'),(3,'Transporte de Líneas Aéreas','Capacita para ejercer como piloto al mando en operaciones de transporte aéreo comercial en cualquier avión certificado para un solo piloto y, también, como copiloto en transporte aéreo comercial de líneas aéreas'),(4,'Instructor de vuelo','Permite capacitar a estudiantes de vuelo en diferentes tipos de aeronaves y en diversas condiciones climáticas. Como CFI, puedes trabajar en una institución educativa, una escuela de vuelo certificada por la FAA o tu propia escuela de vuelo'),(5,'Licencia de Piloto Acrobatico','Permite utilizar aeronaves acrobaticas y actuar en eventos'),(6,'Licencia de Piloto Planeador','Capacita al usuario a volar como piloto en aeronaves sin motor'),(7,'Licencia de Piloto Fumigador','Autoriza a trabajar como piloto fumigador profesional'),(8,'Licencia de Piloto Aerostato','Permite al usuario pilotar un globo aerotatico'),(9,'Licencia de Piloto Apagafuegos','Capacita al usuario a ejercer como piloto apagafuegos frente a incendios'),(10,'Mecanico de Aeronaves','Habilita al usuario a realizar el mantenimiento y reparaciones a aeronaves pequeñas');
/*!40000 ALTER TABLE `tipo_licencia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `id_usuario` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `apellido` varchar(50) NOT NULL,
  `email` varchar(100) NOT NULL,
  `contraseña` varchar(100) NOT NULL,
  `nro_doc` varchar(20) DEFAULT NULL,
  `domicilio` varchar(50) DEFAULT NULL,
  `telefono` varchar(20) DEFAULT NULL,
  `estado` varchar(20) DEFAULT 'Activo',
  `tipo` varchar(50) DEFAULT 'Usuario',
  PRIMARY KEY (`id_usuario`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'Lautaro','Kalkov','lautarokalkov@gmail.com','12345','43843495','Rosario','3476302099','Activo','Administrador'),(2,'lautaro','Kalkov','kalkovlautaro@gmail.com','12345','43843495','Rosario','3476302099','Activo','Usuario'),(3,'Lelouch','Britannia','lelouch@zero.requiem','zero','27384593','Britannia','3410000000','Activo','Instructor'),(4,'Albedo','Gown','albedo@nazarick.guard','ainz','30943628','Nazarick',NULL,'Inactivo','Usuario'),(5,'Zero','Two','zt@yahoo.com','two','23894578','Fort city',NULL,'Activo','Instructor'),(6,'Kakashi','Hatake','kakashi@konoha.com','hokage','29203741','Konoha','470514','Activo','Instructor'),(7,'Izuku','Midoriya','izuku@ua.edu','allmight','46294729','Tokyo','459289789','Activo','Usuario'),(8,'Ranma','Saotome','ranma@nyanniichuan.com','saoto','43291094','Jusenkyo','2382303481','Inactivo','Usuario'),(14,'sdf','sdfg','fgj','ad','asdf','sdfg','sdg','Activo','Usuario'),(15,'sxdg','xdg','sedfg','sdg','sdfg',NULL,NULL,'Activo','Usuario');
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

-- Dump completed on 2026-10-27 16:11:54
