-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 07-10-2023 a las 18:45:53
-- Versión del servidor: 10.4.19-MariaDB
-- Versión de PHP: 8.0.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `register`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `thirdapptable`
--

CREATE TABLE `thirdapptable` (
  `codeId` varchar(30) NOT NULL,
  `thirdapp` varchar(30) NOT NULL,
  `RelationId` varchar(30) NOT NULL,
  `acronym` varchar(30) NOT NULL,
  `creationDate` varchar(30) NOT NULL,
  `updateDate` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `thirdapptable`
--

INSERT INTO `thirdapptable` (`codeId`, `thirdapp`, `RelationId`, `acronym`, `creationDate`, `updateDate`) VALUES
('100646', 'Johan', 'relation', 'Servicio Premium', '2023-09-17T09:05:00.954939200', ''),
('1006460', 'Johan Alexis', 'probando', 'Servicio Premium', '2023-10-07T08:52:33.890673', '2023-10-07T09:04:54.214314600');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `thirdapptable`
--
ALTER TABLE `thirdapptable`
  ADD PRIMARY KEY (`codeId`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
