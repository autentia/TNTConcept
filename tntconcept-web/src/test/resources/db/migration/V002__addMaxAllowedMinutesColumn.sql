ALTER TABLE Project
    MODIFY COLUMN open BOOLEAN NOT NULL;

ALTER TABLE ProjectRole
    ADD maxAllowed INT NOT NULL DEFAULT 0;

ALTER TABLE ProjectRole
    MODIFY COLUMN maxAllowed INT NOT NULL;