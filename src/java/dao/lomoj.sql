-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 31-Ago-2018 às 23:31
-- Versão do servidor: 10.1.25-MariaDB
-- PHP Version: 7.1.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `lomoj`
--
CREATE DATABASE IF NOT EXISTS `lomoj` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `lomoj`;

-- --------------------------------------------------------

--
-- Estrutura da tabela `cliente`
--

CREATE TABLE `cliente` (
  `ID` bigint(20) NOT NULL,
  `ATIVO` tinyint(1) DEFAULT '0',
  `DATANASC` date DEFAULT NULL,
  `EMAIL` varchar(255) DEFAULT NULL,
  `FOTO` varchar(255) DEFAULT NULL,
  `NOME` varchar(255) DEFAULT NULL,
  `PWS` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `cliente`
--

INSERT INTO `cliente` (`ID`, `ATIVO`, `DATANASC`, `EMAIL`, `FOTO`, `NOME`, `PWS`) VALUES
(1, 1, '2018-08-05', 'ana@ana.com', '87d07f90f10c40ed8075f45c042fe6f6.jpg', 'Ana', '111111');

-- --------------------------------------------------------

--
-- Estrutura da tabela `funcionario`
--

CREATE TABLE `funcionario` (
  `ID` bigint(20) NOT NULL,
  `ATIVO` tinyint(1) DEFAULT '0',
  `CARGO` varchar(255) DEFAULT NULL,
  `EMAIL` varchar(255) DEFAULT NULL,
  `FOTO` varchar(255) DEFAULT NULL,
  `NOME` varchar(255) DEFAULT NULL,
  `PWS` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `funcionario`
--

INSERT INTO `funcionario` (`ID`, `ATIVO`, `CARGO`, `EMAIL`, `FOTO`, `NOME`, `PWS`) VALUES
(1, 1, NULL, 'admin@admin', 'Chrysanthemum.jpg', 'admin', '111111');

-- --------------------------------------------------------

--
-- Estrutura da tabela `produto`
--

CREATE TABLE `produto` (
  `ID` bigint(20) NOT NULL,
  `ATIVO` tinyint(1) DEFAULT '0',
  `DESCRICAO` varchar(255) DEFAULT NULL,
  `FOTO01` varchar(255) DEFAULT NULL,
  `FOTO02` varchar(255) DEFAULT NULL,
  `FOTO03` varchar(255) DEFAULT NULL,
  `NOME` varchar(255) DEFAULT NULL,
  `QUANT` int(11) DEFAULT NULL,
  `VALOR` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `EMAIL` (`EMAIL`);

--
-- Indexes for table `funcionario`
--
ALTER TABLE `funcionario`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `EMAIL` (`EMAIL`);

--
-- Indexes for table `produto`
--
ALTER TABLE `produto`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `cliente`
--
ALTER TABLE `cliente`
  MODIFY `ID` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `funcionario`
--
ALTER TABLE `funcionario`
  MODIFY `ID` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `produto`
--
ALTER TABLE `produto`
  MODIFY `ID` bigint(20) NOT NULL AUTO_INCREMENT;COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
