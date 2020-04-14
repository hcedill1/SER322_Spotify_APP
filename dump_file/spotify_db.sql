-- MySQL dump 10.13  Distrib 8.0.19, for macos10.15 (x86_64)
--
-- Host: localhost    Database: spotify_db
-- ------------------------------------------------------
-- Server version	8.0.19

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `Album`
--

DROP TABLE IF EXISTS `Album`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Album` (
  `Album_ID` varchar(50) NOT NULL,
  `Title` varchar(100) DEFAULT NULL,
  `Artist_Name` varchar(100) DEFAULT NULL,
  `Album_Track` varchar(100) DEFAULT NULL,
  `Release_Date` varchar(30) DEFAULT NULL,
  `Genre_ID` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`Album_ID`),
  KEY `Genre_ID` (`Genre_ID`),
  CONSTRAINT `album_ibfk_1` FOREIGN KEY (`Genre_ID`) REFERENCES `Genre` (`Genre_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Album`
--

LOCK TABLES `Album` WRITE;
/*!40000 ALTER TABLE `Album` DISABLE KEYS */;
INSERT INTO `Album` VALUES ('1111','title1','artist1','album1','release1','g1');
/*!40000 ALTER TABLE `Album` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ARTIST`
--

DROP TABLE IF EXISTS `ARTIST`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ARTIST` (
  `Artist_ID` varchar(50) NOT NULL,
  `Artist_Name` varchar(100) DEFAULT NULL,
  `Fans` varchar(100) DEFAULT NULL,
  `Track_Name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`Artist_ID`),
  KEY `Track_Name` (`Track_Name`),
  CONSTRAINT `artist_ibfk_1` FOREIGN KEY (`Track_Name`) REFERENCES `Tracks` (`Track_Name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ARTIST`
--

LOCK TABLES `ARTIST` WRITE;
/*!40000 ALTER TABLE `ARTIST` DISABLE KEYS */;
INSERT INTO `ARTIST` VALUES ('AritsID1','ArtistName1','Fans1','Track1');
/*!40000 ALTER TABLE `ARTIST` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Genre`
--

DROP TABLE IF EXISTS `Genre`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Genre` (
  `Genre_ID` varchar(50) NOT NULL,
  `Type` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`Genre_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Genre`
--

LOCK TABLES `Genre` WRITE;
/*!40000 ALTER TABLE `Genre` DISABLE KEYS */;
INSERT INTO `Genre` VALUES ('G1','type1');
/*!40000 ALTER TABLE `Genre` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Playlist`
--

DROP TABLE IF EXISTS `Playlist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Playlist` (
  `Playlist_ID` varchar(50) NOT NULL,
  `Playlist_Title` varchar(100) DEFAULT NULL,
  `Playlist_Duration` varchar(20) DEFAULT NULL,
  `Date_Added` varchar(30) DEFAULT NULL,
  `User_Playlist_ID` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`Playlist_ID`),
  KEY `User_Playlist_ID` (`User_Playlist_ID`),
  CONSTRAINT `playlist_ibfk_1` FOREIGN KEY (`User_Playlist_ID`) REFERENCES `User` (`User_Playlist_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Playlist`
--

LOCK TABLES `Playlist` WRITE;
/*!40000 ALTER TABLE `Playlist` DISABLE KEYS */;
INSERT INTO `Playlist` VALUES ('PlaylistID1','PlaylistTitle1','456','date1','UserID1');
/*!40000 ALTER TABLE `Playlist` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Popularity`
--

DROP TABLE IF EXISTS `Popularity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Popularity` (
  `Followers` varchar(100) DEFAULT NULL,
  `Likes` varchar(30) DEFAULT NULL,
  `Track_Name` varchar(100) DEFAULT NULL,
  KEY `Track_Name` (`Track_Name`),
  CONSTRAINT `popularity_ibfk_1` FOREIGN KEY (`Track_Name`) REFERENCES `TRACKS` (`Track_Name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Popularity`
--

LOCK TABLES `Popularity` WRITE;
/*!40000 ALTER TABLE `Popularity` DISABLE KEYS */;
INSERT INTO `Popularity` VALUES ('Followers1','Likes1','Track1');
/*!40000 ALTER TABLE `Popularity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Tracks`
--

DROP TABLE IF EXISTS `Tracks`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Tracks` (
  `Track_Name` varchar(100) NOT NULL,
  `Track_Duration` varchar(20) DEFAULT NULL,
  `Album_ID` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`Track_Name`),
  KEY `Album_ID` (`Album_ID`),
  CONSTRAINT `tracks_ibfk_1` FOREIGN KEY (`Album_ID`) REFERENCES `Album` (`Album_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Tracks`
--

LOCK TABLES `Tracks` WRITE;
/*!40000 ALTER TABLE `Tracks` DISABLE KEYS */;
INSERT INTO `Tracks` VALUES ('Track1','123','1111');
/*!40000 ALTER TABLE `Tracks` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `USER`
--

DROP TABLE IF EXISTS `USER`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `USER` (
  `User_Playlist_ID` varchar(50) NOT NULL,
  `Followers` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`User_Playlist_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `USER`
--

LOCK TABLES `USER` WRITE;
/*!40000 ALTER TABLE `USER` DISABLE KEYS */;
INSERT INTO `USER` VALUES ('UserID1','Follower1');
/*!40000 ALTER TABLE `USER` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-04-13 19:25:15
