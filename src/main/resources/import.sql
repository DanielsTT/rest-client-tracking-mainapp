
INSERT INTO restclienttracking.roles(r_id, r_name) VALUES(1, 'ADMIN');
INSERT INTO restclienttracking.roles(r_id, r_name) VALUES(2, 'USER');

INSERT INTO restclienttracking.users (u_id, u_first_name, u_last_name, u_email, u_password, u_phone) VALUES (1, 'admin', 'admin', 'admin@example.com', '{bcrypt}$2a$10$PZomtrVYYPi4dB0vm5HYDOHib.O/WLXHmY41f4iHKKPCVdEDLJUvW', '123');
INSERT INTO restclienttracking.users (u_id, u_first_name, u_last_name, u_email, u_password, u_phone) VALUES (2, 'user', 'admin', 'user@example.com', '{bcrypt}$2a$10$ZKhlcv0ki4chQZhiUGupM.50BUfDavDXPfmHsn3np.IcA26IO8fSC', '123');

INSERT INTO restclienttracking.users_roles (u_id, r_id) VALUES(1, 1);
INSERT INTO restclienttracking.users_roles (u_id, r_id) VALUES(2, 2);
