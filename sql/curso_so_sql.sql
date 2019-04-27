drop database curso_so;
create database curso_so;

use curso_so;

-- Criação de tabelas
CREATE TABLE dados_salvos(
	dados_salvos_id INT 			UNSIGNED 	NOT NULL AUTO_INCREMENT
    ,nome 			VARCHAR(50) 				NOT NULL
    ,criado_em		TIMESTAMP 					NOT NULL DEFAULT now()
    ,salvo_em		TIMESTAMP 					NOT NULL DEFAULT now() ON UPDATE now()
    ,cenario_atual 	INT 			UNSIGNED 	NOT NULL DEFAULT 0
    ,capitulo_atual INT 			UNSIGNED 	NOT NULL DEFAULT 0
    ,nota_cap_1 	NUMERIC(3,1)	UNSIGNED
    ,nota_cap_2 	NUMERIC(3,1)	UNSIGNED
    ,nota_cap_3 	NUMERIC(3,1)	UNSIGNED
    ,nota_cap_4 	NUMERIC(3,1)	UNSIGNED
    ,nota_cap_5 	NUMERIC(3,1)	UNSIGNED
    ,nota_cap_6 	NUMERIC(3,1)	UNSIGNED
    ,PRIMARY KEY	(dados_salvos_id)
);

CREATE TABLE dificuldade(
	dificuldade_id 		INT(1) UNSIGNED NOT NULL
    ,dificuldade_text 	VARCHAR(20) 	NOT NULL
    ,PRIMARY KEY		(dificuldade_id)
    ,UNIQUE				(dificuldade_text)
);


CREATE TABLE enunciado(
	enunciado_id 				INT 	UNSIGNED 	NOT NULL AUTO_INCREMENT
    ,enunciado_text 			TEXT 				NOT NULL
    ,dificuldade_id				INT(1)	UNSIGNED
    ,capitulo_tema	 			INT 	UNSIGNED
    ,PRIMARY KEY 				(enunciado_id)
    ,FOREIGN KEY				(dificuldade_id)
		REFERENCES dificuldade 	(dificuldade_id) ON DELETE CASCADE
);

CREATE TABLE alternativa(
	alternativa_id 				INT UNSIGNED 	NOT NULL AUTO_INCREMENT
    ,alternativa_text 			TEXT 			NOT NULL
    ,enunciado_id 				INT UNSIGNED 	NOT NULL
    ,resultado 					TINYINT 		NOT NULL -- 0 = ERRADO, 1 = CORRETO
    ,PRIMARY KEY 				(alternativa_id)
    ,FOREIGN KEY 				(enunciado_id)
		REFERENCES enunciado	(enunciado_id) 	ON DELETE CASCADE
);

CREATE TABLE local_ranking(
	ranking_id 					INT 	UNSIGNED 	NOT NULL AUTO_INCREMENT
    ,dados_salvos_id			INT 	UNSIGNED
    ,pontuacao					INT 				NOT NULL
    ,jogado_em					TIMESTAMP 			NOT NULL DEFAULT now()
    ,dificuldade_id 			INT(1)	UNSIGNED
    ,PRIMARY KEY				(ranking_id)
    ,FOREIGN KEY 				(dificuldade_id)
		REFERENCES dificuldade	(dificuldade_id)
	,FOREIGN KEY 				(dados_salvos_id)
		REFERENCES dados_salvos (dados_salvos_id)	ON DELETE CASCADE
);

-- Inserção de dados salvos

INSERT INTO dados_salvos(nome) VALUES
	 ('Cecília')
	,('Dennis')
    ,('Douglas')
    ,('Gabriel')
    ,('Wellington')
    ,('Jooj')
    ,('Gabriela')
    ,('Ricardo Millos')
    ,('Milkes')
    ,('Marjorie')
;

-- Inserção de dificuldades

INSERT INTO dificuldade(dificuldade_id, dificuldade_text) VALUES
	 (1, 'Fácil'	)
	,(2, 'Médio'	)
	,(3, 'Difícil'	)
;

-- Inserção de perguntas

INSERT INTO enunciado(enunciado_text, dificuldade_id) VALUES
	 -- Faceis
     ('Qual o valor de x? 2 + 2 = x', 1				)
	,('Você sabe o que é caviar?', 1				)
	,('Você é homosapien sapien?', 1				)
	,('Essa é uma pergunta teste', 1				)
    ,('O que você come no intervalo da faculdade', 1)
    ,('Essa é uma questão com duas alternativas', 1	)
    ,('Essa é uma questão com três alternativas', 1	)
    
    -- Regulares
    ,('Questão de nível médio', 2					)
    
    -- Difíceis
    ,('Questão de nível difícil', 3					)
;

-- Inserção de alternativas
INSERT INTO alternativa(alternativa_text, enunciado_id, resultado) VALUES
	-- Q1
     ('3', 1, 0)
    ,('4', 1, 1)
    ,('2', 1, 0)
    ,('6', 1, 0)
    
    -- Q2
    ,('Não', 2, 0									)
    ,('Sim', 2, 0									)
    ,('Nunca vi, nem comi, eu só ouço falar', 2, 1	)
    ,('Já vi, comi e ouvi falar', 2, 0				)
    
    -- Q3
	,('Sai fora, sou bem macho!', 3, 0		)
    ,('Não, mas não tenho preconceito', 3, 0)
    ,('Claro, todos somos!', 3, 1			)
    ,('Ainda não evoluí a este ponto', 3, 0	)
    
    -- Q4
	,('Essa resposta está errada', 4, 0	)
    ,('Também está errada', 4, 0		)
    ,('Essa tá certa', 4, 1				)
    ,('Outra errada', 4, 0				)
    
    -- Q5
	,('Calzone, pão de batata e outras coisas', 5, 1)
    ,('Pizza, pão de queijo e só', 5, 0				)
    ,('Churrasquinho de gato', 5, 0					)
    ,('Não me alimento na faculdade', 5, 0			)
    
    -- Q6
	,('Uma alternativa - correta', 6, 1	)
    ,('Outra alternativa - errada', 6, 0)
    
    -- Q7
	,('Primeira alternativa - errada', 7, 0	)
    ,('Segunda alternativa - correta', 7, 1	)
    ,('Terceira alternativa - errada', 7, 0	)
    
    -- Q8
	,('1', 8, 0	)
    ,('2', 8, 1	)
    ,('3', 8, 0	)
    ,('4', 8, 0	)
    
    -- Q9
	,('1', 9, 0	)
    ,('2', 9, 1	)
    ,('3', 9, 0	)
    ,('4', 9, 0	)
    ,('5', 9, 0	)
;

-- Inserção das pontuações
INSERT INTO local_ranking(dados_salvos_id, pontuacao, dificuldade_id) VALUES
	-- nivel 1
	 (6, 500000, 1)
    ,(1, 450000, 1)
    ,(2, 400000, 1)
    ,(3, 350000, 1)
    ,(4, 300000, 1)
    ,(5, 250000, 1)
    ,(7, 200000, 1)
    ,(8, 150000, 1)
    ,(9, 100000, 1)
    ,(10, 50000, 1)
    
    -- nivel 2
    ,(6, 750000, 2)
    ,(1, 700000, 2)
    ,(2, 650000, 2)
    ,(3, 600000, 2)
    ,(4, 550000, 2)
    ,(5, 500000, 2)
    ,(7, 450000, 2)
    ,(8, 400000, 2)
    ,(9, 350000, 2)
    ,(10, 300000, 2)
    
    -- nivel 3
    ,(6, 1000000, 3)
    ,(1, 900000, 3)
    ,(2, 850000, 3)
    ,(3, 800000, 3)
    ,(4, 750000, 3)
    ,(5, 700000, 3)
    ,(7, 650000, 3)
    ,(8, 600000, 3)
    ,(9, 550000, 3)
    ,(10, 500000, 3)
;
    
-- select

-- quantidade de enunciados por dificuldade
SELECT 	COUNT(enunciado_id) AS total
FROM 	enunciado
WHERE 	dificuldade_id = 1
;

--  Selecionar questoes aleatórias por dificuldade
SELECT 		enunciado_id
FROM 		enunciado 
WHERE 		dificuldade_id = 1 
ORDER BY 	RAND() 
LIMIT 		10
;

-- Selecionar enunciado e suas alternativas com posiçoes aleatorias
SELECT 	e.enunciado_id, e.enunciado_text, e.dificuldade_id,
		a.alternativa_id, a.alternativa_text, a.resultado
FROM enunciado e
	INNER JOIN alternativa a
		ON e.enunciado_id = a.enunciado_id
WHERE
    -- a.resultado = 1
    -- AND
    e.enunciado_id = 1
ORDER BY Rand()
;

-- Ranking Quiz
-- 1
SELECT 	ds.nome,
		lr.dificuldade_id, lr.pontuacao, lr.jogado_em
FROM 	local_ranking lr
	INNER JOIN dados_salvos ds
		ON ds.dados_salvos_id = lr.dados_salvos_id
WHERE 	lr.dificuldade_id = 1
ORDER BY pontuacao DESC
;

-- 2
SELECT 	ds.nome,
		lr.dificuldade_id, lr.pontuacao, lr.jogado_em
FROM 	local_ranking lr
	INNER JOIN dados_salvos ds
		ON ds.dados_salvos_id = lr.dados_salvos_id
WHERE 	lr.dificuldade_id = 2
ORDER BY pontuacao DESC
;

-- 3
SELECT 	ds.nome,
		lr.dificuldade_id, lr.pontuacao, lr.jogado_em
FROM 	local_ranking lr
	INNER JOIN dados_salvos ds
		ON ds.dados_salvos_id = lr.dados_salvos_id
WHERE 	lr.dificuldade_id = 3
ORDER BY pontuacao DESC
;

-- Dados salvos
SELECT * FROM dados_salvos;