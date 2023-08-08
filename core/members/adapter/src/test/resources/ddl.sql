CREATE TABLE IF NOT EXISTS "members"
(
    id                 BIGINT PRIMARY KEY,
    name               varchar(255) NOT NULL,
    email              varchar(255) NOT NULL,
    phone_number       varchar(255) NOT NULL,
    country_code       varchar(255) NOT NULL,
    is_agree_marketing boolean      NOT NULL,
    created_at         TIMESTAMPTZ DEFAULT NOW(),
    modified_at        TIMESTAMPTZ DEFAULT NOW(),
    version            BIGINT       NOT NULL
);

CREATE TABLE IF NOT EXISTS "members_roles"
(
    member_id   BIGINT       NOT NULL,
    role        varchar(255) NOT NULL,
    created_at  TIMESTAMPTZ DEFAULT NOW(),
    modified_at TIMESTAMPTZ DEFAULT NOW()
);

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