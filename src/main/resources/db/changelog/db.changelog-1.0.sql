--liquibase formatted sql

--changeset Savitsky_E:1
CREATE TABLE IF NOT EXISTS categories
(
    id BIGSERIAL CONSTRAINT categories_pk PRIMARY KEY,
    "name" VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS users
(
    id       bigserial CONSTRAINT users_pk PRIMARY KEY,
    nickname VARCHAR(50) NOT NULL,
    "name"     VARCHAR(80) NOT NULL,
    email    VARCHAR(80) NOT NULL CONSTRAINT users_pk2 UNIQUE
);

CREATE TABLE IF NOT EXISTS channels
(
    id          BIGSERIAL CONSTRAINT channels_pk PRIMARY KEY,
    "name"        VARCHAR(50)             NOT NULL,
    "description" VARCHAR,
    date_create TIMESTAMP DEFAULT now() NOT NULL,
    "language"    VARCHAR(10)             NOT NULL,
    avatar      VARCHAR,
    category_id BIGINT NOT NULL,
    author_id   BIGINT NOT NULL CONSTRAINT channels_users_id_fk REFERENCES users
);

CREATE TABLE IF NOT EXISTS users_channels
(
    user_id    BIGINT NOT NULL CONSTRAINT users_channels_users_id_fk REFERENCES users,
    channel_id BIGINT NOT NULL CONSTRAINT users_channels_channels_id_fk REFERENCES channels,
    CONSTRAINT users_channels_pk PRIMARY KEY (user_id, channel_id)
);