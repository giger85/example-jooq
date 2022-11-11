CREATE TABLE foo (
    id          BIGINT                      PRIMARY KEY,
    name        VARCHAR(16)                 NOT NULL,
    created_at  TIMESTAMP WITH TIME ZONE    NOT NULL DEFAULT now()
);