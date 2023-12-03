--liquibase formatted sql

--changeset Savitsky_E:2
INSERT INTO users (nickname, name, email)
VALUES ('Bobbi', 'Bob Nilso', 'bob_nil@gmail.com'),
       ('Tonnni', 'Tom Rider', 'Tom_r@gmail.com'),
       ('Willi', 'Will Smith', 'will.smith@gmail.com'),
       ('Tommi', 'Tom Cruae', 'tom.cru@gmail.com'),
       ('Sony', 'Sony Nilon', 'so.nik@gmail.com'),
       ('Judi', 'Judi Sovins', 'sovinij@gmail.com'),
       ('li', 'Julia Li', 'juli.li@gmail.com');

INSERT INTO categories (name)
VALUES ('Sport'),
       ('History'),
       ('Discovery'),
       ('Cook'),
       ('Films');

INSERT INTO channels (name, description, "language", avatar, category_id, author_id)
VALUES ('SportOne', 'All kind of sport', 'En', 'link1', 1, 1),
       ('New history', 'History of Europe', 'Fr', 'link2', 2, 2),
       ('TravelEveryDay', 'Travel best', 'Ru', 'link3', 3, 3),
       ('Cook All', 'Food there is cool', 'Gr', 'link4', 4, 4),
       ('Action films', 'Films 24/7', 'It', 'link5', 5, 5);

INSERT INTO users_channels (user_id, channel_id)
VALUES (1, 1),
       (1, 2),
       (1, 3),
       (2, 4),
       (2, 5),
       (3, 2),
       (3, 3),
       (3, 4),
       (4, 2),
       (5, 3),
       (6, 4),
       (7, 2),
       (7, 3),
       (7, 5);