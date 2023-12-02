-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 02-12-2023 a las 02:25:25
-- Versión del servidor: 10.1.38-MariaDB
-- Versión de PHP: 7.1.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `serviciotecnico`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `aplicaciones`
--

CREATE TABLE `aplicaciones` (
  `idAplicacion` int(2) NOT NULL,
  `nombre` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `aplicaciones`
--

INSERT INTO `aplicaciones` (`idAplicacion`, `nombre`) VALUES
(1, 'Tango'),
(2, 'SAP'),
(3, 'Trello');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clientes`
--

CREATE TABLE `clientes` (
  `idCliente` int(4) NOT NULL,
  `apellido` varchar(50) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `cuit` bigint(11) NOT NULL,
  `razonSocial` varchar(50) NOT NULL,
  `mail` varchar(100) NOT NULL,
  `estado` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `clientes`
--

INSERT INTO `clientes` (`idCliente`, `apellido`, `nombre`, `cuit`, `razonSocial`, `mail`, `estado`) VALUES
(1556, 'Diaz', 'Ángel Antonio', 20287442569, 'Solarix Tech SA', 'angant@gmail.com', 1),
(1557, 'Robledo', 'Lucía Elmira', 16245454629, 'Vinchuca Records', 'vinchucarecords@hotmail.com', 1),
(1558, 'Belloso', 'Pedro Ramiro', 22233449574, 'T&R Soluciones', 'tyrsoluciones@tr.com', 1),
(1559, 'Talamonti', 'Inés Gimena', 25392548111, 'Chap', 'chapservice@chap.com', 1),
(1560, 'Constantini', 'Lidia Erminda', 26415856587, 'AZ-Cloud-Services', 'az-cloud@az.com', 1),
(1561, 'Zanabria', 'Gustavo Manuel', 21269871232, 'Oficina Virtual Argentina', 'oficinavirtual@hotmail.com', 1),
(1562, 'Panuchi', 'Matilde Vanina', 18243328528, 'Pyramidal Scam SRL', 'pyramidal@gmail.com', 1),
(1563, 'Fausto', 'Juan Pablo', 24361597530, 'El Rey del Coso', 'reycoso@hotmail.com', 1),
(1564, 'Rizzi', 'Rebeca Rocío', 19276612551, 'Empanadas Salteñas & cryptos', 'empanaditas@gmail.com', 1),
(1565, 'Flosser', 'Daniela Anahí', 22295141750, 'P&G&R&T Vasos plásticos', 'plasticos@gmail.com', 1),
(1566, 'Soto', 'Raúl Armando', 27392020203, 'Bitter Bet, Bett...', 'bit@bitter.bit', 1),
(1567, 'Quinp', 'Sandro Timoteo', 25386452137, 'BOLK SA', 'bolk@bolksa.com', 1),
(1568, 'Cardozo', 'Luis Enrique', 16153775883, 'Aceituna Virtual', 'aceitunardi@gmail.com', 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `comercial`
--

CREATE TABLE `comercial` (
  `idComercial` int(4) NOT NULL,
  `password` varchar(8) NOT NULL,
  `apellido` varchar(50) NOT NULL,
  `nombre` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `comercial`
--

INSERT INTO `comercial` (`idComercial`, `password`, `apellido`, `nombre`) VALUES
(4556, '12345678', 'Coloccini', 'Nilda Florencia'),
(4557, '87654321', 'Hass', 'Sara Anabela');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `entorno`
--

CREATE TABLE `entorno` (
  `idEntorno` int(2) NOT NULL,
  `nombre` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `entorno`
--

INSERT INTO `entorno` (`idEntorno`, `nombre`) VALUES
(1, 'Windows'),
(2, 'Mac'),
(3, 'Linux'),
(4, 'Navegador');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `especialidades`
--

CREATE TABLE `especialidades` (
  `idEspecialidad` int(2) NOT NULL,
  `idEntorno` int(2) NOT NULL,
  `idAplicacion` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `especialidades`
--

INSERT INTO `especialidades` (`idEspecialidad`, `idEntorno`, `idAplicacion`) VALUES
(1, 1, 1),
(2, 1, 2),
(3, 2, 1),
(4, 2, 2),
(5, 3, 1),
(6, 3, 2),
(7, 4, 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `especialidades_tecnicos`
--

CREATE TABLE `especialidades_tecnicos` (
  `idEspecialidades_tecnicos` int(4) NOT NULL,
  `idTecnico` int(4) NOT NULL,
  `idEspecialidad` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `especialidades_tecnicos`
--

INSERT INTO `especialidades_tecnicos` (`idEspecialidades_tecnicos`, `idTecnico`, `idEspecialidad`) VALUES
(1, 2556, 1),
(2, 2556, 2),
(3, 2557, 7),
(4, 2558, 3),
(5, 2559, 4),
(6, 2560, 2),
(7, 2560, 4),
(8, 2560, 6),
(9, 2561, 1),
(10, 2561, 5);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `incidentes`
--

CREATE TABLE `incidentes` (
  `idIncidente` int(4) NOT NULL,
  `idCliente` int(4) NOT NULL,
  `idAplicacion` int(2) NOT NULL,
  `idEntorno` int(2) NOT NULL,
  `idtecnico` int(4) NOT NULL,
  `tiempoResolucion` int(2) NOT NULL,
  `fechaVisita` date NOT NULL,
  `complejidad` varchar(50) NOT NULL,
  `resuelto` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `incidentes`
--

INSERT INTO `incidentes` (`idIncidente`, `idCliente`, `idAplicacion`, `idEntorno`, `idtecnico`, `tiempoResolucion`, `fechaVisita`, `complejidad`, `resuelto`) VALUES
(3556, 1566, 2, 1, 2556, 4, '2023-10-12', 'ALTA', 1),
(3557, 1557, 2, 2, 2559, 2, '2023-10-14', 'BAJA', 1),
(3558, 1561, 2, 1, 2556, 2, '2023-10-14', 'BAJA', 1),
(3559, 1557, 3, 4, 2557, 2, '2023-10-16', 'BAJA', 1),
(3560, 1562, 1, 3, 2561, 2, '2023-10-16', 'BAJA', 1),
(3561, 1564, 3, 4, 2558, 3, '2023-10-16', 'ALTA', 1),
(3562, 1556, 1, 1, 2561, 2, '2023-10-19', 'BAJA', 1),
(3563, 1560, 3, 4, 2557, 4, '2023-10-19', 'ALTA', 1),
(3564, 1565, 1, 2, 2560, 4, '2023-10-21', 'ALTA', 1),
(3565, 1560, 1, 3, 2561, 2, '2023-10-21', 'BAJA', 1),
(3566, 1559, 3, 4, 2558, 2, '2023-10-21', 'BAJA', 1),
(3567, 1567, 1, 1, 2556, 2, '2023-10-21', 'BAJA', 1),
(3568, 1558, 1, 2, 2558, 2, '2023-10-23', 'BAJA', 1),
(3569, 1557, 2, 2, 2559, 5, '2023-10-25', 'ALTA', 1),
(3570, 1560, 3, 4, 2557, 1, '2023-10-26', 'BAJA', 1),
(3571, 1567, 2, 1, 2560, 2, '2023-10-26', 'BAJA', 1),
(3572, 1564, 2, 3, 2560, 3, '2023-10-28', 'ALTA', 1),
(3573, 1563, 1, 1, 2556, 5, '2023-10-28', 'ALTA', 1),
(3574, 1556, 1, 1, 2561, 1, '2023-11-01', 'BAJA', 1),
(3575, 1566, 3, 4, 2558, 2, '2023-11-01', 'BAJA', 1),
(3576, 1557, 3, 4, 2557, 2, '2023-11-01', 'BAJA', 1),
(3577, 1561, 2, 1, 2560, 2, '2023-11-01', 'BAJA', 1),
(3578, 1563, 1, 2, 2558, 3, '2023-11-03', 'ALTA', 1),
(3579, 1566, 2, 1, 2556, 4, '2023-11-04', 'ALTA', 1),
(3580, 1565, 3, 4, 2557, 1, '2023-11-04', 'BAJA', 1),
(3581, 1557, 2, 2, 2558, 3, '2023-11-04', 'ALTA', 1),
(3582, 1560, 2, 3, 2560, 1, '2023-11-07', 'BAJA', 1),
(3583, 1565, 2, 2, 2559, 1, '2023-11-07', 'BAJA', 1),
(3584, 1562, 1, 3, 2561, 2, '2023-11-08', 'BAJA', 1),
(3585, 1561, 3, 4, 2558, 2, '2023-11-09', 'BAJA', 1),
(3586, 1559, 3, 4, 2557, 2, '2023-11-09', 'BAJA', 1),
(3587, 1562, 1, 3, 2561, 3, '2023-11-10', 'ALTA', 1),
(3588, 1557, 2, 2, 2559, 2, '2023-11-11', 'BAJA', 1),
(3589, 1564, 2, 3, 2560, 4, '2023-11-01', 'ALTA', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `mesadeayuda`
--

CREATE TABLE `mesadeayuda` (
  `idMesaDeAyuda` int(4) NOT NULL,
  `password` varchar(8) NOT NULL,
  `apellido` varchar(50) NOT NULL,
  `nombre` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `mesadeayuda`
--

INSERT INTO `mesadeayuda` (`idMesaDeAyuda`, `password`, `apellido`, `nombre`) VALUES
(5556, '12345678', 'Ochoa', 'Julián'),
(5557, '87654321', 'Ramírez', 'Andrea');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `rrhh`
--

CREATE TABLE `rrhh` (
  `idRrhh` int(4) NOT NULL,
  `password` varchar(8) NOT NULL,
  `apellido` varchar(50) NOT NULL,
  `nombre` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `rrhh`
--

INSERT INTO `rrhh` (`idRrhh`, `password`, `apellido`, `nombre`) VALUES
(6556, '12345678', 'Pérez', 'Eleonora'),
(6557, '87654321', 'Andrada', 'Estanislao');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `servicios`
--

CREATE TABLE `servicios` (
  `idServicio` int(2) NOT NULL,
  `idAplicacion` int(2) NOT NULL,
  `idEntorno` int(2) NOT NULL,
  `idCliente` int(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `servicios`
--

INSERT INTO `servicios` (`idServicio`, `idAplicacion`, `idEntorno`, `idCliente`) VALUES
(1, 1, 1, 1556),
(2, 2, 2, 1557),
(3, 3, 4, 1557),
(4, 1, 2, 1558),
(5, 3, 4, 1559),
(6, 1, 1, 1560),
(7, 1, 3, 1560),
(8, 2, 3, 1560),
(9, 3, 4, 1560),
(10, 2, 1, 1561),
(11, 3, 4, 1561),
(12, 1, 3, 1562),
(13, 1, 1, 1563),
(14, 1, 2, 1563),
(15, 1, 3, 1563),
(16, 2, 3, 1564),
(17, 3, 4, 1564),
(18, 1, 2, 1565),
(19, 2, 2, 1565),
(20, 3, 4, 1565),
(21, 2, 1, 1566),
(22, 3, 4, 1566),
(23, 1, 1, 1567),
(24, 2, 1, 1567);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tecnicos`
--

CREATE TABLE `tecnicos` (
  `idTecnico` int(4) NOT NULL,
  `apellido` varchar(50) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `contacto` varchar(30) NOT NULL,
  `disponible` tinyint(1) NOT NULL,
  `estado` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tecnicos`
--

INSERT INTO `tecnicos` (`idTecnico`, `apellido`, `nombre`, `contacto`, `disponible`, `estado`) VALUES
(2556, 'Ruggeri', 'Horacio Jeremías', '3413208245', 1, 1),
(2557, 'De Michelis', 'Miriam Noelia', 'mirimichelis@gmail.com', 1, 1),
(2558, 'Kossman', 'David Sebastián', 'kossmantec@hotmail.com', 1, 1),
(2559, 'Gerardi', 'Nelson Alfredo', '1123219233', 1, 1),
(2560, 'Del Pietro', 'Fernando Joaquín', '1164564580', 0, 1),
(2561, 'Mamana', 'Alicia María José', '3413208245', 1, 1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `aplicaciones`
--
ALTER TABLE `aplicaciones`
  ADD PRIMARY KEY (`idAplicacion`);

--
-- Indices de la tabla `clientes`
--
ALTER TABLE `clientes`
  ADD PRIMARY KEY (`idCliente`);

--
-- Indices de la tabla `comercial`
--
ALTER TABLE `comercial`
  ADD PRIMARY KEY (`idComercial`);

--
-- Indices de la tabla `entorno`
--
ALTER TABLE `entorno`
  ADD PRIMARY KEY (`idEntorno`);

--
-- Indices de la tabla `especialidades`
--
ALTER TABLE `especialidades`
  ADD PRIMARY KEY (`idEspecialidad`),
  ADD KEY `idAplicacion` (`idAplicacion`),
  ADD KEY `idEntorno` (`idEntorno`);

--
-- Indices de la tabla `especialidades_tecnicos`
--
ALTER TABLE `especialidades_tecnicos`
  ADD PRIMARY KEY (`idEspecialidades_tecnicos`),
  ADD KEY `especialidades_tecnicos_ibfk_1` (`idTecnico`),
  ADD KEY `especialidades_tecnicos_ibfk_2` (`idEspecialidad`);

--
-- Indices de la tabla `incidentes`
--
ALTER TABLE `incidentes`
  ADD PRIMARY KEY (`idIncidente`),
  ADD KEY `idAplicacion` (`idAplicacion`),
  ADD KEY `idCliente` (`idCliente`),
  ADD KEY `idEntorno` (`idEntorno`),
  ADD KEY `idtecnico` (`idtecnico`);

--
-- Indices de la tabla `mesadeayuda`
--
ALTER TABLE `mesadeayuda`
  ADD PRIMARY KEY (`idMesaDeAyuda`);

--
-- Indices de la tabla `rrhh`
--
ALTER TABLE `rrhh`
  ADD PRIMARY KEY (`idRrhh`);

--
-- Indices de la tabla `servicios`
--
ALTER TABLE `servicios`
  ADD PRIMARY KEY (`idServicio`),
  ADD KEY `idAplicacion` (`idAplicacion`),
  ADD KEY `idCliente` (`idCliente`),
  ADD KEY `idEntorno` (`idEntorno`);

--
-- Indices de la tabla `tecnicos`
--
ALTER TABLE `tecnicos`
  ADD PRIMARY KEY (`idTecnico`);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `especialidades`
--
ALTER TABLE `especialidades`
  ADD CONSTRAINT `especialidades_ibfk_1` FOREIGN KEY (`idAplicacion`) REFERENCES `aplicaciones` (`idAplicacion`),
  ADD CONSTRAINT `especialidades_ibfk_2` FOREIGN KEY (`idEntorno`) REFERENCES `entorno` (`idEntorno`);

--
-- Filtros para la tabla `especialidades_tecnicos`
--
ALTER TABLE `especialidades_tecnicos`
  ADD CONSTRAINT `especialidades_tecnicos_ibfk_1` FOREIGN KEY (`idTecnico`) REFERENCES `tecnicos` (`idTecnico`),
  ADD CONSTRAINT `especialidades_tecnicos_ibfk_2` FOREIGN KEY (`idEspecialidad`) REFERENCES `especialidades` (`idEspecialidad`);

--
-- Filtros para la tabla `incidentes`
--
ALTER TABLE `incidentes`
  ADD CONSTRAINT `incidentes_ibfk_1` FOREIGN KEY (`idAplicacion`) REFERENCES `aplicaciones` (`idAplicacion`),
  ADD CONSTRAINT `incidentes_ibfk_2` FOREIGN KEY (`idCliente`) REFERENCES `clientes` (`idCliente`),
  ADD CONSTRAINT `incidentes_ibfk_3` FOREIGN KEY (`idEntorno`) REFERENCES `entorno` (`idEntorno`),
  ADD CONSTRAINT `incidentes_ibfk_4` FOREIGN KEY (`idtecnico`) REFERENCES `tecnicos` (`idTecnico`);

--
-- Filtros para la tabla `servicios`
--
ALTER TABLE `servicios`
  ADD CONSTRAINT `servicios_ibfk_1` FOREIGN KEY (`idAplicacion`) REFERENCES `aplicaciones` (`idAplicacion`),
  ADD CONSTRAINT `servicios_ibfk_2` FOREIGN KEY (`idCliente`) REFERENCES `clientes` (`idCliente`),
  ADD CONSTRAINT `servicios_ibfk_3` FOREIGN KEY (`idEntorno`) REFERENCES `entorno` (`idEntorno`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
