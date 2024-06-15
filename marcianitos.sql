-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         11.3.2-MariaDB - mariadb.org binary distribution
-- SO del servidor:              Win64
-- HeidiSQL Versión:             12.6.0.6765
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Volcando estructura de base de datos para marcianitosdb
CREATE DATABASE IF NOT EXISTS `marcianitosdb` /*!40100 DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci */;
USE `marcianitosdb`;

-- Volcando estructura para tabla marcianitosdb.inventario
CREATE TABLE IF NOT EXISTS `inventario` (
  `idUser` int(11) DEFAULT NULL,
  `idProduct` int(11) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- Volcando datos para la tabla marcianitosdb.inventario: ~6 rows (aproximadamente)
INSERT INTO `inventario` (`idUser`, `idProduct`, `quantity`) VALUES
	(1, 1, 3),
	(1, 1, 1),
	(4, 1, 1),
	(4, 1, 1),
	(4, 1, 1),
	(4, 1, 1);

-- Volcando estructura para tabla marcianitosdb.product
CREATE TABLE IF NOT EXISTS `product` (
  `idProduct` int(11) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `imatge` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- Volcando datos para la tabla marcianitosdb.product: ~2 rows (aproximadamente)
INSERT INTO `product` (`idProduct`, `name`, `description`, `price`, `imatge`) VALUES
	(1, 'Martillo\r\n', 'Tool', 50, 'https://static.wikia.nocookie.net/marvelcinematicuniverse/images/2/25/Mjolnir.png'),
	(2, 'Pico', 'Tool', 70, 'https://cdn-icons-png.flaticon.com/512/4813/4813227.png');

-- Volcando estructura para tabla marcianitosdb.user
CREATE TABLE IF NOT EXISTS `user` (
  `idUser` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `surname` varchar(50) DEFAULT NULL,
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `coins` double DEFAULT NULL,
  `fuel` int(11) DEFAULT NULL,
  `food` int(11) DEFAULT NULL,
  PRIMARY KEY (`idUser`),
  /*UNIQUE KEY `username` (`username`)*/
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci ROW_FORMAT=DYNAMIC;

-- Volcando datos para la tabla marcianitosdb.user: ~10 rows (aproximadamente)
INSERT INTO `user` (`idUser`, `name`, `surname`, `username`, `password`, `coins`, `fuel`, `food`) VALUES
	(1, 'Laura', 'Esquius', 'lidia2', '12345', 50, 45, 17),
	(2, 'carla', 'ab', 'carla3', '12345', 50, 45, 17),
	(3, 'Carla', 'Abascal', 'carla11', '12345', 100, 0, 0),
	(4, 'Laura', 'Fernandez', 'lauraa8', '56789', 50, 0, 0),
	(5, 'Mayra', 'Sanchez', 'mayra23', '12345', 100, 0, 0),
	(6, 'Juan', 'Lopez', 'juan10', '12345', 100, 0, 0),
	(7, 'Toni', 'Oller', 'toni1', '12345', 100, 0, 0),
	(9, 'Toni', 'Oller', 'toni3', '12345', 100, 0, 0),
	(10, 'Toni', 'Bote', 'toni23', '12345', 100, 0, 0),
	(11, 'Victor', 'Abascal', 'victor13', '12345', 100, 0, 0);

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
