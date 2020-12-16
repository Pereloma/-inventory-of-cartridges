CREATE TABLE IF NOT EXISTS Hospital
(
    id           serial PRIMARY KEY,
    abbreviation text,
    name         text,
    address      text,
    comment      text
)