CREATE TABLE `cidades` (
  `codigo_municipio` int(7) NOT NULL, -- int(7) MySQL / integer para  Postgre
  `nome_municipio` varchar(50) NOT NULL,
  `uf` varchar(2) NOT NULL,
  `nome_uf` varchar(20) NOT NULL,
  PRIMARY KEY (`codigo_municipio`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

CREATE INDEX idx_codigo_municipio ON cidades (codigo_municipio);
CREATE INDEX idx_nome_municipio ON cidades (nome_municipio);
CREATE INDEX idx_uf ON cidades (uf);
CREATE INDEX idx_nome_uf ON cidades (nome_uf);


CREATE TABLE `profissoes` (
  `id` int(11) NOT NULL AUTO_INCREMENT, -- int(11) MySQL / integer para  Postgre
  `nome` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

CREATE INDEX idx_nome ON profissoes (nome);


CREATE TABLE `empresas` (
  `id` int(11) NOT NULL AUTO_INCREMENT, -- int(11) MySQL / integer para  Postgre
  `nome` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

CREATE INDEX idx_nome ON empresas (nome);


CREATE TABLE `enderecos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bairro` varchar(20) ,
  `cep` bigint(20) ,
  `complemento` varchar(20) ,
  `logradouro` varchar(50) ,
  `numero` varchar(10) ,
  `codigo_municipio` int(11) ,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`codigo_municipio`)
  REFERENCES `cidades` (`codigo_municipio`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;


CREATE TABLE `cadastros` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `numero` bigint(20) DEFAULT NULL,
  `whatsapp` bit(1) NOT NULL,
  `cpf` varchar(11) NOT NULL,
  `data_nascimento` date DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `valor_maximo` double DEFAULT NULL,
  `valor_minimo` double DEFAULT NULL,
  `sexo` varchar(10) DEFAULT NULL,
  `endereco_id` int(11) DEFAULT NULL,
  `profissao_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`profissao_id`) REFERENCES `profissoes` (`id`),
  FOREIGN KEY (`endereco_id`) REFERENCES `enderecos` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;


CREATE TABLE `cadastro_habilidades` (
  `cadastro_id` int(11) NOT NULL,
  `habilidades` varchar(255) DEFAULT NULL,
  FOREIGN KEY (`cadastro_id`) REFERENCES `cadastros` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

CREATE INDEX idx_cadastro_id ON cadastro_habilidades (cadastro_id);
CREATE INDEX idx_habilidades ON cadastro_habilidades (habilidades);


CREATE TABLE `cadastro_experiencias` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `data_contratacao` date DEFAULT NULL,
  `data_desligamento` date DEFAULT NULL,
  `emprego_atual` bit(1) NOT NULL,
  `regime_contratacao` varchar(5) DEFAULT NULL,
  `salario` double DEFAULT NULL,
  `cadastro_id` int(11) NOT NULL,
  `profissao_id` int(11) DEFAULT NULL,
  `empresa_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`profissao_id`) REFERENCES `profissoes` (`id`),
  FOREIGN KEY (`empresa_id`) REFERENCES `empresas` (`id`),
  FOREIGN KEY (`cadastro_id`) REFERENCES `cadastros` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;



