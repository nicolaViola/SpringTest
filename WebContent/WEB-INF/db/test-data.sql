INSERT INTO USERS(USERNAME, PASSWORD, ENABLED) VALUES ('admin', '$2a$04$M4tuM6J.qc9DtVu8Mzdj1u4ll5r8hEemXyO2MMO4ybWDSP8vnKej6', TRUE);
INSERT INTO USERS(USERNAME, PASSWORD, ENABLED) VALUES ('doe',   '$2a$04$X0QnO08OXDd2fWQY.YDAyed49z8UnhFXg/yMAVFsBddM18g8FxXza', TRUE);
INSERT INTO USERS(USERNAME, PASSWORD, ENABLED) VALUES ('bau',   '$2a$04$p8k81iEseArTEBzxLFcW9enlwM8Q58PwAEHc68xepIWNIp4zspnh2', TRUE);
INSERT INTO AUTHORITIES(USERNAME, AUTHORITY) VALUES ('admin', 'ROLE_ADMIN');
INSERT INTO AUTHORITIES(USERNAME, AUTHORITY) VALUES ('doe', 'ROLE_USER,ROLE_ADMIN');
INSERT INTO AUTHORITIES(USERNAME, AUTHORITY) VALUES ('bau', 'ROLE_USER');
