CREATE DATABASE  IF NOT EXISTS `bookstore_final` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `bookstore_final`;
-- MySQL dump 10.13  Distrib 5.6.13, for osx10.6 (i386)
--
-- Host: localhost    Database: bookstore_final
-- ------------------------------------------------------
-- Server version	5.5.37

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
-- Table structure for table `address`
--

DROP TABLE IF EXISTS `address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `address` (
  `address_id` int(11) NOT NULL AUTO_INCREMENT,
  `line_1` varchar(255) NOT NULL,
  `line_2` varchar(255) NOT NULL,
  `city` varchar(255) NOT NULL,
  `state` varchar(2) NOT NULL,
  `zip_code` int(5) NOT NULL,
  PRIMARY KEY (`address_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `address`
--

LOCK TABLES `address` WRITE;
/*!40000 ALTER TABLE `address` DISABLE KEYS */;
INSERT INTO `address` VALUES (1,'1353 S 56th Street','Apt 1','Milwaukee','WI',12345),(2,'1353 S 56th Street','None','West Allis','WI',53214),(3,'1353 S 56th Street','None','West Allis','WI',53214),(4,'1353 S 56th Street','None','West Allis','WI',53214),(5,'1353 S 56th Street','None','West Allis','WI',53214),(6,'1353 S 56th Street','None','West Allis','WI',53214),(7,'1353 S 56th Street','None','West Allis','WI',42143),(8,'1353 S 56th Street','None','West Allis','WI',42143),(9,'1353 S 56th Street','None','West Allis','WI',12345),(10,'1353 S 56th Street','None','West Allis','WI',53214),(11,'1353 S 56th Street','Apt 1','Milwaukee','WI',53214),(12,'5555 s 55','none','West Allis','WI',53214);
/*!40000 ALTER TABLE `address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `authorities`
--

DROP TABLE IF EXISTS `authorities`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `authorities` (
  `username` varchar(50) NOT NULL,
  `authority` varchar(50) NOT NULL DEFAULT 'ROLE_USER',
  `authorities_id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`authorities_id`),
  UNIQUE KEY `ix_auth_username` (`username`,`authority`),
  CONSTRAINT `fk_authorities_users` FOREIGN KEY (`username`) REFERENCES `users` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `authorities`
--

LOCK TABLES `authorities` WRITE;
/*!40000 ALTER TABLE `authorities` DISABLE KEYS */;
INSERT INTO `authorities` VALUES ('admin@isp.com','ROLE_ADMIN',1),('bar@isp.com','ROLE_CUSTOMER',19),('blah@isp.com','ROLE_CUSTOMER',16),('blahblah@isp.com','ROLE_CUSTOMER',17),('customer@isp.com','ROLE_CUSTOMER',9),('foo@isp.com','ROLE_CUSTOMER',18),('jack@isp.com','ROLE_CUSTOMER',11),('jason.scherer.1984@gmail.com','ROLE_CUSTOMER',4),('jason.scherer.asfdsd1984@gmail.com','ROLE_CUSTOMER',8),('jason.scherer@gmail.com','ROLE_CUSTOMER',5),('jason@isp.com','ROLE_CUSTOMER',2),('jasonschersdfer@gmail.com','ROLE_CUSTOMER',6),('jasonschersdfsfsder@gmail.com','ROLE_CUSTOMER',7),('Jimmy@isp.com','ROLE_CUSTOMER',13),('john@isp.com','ROLE_CUSTOMER',10),('mine@isp.com','ROLE_CUSTOMER',15),('test@isp.com','ROLE_CUSTOMER',3),('testing@isp.eu','ROLE_CUSTOMER',14),('tim@isp.com','ROLE_CUSTOMER',12);
/*!40000 ALTER TABLE `authorities` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customers`
--

DROP TABLE IF EXISTS `customers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customers` (
  `customer_id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(255) NOT NULL,
  `last_name` varchar(255) NOT NULL,
  `customer_email` varchar(255) NOT NULL,
  `address_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`customer_id`),
  UNIQUE KEY `customer_email` (`customer_email`),
  KEY `address_id` (`address_id`),
  CONSTRAINT `customers_ibfk_1` FOREIGN KEY (`address_id`) REFERENCES `address` (`address_id`)
) ENGINE=InnoDB AUTO_INCREMENT=60 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customers`
--

LOCK TABLES `customers` WRITE;
/*!40000 ALTER TABLE `customers` DISABLE KEYS */;
INSERT INTO `customers` VALUES (1,'Jason','Scherer12','jason@isp.com',1),(2,'Jason','Scherer','test@isp.com',2),(3,'Jason','Scherer','jason.scherer.1984@gmail.com',3),(5,'Jason','Scherer','jason.scherer@gmail.com',4),(6,'Jason','Scherer','jasonschersdfer@gmail.com',5),(8,'Jason','Scherer','jasonschersdfsfsder@gmail.com',6),(56,'Jason','Scherer','jason.scherer.asfdsd1984@gmail.com',9),(57,'Jason','Scherer','customer@isp.com',10),(58,'John','Smith','john@isp.com',11),(59,'Jack','Frost','jack@isp.com',12);
/*!40000 ALTER TABLE `customers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `orders` (
  `order_id` int(11) NOT NULL AUTO_INCREMENT,
  `customer_id` int(11) NOT NULL,
  `date_ordered` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`order_id`),
  KEY `customer_id_idx` (`customer_id`),
  CONSTRAINT `customer_id` FOREIGN KEY (`customer_id`) REFERENCES `customers` (`customer_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=96 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (63,57,'2014-05-10 01:24:28'),(64,57,'2014-05-10 01:31:13'),(65,57,'2014-05-10 01:31:13'),(66,57,'2014-05-10 01:31:13'),(67,57,'2014-05-10 01:31:13'),(68,57,'2014-05-10 01:31:13'),(69,57,'2014-05-10 01:31:13'),(70,57,'2014-05-10 01:31:13'),(71,57,'2014-05-10 01:31:13'),(72,57,'2014-05-10 01:36:56'),(73,57,'2014-05-10 01:37:52'),(74,57,'2014-05-10 01:37:52'),(75,57,'2014-05-12 22:07:03'),(76,1,'2014-05-17 01:39:00'),(77,1,'2014-05-17 03:12:10'),(78,57,'2014-05-17 03:13:22'),(79,57,'2014-05-17 03:17:01'),(80,58,'2014-05-17 03:22:36'),(81,58,'2014-05-17 12:51:23'),(82,58,'2014-05-17 20:54:57'),(83,58,'2014-05-17 20:58:27'),(84,58,'2014-05-17 20:58:27'),(85,58,'2014-05-17 20:58:27'),(86,58,'2014-05-17 21:00:06'),(87,58,'2014-05-17 21:00:06'),(88,58,'2014-05-17 21:00:06'),(89,58,'2014-05-17 21:00:06'),(90,58,'2014-05-17 21:00:06'),(91,58,'2014-05-17 21:00:06'),(92,58,'2014-05-17 21:05:30'),(93,58,'2014-05-17 21:10:35'),(94,58,'2014-05-17 21:11:52'),(95,57,'2014-05-18 01:42:30');
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders_products`
--

DROP TABLE IF EXISTS `orders_products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `orders_products` (
  `order_id` int(11) NOT NULL,
  `product_id` int(11) NOT NULL,
  `qty` int(11) NOT NULL,
  KEY `product_id` (`product_id`),
  KEY `orders_products_order_id_idx` (`order_id`),
  CONSTRAINT `orders_products_ibfk_2` FOREIGN KEY (`product_id`) REFERENCES `products` (`product_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `orders_products_ibfk_3` FOREIGN KEY (`product_id`) REFERENCES `products` (`product_id`),
  CONSTRAINT `orders_products_order_id` FOREIGN KEY (`order_id`) REFERENCES `orders` (`order_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders_products`
--

LOCK TABLES `orders_products` WRITE;
/*!40000 ALTER TABLE `orders_products` DISABLE KEYS */;
INSERT INTO `orders_products` VALUES (65,1,1),(66,1,1),(67,1,1),(68,1,1),(69,1,1),(77,3,1),(77,1,1),(78,3,1),(78,3,1),(79,3,1),(79,3,1),(80,3,1),(80,1,1),(81,1,1),(81,1,1),(81,3,1),(81,3,1),(82,3,1),(82,1,1),(84,1,1),(84,3,1),(85,1,1),(85,3,1),(86,1,1),(86,3,1),(87,3,1),(87,1,1),(88,3,1),(88,1,1),(90,3,1),(90,1,1),(91,1,1),(92,1,1),(93,3,1),(94,3,1),(95,3,1);
/*!40000 ALTER TABLE `orders_products` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `products`
--

DROP TABLE IF EXISTS `products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `products` (
  `product_id` int(11) NOT NULL AUTO_INCREMENT,
  `product_name` varchar(255) NOT NULL,
  `product_desc` varchar(255) NOT NULL,
  `product_price` decimal(4,0) NOT NULL,
  `qtyInStock` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `products`
--

LOCK TABLES `products` WRITE;
/*!40000 ALTER TABLE `products` DISABLE KEYS */;
INSERT INTO `products` VALUES (1,'1984','Big Brother Government',13,10),(3,'Dracula','The Vampire book',13,12),(5,'Frankenstien','A story about a pieced together person.',13,112);
/*!40000 ALTER TABLE `products` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `username` varchar(255) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `enabled` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES ('admin@isp.com','518794af334479bec993c52b9b7671cd667f6731f1f1d5bfeee7d3a7c2a684b07073c3907bbcf4cd018fa1adb4217aa145fc7919e6a1fb21c91062dc2fc07ca2',1),('bar@isp.com','c9873cbe06b9ff34ed0bfa7abdac96151a025bbd25abdb06e49f1921d34f8d940d8be36a9c51848bbe5518ef54d93e18dc939e0ebc5c0705c7253b6105ca7077',1),('blah@isp.com','19eccef09e869d2559005444afa63fe8f563db56ede7a4bbe0eb9308a1c5a89694a18512f97638b66fd52647fcaaf83cd3c8d157e36474f8eabba26b360f32bc',1),('blahblah@isp.com','9392602174fd9714441844af18109fcc21f388c1952cced095fdfa09770181614fd1d2f95e5330eda56812468050599c54e8bac2c1d6da341a5e7069b2fd9266',1),('customer@isp.com','8d14c3c1d53cb9a39eeca8571b6974262d84e6afd06db90d9163d9bcf44cb014ef1ed2cbe7db7f4586f48940ab0795f09314c9a20ce7d4299c1322f6585957cb',1),('foo@isp.com','fee67aae37b83a761efe0c086d1e95ad8536d0189cc36c9f10bde25c6a8c17920e25034a2988f91c35725262a19f8710cb4cf685c9a7981ded4eba017a27c767',1),('jack@isp.com','a7258dc4a342f48e2616e75ec04f8a1da3280449210eed37898dcc32cf616551fc0eb4cc100acc3a5af7e75b192fc6f9d238810934f8a0585b4ca132b83f963b',1),('jason.scherer.1984@gmail.com','24fcf67db60610c870e94851e5af74773637a92a077bedb724a8fe6a531849aa3f39d8b2c8b7cd2313f2c26a1ee5b913f8f96c8fda99b984ce82c62a6c734cf4',1),('jason.scherer.asfdsd1984@gmail.com','77e00c8aa9fb376df5b21aebe021b75eb917f8001fae8e18bbcd8cd44af4c199c22c20aa38555989c795dfb24fee481e1afcb46f1b6af14328d0effb132474de',1),('jason.scherer@gmail.com','8418de8575a19daa21b7e796891a78f44a7189a36c086b307ce251ae42226ee4e86a3603cb4e542483b5b9b0cbfb4607151ce6568a45d30a30589710ed910d8d',1),('jason@isp.com','841d670b5242527e2641bd7446a74f27b4df8ed0d74f3dd92d3694ffb023fcc2a05e26187347c4ac8fd98381056969c75451ed1ecab2c1b61301b46eacf1162a',1),('jasonschersdfer@gmail.com','a93e2c958bdd5f5ce46b0ad9562f2d3f11b0868c679eceeaf29b5432c3771495b2c28580692a492ecc82cfcdc0963e8e8aba73311fbadfa20c52e87defab2af8',1),('jasonschersdfsfsder@gmail.com','b5f1fc361494f96c5235e09717bba790310bd9faadaebf3500d5722dae0654637fce5bc2ffc639b5a0364f9abf6e88f291a05bc5a3caf3c882c7e24788c53830',1),('Jimmy@isp.com','588f15d66ba2f2771fb8d77a58826961689adcc04622641a104d22bdd0ff02caf84280e7e4ebf327082ba9e6bfa8b33f9fe5b6083b35a9dda81e2dea244d6032',1),('john@isp.com','508c448f0618a5d3c406aa0702f8453f7343a5dd7e9b1a276815896c70c670b6d941ad33e01ba92909d34e4a066f4d0d147c707119388e434f416bf90aeeee9e',1),('mine@isp.com','557aacaa1491ea3010760d7bfe7c9ad5782df85875bdbae272b7b32775d3b2b2abbbc956249097620c7b2bf3589df0e1c93866bb478534b4b951dcfe2acae5cf',1),('test@isp.com','47e50cc9573ed4925d2242328bf19fe6acd6c7544971da740ae020954a0cc87d38378d595c8a3a1c9b9513fe7d3b09c8fe8c76fa2bbf70cb047b01ec784ddabc',1),('testing@isp.eu','f7821e54d733918e7c2b5fc9f322d888287295a9b8202ee69777437635fa61690ebe566745f7124c2ada98794e82882c4312e7fab22aed0259a0d2ade4f62012',1),('tim@isp.com','84d4425b44c46bcf38b7c3b86132a021f41b0bbe17109dd4cfc5eeda34c5492c1311010df2a27a9c462859de34806b1104f340b0e801c01c97b8b3b03a699132',1);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-05-18 22:56:32
