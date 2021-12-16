INSERT INTO tb_setor (nome) VALUES ('aa');
INSERT INTO tb_setor (nome) VALUES ('ab');
INSERT INTO tb_setor (nome) VALUES ('ac');
INSERT INTO tb_setor (nome) VALUES ('ad');
INSERT INTO tb_setor (nome) VALUES ('ae');

INSERT INTO tb_cargo (nome, setor_id) VALUES ('ba', 1);
INSERT INTO tb_cargo (nome, setor_id) VALUES ('bb', 3);
INSERT INTO tb_cargo (nome, setor_id) VALUES ('bc', 1);
INSERT INTO tb_cargo (nome, setor_id) VALUES ('bd', 2);

INSERT INTO tb_trabalhador (name, cpf, sexo, cargo_id) VALUES ('Trabalhador 1', '000.000.000-00', 'm', 1);
INSERT INTO tb_trabalhador (name, cpf, sexo, cargo_id) VALUES ('Trabalhador 2', '000.000.000-01', 'f', 2);
INSERT INTO tb_trabalhador (name, cpf, sexo, cargo_id) VALUES ('Trabalhador 3', '000.000.000-02', 'm', 3);
INSERT INTO tb_trabalhador (name, cpf, sexo, cargo_id) VALUES ('Trabalhador 4', '000.000.000-03', 'm', 4);
INSERT INTO tb_trabalhador (name, cpf, sexo, cargo_id) VALUES ('Trabalhador 5', '000.000.000-40', 'f', 2);