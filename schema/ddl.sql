CREATE TABLE IF NOT EXISTS "events"
(
    id               BIGINT PRIMARY KEY,
    type             varchar(255) NOT NULL,
    payload          json         NOT NULL,
    occurred_at      TIMESTAMPTZ  NOT NULL,
    created_at       TIMESTAMPTZ DEFAULT NOW(),
    last_modified_at TIMESTAMPTZ DEFAULT NOW(),
    version          BIGINT       NOT NULL
);