-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : jeu. 12 nov. 2020 à 14:06
-- Version du serveur :  5.7.31
-- Version de PHP : 7.3.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `bookstore`
--

-- --------------------------------------------------------

--
-- Structure de la table `book`
--

DROP TABLE IF EXISTS `book`;
CREATE TABLE IF NOT EXISTS `book` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL,
  `author` varchar(255) NOT NULL,
  `price` double NOT NULL,
  `releaseDate` date NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `book`
--

INSERT INTO `book` (`id`, `title`, `author`, `price`, `releaseDate`) VALUES
(1, 'mm', 'll', 8, '2020-09-17'),
(9, 'mm', 'll', 8, '2020-09-17'),
(3, 'my book', 'book author', 55, '1970-01-01'),
(4, 'go', 'on', 55, '1970-01-01'),
(5, 'inner', 'low', 797, '1970-01-01'),
(8, 'africa', 'world', 22, '2020-02-12'),
(10, 'algeria', 'random', 88, '2019-09-06'),
(11, 'monday', 'tuesday', 8, '2020-02-12');

-- --------------------------------------------------------

--
-- Structure de la table `cmdline`
--

DROP TABLE IF EXISTS `cmdline`;
CREATE TABLE IF NOT EXISTS `cmdline` (
  `idcl` int(11) NOT NULL AUTO_INCREMENT,
  `idb` int(11) NOT NULL,
  `priceb` double NOT NULL,
  `qte` double NOT NULL,
  `pricecl` double NOT NULL,
  PRIMARY KEY (`idcl`),
  KEY `fk3` (`idb`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `login` varchar(16) NOT NULL,
  `mdp` varchar(16) NOT NULL,
  `nom` varchar(255) NOT NULL,
  `prenom` varchar(255) NOT NULL,
  `tel` varchar(20) NOT NULL,
  PRIMARY KEY (`login`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `user`
--

INSERT INTO `user` (`login`, `mdp`, `nom`, `prenom`, `tel`) VALUES
('akll88', 'motdepasse', 'jack', 'jhon', '22225565'),
('log', 'pass', 'mm', 'kk', '5545655'),
('pppp', 'm', 'klklm', 'klkl', '456454');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
