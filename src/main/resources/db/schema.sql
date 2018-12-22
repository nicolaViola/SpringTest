create table users(
	username varchar_ignorecase(50) not null primary key,
	password varchar_ignorecase(200) not null,
	enabled boolean not null
);

create table authorities (
	username varchar_ignorecase(50) not null,
	authority varchar_ignorecase(50) not null,
	constraint fk_authorities_users foreign key(username) references users(username)
);

create table test(
	nome varchar(50),
	cognome varchar(50),
	eta integer
);
create table Elemento(
	id integer not null primary key,
	nome varchar(50),
);

