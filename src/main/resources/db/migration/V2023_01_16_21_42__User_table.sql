CREATE TABLE users
(
    u_id         BIGINT AUTO_INCREMENT NOT NULL,
    u_first_name VARCHAR(255)          NOT NULL,
    u_last_name  VARCHAR(255)          NOT NULL,
    u_email      VARCHAR(255)          NOT NULL,
    u_password   VARCHAR(255)          NOT NULL,
    u_phone      VARCHAR(255)          NOT NULL,
    CONSTRAINT pk_users PRIMARY KEY (u_id)
);