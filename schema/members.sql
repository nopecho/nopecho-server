CREATE TABLE IF NOT EXISTS "members"
(
    id                 BIGINT PRIMARY KEY,
    name               varchar(255) NOT NULL,
    email              varchar(255) NOT NULL,
    phone_number       varchar(255) NOT NULL,
    country_code       varchar(255) NOT NULL,
    is_agree_marketing bool         NOT NULL,
    created_at         TIMESTAMPTZ DEFAULT NOW(),
    modified_at        TIMESTAMPTZ DEFAULT NOW(),
    version            BIGINT       NOT NULL
);