-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 05-05-2017 a las 19:46:46
-- Versión del servidor: 10.1.21-MariaDB
-- Versión de PHP: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `db_editoriales`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `autor`
--

CREATE TABLE `autor` (
  `id_autor` int(11) NOT NULL,
  `nombre_autor` varchar(50) DEFAULT NULL,
  `apellido_autor` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `autor`
--

INSERT INTO `autor` (`id_autor`, `nombre_autor`, `apellido_autor`) VALUES
(1, 'mune', 'Orozco'),
(2, 'Roberto', 'Tammasia'),
(3, 'Carmen', 'Lyra'),
(4, 'Maniao', 'Falanges'),
(5, 'Armando', 'Carballo');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `libro_autor`
--

CREATE TABLE `libro_autor` (
  `id_autor` int(11) NOT NULL,
  `id_libro` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `libro_autor`
--

INSERT INTO `libro_autor` (`id_autor`, `id_libro`) VALUES
(1, 8),
(1, 10),
(1, 11),
(3, 11);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tb_editorial`
--

CREATE TABLE `tb_editorial` (
  `id_editorial` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `direccion` varchar(50) NOT NULL,
  `telefono` varchar(9) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `tb_editorial`
--

INSERT INTO `tb_editorial` (`id_editorial`, `nombre`, `direccion`, `telefono`) VALUES
(1, 'Universo', 'Chicago', '78965541'),
(2, 'Roguendo', 'Michigan', '987233455'),
(3, 'El planeta', 'Costa Rica', '271033455');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tb_libros`
--

CREATE TABLE `tb_libros` (
  `id_libro` int(11) NOT NULL,
  `titulo` varchar(50) NOT NULL,
  `anio` smallint(6) NOT NULL,
  `id_editorial` int(11) NOT NULL,
  `precio` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `tb_libros`
--

INSERT INTO `tb_libros` (`id_libro`, `titulo`, `anio`, `id_editorial`, `precio`) VALUES
(1, 'Blanca nieves', 1999, 1, 0),
(2, 'Blanca ', 1999, 1, 0),
(3, 'Blanca ', 1999, 1, 0),
(4, 'Blanca ', 1999, 1, 0),
(5, 'Rio verde ', 1999, 1, 0),
(6, 'Rio verde ', 1999, 1, 0),
(7, 'Rio verde ', 1999, 1, 0),
(8, 'Rio verde ', 1999, 1, 0),
(9, 'Los jardines', 1998, 1, 6000),
(10, 'Revolucion ', 1955, 3, 4500),
(11, 'Flor de caña', 2000, 3, 6000);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `autor`
--
ALTER TABLE `autor`
  ADD PRIMARY KEY (`id_autor`);

--
-- Indices de la tabla `libro_autor`
--
ALTER TABLE `libro_autor`
  ADD PRIMARY KEY (`id_autor`,`id_libro`),
  ADD KEY `id_libro` (`id_libro`);

--
-- Indices de la tabla `tb_editorial`
--
ALTER TABLE `tb_editorial`
  ADD PRIMARY KEY (`id_editorial`);

--
-- Indices de la tabla `tb_libros`
--
ALTER TABLE `tb_libros`
  ADD PRIMARY KEY (`id_libro`),
  ADD KEY `fk_editorial` (`id_editorial`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `autor`
--
ALTER TABLE `autor`
  MODIFY `id_autor` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `libro_autor`
--
ALTER TABLE `libro_autor`
  ADD CONSTRAINT `libro_autor_ibfk_1` FOREIGN KEY (`id_autor`) REFERENCES `autor` (`id_autor`),
  ADD CONSTRAINT `libro_autor_ibfk_2` FOREIGN KEY (`id_libro`) REFERENCES `tb_libros` (`id_libro`);

--
-- Filtros para la tabla `tb_libros`
--
ALTER TABLE `tb_libros`
  ADD CONSTRAINT `fk_editorial` FOREIGN KEY (`id_editorial`) REFERENCES `tb_editorial` (`id_editorial`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
