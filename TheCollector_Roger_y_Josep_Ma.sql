CREATE DATABASE  IF NOT EXISTS `thecollector` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `thecollector`;
-- MySQL dump 10.13  Distrib 5.6.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: thecollector
-- ------------------------------------------------------
-- Server version	5.5.5-10.1.36-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `genero`
--

DROP TABLE IF EXISTS `genero`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `genero` (
  `idgenero` int(11) NOT NULL AUTO_INCREMENT,
  `nombregenero` varchar(60) NOT NULL,
  `tipogenero` int(11) NOT NULL,
  PRIMARY KEY (`idgenero`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `genero`
--

LOCK TABLES `genero` WRITE;
/*!40000 ALTER TABLE `genero` DISABLE KEYS */;
INSERT INTO `genero` VALUES (1,'Aventura',1),(2,'Comedia',1),(3,'Drama',1),(4,'Terror',1),(5,'Ciencia Ficcion',1),(6,'Arcade',0),(7,'Plataformas',0),(8,'Shooter',0),(9,'Accion',0),(10,'Estrategia',0);
/*!40000 ALTER TABLE `genero` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `libro`
--

DROP TABLE IF EXISTS `libro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `libro` (
  `idlibro` int(11) NOT NULL AUTO_INCREMENT,
  `nombrelibro` varchar(100) NOT NULL,
  `autor` varchar(150) NOT NULL,
  `numpaginas` int(11) NOT NULL,
  `idgenero` int(11) NOT NULL,
  PRIMARY KEY (`idlibro`),
  KEY `fk_libro` (`idgenero`),
  CONSTRAINT `fk_libro` FOREIGN KEY (`idgenero`) REFERENCES `genero` (`idgenero`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `libro`
--

LOCK TABLES `libro` WRITE;
/*!40000 ALTER TABLE `libro` DISABLE KEYS */;
/*!40000 ALTER TABLE `libro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `librousuario`
--

DROP TABLE IF EXISTS `librousuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `librousuario` (
  `username` varchar(20) NOT NULL,
  `idlibro` int(11) NOT NULL,
  `paginaactual` int(11) NOT NULL,
  `valoracion` int(11) DEFAULT NULL,
  PRIMARY KEY (`username`,`idlibro`),
  KEY `fk_username` (`username`),
  KEY `fk_idlibro` (`idlibro`),
  CONSTRAINT `fk_librousuario_idlibro` FOREIGN KEY (`idlibro`) REFERENCES `libro` (`idlibro`),
  CONSTRAINT `fk_librousuario_username` FOREIGN KEY (`username`) REFERENCES `usuario` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `librousuario`
--

LOCK TABLES `librousuario` WRITE;
/*!40000 ALTER TABLE `librousuario` DISABLE KEYS */;
/*!40000 ALTER TABLE `librousuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pelicula`
--

DROP TABLE IF EXISTS `pelicula`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pelicula` (
  `idpelicula` int(11) NOT NULL AUTO_INCREMENT,
  `nombrepelicula` varchar(100) NOT NULL,
  `direccion` varchar(150) NOT NULL,
  `duracion` int(11) NOT NULL,
  `idgenero` int(11) NOT NULL,
  PRIMARY KEY (`idpelicula`),
  KEY `fk_pelicula` (`idgenero`),
  CONSTRAINT `fk_pelicula` FOREIGN KEY (`idgenero`) REFERENCES `genero` (`idgenero`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pelicula`
--

LOCK TABLES `pelicula` WRITE;
/*!40000 ALTER TABLE `pelicula` DISABLE KEYS */;
/*!40000 ALTER TABLE `pelicula` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `peliculausuario`
--

DROP TABLE IF EXISTS `peliculausuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `peliculausuario` (
  `username` varchar(20) NOT NULL,
  `idpelicula` int(11) NOT NULL,
  `minuto` int(11) NOT NULL,
  `valoracion` int(11) DEFAULT NULL,
  PRIMARY KEY (`username`,`idpelicula`),
  KEY `fk_username` (`username`),
  KEY `fk_idpelicula` (`idpelicula`),
  CONSTRAINT `fk_peliculasuario_idpelicula` FOREIGN KEY (`idpelicula`) REFERENCES `pelicula` (`idpelicula`),
  CONSTRAINT `fk_peliculasuario_username` FOREIGN KEY (`username`) REFERENCES `usuario` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `peliculausuario`
--

LOCK TABLES `peliculausuario` WRITE;
/*!40000 ALTER TABLE `peliculausuario` DISABLE KEYS */;
/*!40000 ALTER TABLE `peliculausuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `serie`
--

DROP TABLE IF EXISTS `serie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `serie` (
  `idserie` int(11) NOT NULL AUTO_INCREMENT,
  `nombreserie` varchar(100) NOT NULL,
  `direccion` varchar(150) NOT NULL,
  `numtemporadas` int(11) NOT NULL,
  `numcapitulos` int(11) NOT NULL,
  `duracioncapitulo` int(11) NOT NULL,
  `idgenero` int(11) NOT NULL,
  PRIMARY KEY (`idserie`),
  KEY `fk_serie` (`idgenero`),
  CONSTRAINT `fk_serie` FOREIGN KEY (`idgenero`) REFERENCES `genero` (`idgenero`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `serie`
--

LOCK TABLES `serie` WRITE;
/*!40000 ALTER TABLE `serie` DISABLE KEYS */;
/*!40000 ALTER TABLE `serie` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `serieusuario`
--

DROP TABLE IF EXISTS `serieusuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `serieusuario` (
  `username` varchar(20) NOT NULL,
  `idserie` int(11) NOT NULL,
  `temporada` int(11) NOT NULL,
  `capitulo` int(11) NOT NULL,
  `minuto` int(11) NOT NULL,
  `valoracion` int(11) DEFAULT NULL,
  PRIMARY KEY (`username`,`idserie`),
  KEY `fk_username` (`username`),
  KEY `fk_idserie` (`idserie`),
  CONSTRAINT `fk_seriesuario_idserie` FOREIGN KEY (`idserie`) REFERENCES `serie` (`idserie`),
  CONSTRAINT `fk_seriesuario_username` FOREIGN KEY (`username`) REFERENCES `usuario` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `serieusuario`
--

LOCK TABLES `serieusuario` WRITE;
/*!40000 ALTER TABLE `serieusuario` DISABLE KEYS */;
/*!40000 ALTER TABLE `serieusuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `idusuario` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL,
  `pass` varchar(255) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `apellidos` varchar(150) NOT NULL,
  `tipo` int(11) NOT NULL,
  `email` varchar(100) NOT NULL,
  PRIMARY KEY (`username`),
  UNIQUE KEY `idusuario` (`idusuario`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'josep','123','josep','josep',0,'josep'),(2,'roger','123','roger','roger',0,'roger');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `videojuego`
--

DROP TABLE IF EXISTS `videojuego`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `videojuego` (
  `idvideojuego` int(11) NOT NULL AUTO_INCREMENT,
  `nombrevideojuego` varchar(100) NOT NULL,
  `desarrolladora` varchar(150) NOT NULL,
  `idgenero` int(11) NOT NULL,
  PRIMARY KEY (`idvideojuego`),
  KEY `fk_videojuego` (`idgenero`),
  CONSTRAINT `fk_videojuego` FOREIGN KEY (`idgenero`) REFERENCES `genero` (`idgenero`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `videojuego`
--

LOCK TABLES `videojuego` WRITE;
/*!40000 ALTER TABLE `videojuego` DISABLE KEYS */;
/*!40000 ALTER TABLE `videojuego` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `videojuegousuario`
--

DROP TABLE IF EXISTS `videojuegousuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `videojuegousuario` (
  `username` varchar(20) NOT NULL,
  `idvideojuego` int(11) NOT NULL,
  `valoracion` int(11) DEFAULT NULL,
  PRIMARY KEY (`username`,`idvideojuego`),
  KEY `fk_username` (`username`),
  KEY `fk_idvideojuego` (`idvideojuego`),
  CONSTRAINT `fk_videojuegousuario_idvideojuego` FOREIGN KEY (`idvideojuego`) REFERENCES `videojuego` (`idvideojuego`),
  CONSTRAINT `fk_videojuegousuario_username` FOREIGN KEY (`username`) REFERENCES `usuario` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `videojuegousuario`
--

LOCK TABLES `videojuegousuario` WRITE;
/*!40000 ALTER TABLE `videojuegousuario` DISABLE KEYS */;
/*!40000 ALTER TABLE `videojuegousuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'thecollector'
--

--
-- Dumping routines for database 'thecollector'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-05-28 16:43:33
