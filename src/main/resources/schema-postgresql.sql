CREATE TABLE IF NOT EXISTS game (
    id serial PRIMARY KEY,
    nome varchar(50),
    anoLancamento INT,
    preco NUMERIC(10, 2)
);