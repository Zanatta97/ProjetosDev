-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Tempo de geração: 26/03/2018 às 16:03
-- Versão do servidor: 5.7.19
-- Versão do PHP: 7.1.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `db_media_escolar`
--

-- --------------------------------------------------------

--
-- Estrutura para tabela `media_escolar`
--

CREATE TABLE `media_escolar` (
  `id` int(11) NOT NULL,
  `materia` varchar(35) NOT NULL,
  `bimestre` varchar(15) NOT NULL,
  `situacao` varchar(12) NOT NULL,
  `notaProva` double NOT NULL,
  `notaMateria` double NOT NULL,
  `mediaFinal` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Fazendo dump de dados para tabela `media_escolar`
--

INSERT INTO `media_escolar` (`id`, `materia`, `bimestre`, `situacao`, `notaProva`, `notaMateria`, `mediaFinal`) VALUES
(1, 'Matemática', '1º Bimestre', 'Aprovado', 10, 10, 10),
(2, 'Física', '3º Bimestre', 'Aprovado', 10, 10, 10),
(3, 'Inglês', '2º Bimestre', 'Aprovado', 10, 10, 10),
(4, 'Inglês', '3º Bimestre', 'Aprovado', 10, 10, 10),
(5, 'Matemática', '2º Bimestre', 'Aprovado', 10, 10, 10),
(6, 'Matemática', '4º Bimestre', 'Aprovado', 10, 10, 10),
(7, 'Matemática', '3º Bimestre', 'Aprovado', 10, 10, 10),
(8, 'Geografia', '1º Bimestre', 'Aprovado', 10, 10, 10);

--
-- Índices de tabelas apagadas
--

--
-- Índices de tabela `media_escolar`
--
ALTER TABLE `media_escolar`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de tabelas apagadas
--

--
-- AUTO_INCREMENT de tabela `media_escolar`
--
ALTER TABLE `media_escolar`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
