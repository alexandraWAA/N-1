-- liquibase formatted sql

-- changeset Homychok:1
CREATE TABLE comment(
                        id BIGSERIAL PRIMARY KEY,
                        body VARCHAR(255) NOT NULL,
                        post_id BIGINT REFERENCES post(id),
                        user_id BIGINT REFERENCES users(id)
);