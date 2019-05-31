INSERT INTO users (user_id, first_name, last_name, login, password, shift, enabled) VALUES ('1', 'Administrator', 'Główny', 'admin', '$2a$10$ArmIW3qCKzm/ctx6HHyzC.28v5b3UN9PxgnjcYB28S2QL7DVM69Rm', '0', '1');
INSERT INTO users (user_id, first_name, last_name, login, password, shift, enabled) VALUES ('2', 'Dyspozytor', 'Główny', 'dyspozytor', '$2a$10$naydFa84vYnpqgJkAW6Zb.NqshewziJ7TCAo8Y2IbzUYW4EOeg6k6', '0', '1');
INSERT INTO users (user_id, first_name, last_name, login, password, shift, enabled) VALUES ('3', 'Koordynator', 'Pierwszy', 'koordynator', '$2a$10$2S7vBwaCgzzEQdM4mL2/eOhn8MuAIUP1aGjv2oZ.9b.EOS8l5dE.y', '0', '1');

INSERT INTO roles (role_id, role_name) VALUES ('1', 'ROLE_ADMIN');
INSERT INTO roles (role_id, role_name) VALUES ('2', 'ROLE_DYSP');
INSERT INTO roles (role_id, role_name) VALUES ('3', 'ROLE_KOORD');

INSERT INTO user_role (user_id, role_id) VALUES ('1', '1');
INSERT INTO user_role (user_id, role_id) VALUES ('2', '2');
INSERT INTO user_role (user_id, role_id) VALUES ('3', '3');