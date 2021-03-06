--Como usuário, quando seleciono "Cidades" quero ver a lista de cidades.
SELECT * FROM CIDADE;

--Como usuário, quando seleciono uma cidade quero ver a lista de filmes.
SELECT F.ID, F.NAME
FROM FILME F
INNER JOIN FILME_SALA_HORARIO FSH ON FSH.ID_FILME = F.ID
INNER JOIN SALA S ON S.ID = FSH.ID_SALA
INNER JOIN CINEMA C ON C.ID = S.ID_CINEMA
INNER JOIN CIDADE CI ON CI.ID = C.ID_CIDADE
WHERE CI.ID = ?
GROUP BY F.ID, F.NAME;

--Como usuário, quando seleciono um filme quero ver a lista de cinemas.
SELECT
	C.ID AS ID_CINEMA,
	C.NAME AS CINEMA,
	CI.ID AS ID_CIDADE,
	CI.NOME AS CIDADE
FROM CINEMA C
INNER JOIN SALA S ON S.ID_CINEMA = C.ID
INNER JOIN FILME_SALA_HORARIO FSH ON FSH.ID_SALA = S.ID
INNER JOIN FILME F ON F.ID = FSH.ID_FILME
INNER JOIN CIDADE CI ON CI.ID = C.ID_CIDADE
WHERE F.ID = ?
GROUP BY C.ID, C.NAME, CI.ID, CI.NOME;

--Como usuário, quando seleciono um cinema quero ver a lista de horários.
SELECT
	H.HORA_INICIO,
	H.HORA_FIM
FROM HORARIO H
INNER JOIN FILME_SALA_HORARIO FSH ON FSH.ID_HORARIO = H.ID
INNER JOIN SALA S ON S.ID = FSH.ID_SALA
INNER JOIN CINEMA C ON C.ID = S.ID_CINEMA
INNER JOIN CIDADE CI ON CI.ID = C.ID_CIDADE
WHERE C.ID = ?
GROUP BY H.HORA_INICIO, H.HORA_FIM;

--Como usuário, quando seleciono um horário e informo o número de assentos quero ver os assentos disponíveis.
SELECT
	A.ID,
	A.NOME,
	A.FILA,
	A.NUM_CADEIRA
FROM ASSENTO A
INNER JOIN SALA S ON S.ID = A.ID_SALA
INNER JOIN FILME_SALA_HORARIO FSH ON FSH.ID_SALA = S.ID
INNER JOIN FILME F ON F.ID = FSH.ID_FILME
INNER JOIN HORARIO H ON H.ID = FSH.ID_HORARIO
LEFT JOIN INGRESSO I ON I.ID_FILME_SALA_HORARIO = FSH.ID
WHERE S.ID = ?
	AND F.ID = ?
	AND H.ID = ?
	AND I.ID IS NULL // Retira os assentos com ingressos
GROUP BY A.ID, A.NOME, A.FILA, A.NUM_CADEIRA;

--Como usuário, quando seleciono o(s) assento(s) quero ver o preço total.
SELECT
	SUM(FSH.VALOR) AS PRECO_TOTAL
FROM ASSENTO A
INNER JOIN SALA S ON S.ID = A.ID_SALA
INNER JOIN FILME_SALA_HORARIO FSH ON FSH.ID_SALA = S.ID
INNER JOIN FILME F ON F.ID = FSH.ID_FILME
INNER JOIN HORARIO H ON H.ID = FSH.ID_HORARIO
WHERE S.ID = ?
	AND F.ID = ?
	AND H.ID = ?
	AND A.ID = ?;

--Como usuário, quando  seleciono  "Concluir  Compra"  quero  ser  redirecionado  a  um  gateway  de pagamento.
INSERT INTO INGRESSO (ID_FILME_SALA_HORARIO, ID_ASSENTO, ID_USUARIO) VALUES (?, ?, ?); -- INSERT para cada ingresso comprado

--Como usuário, quando realizo o pagamento quero receber o(s) ingresso(s) por e-mail.
SELECT
	C.NOME AS CINEMA,
	S.NOME AS SALA,
	A.FILA, A.NUM_CADEIRA,
	F.NOME AS FILME,
	H.HORA_INICIO,
	H.HORA_FIM
FROM INGRESSO I
INNER JOIN ASSENTO A ON A.ID = I.ID_ASSENTO
INNER JOIN SALA S ON S.ID = A.ID_SALA
INNER JOIN CINEMA C ON C.ID = S.ID_CINEMA
INNER JOIN FILME_SALA_HORARIO FSH ON FSH.ID = I.ID_FILME_SALA_HORARIO
INNER JOIN FILME F ON F.ID = FSH.ID_FILME
INNER JOIN HORARIO H ON H.ID = FSH.ID_HORARIO
WHERE I.ID_USUARIO = ?
GROUP BY C.NOME AS CINEMA, S.NOME AS SALA, A.FILA, A.NUM_CADEIRA, F.NOME AS FILME, H.HORA_INICIO, H.HORA_FIM;
