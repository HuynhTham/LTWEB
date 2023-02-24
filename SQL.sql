-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: animeweb
-- ------------------------------------------------------
-- Server version	8.0.32

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
-- Table structure for table `account_roles`
--

DROP TABLE IF EXISTS `account_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `account_roles` (
  `idUser` int DEFAULT NULL,
  `idrole` int DEFAULT NULL,
  KEY `accroleidUser` (`idUser`),
  KEY `accroleid` (`idrole`),
  CONSTRAINT `accroleid` FOREIGN KEY (`idrole`) REFERENCES `roles` (`idrole`),
  CONSTRAINT `accroleidUser` FOREIGN KEY (`idUser`) REFERENCES `accounts` (`idUser`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account_roles`
--

LOCK TABLES `account_roles` WRITE;
/*!40000 ALTER TABLE `account_roles` DISABLE KEYS */;
INSERT INTO `account_roles` VALUES (1,4);
/*!40000 ALTER TABLE `account_roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `account_types`
--

DROP TABLE IF EXISTS `account_types`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `account_types` (
  `typeId` int NOT NULL AUTO_INCREMENT,
  `description` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`typeId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account_types`
--

LOCK TABLES `account_types` WRITE;
/*!40000 ALTER TABLE `account_types` DISABLE KEYS */;
INSERT INTO `account_types` VALUES (1,'base User'),(2,'google User'),(3,'facebook User'),(4,'quản lý');
/*!40000 ALTER TABLE `account_types` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `accounts`
--

DROP TABLE IF EXISTS `accounts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `accounts` (
  `idUser` int NOT NULL AUTO_INCREMENT,
  `UserName` varchar(240) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `Password` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `Email` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `avatar` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `typeId` int DEFAULT NULL,
  `isActive` int DEFAULT NULL,
  PRIMARY KEY (`idUser`),
  KEY `acctype` (`typeId`),
  CONSTRAINT `acctype` FOREIGN KEY (`typeId`) REFERENCES `account_types` (`typeId`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `accounts`
--

LOCK TABLES `accounts` WRITE;
/*!40000 ALTER TABLE `accounts` DISABLE KEYS */;
INSERT INTO `accounts` VALUES (1,'admin','ZvniDNSIriVuH6j9pEQZHQey9e4=','maganeckji@gmail.com','admin.jpg',1,1),(2,'20130305','w0XhvSyORlI2Y0t4WS2uGK8m7oA=','20130305@st.hcmuaf.edu.vn',NULL,2,1),(3,'yaemiko27092002','5ZPmVKY7bSZQUbtKgxxjMxgEfZo=','yaemiko27092002@gmail.com',NULL,2,1),(4,'maganeckji','s1vnwLwzlss2HgVikMjM6wjtL9Y=','maganeckji@gmail.com',NULL,2,1),(5,'Phúc An Nguyễn Nhật','x4cwHr6w7Ql0KImOVkw2Vl5isYY=','goblinslayer27092002@gmail.com',NULL,2,1);
/*!40000 ALTER TABLE `accounts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `accounts_facebook`
--

DROP TABLE IF EXISTS `accounts_facebook`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `accounts_facebook` (
  `idFacebook` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `Username` varchar(240) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `idUser` int DEFAULT NULL,
  `Email` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`idFacebook`),
  KEY `FK__blogComme__UserN__44FF419As` (`idUser`),
  CONSTRAINT `FK__blogComme__UserN__44FF419As` FOREIGN KEY (`idUser`) REFERENCES `accounts` (`idUser`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `accounts_facebook`
--

LOCK TABLES `accounts_facebook` WRITE;
/*!40000 ALTER TABLE `accounts_facebook` DISABLE KEYS */;
/*!40000 ALTER TABLE `accounts_facebook` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `accounts_google`
--

DROP TABLE IF EXISTS `accounts_google`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `accounts_google` (
  `idGoogle` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `Username` varchar(240) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `idUser` int DEFAULT NULL,
  `Email` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`idGoogle`),
  KEY `FK__blogComme__UserN__44FF419Asa` (`idUser`),
  CONSTRAINT `FK__blogComme__UserN__44FF419Asa` FOREIGN KEY (`idUser`) REFERENCES `accounts` (`idUser`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `accounts_google`
--

LOCK TABLES `accounts_google` WRITE;
/*!40000 ALTER TABLE `accounts_google` DISABLE KEYS */;
INSERT INTO `accounts_google` VALUES ('102171743969144076968','Phúc An Nguyễn Nhật',5,'goblinslayer27092002@gmail.com'),('107409601924003064725','20130305',2,'20130305@st.hcmuaf.edu.vn'),('113222806438638623277','maganeckji',4,'maganeckji@gmail.com'),('115321105266146591150','yaemiko27092002',3,'yaemiko27092002@gmail.com');
/*!40000 ALTER TABLE `accounts_google` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `avts_movie`
--

DROP TABLE IF EXISTS `avts_movie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `avts_movie` (
  `idavt` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`idavt`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `avts_movie`
--

LOCK TABLES `avts_movie` WRITE;
/*!40000 ALTER TABLE `avts_movie` DISABLE KEYS */;
/*!40000 ALTER TABLE `avts_movie` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `blog_comments`
--

DROP TABLE IF EXISTS `blog_comments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `blog_comments` (
  `idBlog` int DEFAULT NULL,
  `idCmt` int NOT NULL AUTO_INCREMENT,
  `mess` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `idUser` int DEFAULT NULL,
  `dateCmt` datetime DEFAULT CURRENT_TIMESTAMP,
  `isActive` int NOT NULL,
  PRIMARY KEY (`idCmt`),
  KEY `FK__blogComme__idBlo__440B1D61` (`idBlog`),
  KEY `FK__blogComme__UserN__44FF419A` (`idUser`),
  CONSTRAINT `FK__blogComme__idBlo__440B1D61` FOREIGN KEY (`idBlog`) REFERENCES `blogs` (`idBlog`),
  CONSTRAINT `FK__blogComme__UserN__44FF419A` FOREIGN KEY (`idUser`) REFERENCES `accounts` (`idUser`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `blog_comments`
--

LOCK TABLES `blog_comments` WRITE;
/*!40000 ALTER TABLE `blog_comments` DISABLE KEYS */;
/*!40000 ALTER TABLE `blog_comments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `blogs`
--

DROP TABLE IF EXISTS `blogs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `blogs` (
  `idBlog` int NOT NULL AUTO_INCREMENT,
  `title` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `folder` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `datePost` datetime DEFAULT CURRENT_TIMESTAMP,
  `avt` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `dayDebut` datetime DEFAULT NULL,
  `isActive` int DEFAULT NULL,
  PRIMARY KEY (`idBlog`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `blogs`
--

LOCK TABLES `blogs` WRITE;
/*!40000 ALTER TABLE `blogs` DISABLE KEYS */;
/*!40000 ALTER TABLE `blogs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `chapters`
--

DROP TABLE IF EXISTS `chapters`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `chapters` (
  `idMovie` int NOT NULL,
  `stt` int NOT NULL,
  `opening` int DEFAULT NULL,
  PRIMARY KEY (`idMovie`,`stt`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chapters`
--

LOCK TABLES `chapters` WRITE;
/*!40000 ALTER TABLE `chapters` DISABLE KEYS */;
/*!40000 ALTER TABLE `chapters` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `follows`
--

DROP TABLE IF EXISTS `follows`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `follows` (
  `idUser` int DEFAULT NULL,
  `idMovie` int DEFAULT NULL,
  `timefollow` datetime DEFAULT CURRENT_TIMESTAMP,
  KEY `FK__follow__UserName__49C3F6B7` (`idUser`),
  CONSTRAINT `FK__follow__UserName__49C3F6B7` FOREIGN KEY (`idUser`) REFERENCES `accounts` (`idUser`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `follows`
--

LOCK TABLES `follows` WRITE;
/*!40000 ALTER TABLE `follows` DISABLE KEYS */;
/*!40000 ALTER TABLE `follows` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `genres`
--

DROP TABLE IF EXISTS `genres`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `genres` (
  `idGenre` int NOT NULL AUTO_INCREMENT,
  `description` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`idGenre`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `genres`
--

LOCK TABLES `genres` WRITE;
/*!40000 ALTER TABLE `genres` DISABLE KEYS */;
/*!40000 ALTER TABLE `genres` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `log`
--

DROP TABLE IF EXISTS `log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `log` (
  `idLog` int NOT NULL AUTO_INCREMENT,
  `level` int DEFAULT NULL,
  `user` int DEFAULT NULL,
  `ip` varchar(100) DEFAULT NULL,
  `src` varchar(100) DEFAULT NULL,
  `content` varchar(200) DEFAULT NULL,
  `createAt` datetime DEFAULT CURRENT_TIMESTAMP,
  `status` int DEFAULT NULL,
  PRIMARY KEY (`idLog`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `log`
--

LOCK TABLES `log` WRITE;
/*!40000 ALTER TABLE `log` DISABLE KEYS */;
/*!40000 ALTER TABLE `log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movie_avts`
--

DROP TABLE IF EXISTS `movie_avts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `movie_avts` (
  `idMovie` int DEFAULT NULL,
  `idavt` int DEFAULT NULL,
  KEY `movieavtid` (`idMovie`),
  KEY `idavtmovie` (`idavt`),
  CONSTRAINT `idavtmovie` FOREIGN KEY (`idavt`) REFERENCES `avts_movie` (`idavt`),
  CONSTRAINT `movieavtid` FOREIGN KEY (`idMovie`) REFERENCES `movies` (`idMovie`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movie_avts`
--

LOCK TABLES `movie_avts` WRITE;
/*!40000 ALTER TABLE `movie_avts` DISABLE KEYS */;
/*!40000 ALTER TABLE `movie_avts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movie_comments`
--

DROP TABLE IF EXISTS `movie_comments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `movie_comments` (
  `idComment` int NOT NULL AUTO_INCREMENT,
  `idUser` int DEFAULT NULL,
  `mess` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `idMovie` int DEFAULT NULL,
  `timecomment` datetime DEFAULT CURRENT_TIMESTAMP,
  `isActive` int NOT NULL,
  PRIMARY KEY (`idComment`),
  KEY `FK__comment__idMovie__46E78A0C` (`idMovie`),
  KEY `FK__comment__UserNam__47DBAE45` (`idUser`),
  CONSTRAINT `FK__comment__idMovie__46E78A0C` FOREIGN KEY (`idMovie`) REFERENCES `movies` (`idMovie`),
  CONSTRAINT `FK__comment__UserNam__47DBAE45` FOREIGN KEY (`idUser`) REFERENCES `accounts` (`idUser`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movie_comments`
--

LOCK TABLES `movie_comments` WRITE;
/*!40000 ALTER TABLE `movie_comments` DISABLE KEYS */;
/*!40000 ALTER TABLE `movie_comments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movie_genres`
--

DROP TABLE IF EXISTS `movie_genres`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `movie_genres` (
  `idMovie` int DEFAULT NULL,
  `idGenre` int DEFAULT NULL,
  KEY `movieid` (`idMovie`),
  KEY `idgenre` (`idGenre`),
  CONSTRAINT `idgenre` FOREIGN KEY (`idGenre`) REFERENCES `genres` (`idGenre`),
  CONSTRAINT `movieid` FOREIGN KEY (`idMovie`) REFERENCES `movies` (`idMovie`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movie_genres`
--

LOCK TABLES `movie_genres` WRITE;
/*!40000 ALTER TABLE `movie_genres` DISABLE KEYS */;
/*!40000 ALTER TABLE `movie_genres` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movie_producers`
--

DROP TABLE IF EXISTS `movie_producers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `movie_producers` (
  `idMovie` int DEFAULT NULL,
  `idproducer` int DEFAULT NULL,
  KEY `movieproducerid` (`idMovie`),
  KEY `movieproduceridpro` (`idproducer`),
  CONSTRAINT `movieproducerid` FOREIGN KEY (`idMovie`) REFERENCES `movies` (`idMovie`),
  CONSTRAINT `movieproduceridpro` FOREIGN KEY (`idproducer`) REFERENCES `producers` (`idproducer`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movie_producers`
--

LOCK TABLES `movie_producers` WRITE;
/*!40000 ALTER TABLE `movie_producers` DISABLE KEYS */;
/*!40000 ALTER TABLE `movie_producers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movies`
--

DROP TABLE IF EXISTS `movies`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `movies` (
  `idMovie` int NOT NULL AUTO_INCREMENT,
  `nameMovie` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `currentEpisode` int DEFAULT NULL,
  `totalEpisodes` int DEFAULT NULL,
  `descriptionVN` varchar(5000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `descriptionEN` varchar(5000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `dayadd` datetime DEFAULT CURRENT_TIMESTAMP,
  `isActive` int NOT NULL,
  PRIMARY KEY (`idMovie`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movies`
--

LOCK TABLES `movies` WRITE;
/*!40000 ALTER TABLE `movies` DISABLE KEYS */;
/*!40000 ALTER TABLE `movies` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `producers`
--

DROP TABLE IF EXISTS `producers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `producers` (
  `idproducer` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`idproducer`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `producers`
--

LOCK TABLES `producers` WRITE;
/*!40000 ALTER TABLE `producers` DISABLE KEYS */;
/*!40000 ALTER TABLE `producers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rates_movie`
--

DROP TABLE IF EXISTS `rates_movie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rates_movie` (
  `idMovie` int DEFAULT NULL,
  `idUser` int DEFAULT NULL,
  `score` int DEFAULT NULL,
  `timevote` datetime DEFAULT CURRENT_TIMESTAMP,
  KEY `FK__rate__idMovie__4AB81AF0` (`idMovie`),
  KEY `FK__rate__UserName__4BAC3F29` (`idUser`),
  CONSTRAINT `FK__rate__idMovie__4AB81AF0` FOREIGN KEY (`idMovie`) REFERENCES `movies` (`idMovie`),
  CONSTRAINT `FK__rate__UserName__4BAC3F29` FOREIGN KEY (`idUser`) REFERENCES `accounts` (`idUser`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rates_movie`
--

LOCK TABLES `rates_movie` WRITE;
/*!40000 ALTER TABLE `rates_movie` DISABLE KEYS */;
/*!40000 ALTER TABLE `rates_movie` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reply_comment_blog`
--

DROP TABLE IF EXISTS `reply_comment_blog`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reply_comment_blog` (
  `idBlog` int DEFAULT NULL,
  `idCmt` int DEFAULT NULL,
  `idUserCmt` int DEFAULT NULL,
  `idUserReply` int DEFAULT NULL,
  `mess` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `daycmt` datetime DEFAULT CURRENT_TIMESTAMP,
  `sttCmt` int NOT NULL AUTO_INCREMENT,
  `isActive` int NOT NULL,
  PRIMARY KEY (`sttCmt`),
  KEY `FK__replyComm__idBlo__4CA06362` (`idBlog`),
  KEY `FK__replyComm__idCmt__6383C8BA` (`idCmt`),
  KEY `FK__replyComm__UserN__6477ECF3` (`idUserCmt`),
  KEY `FK__replyComm__UserN__656C112C` (`idUserReply`),
  CONSTRAINT `FK__replyComm__idBlo__4CA06362` FOREIGN KEY (`idBlog`) REFERENCES `blogs` (`idBlog`),
  CONSTRAINT `FK__replyComm__idCmt__4D94879B` FOREIGN KEY (`idCmt`) REFERENCES `blog_comments` (`idCmt`),
  CONSTRAINT `FK__replyComm__idCmt__6383C8BA` FOREIGN KEY (`idCmt`) REFERENCES `blog_comments` (`idCmt`),
  CONSTRAINT `FK__replyComm__UserN__4E88ABD4` FOREIGN KEY (`idUserCmt`) REFERENCES `accounts` (`idUser`),
  CONSTRAINT `FK__replyComm__UserN__4F7CD00D` FOREIGN KEY (`idUserReply`) REFERENCES `accounts` (`idUser`),
  CONSTRAINT `FK__replyComm__UserN__6477ECF3` FOREIGN KEY (`idUserCmt`) REFERENCES `accounts` (`idUser`),
  CONSTRAINT `FK__replyComm__UserN__656C112C` FOREIGN KEY (`idUserReply`) REFERENCES `accounts` (`idUser`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reply_comment_blog`
--

LOCK TABLES `reply_comment_blog` WRITE;
/*!40000 ALTER TABLE `reply_comment_blog` DISABLE KEYS */;
/*!40000 ALTER TABLE `reply_comment_blog` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reply_comment_movie`
--

DROP TABLE IF EXISTS `reply_comment_movie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reply_comment_movie` (
  `idMovie` int DEFAULT NULL,
  `idComment` int DEFAULT NULL,
  `idUserCmt` int DEFAULT NULL,
  `idUserReply` int DEFAULT NULL,
  `mess` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `daycmt` datetime DEFAULT CURRENT_TIMESTAMP,
  `sttCmt` int NOT NULL AUTO_INCREMENT,
  `isActive` int NOT NULL,
  PRIMARY KEY (`sttCmt`),
  KEY `FK__replyComm__idBlo__4CA063621` (`idMovie`),
  KEY `FK__replyComm__idCmt__6383C8BA1` (`idComment`),
  KEY `FK__replyComm__UserN__6477ECF31` (`idUserCmt`),
  KEY `FK__replyComm__UserN__656C112C1` (`idUserReply`),
  CONSTRAINT `FK__replyComm__idBlo__4CA063621` FOREIGN KEY (`idMovie`) REFERENCES `movies` (`idMovie`),
  CONSTRAINT `FK__replyComm__idCmt__4D94879B1` FOREIGN KEY (`idComment`) REFERENCES `movie_comments` (`idComment`),
  CONSTRAINT `FK__replyComm__idCmt__6383C8BA1` FOREIGN KEY (`idComment`) REFERENCES `movie_comments` (`idComment`),
  CONSTRAINT `FK__replyComm__UserN__4E88ABD41` FOREIGN KEY (`idUserCmt`) REFERENCES `accounts` (`idUser`),
  CONSTRAINT `FK__replyComm__UserN__4F7CD00D1` FOREIGN KEY (`idUserReply`) REFERENCES `accounts` (`idUser`),
  CONSTRAINT `FK__replyComm__UserN__6477ECF31` FOREIGN KEY (`idUserCmt`) REFERENCES `accounts` (`idUser`),
  CONSTRAINT `FK__replyComm__UserN__656C112C1` FOREIGN KEY (`idUserReply`) REFERENCES `accounts` (`idUser`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reply_comment_movie`
--

LOCK TABLES `reply_comment_movie` WRITE;
/*!40000 ALTER TABLE `reply_comment_movie` DISABLE KEYS */;
/*!40000 ALTER TABLE `reply_comment_movie` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `roles` (
  `idrole` int NOT NULL AUTO_INCREMENT,
  `description` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`idrole`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` VALUES (1,'base User'),(4,'admin');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_views`
--

DROP TABLE IF EXISTS `user_views`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_views` (
  `idUser` int DEFAULT NULL,
  `idMovie` int DEFAULT NULL,
  `timewatch` datetime DEFAULT CURRENT_TIMESTAMP,
  KEY `userviewidmovie` (`idMovie`),
  KEY `userviewUserName` (`idUser`),
  CONSTRAINT `userviewidmovie` FOREIGN KEY (`idMovie`) REFERENCES `movies` (`idMovie`),
  CONSTRAINT `userviewUserName` FOREIGN KEY (`idUser`) REFERENCES `accounts` (`idUser`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_views`
--

LOCK TABLES `user_views` WRITE;
/*!40000 ALTER TABLE `user_views` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_views` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-02-24 13:24:24
