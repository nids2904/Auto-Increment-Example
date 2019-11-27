-- MySQL dump 10.13  Distrib 8.0.18, for Win64 (x86_64)
--
-- Host: localhost    
-- ------------------------------------------------------
-- Server version	8.0.18



-- database : test

-- 
-- Table structure for table `number`
--

DROP TABLE IF EXISTS `number`;

CREATE TABLE `number` (
  `id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


--
-- Dumping data for table `number`
--

LOCK TABLES `number` WRITE;
INSERT INTO `number` VALUES (0);
UNLOCK TABLES;
