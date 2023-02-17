-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: animeweb
-- ------------------------------------------------------
-- Server version	8.0.32
create database AnimeWeb;
use AnimeWeb;
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
-- Table structure for table `account`
--

DROP TABLE IF EXISTS `account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `account` (
  `UserName` varchar(24) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `PassW` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `Email` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `avatar` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`UserName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `accountrole`
--

DROP TABLE IF EXISTS `accountrole`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `accountrole` (
  `UserName` varchar(24) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `idrole` int DEFAULT NULL,
  KEY `accroleName` (`UserName`),
  KEY `accroleid` (`idrole`),
  CONSTRAINT `accroleid` FOREIGN KEY (`idrole`) REFERENCES `role` (`idrole`),
  CONSTRAINT `accroleName` FOREIGN KEY (`UserName`) REFERENCES `account` (`UserName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `accountrole`
--

LOCK TABLES `accountrole` WRITE;
/*!40000 ALTER TABLE `accountrole` DISABLE KEYS */;
/*!40000 ALTER TABLE `accountrole` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `avtmovie`
--

DROP TABLE IF EXISTS `avtmovie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `avtmovie` (
  `idavt` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`idavt`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `avtmovie`
--

LOCK TABLES `avtmovie` WRITE;
/*!40000 ALTER TABLE `avtmovie` DISABLE KEYS */;
/*!40000 ALTER TABLE `avtmovie` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `blog`
--

DROP TABLE IF EXISTS `blog`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `blog` (
  `idBlog` int NOT NULL AUTO_INCREMENT,
  `title` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `folder` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `datePost` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `avt` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `dayDebut` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`idBlog`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `blog`
--

LOCK TABLES `blog` WRITE;
/*!40000 ALTER TABLE `blog` DISABLE KEYS */;
/*!40000 ALTER TABLE `blog` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `blogcomment`
--

DROP TABLE IF EXISTS `blogcomment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `blogcomment` (
  `idBlog` int DEFAULT NULL,
  `idCmt` int NOT NULL AUTO_INCREMENT,
  `mess` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `UserName` varchar(24) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `dateCmt` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `isActive` int not null,
  PRIMARY KEY (`idCmt`),
  KEY `FK__blogComme__idBlo__440B1D61` (`idBlog`),
  KEY `FK__blogComme__UserN__44FF419A` (`UserName`),
  CONSTRAINT `FK__blogComme__idBlo__440B1D61` FOREIGN KEY (`idBlog`) REFERENCES `blog` (`idBlog`),
  CONSTRAINT `FK__blogComme__UserN__44FF419A` FOREIGN KEY (`UserName`) REFERENCES `account` (`UserName`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `blogcomment`
--

LOCK TABLES `blogcomment` WRITE;
/*!40000 ALTER TABLE `blogcomment` DISABLE KEYS */;
/*!40000 ALTER TABLE `blogcomment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `chapter`
--

DROP TABLE IF EXISTS `chapter`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `chapter` (
  `idMovie` int NOT NULL,
  `stt` int NOT NULL,
  `opening` int DEFAULT NULL,
  PRIMARY KEY (`idMovie`,`stt`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chapter`
--

LOCK TABLES `chapter` WRITE;
/*!40000 ALTER TABLE `chapter` DISABLE KEYS */;
/*!40000 ALTER TABLE `chapter` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comment`
--

DROP TABLE IF EXISTS `comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `comment` (
  `idComment` int NOT NULL AUTO_INCREMENT,
  `UserName` varchar(24) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `mess` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `idMovie` int DEFAULT NULL,
  `timecomment` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `isActive` int not null,
  PRIMARY KEY (`idComment`),
  KEY `FK__comment__idMovie__46E78A0C` (`idMovie`),
  KEY `FK__comment__UserNam__47DBAE45` (`UserName`),
  CONSTRAINT `FK__comment__idMovie__46E78A0C` FOREIGN KEY (`idMovie`) REFERENCES `movie` (`idMovie`),
  CONSTRAINT `FK__comment__UserNam__47DBAE45` FOREIGN KEY (`UserName`) REFERENCES `account` (`UserName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comment`
--

LOCK TABLES `comment` WRITE;
/*!40000 ALTER TABLE `comment` DISABLE KEYS */;
/*!40000 ALTER TABLE `comment` ENABLE KEYS */;
UNLOCK TABLES;
 
 DROP TABLE IF EXISTS `replycommentMovie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `replycommentMovie` (
  `idMovie` int DEFAULT NULL,
  `idComment` int DEFAULT NULL,
  `UserNameCmt` varchar(24) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `UserNameReply` varchar(24) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `mess` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `daycmt` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `sttCmt` int NOT NULL AUTO_INCREMENT,
  `isActive` int not null,
  PRIMARY KEY (`sttCmt`),
  KEY `FK__replyComm__idBlo__4CA063621` (`idMovie`),
  KEY `FK__replyComm__idCmt__6383C8BA1` (`idComment`),
  KEY `FK__replyComm__UserN__6477ECF31` (`UserNameCmt`),
  KEY `FK__replyComm__UserN__656C112C1` (`UserNameReply`),
  CONSTRAINT `FK__replyComm__idBlo__4CA063621` FOREIGN KEY (`idMovie`) REFERENCES `movie` (`idMovie`),
  CONSTRAINT `FK__replyComm__idCmt__4D94879B1` FOREIGN KEY (`idComment`) REFERENCES `comment` (`idComment`),
  CONSTRAINT `FK__replyComm__idCmt__6383C8BA1` FOREIGN KEY (`idComment`) REFERENCES `comment` (`idComment`),
  CONSTRAINT `FK__replyComm__UserN__4E88ABD41` FOREIGN KEY (`UserNameCmt`) REFERENCES `account` (`UserName`),
  CONSTRAINT `FK__replyComm__UserN__4F7CD00D1` FOREIGN KEY (`UserNameReply`) REFERENCES `account` (`UserName`),
  CONSTRAINT `FK__replyComm__UserN__6477ECF31` FOREIGN KEY (`UserNameCmt`) REFERENCES `account` (`UserName`),
  CONSTRAINT `FK__replyComm__UserN__656C112C1` FOREIGN KEY (`UserNameReply`) REFERENCES `account` (`UserName`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
--
-- Table structure for table `follow`
--

DROP TABLE IF EXISTS `follow`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `follow` (
  `UserName` varchar(24) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `idMovie` int DEFAULT NULL,
  `timefollow` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  KEY `FK__follow__UserName__49C3F6B7` (`UserName`),
  CONSTRAINT `FK__follow__UserName__49C3F6B7` FOREIGN KEY (`UserName`) REFERENCES `account` (`UserName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `follow`
--

LOCK TABLES `follow` WRITE;
/*!40000 ALTER TABLE `follow` DISABLE KEYS */;
/*!40000 ALTER TABLE `follow` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `genre`
--

DROP TABLE IF EXISTS `genre`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `genre` (
  `idGenre` int NOT NULL AUTO_INCREMENT,
  `description` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`idGenre`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `genre`
--

LOCK TABLES `genre` WRITE;
/*!40000 ALTER TABLE `genre` DISABLE KEYS */;
/*!40000 ALTER TABLE `genre` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movie`
--

DROP TABLE IF EXISTS `movie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `movie` (
  `idMovie` int NOT NULL AUTO_INCREMENT,
  `nameMovie` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `currentEpisode` int DEFAULT NULL,
  `totalEpisodes` int DEFAULT NULL,
  `descriptionVN` varchar(5000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `descriptionEN` varchar(5000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `dayadd` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `isActive` int not null, 
  PRIMARY KEY (`idMovie`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movie`
--

LOCK TABLES `movie` WRITE;
/*!40000 ALTER TABLE `movie` DISABLE KEYS */;
/*!40000 ALTER TABLE `movie` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movieavt`
--

DROP TABLE IF EXISTS `movieavt`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `movieavt` (
  `idMovie` int DEFAULT NULL,
  `idavt` int DEFAULT NULL,
  KEY `movieavtid` (`idMovie`),
  KEY `idavtmovie` (`idavt`),
  CONSTRAINT `idavtmovie` FOREIGN KEY (`idavt`) REFERENCES `avtmovie` (`idavt`),
  CONSTRAINT `movieavtid` FOREIGN KEY (`idMovie`) REFERENCES `movie` (`idMovie`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movieavt`
--

LOCK TABLES `movieavt` WRITE;
/*!40000 ALTER TABLE `movieavt` DISABLE KEYS */;
/*!40000 ALTER TABLE `movieavt` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `moviegenre`
--

DROP TABLE IF EXISTS `moviegenre`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `moviegenre` (
  `idMovie` int DEFAULT NULL,
  `idGenre` int DEFAULT NULL,
  KEY `movieid` (`idMovie`),
  KEY `idgenre` (`idGenre`),
  CONSTRAINT `idgenre` FOREIGN KEY (`idGenre`) REFERENCES `genre` (`idGenre`),
  CONSTRAINT `movieid` FOREIGN KEY (`idMovie`) REFERENCES `movie` (`idMovie`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `moviegenre`
--

LOCK TABLES `moviegenre` WRITE;
/*!40000 ALTER TABLE `moviegenre` DISABLE KEYS */;
/*!40000 ALTER TABLE `moviegenre` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movieproducer`
--

DROP TABLE IF EXISTS `movieproducer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `movieproducer` (
  `idMovie` int DEFAULT NULL,
  `idproducer` int DEFAULT NULL,
  KEY `movieproducerid` (`idMovie`),
  KEY `movieproduceridpro` (`idproducer`),
  CONSTRAINT `movieproducerid` FOREIGN KEY (`idMovie`) REFERENCES `movie` (`idMovie`),
  CONSTRAINT `movieproduceridpro` FOREIGN KEY (`idproducer`) REFERENCES `producer` (`idproducer`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movieproducer`
--

LOCK TABLES `movieproducer` WRITE;
/*!40000 ALTER TABLE `movieproducer` DISABLE KEYS */;
/*!40000 ALTER TABLE `movieproducer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `producer`
--

DROP TABLE IF EXISTS `producer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `producer` (
  `idproducer` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`idproducer`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `producer`
--

LOCK TABLES `producer` WRITE;
/*!40000 ALTER TABLE `producer` DISABLE KEYS */;
/*!40000 ALTER TABLE `producer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rate`
--

DROP TABLE IF EXISTS `rate`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rate` (
  `idMovie` int DEFAULT NULL,
  `UserName` varchar(24) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `score` int DEFAULT NULL,
  `timevote` varchar(20) DEFAULT NULL,
  KEY `FK__rate__idMovie__4AB81AF0` (`idMovie`),
  KEY `FK__rate__UserName__4BAC3F29` (`UserName`),
  CONSTRAINT `FK__rate__idMovie__4AB81AF0` FOREIGN KEY (`idMovie`) REFERENCES `movie` (`idMovie`),
  CONSTRAINT `FK__rate__UserName__4BAC3F29` FOREIGN KEY (`UserName`) REFERENCES `account` (`UserName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rate`
--

LOCK TABLES `rate` WRITE;
/*!40000 ALTER TABLE `rate` DISABLE KEYS */;
/*!40000 ALTER TABLE `rate` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `replycomment`
--

DROP TABLE IF EXISTS `replycomment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `replycomment` (
  `idBlog` int DEFAULT NULL,
  `idCmt` int DEFAULT NULL,
  `UserNameCmt` varchar(24) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `UserNameReply` varchar(24) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `mess` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `daycmt` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `sttCmt` int NOT NULL AUTO_INCREMENT,
  `isActive` int not null,
  PRIMARY KEY (`sttCmt`),
  KEY `FK__replyComm__idBlo__4CA06362` (`idBlog`),
  KEY `FK__replyComm__idCmt__6383C8BA` (`idCmt`),
  KEY `FK__replyComm__UserN__6477ECF3` (`UserNameCmt`),
  KEY `FK__replyComm__UserN__656C112C` (`UserNameReply`),
  CONSTRAINT `FK__replyComm__idBlo__4CA06362` FOREIGN KEY (`idBlog`) REFERENCES `blog` (`idBlog`),
  CONSTRAINT `FK__replyComm__idCmt__4D94879B` FOREIGN KEY (`idCmt`) REFERENCES `blogcomment` (`idCmt`),
  CONSTRAINT `FK__replyComm__idCmt__6383C8BA` FOREIGN KEY (`idCmt`) REFERENCES `blogcomment` (`idCmt`),
  CONSTRAINT `FK__replyComm__UserN__4E88ABD4` FOREIGN KEY (`UserNameCmt`) REFERENCES `account` (`UserName`),
  CONSTRAINT `FK__replyComm__UserN__4F7CD00D` FOREIGN KEY (`UserNameReply`) REFERENCES `account` (`UserName`),
  CONSTRAINT `FK__replyComm__UserN__6477ECF3` FOREIGN KEY (`UserNameCmt`) REFERENCES `account` (`UserName`),
  CONSTRAINT `FK__replyComm__UserN__656C112C` FOREIGN KEY (`UserNameReply`) REFERENCES `account` (`UserName`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `replycomment`
--

LOCK TABLES `replycomment` WRITE;
/*!40000 ALTER TABLE `replycomment` DISABLE KEYS */;
/*!40000 ALTER TABLE `replycomment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role` (
  `idrole` int NOT NULL AUTO_INCREMENT,
  `description` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`idrole`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userview`
--

DROP TABLE IF EXISTS `userview`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `userview` (
  `UserName` varchar(24) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `idMovie` int DEFAULT NULL,
  `timewatch` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  KEY `userviewidmovie` (`idMovie`),
  KEY `userviewUserName` (`UserName`),
  CONSTRAINT `userviewidmovie` FOREIGN KEY (`idMovie`) REFERENCES `movie` (`idMovie`),
  CONSTRAINT `userviewUserName` FOREIGN KEY (`UserName`) REFERENCES `account` (`UserName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userview`
--

LOCK TABLES `userview` WRITE;
/*!40000 ALTER TABLE `userview` DISABLE KEYS */;
/*!40000 ALTER TABLE `userview` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-02-17 12:25:40
