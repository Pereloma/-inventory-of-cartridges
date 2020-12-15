CREATE TABLE IF NOT EXISTS Cartridges
(
    id         integer PRIMARY KEY,
    barcode_1d text,
    barcode_qr text,
    comment    text,
    hospital   integer REFERENCES Hospital (id),
    cabinet    text
    )