CREATE TABLE visitors
(
    v_id          BIGINT AUTO_INCREMENT NOT NULL,
    v_ip_address  VARCHAR(255)          NOT NULL,
    v_method      VARCHAR(255)          NOT NULL,
    v_request     VARCHAR(255)          NOT NULL,
    v_logged_time datetime              NOT NULL,
    CONSTRAINT pk_visitors PRIMARY KEY (v_id)
);