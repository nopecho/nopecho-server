CREATE TABLE IF NOT EXISTS "members_roles"
(
    id          BIGINT PRIMARY KEY,
    member_id   BIGINT       NOT NULL,
    role        varchar(255) NOT NULL,
    created_at  TIMESTAMPTZ DEFAULT NOW(),
    modified_at TIMESTAMPTZ DEFAULT NOW(),
    version     BIGINT       NOT NULL
);

CREATE TABLE IF NOT EXISTS "members_signs"
(
    id          BIGINT PRIMARY KEY,
    member_id   BIGINT       NOT NULL,
    provider    varchar(255) NOT NULL,
    token       varchar(255) NOT NULL,
    created_at  TIMESTAMPTZ DEFAULT NOW(),
    modified_at TIMESTAMPTZ DEFAULT NOW(),
    version     BIGINT       NOT NULL
);