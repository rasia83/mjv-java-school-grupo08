-- Remodelar toda a estrutura de banco de forma que atenda o diagrama apresentado acima
use jobby;

-- Realizar cadastros prévios para a inserção dos candidatos como: Profissões, Cidades e Empresas
-- \Jobby\src\main\resources\db\migration\mysql
-- V2__cidades.sql ,
-- V3__profissoes.sql
-- V4__empresas.sql

-- Garantir que os cadastros sejam inseridos no banco de dados considerando a nova estrutura
-- com.mjvinnovation.school.jobby.start.CommandStarter

-- Contar quantos candidatos possuem a habilidade JAVA
SELECT COUNT(DISTINCT ch.cadastro_id)
FROM cadastro_habilidades ch
WHERE LOWER(ch.habilidades) LIKE '%java%';
-- Para o PostgreSQL, usar a função ILIKE, que realiza uma comparação de "igualdade" sem distinguir entre maiúsculas e minúsculas. 
-- WHERE ch.habilidades ILIKE '%java%';


-- Identificar quais candidatos NÃO possuem habilidade relacionadas
SELECT c.* FROM cadastros c
LEFT JOIN cadastro_habilidades ch ON c.id = ch.cadastro_id
WHERE ch.cadastro_id IS NULL;


-- Selecionar os candidatos que são do sexo FEMININO e que moram nas cidades do estado sigla SP informando o nome, cpf, dados de endereço e nome da cidade
SELECT c.nome, c.cpf, e.logradouro, e.numero, e.bairro, e.cep, ci.nome_municipio as cidade
FROM cadastros c
JOIN enderecos e ON c.endereco_id = e.id
JOIN cidades ci ON e.codigo_municipio = ci.codigo_municipio
WHERE c.sexo = 'FEMININO' AND ci.uf = 'SP';


-- Agrupar por profissão e contar quantos profissionais que moram na cidade de nome SÃO PAULO
SELECT p.nome as profissao, COUNT(*) as total_profissionais
FROM cadastros c
JOIN enderecos e ON c.endereco_id = e.id
JOIN cidades ci ON e.codigo_municipio = ci.codigo_municipio
JOIN profissoes p ON c.profissao_id = p.id
WHERE ci.nome_municipio = 'SÃO PAULO'
GROUP BY p.nome;


-- Selecionar candidatos que registram experiências com data de contratação entre 01/01/2020 a 31/12/2023
SELECT c.* FROM cadastros c
JOIN cadastro_experiencias ce ON c.id = ce.cadastro_id
WHERE ce.data_contratacao BETWEEN '2020-01-01' AND '2023-12-31';
-- PostgreSQL
-- WHERE ce.data_contratacao BETWEEN DATE '2020-01-01' AND DATE '2023-12-31';


-- Selecionar candidatos que trabalharam na empresa MICROSOFT
SELECT c.* FROM cadastros c
JOIN cadastro_experiencias ce ON c.id = ce.cadastro_id
JOIN empresas e ON ce.empresa_id = e.id
WHERE e.nome = 'MICROSOFT';


-- Selecionar candidatos que AINDA trabalham na empresa MICROSOFT
SELECT c.* FROM cadastros c
JOIN cadastro_experiencias ce ON c.id = ce.cadastro_id
JOIN empresas e ON ce.empresa_id = e.id
WHERE e.nome = 'MICROSOFT' AND ce.emprego_atual = 1;
-- PostgreSQL
-- WHERE e.nome = 'MICROSOFT' AND ce.emprego_atual = TRUE;


-- Selecionar candidatos que estão trabalhando atualmente
SELECT c.* FROM cadastros c
JOIN cadastro_experiencias ce ON c.id = ce.cadastro_id
WHERE ce.emprego_atual = 1;
-- PostgreSQL
-- WHERE ce.emprego_atual = TRUE;


-- Criar uma consulta que retorne todos os candidatos e nome da sua profissão correspondentemente
SELECT c.nome, p.nome as profissao FROM cadastros c
JOIN profissoes p ON c.profissao_id = p.id;


-- Criar uma consulta que retorne todos os candidatos e nome da sua profissão onde o id da profissão corresponda ao registro ANALISTA DE SISTEMAS
SELECT c.nome, p.nome as profissao FROM cadastros c
JOIN profissoes p ON c.profissao_id = p.id
WHERE p.nome = 'ANALISTA DE SISTEMAS';


-- Criar uma consulta que conte a quantidade de profissionais por profissão
SELECT p.nome as profissao, COUNT(*) as quantidade_profissionais
FROM cadastros c
JOIN profissoes p ON c.profissao_id = p.id
GROUP BY p.nome;


-- Criar uma consulta que retorne os candidatos ordenados por profissão e salário máximo de forma decrescente
SELECT c.nome, p.nome as profissao FROM cadastros c
JOIN profissoes p ON c.profissao_id = p.id
ORDER BY p.nome, c.valor_maximo DESC;

