CREATE TABLE IF NOT EXISTS SendingForFueling
(
    id              serial PRIMARY KEY,
    date_of_sending date,
    date_of_receipt date,
    status          serial REFERENCES Status (id),
    refills_status  integer,
    cartridges      integer REFERENCES Cartridges (id)
)