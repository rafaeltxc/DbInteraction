CREATE SCHEMA IF NOT EXISTS library
DEFAULT CHARACTER SET utf8mb4
DEFAULT COLLATE utf8mb4_general_ci;

CREATE TABLE library.tbl_user (

    id_user    INT NOT NULL AUTO_INCREMENT,
    nickname_user    VARCHAR(25) NOT NULL,
    password_user	 VARCHAR(100) NOT NULL,
    birth_user    DATE NOT NULL,

    PRIMARY KEY (id_user)
);

CREATE TABLE library.tbl_book (

	id_book    INT NOT NULL AUTO_INCREMENT,
	title_book    VARCHAR(100) NOT NULL,
	resume_book    TEXT(500),
	book    TEXT(999999) NOT NULL,
	fk_id_user INT NOT NULL,
	
	PRIMARY KEY (id_book),
	FOREIGN KEY (fk_id_user) REFERENCES library.tbl_user (id_user) ON DELETE CASCADE

);
