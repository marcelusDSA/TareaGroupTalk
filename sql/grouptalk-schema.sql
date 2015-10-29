drop database if exists grouptalkdb;
create database grouptalkdb;

use grouptalkdb;

CREATE TABLE users (
	id BINARY(16) NOT NULL,
	loginid VARCHAR(15) NOT NULL UNIQUE,
	password BINARY(16) NOT NULL,
	email VARCHAR (255) NOT NULL,
	fullname VARCHAR (255) NOT NULL,
	PRIMARY KEY (id,loginid)
);

CREATE TABLE user_roles (
	userid BINARY(16) NOT NULL,
	role ENUM ('registered'),
	FOREIGN KEY (userid) REFERENCES users(id) on delete cascade,
	PRIMARY KEY (userid, role)
);

CREATE TABLE auth_tokens (
	userid BINARY(16) NOT NULL,
	token BINARY(16) NOT NULL,
	FOREIGN KEY (userid) REFERENCES users(id) on delete cascade,
	PRIMARY KEY (token)
);

CREATE TABLE grupos (
	id VARCHAR(15) NULL,
	tipodegrupo VARCHAR (50) NOT NULL,
	PRIMARY KEY (id)
);

INSERT INTO grupos (id, tipodegrupo) VALUES ('1', 'Economia');
INSERT INTO grupos (id, tipodegrupo) VALUES ('2', 'Politica');
INSERT INTO grupos (id, tipodegrupo) VALUES ('3', 'Religion');


CREATE TABLE temas (

	id BINARY(16) NOT NULL,
	userid varchar(15) NULL,
	grupoid VARCHAR(15) NOT NULL,
	titulo VARCHAR(50) NOT NULL,
	contenido VARCHAR (200) NOT NULL,
	FOREIGN KEY (userid) REFERENCES users(loginid) on delete cascade,
	FOREIGN KEY (grupoid) REFERENCES grupos(id) on delete cascade,
	PRIMARY KEY (id)
);
/*
userid BINARY(16) NOT NULL,
*/
CREATE TABLE respuestas (
	id BINARY (16) NOT NULL,
	userid varchar(15) NOT NULL,
	temaid BINARY(16) NOT NULL,
	respuesta VARCHAR (200) NOT NULL,
	FOREIGN KEY (userid) REFERENCES users(loginid) on delete cascade,
        FOREIGN KEY (temaid) REFERENCES temas(id) on delete cascade,
	PRIMARY KEY (id)
);



