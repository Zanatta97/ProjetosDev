/*------------------------------------------------------------*/
/*   Esquema para a criação do banco de dados da aplicação    */
/*                         Lancamentos                        */
/*------------------------------------------------------------*/
/*------------------------------------------------------------*/
/*                     Exclusão de Views                      */
/*------------------------------------------------------------*/

/*------------------------------------------------------------*/
/*                     Exclusão de tabelas                    */
/*------------------------------------------------------------*/

DROP TABLE IF EXISTS "CLIENTES";
DROP TABLE IF EXISTS "FORNECEDORES";
DROP TABLE IF EXISTS "LANC_CLIENTES";
DROP TABLE IF EXISTS "LANC_FORNECEDOR";
DROP TABLE IF EXISTS "MOVIMENTACAO_FORNECEDOR";
DROP TABLE IF EXISTS "TB_LOGIN_GROUP";
DROP TABLE IF EXISTS "TB_LOGIN_RULE";
DROP TABLE IF EXISTS "TB_LOGIN_USER";
/*------------------------------------------------------------*/
/*                     Criação das tabelas                    */
/*------------------------------------------------------------*/

/*------------------------------------------------------------*/
/*    Criação de Tabelas, Indices e Atribuição de Default    */
/*    CLIENTES    */
/*------------------------------------------------------------*/

 CREATE TABLE "CLIENTES"(
	"ID_CLIENTE"                            SERIAL  NOT NULL,
	"NOME_CLIENTE"                         varchar (500)        NOT NULL,
	"CPF_CLIENTE"                          varchar (14)         NULL,
	"CNPJ_CLIENTE"                         varchar (18)         NULL,
	"ENDERECO_CLIENTE"                     varchar (500)        NULL,
	"COMPLEMENTO_CLIENTE"                  varchar (500)        NULL,
	"BAIRRO_CLIENTE"                       varchar (500)        NULL,
	"CIDADE_CLIENTE"                       varchar (500)        NULL,
	"UF_CLIENTE"                           varchar (500)        NULL,
	"CEP_CLIENTE"                          varchar (10)         NULL,
	"TELEFONE_CLIENTE"                     varchar (14)         NULL,
	"CELULAR_CLIENTE"                      varchar (15)         NULL,
	"STATUS_CLIENTE"                       varchar (10)         NOT NULL,
	"QT_LANCAMENTOS_CLIENTE"               bigint               DEFAULT 0 NOT NULL,
		CONSTRAINT "PK_CLIENTES" PRIMARY KEY 
		(
			"ID_CLIENTE"
		) 
);

/*------------------------------------------------------------*/
/*    Criação de Tabelas, Indices e Atribuição de Default    */
/*      FORNECEDORES      */
/*------------------------------------------------------------*/

 CREATE TABLE "FORNECEDORES"(
	"ID_FORNEC"                             SERIAL  NOT NULL,
	"NOME_FORNEC"                          varchar (500)        NOT NULL,
	"CPF_FORNEC"                           varchar (14)         NULL,
	"CNPJ_FORNEC"                          varchar (18)         NOT NULL,
	"ENDERECO_FORNEC"                      varchar (500)        NULL,
	"COMPLEMENTO_FORNEC"                   varchar (500)        NOT NULL,
	"BAIRRO_FORNEC"                        varchar (500)        NULL,
	"CIDADE_FORNEC"                        varchar (500)        NULL,
	"UF_FORNEC"                            varchar (10)         NULL,
	"CEP_FORNEC"                           varchar (10)         NULL,
	"TELEFONE_FORNEC"                      varchar (14)         NULL,
	"CELULAR_FORNEC"                       varchar (15)         NULL,
	"STATUS_FORNEC"                        varchar (10)         NOT NULL,
	"QT_LANCAMENTOS_FORNEC"                bigint               DEFAULT 0 NOT NULL,
	"SALDO_ATUAL_FORNEC"                   decimal (14,2)       DEFAULT 0 NOT NULL,
	"JUROS_FORNEC"                         decimal (14,2)       DEFAULT 0 NOT NULL,
	"ULTIMO_JUROS_FORNEC"                  date                 NULL,
	"PROXIMA_ATT_FORNEC"                   date                 NULL,
	"ULTIMO_SAQUE_FORNEC"                  date                 NULL,
	"ULTIMO_DEPOSITO_FORNEC"               varchar (10)         NULL,
		CONSTRAINT "PK_FORNECEDORES" PRIMARY KEY 
		(
			"ID_FORNEC"
		) 
);

/*------------------------------------------------------------*/
/*    Criação de Tabelas, Indices e Atribuição de Default    */
/*      LANC_CLIENTES      */
/*------------------------------------------------------------*/

 CREATE TABLE "LANC_CLIENTES"(
	"ID_LANC_CLI"                           SERIAL  NOT NULL,
	"ID_CLIENTE"                           bigint               NOT NULL,
	"SEQUENCIAL_LANC_CLI"                  bigint               DEFAULT 0 NOT NULL,
	"VALOR_LANC_CLI"                       decimal (14,2)       DEFAULT 0 NOT NULL,
	"TAXA_LANC_CLI"                        decimal (14,2)       DEFAULT 0 NOT NULL,
	"DATA_LANC_CLI"                        date                 NOT NULL,
	"PRAZO_LANC_CLI"                       bigint               DEFAULT 0 NOT NULL,
	"DATA_FINAL_LANC_CLI"                  date                 NOT NULL,
	"VOLTA_LANC_CLI"                       decimal (14,2)       DEFAULT 0 NOT NULL,
		CONSTRAINT "PK_LANC_CLIENTES" PRIMARY KEY 
		(
			"ID_LANC_CLI"
		) 
);

/*------------------------------------------------------------*/
/*    Criação de Tabelas, Indices e Atribuição de Default    */
/*       LANC_FORNECEDOR       */
/*------------------------------------------------------------*/

 CREATE TABLE "LANC_FORNECEDOR"(
	"ID_LANC_FORNEC"                        SERIAL  NOT NULL,
	"ID_FORNEC"                            bigint               NOT NULL,
	"SEQUENCIAL_LANC_FORNEC"               bigint               DEFAULT 0 NOT NULL,
	"VALOR_LANC_FORNEC"                    decimal (14,2)       DEFAULT 0 NOT NULL,
	"VALOR_JUROS_LANC_FORNEC"              decimal (14,2)       DEFAULT 0 NOT NULL,
	"JUROS_ACUMULADOS_LANC_FORNEC"         decimal (14,2)       DEFAULT 0 NOT NULL,
	"DATA_PRIMEIRO_LANC_FORNEC"            date                 NOT NULL,
	"DATA_PROXIMO_LANC_FORNEC"             date                 NOT NULL,
	"DATA_ULTIMO_LANC_FORNEC"              date                 NOT NULL,
		CONSTRAINT "PK_LANC_FORNECEDOR" PRIMARY KEY 
		(
			"ID_LANC_FORNEC"
		) 
);

/*------------------------------------------------------------*/
/*    Criação de Tabelas, Indices e Atribuição de Default    */
/*           MOVIMENTACAO_FORNECEDOR           */
/*------------------------------------------------------------*/

 CREATE TABLE "MOVIMENTACAO_FORNECEDOR"(
	"ID_MOV"                                SERIAL  NOT NULL,
	"ID_FORNEC"                            bigint               NOT NULL,
	"TIPO_MOV"                             varchar (10)         NOT NULL,
	"VALOR_MOV"                            decimal (14,2)       DEFAULT 0 NOT NULL,
	"SALDO_ANTERIOR_MOV"                   decimal (14,2)       DEFAULT 0 NOT NULL,
	"SALDO_NOVO_MOV"                       decimal (14,2)       DEFAULT 0 NOT NULL,
	"DATA_MOV"                             date                 NOT NULL,
		CONSTRAINT "PK_MOVIMENTACAO_FORNECEDOR" PRIMARY KEY 
		(
			"ID_MOV"
		) 
);

/*------------------------------------------------------------*/
/*    Criação de Tabelas, Indices e Atribuição de Default    */
/*       TB_LOGIN_GROUP       */
/*------------------------------------------------------------*/

 CREATE TABLE "TB_LOGIN_GROUP"(
	"LOGIN_GROUP_NAME"                     varchar (60)         NOT NULL,
	"LOGIN_GROUP_IS_ADMIN"                 boolean              NOT NULL,
		CONSTRAINT "LOGIN_GROUP_PK" PRIMARY KEY 
		(
			"LOGIN_GROUP_NAME"
		) 
);

/*------------------------------------------------------------*/
/*    Criação de Tabelas, Indices e Atribuição de Default    */
/*      TB_LOGIN_RULE      */
/*------------------------------------------------------------*/

 CREATE TABLE "TB_LOGIN_RULE"(
	"LOGIN_RULE_PROJECT"                   varchar (8)          NOT NULL,
	"LOGIN_GROUP_NAME"                     varchar (60)         NOT NULL,
	"LOGIN_RULE_OBJECT"                    varchar (100)        NOT NULL,
	"LOGIN_RULE_PERMISSIONS"               varchar (100)        NOT NULL,
		CONSTRAINT "LOGIN_RULE_PK" PRIMARY KEY 
		(
			"LOGIN_RULE_PROJECT","LOGIN_GROUP_NAME","LOGIN_RULE_OBJECT"
		) 
);

/*------------------------------------------------------------*/
/*    Criação de Tabelas, Indices e Atribuição de Default    */
/*      TB_LOGIN_USER      */
/*------------------------------------------------------------*/

 CREATE TABLE "TB_LOGIN_USER"(
	"LOGIN_GROUP_NAME"                     varchar (60)         NOT NULL,
	"LOGIN_USER_LOGIN"                     varchar (40)         NOT NULL,
	"LOGIN_USER_PASSWORD"                  varchar (40)         NOT NULL,
	"LOGIN_USER_NAME"                      varchar (60)         NOT NULL,
	"LOGIN_USER_OBS"                       text                 NOT NULL,
		CONSTRAINT "LOGIN_USER_PK" PRIMARY KEY 
		(
			"LOGIN_USER_LOGIN"
		) 
);

ALTER TABLE "CLIENTES" ADD CONSTRAINT "FK_LANC_CLIENTES"
	FOREIGN KEY
		("ID_CLIENTE")
	REFERENCES "LANC_CLIENTES"
		("ID_CLIENTE")
	ON UPDATE CASCADE;

ALTER TABLE "FORNECEDORES" ADD CONSTRAINT "FK_LANC_FORNECEDOR"
	FOREIGN KEY
		("ID_FORNEC")
	REFERENCES "LANC_FORNECEDOR"
		("ID_FORNEC")
	ON UPDATE CASCADE;

ALTER TABLE "FORNECEDORES" ADD CONSTRAINT "FK_MOVIMENTACAO_FORNECEDOR"
	FOREIGN KEY
		("ID_FORNEC")
	REFERENCES "MOVIMENTACAO_FORNECEDOR"
		("ID_FORNEC")
	ON UPDATE CASCADE;

ALTER TABLE "TB_LOGIN_RULE" ADD CONSTRAINT "TB_LOGIN_GROUP_RULE"
	FOREIGN KEY
		("LOGIN_GROUP_NAME")
	REFERENCES "TB_LOGIN_GROUP"
		("LOGIN_GROUP_NAME")
	ON DELETE CASCADE;

ALTER TABLE "TB_LOGIN_USER" ADD CONSTRAINT "TB_LOGIN_GROUP_USER"
	FOREIGN KEY
		("LOGIN_GROUP_NAME")
	REFERENCES "TB_LOGIN_GROUP"
		("LOGIN_GROUP_NAME")
	ON DELETE CASCADE;

