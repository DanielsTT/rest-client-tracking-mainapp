CREATE TABLE trainers
(
    t_id         BIGINT AUTO_INCREMENT NOT NULL,
    t_first_name VARCHAR(255)          NOT NULL,
    t_last_name  VARCHAR(255)          NOT NULL,
    t_email      VARCHAR(255)          NOT NULL,
    t_phone      VARCHAR(255)          NOT NULL,
    CONSTRAINT pk_trainers PRIMARY KEY (t_id)
);