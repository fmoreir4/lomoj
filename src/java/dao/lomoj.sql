--
-- Database: `LOMOJ`
--

CREATE DATABASE lomoj;

USE lomoj

CREATE TABLE `FUNCIONARIO` (
  `ID` bigint(20) NOT NULL  AUTO_INCREMENT PRIMARY KEY,
  `ATIVO` tinyint(1) DEFAULT '0',
  `CARGO` varchar(255) DEFAULT NULL,
  `EMAIL` varchar(255) DEFAULT NULL,
  `FOTO` varchar(255) DEFAULT NULL,
  `NOME` varchar(255) DEFAULT NULL,
  `PWS` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `FUNCIONARIO`
--

INSERT INTO `FUNCIONARIO` (`ID`, `ATIVO`, `CARGO`, `EMAIL`, `FOTO`, `NOME`, `PWS`) VALUES
(1, 1, 'ADMINISTRADOR', 'admin@admin', '453859528b76397a5a12a9d2f36ba702.jpg', 'Administrador', '96e79218965eb72c92a549dd5a330112');
