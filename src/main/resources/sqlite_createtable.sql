CREATE TABLE 'budget' (
    ID  INT PRIMARY KEY     NOT NULL,
    serialnumberofstandard  MESSAGE_TEXT,
    nameofprojectorcost MESSAGE_TEXT,
    UNIT MESSAGE_TEXT,
    QUANTITY REAL,
    UNITPRICE REAL,
    COMBINEDPRICE   REAL
);