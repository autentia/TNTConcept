-- -----------------------------------------------------------------------------
-- Activity
-- -----------------------------------------------------------------------------
--
ALTER TABLE Activity ADD approvalState varchar(10) NOT NULL;
-- -----------------------------------------------------------------------------
-- Version
-- -----------------------------------------------------------------------------
--
-- Update version number
UPDATE Version
SET version='0.48';