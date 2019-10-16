-- MySQL dump 10.13  Distrib 8.0.18, for Win64 (x86_64)
--
-- Host: localhost    Database: academy_portal
-- ------------------------------------------------------
-- Server version	8.0.18

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
-- Table structure for table `batch_allocation1`
--

DROP TABLE IF EXISTS `batch_allocation1`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `batch_allocation1` (
  `Bat_ID` varchar(45) NOT NULL,
  `Dom_ID` varchar(45) NOT NULL,
  `Fac_ID` varchar(45) NOT NULL,
  `Bat_Start_Date` date DEFAULT NULL,
  `Bat_End_Date` date DEFAULT NULL,
  `Bat_Closed_Date` date DEFAULT NULL,
  PRIMARY KEY (`Bat_ID`),
  KEY `Dom_ID` (`Dom_ID`),
  KEY `Fac_ID` (`Fac_ID`),
  CONSTRAINT `Dom_ID` FOREIGN KEY (`Dom_ID`) REFERENCES `domain_master` (`Dom_ID`),
  CONSTRAINT `batch_allocation1_ibfk_1` FOREIGN KEY (`Fac_ID`) REFERENCES `faculty_registration` (`Fac_ID`),
  CONSTRAINT `batch_allocation1_ibfk_2` FOREIGN KEY (`Fac_ID`) REFERENCES `faculty_registration` (`Fac_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `batch_allocation1`
--

LOCK TABLES `batch_allocation1` WRITE;
/*!40000 ALTER TABLE `batch_allocation1` DISABLE KEYS */;
/*!40000 ALTER TABLE `batch_allocation1` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `domain_master`
--

DROP TABLE IF EXISTS `domain_master`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `domain_master` (
  `Dom_ID` varchar(45) NOT NULL,
  `Mod_Domain_Desc` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`Dom_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `domain_master`
--

LOCK TABLES `domain_master` WRITE;
/*!40000 ALTER TABLE `domain_master` DISABLE KEYS */;
/*!40000 ALTER TABLE `domain_master` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `faculty_points1`
--

DROP TABLE IF EXISTS `faculty_points1`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `faculty_points1` (
  `Bat_ID` varchar(45) NOT NULL,
  `Fac_ID` varchar(45) NOT NULL,
  `Credit_Points` int(11) DEFAULT NULL,
  `Grade` varchar(45) DEFAULT NULL,
  KEY `Bat_ID` (`Bat_ID`),
  KEY `Fac_ID` (`Fac_ID`),
  CONSTRAINT `Bat_ID` FOREIGN KEY (`Bat_ID`) REFERENCES `batch_allocation1` (`Bat_ID`),
  CONSTRAINT `faculty_points1_ibfk_1` FOREIGN KEY (`Fac_ID`) REFERENCES `faculty_registration` (`Fac_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `faculty_points1`
--

LOCK TABLES `faculty_points1` WRITE;
/*!40000 ALTER TABLE `faculty_points1` DISABLE KEYS */;
/*!40000 ALTER TABLE `faculty_points1` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `faculty_registration`
--

DROP TABLE IF EXISTS `faculty_registration`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `faculty_registration` (
  `Fac_ID` varchar(45) NOT NULL,
  `Fac_Name` varchar(45) DEFAULT NULL,
  `Fac_Qualification` varchar(45) DEFAULT NULL,
  `Fac_Year_Of_Exp` int(11) DEFAULT NULL,
  `Fac_Contact` decimal(10,0) DEFAULT NULL,
  `Fac_Email` varchar(45) DEFAULT NULL,
  `Fac_Address` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`Fac_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `faculty_registration`
--

LOCK TABLES `faculty_registration` WRITE;
/*!40000 ALTER TABLE `faculty_registration` DISABLE KEYS */;
INSERT INTO `faculty_registration` VALUES ('ram#001','ram','MTECH',10,9897044333,'as@dgf.com','asdrewe');
/*!40000 ALTER TABLE `faculty_registration` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `faculty_skill`
--

DROP TABLE IF EXISTS `faculty_skill`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `faculty_skill` (
  `Fac_ID` varchar(45) NOT NULL,
  `Fac_Skill` varchar(45) DEFAULT NULL,
  `Fac_Certification` varchar(45) DEFAULT NULL,
  KEY `Fac_ID` (`Fac_ID`),
  CONSTRAINT `Fac_ID` FOREIGN KEY (`Fac_ID`) REFERENCES `faculty_registration` (`Fac_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `faculty_skill`
--

LOCK TABLES `faculty_skill` WRITE;
/*!40000 ALTER TABLE `faculty_skill` DISABLE KEYS */;
INSERT INTO `faculty_skill` VALUES ('ram#001','C++','Y');
/*!40000 ALTER TABLE `faculty_skill` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `login`
--

DROP TABLE IF EXISTS `login`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `login` (
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `login`
--

LOCK TABLES `login` WRITE;
/*!40000 ALTER TABLE `login` DISABLE KEYS */;
INSERT INTO `login` VALUES ('ad','ad');
/*!40000 ALTER TABLE `login` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `report_details1`
--

DROP TABLE IF EXISTS `report_details1`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `report_details1` (
  `Bat_ID` varchar(45) NOT NULL,
  `Fac_ID` varchar(45) NOT NULL,
  `Weekly_Report` int(11) DEFAULT NULL,
  `Mock_Test` int(11) DEFAULT NULL,
  `BHS_Report` varchar(45) DEFAULT NULL,
  `Inn_Project_Title` varchar(45) DEFAULT NULL,
  `Inn_Project_Desc` varchar(45) DEFAULT NULL,
  `Inn_Project_Status` varchar(45) DEFAULT NULL,
  KEY `Fac_ID` (`Fac_ID`),
  KEY `Bat_ID` (`Bat_ID`),
  CONSTRAINT `report_details1_ibfk_1` FOREIGN KEY (`Fac_ID`) REFERENCES `faculty_registration` (`Fac_ID`),
  CONSTRAINT `report_details1_ibfk_2` FOREIGN KEY (`Bat_ID`) REFERENCES `batch_allocation1` (`Bat_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `report_details1`
--

LOCK TABLES `report_details1` WRITE;
/*!40000 ALTER TABLE `report_details1` DISABLE KEYS */;
/*!40000 ALTER TABLE `report_details1` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `technology_master`
--

DROP TABLE IF EXISTS `technology_master`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `technology_master` (
  `Tech_ID` varchar(45) NOT NULL,
  `Mod_Tech_Name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`Tech_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `technology_master`
--

LOCK TABLES `technology_master` WRITE;
/*!40000 ALTER TABLE `technology_master` DISABLE KEYS */;
/*!40000 ALTER TABLE `technology_master` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-10-16 17:08:19
