INSERT INTO USUARIO(nome, email, senha) VALUES('Aluno', 'aluno@email.com', '$2a$10$wJ9rYGuQKstk2cKapAhIteDqPkmjgaZZplrb/JCd6liHlsYqDbQou');
INSERT INTO USUARIO(nome, email, senha) VALUES('Moderador', 'moderador@email.com', '$2a$10$wJ9rYGuQKstk2cKapAhIteDqPkmjgaZZplrb/JCd6liHlsYqDbQou');

INSERT INTO PERFIL(id,nome) VALUES(1, 'ROLE_ALUNO')
INSERT INTO PERFIL(id,nome) VALUES(2, 'ROLE_MODERADOR')

INSERT INTO USUARIO_PERFIS(usuario_id, perfis_id) VALUES (1,1);
INSERT INTO USUARIO_PERFIS(usuario_id, perfis_id) VALUES (2,2);

INSERT INTO CURSO(nome, categoria) VALUES('HTML 5', 'Front-End');
INSERT INTO CURSO(nome, categoria) VALUES('Spring Boot', 'Programacao');

INSERT INTO TOPICO(titulo, mensagem, data_criacao, status, autor_id, curso_id) VALUES('Duvida', 'Erro ao criar projeto', '2019-05-05T10:25:14.2151209', 'NAO_RESPONDIDO', '1', '1');
INSERT INTO TOPICO(titulo, mensagem, data_criacao, status, autor_id, curso_id) VALUES('Duvida', 'Erro ao criar projeto', '2019-05-05T10:25:14.2151209', 'NAO_RESPONDIDO', '1', '1');
INSERT INTO TOPICO(titulo, mensagem, data_criacao, status, autor_id, curso_id) VALUES('Duvida', 'Erro ao criar projeto', '2019-05-05T10:25:14.2151209', 'NAO_RESPONDIDO', '1', '2');