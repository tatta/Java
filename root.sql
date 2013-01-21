-- phpMyAdmin SQL Dump
-- version 3.4.10.1deb1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Jan 21, 2013 at 11:43 AM
-- Server version: 5.5.28
-- PHP Version: 5.3.10-1ubuntu3.4

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `root`
--

-- --------------------------------------------------------

--
-- Table structure for table `Kategoriat`
--

DROP TABLE IF EXISTS `Kategoriat`;
CREATE TABLE IF NOT EXISTS `Kategoriat` (
  `id` int(11) NOT NULL,
  `nimi` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Kategoriat`
--

INSERT INTO `Kategoriat` (`id`, `nimi`) VALUES
(1, 'Uutiset'),
(2, 'Viihde'),
(3, 'Urheilu'),
(4, 'Sää'),
(5, 'Lifestyle');

-- --------------------------------------------------------

--
-- Table structure for table `KategorinSanat`
--

DROP TABLE IF EXISTS `KategorinSanat`;
CREATE TABLE IF NOT EXISTS `KategorinSanat` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sana` varchar(30) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`,`sana`),
  KEY `sana` (`sana`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Dumping data for table `KategorinSanat`
--

INSERT INTO `KategorinSanat` (`id`, `sana`) VALUES
(3, 'arvostelu'),
(3, 'että ei'),
(3, 'hetkauttaa'),
(3, 'luotsi'),
(4, 'luvata'),
(1, 'murha'),
(3, 'puolustaa'),
(5, 'ruokavalio'),
(4, 'ulkomaa'),
(2, 'viihde');

-- --------------------------------------------------------

--
-- Table structure for table `Sanat`
--

DROP TABLE IF EXISTS `Sanat`;
CREATE TABLE IF NOT EXISTS `Sanat` (
  `infinitiv` varchar(30) NOT NULL,
  `suomeksi` varchar(30) DEFAULT NULL,
  `ruotsiksi` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`infinitiv`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Sanat`
--

INSERT INTO `Sanat` (`infinitiv`, `suomeksi`, `ruotsiksi`) VALUES
('arvostelu', 'arvostelu', 'bedömmning, kritik'),
('että ei', 'ettei', 'att, inte'),
('hetkauttaa', 'hetkauttaa', 'rubba, flytta'),
('luotsi', 'portugalilaisluotsi', 'lots, lotsen'),
('luvata', 'luvataan', 'lova'),
('murha', 'murhista', 'mord'),
('puolustaa', 'puolustaa', 'försvara, rättfärdiga'),
('ruokavalio', 'ruokavalioonsa', 'utomlands'),
('ulkomaa', 'ulkomaille', 'utomlands'),
('viihde', 'viihde', 'förströelse, underhållning');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `KategorinSanat`
--
ALTER TABLE `KategorinSanat`
  ADD CONSTRAINT `KategorinSanat_ibfk_1` FOREIGN KEY (`id`) REFERENCES `Kategoriat` (`id`),
  ADD CONSTRAINT `KategorinSanat_ibfk_2` FOREIGN KEY (`sana`) REFERENCES `Sanat` (`infinitiv`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
