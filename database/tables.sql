CREATE TABLE users (
	id SERIAL PRIMARY KEY,
	name VARCHAR ( 80 ) UNIQUE NOT NULL,
	password VARCHAR ( 255 ) NOT NULL,
	email VARCHAR ( 255 ) UNIQUE NOT NULL,
	age integer not null
);