create table horses (
	id BIGSERIAL PRIMARY KEY NOT NULL,
	first_name VARCHAR(50) NOT NULL,
	last_name VARCHAR(50) NOT NULL,
	email VARCHAR(50) NOT NULL,
	gender VARCHAR(50) NOT NULL,
	picture VARCHAR(50),
	biography TEXT,
    body_height INT NOT NULL DEFAULT 0,
	body_length INT NOT NULL DEFAULT 0,
	city VARCHAR(50),
	country VARCHAR(50),
	is_active VARCHAR(50) DEFAULT 0,
	last_active_at DATE,
	created_at DATE,
	updated_at DATE
);