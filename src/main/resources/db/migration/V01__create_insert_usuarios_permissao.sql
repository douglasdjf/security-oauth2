CREATE TABLE usuario (
	id BIGINT PRIMARY KEY auto_increment ,
	nome VARCHAR(50) NOT NULL,
	email VARCHAR(50) NOT NULL,
	senha VARCHAR(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE permissao (
	id BIGINT PRIMARY KEY auto_increment,
	descricao VARCHAR(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE usuario_permissao (
	id_usuario BIGINT NOT NULL ,
	id_permissao BIGINT NOT NULL,
	PRIMARY KEY (id_usuario, id_permissao),
	FOREIGN KEY (id_usuario) REFERENCES usuario(id),
	FOREIGN KEY (id_permissao) REFERENCES permissao(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- inserindo permissão
INSERT INTO permissao (id, descricao) values (1, 'ROLE_PESQUISAR_USUARIO');
INSERT INTO permissao (id, descricao) values (2, 'ROLE_CRIAR_USUARIO');
INSERT INTO permissao (id, descricao) values (3, 'ROLE_DELETE_USUARIO');
INSERT INTO permissao (id, descricao) values (4, 'ROLE_ALTERAR_USUARIO');

-- inserindo usuario
-- senha admin
INSERT INTO usuario (nome, email, senha) values ( 'Administrador', 'admin@admin.com', '$2a$10$X607ZPhQ4EgGNaYKt3n4SONjIv9zc.VMWdEuhCuba7oLAL5IvcL5.');
-- senha maria
INSERT INTO usuario (nome, email, senha) values ( 'Maria Silva', 'maria@maria.com', '$2a$10$Zc3w6HyuPOPXamaMhh.PQOXvDnEsadztbfi6/RyZWJDzimE8WQjaq');


-- admin
INSERT INTO usuario_permissao (id_usuario, id_permissao) values (1, 1);
INSERT INTO usuario_permissao (id_usuario, id_permissao) values (1, 2);
INSERT INTO usuario_permissao (id_usuario, id_permissao) values (1, 3);
INSERT INTO usuario_permissao (id_usuario, id_permissao) values (1, 4);

-- maria
INSERT INTO usuario_permissao (id_usuario, id_permissao) values (2, 1);

