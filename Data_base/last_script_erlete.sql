-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 25-05-2021 a las 10:40:17
-- Versión del servidor: 10.4.19-MariaDB
-- Versión de PHP: 8.0.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `erlete_db`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `booking_can`
--

CREATE TABLE `booking_can` (
  `id_booking` int(11) NOT NULL,
  `id_can` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `booking_can`
--

INSERT INTO `booking_can` (`id_booking`, `id_can`) VALUES
(115, 2),
(115, 1),
(116, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `can`
--

CREATE TABLE `can` (
  `id_can` int(11) NOT NULL,
  `capacity` int(11) DEFAULT NULL,
  `availability` tinyint(1) DEFAULT NULL,
  `new_use` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `can`
--

INSERT INTO `can` (`id_can`, `capacity`, `availability`, `new_use`) VALUES
(1, 100, 1, NULL),
(2, 100, 1, NULL),
(3, 100, 1, NULL),
(4, 150, 1, NULL),
(5, 150, 1, NULL),
(6, 150, 1, NULL),
(7, 250, 1, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `expense`
--

CREATE TABLE `expense` (
  `id_expense` int(11) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `price` float DEFAULT NULL,
  `expense_type` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `expense`
--

INSERT INTO `expense` (`id_expense`, `description`, `price`, `expense_type`) VALUES
(1, 'funtzionatzen aldu?', 8, 'Supplies'),
(2, 'asdasd', 5, 'Supply'),
(3, 'Light fee', 58, 'Maintenance');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `partner`
--

CREATE TABLE `partner` (
  `DNI` varchar(15) NOT NULL,
  `name` varchar(30) DEFAULT NULL,
  `surname` varchar(30) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `IBAN` varchar(30) DEFAULT NULL,
  `phone` varchar(15) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `active` tinyint(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `partner`
--

INSERT INTO `partner` (`DNI`, `name`, `surname`, `email`, `password`, `IBAN`, `phone`, `address`, `active`) VALUES
('12345678A', 'Jon', 'Suinaga', 'xui@erlete.eus', 'xui', 'ES45 6734 8534 0534 9503 4512', '+23 656 646 623', 'Erdiko kalea 32', 1),
('12345678T', 'Abderrafia', 'Hayar', 'abde@erlete.eus', 'abde', 'ES12 1546 4952 6547 5987 5214', '+34 630 322 370', 'Bergara', 1),
('1234A', 'Benito', 'Vilarchao', 'benito@erlete.eus', 'benito', 'ES3220854596534796523443', '+34 656 656 656', 'Benito Kalea 2-5D, 20870, Elgoibar, Gipuzkoa', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `partnership_fee`
--

CREATE TABLE `partnership_fee` (
  `partner_DNI` varchar(15) NOT NULL,
  `year` int(11) NOT NULL,
  `fee_charged` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `partnership_fee`
--

INSERT INTO `partnership_fee` (`partner_DNI`, `year`, `fee_charged`) VALUES
('12345678A', 2021, 1),
('12345678T', 2021, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `production_fee`
--

CREATE TABLE `production_fee` (
  `partner_DNI` varchar(15) NOT NULL,
  `month` varchar(15) NOT NULL,
  `year` int(11) NOT NULL,
  `total_price` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `production_fee`
--

INSERT INTO `production_fee` (`partner_DNI`, `month`, `year`, `total_price`) VALUES
('12345678T', 'May', 2021, 20),
('1234A', 'May', 2021, 50);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `room_booking`
--

CREATE TABLE `room_booking` (
  `id_booking` int(11) NOT NULL,
  `partner_DNI` varchar(15) DEFAULT NULL,
  `book_date` date DEFAULT NULL,
  `extracted_quantity` int(11) DEFAULT NULL,
  `state` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `room_booking`
--

INSERT INTO `room_booking` (`id_booking`, `partner_DNI`, `book_date`, `extracted_quantity`, `state`) VALUES
(115, '1234A', '2021-05-08', 200, 0),
(116, '12345678T', '2021-05-09', 80, 0);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `booking_can`
--
ALTER TABLE `booking_can`
  ADD KEY `fk_book` (`id_booking`),
  ADD KEY `fk_can` (`id_can`);

--
-- Indices de la tabla `can`
--
ALTER TABLE `can`
  ADD PRIMARY KEY (`id_can`);

--
-- Indices de la tabla `expense`
--
ALTER TABLE `expense`
  ADD PRIMARY KEY (`id_expense`);

--
-- Indices de la tabla `partner`
--
ALTER TABLE `partner`
  ADD PRIMARY KEY (`DNI`);

--
-- Indices de la tabla `partnership_fee`
--
ALTER TABLE `partnership_fee`
  ADD PRIMARY KEY (`partner_DNI`,`year`);

--
-- Indices de la tabla `production_fee`
--
ALTER TABLE `production_fee`
  ADD PRIMARY KEY (`partner_DNI`,`month`,`year`);

--
-- Indices de la tabla `room_booking`
--
ALTER TABLE `room_booking`
  ADD PRIMARY KEY (`id_booking`),
  ADD UNIQUE KEY `book_date` (`book_date`),
  ADD KEY `fk_bookBazkideDNI` (`partner_DNI`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `can`
--
ALTER TABLE `can`
  MODIFY `id_can` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `expense`
--
ALTER TABLE `expense`
  MODIFY `id_expense` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `room_booking`
--
ALTER TABLE `room_booking`
  MODIFY `id_booking` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=119;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `booking_can`
--
ALTER TABLE `booking_can`
  ADD CONSTRAINT `fk_book` FOREIGN KEY (`id_booking`) REFERENCES `room_booking` (`id_booking`),
  ADD CONSTRAINT `fk_can` FOREIGN KEY (`id_can`) REFERENCES `can` (`id_can`);

--
-- Filtros para la tabla `partnership_fee`
--
ALTER TABLE `partnership_fee`
  ADD CONSTRAINT `fk_partBazkideDNI` FOREIGN KEY (`partner_DNI`) REFERENCES `partner` (`DNI`);

--
-- Filtros para la tabla `production_fee`
--
ALTER TABLE `production_fee`
  ADD CONSTRAINT `fk_prodBazkideDNI` FOREIGN KEY (`partner_DNI`) REFERENCES `partner` (`DNI`);

--
-- Filtros para la tabla `room_booking`
--
ALTER TABLE `room_booking`
  ADD CONSTRAINT `fk_bookBazkideDNI` FOREIGN KEY (`partner_DNI`) REFERENCES `partner` (`DNI`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
