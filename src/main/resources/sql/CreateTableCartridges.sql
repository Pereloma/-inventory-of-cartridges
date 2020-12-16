CREATE TABLE IF NOT EXISTS Cartridges
(
    id         serial PRIMARY KEY,
    barcode_1d text,
    barcode_qr text,
    status     serial REFERENCES Status (id),
    comment    text,
    hospital   serial REFERENCES Hospital (id),
    cabinet    text
    )