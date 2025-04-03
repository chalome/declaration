-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Apr 03, 2025 at 02:44 PM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `declaration_obr`
--

-- --------------------------------------------------------

--
-- Table structure for table `category`
--

CREATE TABLE `category` (
  `id` int(11) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `category`
--

INSERT INTO `category` (`id`, `description`, `nom`) VALUES
(1, 'For administrators of the application', 'Admin'),
(2, 'For clients of the application', 'Client');

-- --------------------------------------------------------

--
-- Table structure for table `declaration`
--

CREATE TABLE `declaration` (
  `id` int(11) NOT NULL,
  `date_declaration` datetime(6) DEFAULT NULL,
  `montant` double NOT NULL,
  `mode_paiement_id` int(11) DEFAULT NULL,
  `type_declaration_id` int(11) DEFAULT NULL,
  `utilisateur_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `declaration`
--

INSERT INTO `declaration` (`id`, `date_declaration`, `montant`, `mode_paiement_id`, `type_declaration_id`, `utilisateur_id`) VALUES
(1, '2025-03-26 06:49:01.000000', 10000, 1, 1, 1),
(2, '2025-04-01 06:33:54.000000', 40000, 2, 2, 1);

-- --------------------------------------------------------

--
-- Table structure for table `mode_paiement`
--

CREATE TABLE `mode_paiement` (
  `id` int(11) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `mode_paiement`
--

INSERT INTO `mode_paiement` (`id`, `description`, `nom`) VALUES
(1, 'Payer a l\'aide du service lumicash', 'Lumicash'),
(2, 'Paiement par le compte banquaire', 'Compte Banquaire');

-- --------------------------------------------------------

--
-- Table structure for table `type_declaration`
--

CREATE TABLE `type_declaration` (
  `id` int(11) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `type_declaration`
--

INSERT INTO `type_declaration` (`id`, `description`, `nom`) VALUES
(1, 'Declaration par mois', 'Declaration Mensuelle'),
(2, 'Declaration par trois mois', 'Declaration Trimestrielle');

-- --------------------------------------------------------

--
-- Table structure for table `utilisateur`
--

CREATE TABLE `utilisateur` (
  `id` int(11) NOT NULL,
  `adresse` varchar(255) DEFAULT NULL,
  `date_creation` datetime(6) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `mot_de_passe` varchar(255) DEFAULT NULL,
  `nif` varchar(255) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `numero_telephone` varchar(255) DEFAULT NULL,
  `prenom` varchar(255) DEFAULT NULL,
  `category_id` int(11) DEFAULT 2
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `utilisateur`
--

INSERT INTO `utilisateur` (`id`, `adresse`, `date_creation`, `email`, `mot_de_passe`, `nif`, `nom`, `numero_telephone`, `prenom`, `category_id`) VALUES
(1, 'mutanga', '2025-03-25 10:19:25.000000', 'jackin@gmail.com', 'jaja12345', '5000/483', 'mugisha', '78898989', 'jackin', 2),
(2, 'kayanza', '2025-04-01 06:41:02.000000', 'dev@gmail.com', 'dev12345', '5000/48334', 'NIYUKURI', '78987665', 'dev', 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `declaration`
--
ALTER TABLE `declaration`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKnidramwavijld4y7ce6wyan0h` (`mode_paiement_id`),
  ADD KEY `FKbmbdd4o1t8s0dff7ehjd3l28` (`type_declaration_id`),
  ADD KEY `FK7jhsadnk5q3oa5nohhi8y00yw` (`utilisateur_id`);

--
-- Indexes for table `mode_paiement`
--
ALTER TABLE `mode_paiement`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `type_declaration`
--
ALTER TABLE `type_declaration`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `utilisateur`
--
ALTER TABLE `utilisateur`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKhdjs5les4hs931m2xu174rthg` (`category_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `category`
--
ALTER TABLE `category`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `declaration`
--
ALTER TABLE `declaration`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `mode_paiement`
--
ALTER TABLE `mode_paiement`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `type_declaration`
--
ALTER TABLE `type_declaration`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `utilisateur`
--
ALTER TABLE `utilisateur`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `declaration`
--
ALTER TABLE `declaration`
  ADD CONSTRAINT `FK7jhsadnk5q3oa5nohhi8y00yw` FOREIGN KEY (`utilisateur_id`) REFERENCES `utilisateur` (`id`),
  ADD CONSTRAINT `FKbmbdd4o1t8s0dff7ehjd3l28` FOREIGN KEY (`type_declaration_id`) REFERENCES `type_declaration` (`id`),
  ADD CONSTRAINT `FKnidramwavijld4y7ce6wyan0h` FOREIGN KEY (`mode_paiement_id`) REFERENCES `mode_paiement` (`id`);

--
-- Constraints for table `utilisateur`
--
ALTER TABLE `utilisateur`
  ADD CONSTRAINT `FKhdjs5les4hs931m2xu174rthg` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
