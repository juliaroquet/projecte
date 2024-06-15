CREATE TABLE IF NOT EXISTS `inventario` (
  `idUser` int(11) DEFAULT NULL,
  `idProduct` int(11) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL
);

LOCK TABLES `inventario` WRITE;
INSERT INTO `inventario` (`idUser`, `idProduct`, `quantity`) VALUES
	(1, 1, 3),
	(1, 1, 1),
	(4, 1, 1),
	(4, 1, 1),
	(4, 1, 1),
	(4, 1, 1);
UNLOCK TABLES;

CREATE TABLE IF NOT EXISTS `product` (
  `idProduct` int(11) DEFAULT NULL PRIMARY KEY,
  `name` varchar(50) DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `imatge` varchar(200) DEFAULT NULL,
);

LOCK TABLES `product` WRITE;
INSERT INTO `product` (`idProduct`, `name`, `description`, `price`, `imatge`) VALUES
	(1, 'Martillo\r\n', 'Tool', 50, 'https://cdn-icons-png.flaticon.com/512/5414/5414745.png'),
	(2, 'Pico', 'Tool', 70, 'https://cdn-icons-png.flaticon.com/512/664/664112.png'),
	(3, 'Pistola Laser','Tool to save the alien',70, 'https://cdn-icons-png.flaticon.com/512/2949/2949166.png'),
	(4, 'Espada','Tool to save the alien',50, 'https://cdn-icons-png.flaticon.com/512/3275/3275467.png');

UNLOCK TABLES;


CREATE TABLE IF NOT EXISTS `user` (
  `idUser` int(10) AUTO_INCREMENT PRIMARY KEY,
  `name` varchar(50) DEFAULT NULL,
  `surname` varchar(50) DEFAULT NULL,
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `coins` double DEFAULT NULL,
  `fuel` int(11) DEFAULT NULL,
  `food` int(11) DEFAULT NULL,

  /*UNIQUE KEY `username` (`username`)*/
) ;


LOCK TABLES `user` WRITE;
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
UNLOCK TABLES;
