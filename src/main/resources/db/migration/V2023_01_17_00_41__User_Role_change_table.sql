CREATE TABLE roles
(
    r_id   BIGINT AUTO_INCREMENT NOT NULL,
    r_name VARCHAR(255)          NOT NULL,
    CONSTRAINT pk_roles PRIMARY KEY (r_id)
);

CREATE TABLE users
(
    u_id       BIGINT AUTO_INCREMENT NOT NULL,
    u_name     VARCHAR(255)          NOT NULL,
    u_email    VARCHAR(255)          NOT NULL,
    u_password VARCHAR(255)          NOT NULL,
    CONSTRAINT pk_users PRIMARY KEY (u_id)
);

CREATE TABLE users_roles
(
    r_id BIGINT NOT NULL,
    u_id BIGINT NOT NULL
);

ALTER TABLE users_roles
    ADD CONSTRAINT fk_userol_on_role FOREIGN KEY (r_id) REFERENCES roles (r_id);

ALTER TABLE users_roles
    ADD CONSTRAINT fk_userol_on_user FOREIGN KEY (u_id) REFERENCES users (u_id);