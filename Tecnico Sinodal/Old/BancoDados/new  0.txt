CREATE TABLE niveis_acessos (
  id int(11) NOT NULL,
  nome varchar(30) DEFAULT NULL,
  dta_inclusao datetime NOT NULL,
  dta_alteracao datetime DEFAULT NULL
);

INSERT INTO niveis_acessos (id, nome, dta_inclusao, dta_alteracao) VALUES
(1, 'Administrador', '2019-09-23 00:00:00', NULL),
(2, 'Financeiro', '2019-09-23 00:00:00', NULL),
(3, 'Cliente', '2019-09-23 00:00:00', NULL),
(4, 'Suporte', '2019-09-23 00:00:00', NULL);

-- --------------------------------------------------------

--
-- Estrutura para tabela situacaos
--

CREATE TABLE situacao (
  id int(11) NOT NULL,
  nome varchar(30) NOT NULL,
  dta_inclusao datetime NOT NULL,
  dta_alteracao datetime DEFAULT NULL
) ;

INSERT INTO situacao (id, nome, dta_inclusao, dta_alteracao) VALUES
(1, 'Ativo', '2019-09-23 00:00:00', NULL),
(2, 'Inativo', '2019-09-23 00:00:00', NULL);

-- --------------------------------------------------------

--
-- Estrutura para tabela usuarios
--

CREATE TABLE usuarios (
  id int(11) NOT NULL,
  nome varchar(120) DEFAULT NULL,
  email varchar(220) NOT NULL,
  situacao_id int(11) NOT NULL DEFAULT '2',
  niveis_acesso_id int(11) NOT NULL,
  qnt_acessos int(11) NOT NULL DEFAULT '0',
  dta_inclusao datetime NOT NULL,
  dta_alteracao datetime DEFAULT NULL
);

--
-- Fazendo dump de dados para tabela usuarios
--

INSERT INTO usuarios (id, nome, email, situacao_id, niveis_acesso_id, qnt_acessos, dta_inclusao,dta_alteracao) values
(1, 'Edison', 'edison@gmail.com.br', 1, 1, 15, '2017-09-23 00:00:00', NULL),
(2, 'Kelly', 'kelly@gmail.com.br', 1, 2, 20, '2017-09-23 00:00:00', NULL),
(3, 'Jessica', 'jessica@gmail.com.br', 1, 3, 10, '2017-09-23 00:00:00', NULL),
(4, 'Ana', 'ana@gmail.com.br', 2, 3, 15, '2017-09-23 00:00:00', NULL),
(5, 'Carlos', 'carlos@gmail.com.br', 2, 3, 0, '2017-09-23 15:48:31', NULL),
(6, 'mello 1', 'mello1@gmail.com.br', 2, 3, 0, '2017-09-23 15:50:43', NULL),
(7, 'mello 2', 'mello2@gmail.com.br', 2, 3, 0, '2017-09-23 15:57:35', NULL),
(8, 'mello 4', 'mello4@gmail.com.br', 2, 3, 0, '2017-09-23 16:22:16', NULL);


--
ALTER TABLE niveis_acessos
  ADD PRIMARY KEY (id);

ALTER TABLE situacao
  ADD PRIMARY KEY (id);

ALTER TABLE usuarios
  ADD PRIMARY KEY (id),
  ADD KEY situacao_id (situacao_id),
  ADD KEY niveis_acesso_id (niveis_acesso_id);

--
-- AUTO_INCREMENT de tabela niveis_acessos
--
ALTER TABLE niveis_acessos
  MODIFY id int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT de tabela situacaos
--
ALTER TABLE situacao
  MODIFY id int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT de tabela usuarios
--
ALTER TABLE usuarios
  MODIFY id int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

  
ALTER TABLE usuarios
  ADD CONSTRAINT usuarios_sit_id FOREIGN KEY (situacao_id) REFERENCES situacao (id) ON DELETE NO ACTION ON UPDATE CASCADE,
  ADD CONSTRAINT usuarios_niv_id FOREIGN KEY (niveis_acesso_id) REFERENCES niveis_acessos (id) ON DELETE NO ACTION ON UPDATE CASCADE;