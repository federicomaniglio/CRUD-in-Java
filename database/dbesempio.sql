-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Creato il: Gen 28, 2024 alle 23:43
-- Versione del server: 10.4.27-MariaDB
-- Versione PHP: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `dbesempio`
--
CREATE DATABASE IF NOT EXISTS `dbesempio` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `dbesempio`;

-- --------------------------------------------------------

--
-- Struttura della tabella `persone`
--

CREATE TABLE IF NOT EXISTS `persone` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Nome` varchar(100) DEFAULT NULL,
  `Cognome` varchar(100) DEFAULT NULL,
  `Eta` int(11) DEFAULT NULL,
  `Sesso` char(1) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dump dei dati per la tabella `persone`
--

INSERT INTO `persone` (`ID`, `Nome`, `Cognome`, `Eta`, `Sesso`) VALUES
(1, 'Mario', 'Rossi', 26, 'm'),
(2, 'Giorgia', 'Bianchi', 48, 'f'),
(3, 'Lorenzo', 'Verdi', 37, 'm'),
(4, 'Sofia', 'Rossi', 19, 'f'),
(6, 'Lorenzo', 'Arancioni', 48, 'm'),
(7, 'Marco', 'Rossi', 32, 'm'),
(11, 'Federico', 'Maniglio', 26, 'm');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
