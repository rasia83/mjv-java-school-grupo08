CREATE TABLE `empresas` (
  `id` int(11) NOT NULL AUTO_INCREMENT, -- int(11) MySQL / integer para  Postgre
  `nome` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

CREATE INDEX idx_nome ON empresas (nome);


INSERT INTO empresas (nome)
VALUES
  ('Não Cadastrada'),
  ('MJV Technology & Innovation'),
  ('TOTVS IP'),
  ('CAPGEMINI'),
  ('IBM'),
  ('Microsoft'),
  ('Oracle'),
  ('SAP'),
  ('Dell'),
  ('Cisco'),
  ('Intel'),
  ('HP'),
  ('Amazon Web Services'),
  ('Google'),
  ('Apple'),
  ('Facebook'),
  ('Netflix'),
  ('Uber'),
  ('Airbnb'),
  ('Salesforce'),
  ('Adobe'),
  ('VMware'),
  ('Accenture'),
  ('Deloitte'),
  ('PwC'),
  ('Ernst & Young'),
  ('KPMG'),
  ('Tata Consultancy Services'),
  ('Infosys'),
  ('Wipro'),
  ('HCL Technologies'),
  ('Tech Mahindra'),
  ('Cognizant'),
  ('Genpact'),
  ('Walmart'),
  ('Banco do Brasil'),
  ('Itaú Unibanco'),
  ('Bradesco'),
  ('Santander'),
  ('Caixa Econômica Federal'),
  ('Banco Safra'),
  ('Nubank'),
  ('PagSeguro'),
  ('Stone'),
  ('Mercado Livre'),
  ('Magazine Luiza'),
  ('Americanas'),
  ('Submarino'),
  ('Cielo'),
  ('Positivo'),
  ('Samsung'),
  ('LG'),
  ('Motorola'),
  ('Lenovo'),
  ('Sony'),
  ('Nokia'),
  ('Algar Telecom'),
  ('TIM'),
  ('Vivo'),
  ('Claro'),
  ('Oi'),
  ('Embratel'),
  ('Globo'),
  ('RecordTV'),
  ('SBT'),
  ('RedeTV!'),
  ('Band'),
  ('TikTok'),
  ('Snapchat'),
  ('Twitter'),
  ('LinkedIn'),
  ('Zoom'),
  ('Uber Eats'),
  ('iFood'),
  ('Rappi'),
  ('Gympass'),
  ('99'),
  ('99Food'),
  ('Loggi'),
  ('99Pay'),
  ('Movile'),
  ('PlayKids'),
  ('iFood'),
  ('Zapier'),
  ('HashiCorp'),
  ('Datadog'),
  ('Twilio'),
  ('MongoDB'),
  ('Elastic'),
  ('Atlassian'),
  ('GitHub'),
  ('Slack'),
  ('Notion'),
  ('Trello');
