-- liquibase formatted sql

-- changeset Homychok:1

CREATE TABLE users(
                      id         BIGSERIAL PRIMARY KEY,
                      user_name   VARCHAR(60)
);