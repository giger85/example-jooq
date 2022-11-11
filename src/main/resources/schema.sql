CREATE TABLE foo (
    id              BIGINT                      PRIMARY KEY,
    name            VARCHAR(16)                 NOT NULL,
    json_data       JSONB                       NULL,
    created_at      TIMESTAMP WITH TIME ZONE    NOT NULL DEFAULT now()
);

CREATE TABLE bar (
    id              BIGINT                      PRIMARY KEY,
    name            VARCHAR(16)                 NOT NULL,
    json_array_data JSONB                       NULL,
    created_at      TIMESTAMP WITH TIME ZONE    NOT NULL DEFAULT now()
);