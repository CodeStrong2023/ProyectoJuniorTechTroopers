-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         8.0.34 - MySQL Community Server - GPL
-- SO del servidor:              Win64
-- HeidiSQL Versión:             12.5.0.6677
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Volcando estructura de base de datos para trooper_stay
CREATE DATABASE IF NOT EXISTS `trooper_stay` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `trooper_stay`;

-- Volcando estructura para tabla trooper_stay.hospedajes
CREATE TABLE IF NOT EXISTS `hospedajes` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `tipo` int DEFAULT NULL,
  `capacidad` int DEFAULT NULL,
  `localizacion` varchar(50) DEFAULT NULL,
  `precio_por_noche` float DEFAULT NULL,
  `estado` binary(10) DEFAULT NULL,
  `id_usuario` int DEFAULT NULL,
  `id_usuario_inquilino` int DEFAULT NULL,
  `estadia` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_usuario` (`id_usuario`),
  CONSTRAINT `id_usuario` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Volcando datos para la tabla trooper_stay.hospedajes: ~0 rows (aproximadamente)

-- Volcando estructura para tabla trooper_stay.usuarios
CREATE TABLE IF NOT EXISTS `usuarios` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre_de_usuario` varchar(50) DEFAULT NULL,
  `contrasenia` varchar(50) DEFAULT NULL,
  `correo` varchar(50) DEFAULT NULL,
  `edad` int DEFAULT NULL,
  `nombre` varchar(50) DEFAULT NULL,
  `apellido` varchar(50) DEFAULT NULL,
  `saldo` float DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Volcando datos para la tabla trooper_stay.usuarios: ~3 rows (aproximadamente)
INSERT INTO `usuarios` (`id`, `nombre_de_usuario`, `contrasenia`, `correo`, `edad`, `nombre`, `apellido`, `saldo`) VALUES
	(1, 'Roberto30', '1234', 'roberto5@gmail.com', 45, 'Roberto', 'Figurea', 100000),
	(2, 'Facundo', '1234', 'corre@.com', 43, 'Facundo', 'Garlopa', 1000000),
	(8, 'Makarov342', '1234', 'juan@cristo.rey', 20, 'Jose', 'Sajnovsky', 30000);

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
