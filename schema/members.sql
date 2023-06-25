CREATE TABLE IF NOT EXISTS "members"
(
    id          BIGINT PRIMARY KEY,
    name        varchar(255) NOT NULL,
    email       varchar(255) NOT NULL,
    role        varchar(255) NOT NULL,
    created_at  TIMESTAMPTZ DEFAULT NOW(),
    modified_at TIMESTAMPTZ DEFAULT NOW(),
    version     BIGINT       NOT NULL
);