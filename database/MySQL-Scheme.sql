CREATE SCHEMA IF NOT EXISTS authentication
DEFAULT CHARACTER SET utf8mb4
DEFAULT COLLATE utf8mb4_general_ci;

CREATE TABLE authentication.tbl_user (

    id_user    INT NOT NULL AUTO_INCREMENT,
    first_name    VARCHAR(15) NOT NULL,
    last_name    VARCHAR(15) NOT NULL,
    email    VARCHAR(35) NOT NULL,
    birth    DATE NOT NULL,

    PRIMARY KEY (id_user)
);
