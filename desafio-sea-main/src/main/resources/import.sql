INSERT INTO tb_setor (name) VALUES ('Compras');
INSERT INTO tb_setor (name) VALUES ('Administracao');
INSERT INTO tb_setor (name) VALUES ('Contabilidade');
INSERT INTO tb_setor (name) VALUES ('Tecnologia');
INSERT INTO tb_setor (name) VALUES ('Logistica');

INSERT INTO tb_cargo (name, setor_id) VALUES ('Comprador', 1);
INSERT INTO tb_cargo (name, setor_id) VALUES ('Contador', 3);
INSERT INTO tb_cargo (name, setor_id) VALUES ('Comprador', 1);
INSERT INTO tb_cargo (name, setor_id) VALUES ('Administrador', 2);

INSERT INTO tb_trabalhador (name, cpf, sexo, cargo_id) VALUES ('Pedro', '000.000.000-00', 'm', 1);
INSERT INTO tb_trabalhador (name, cpf, sexo, cargo_id) VALUES ('Paula', '000.000.000-01', 'f', 2);
INSERT INTO tb_trabalhador (name, cpf, sexo, cargo_id) VALUES ('Mauro', '000.000.000-02', 'm', 3);
INSERT INTO tb_trabalhador (name, cpf, sexo, cargo_id) VALUES ('Cristopher', '000.000.000-03', 'm', 4);
INSERT INTO tb_trabalhador (name, cpf, sexo, cargo_id) VALUES ('Maria', '000.000.000-40', 'f', 2);
