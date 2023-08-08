CREATE TABLE IF NOT EXISTS "accounts"
(
    id          BIGSERIAL PRIMARY KEY,
    member_id   BIGINT NOT NULL,
    created_at  TIMESTAMPTZ DEFAULT NOW(),
    modified_at TIMESTAMPTZ DEFAULT NOW(),
    version     BIGINT NOT NULL
);

CREATE TABLE IF NOT EXISTS "accounts_signatures"
(
    accounts_id BIGINT       NOT NULL,
    method      varchar(255) NOT NULL,
    token       varchar(255) NOT NULL,
    created_at  TIMESTAMPTZ DEFAULT NOW(),
    modified_at TIMESTAMPTZ DEFAULT NOW()
);