--
-- TNTConcept Easy Enterprise Management by Autentia Real Bussiness Solution S.L.
-- Copyright (C) 2007 Autentia Real Bussiness Solution S.L.
--
-- This program is free software: you can redistribute it and/or modify
-- it under the terms of the GNU General Public License as published by
-- the Free Software Foundation, either version 3 of the License.
--
-- This program is distributed in the hope that it will be useful,
-- but WITHOUT ANY WARRANTY; without even the implied warranty of
-- MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
-- GNU General Public License for more details.
--
-- You should have received a copy of the GNU General Public License
-- along with this program.  If not, see <http://www.gnu.org/licenses/>.
--

-- Debe añadirse debajo de [mysqld] en el archivo my.cnf de la instalación mysql de la máquina destino.
-- Si se realiza mediante script necesita ser ejecutado por un usuario con permiso SUPER.
-- set global sql_mode = 'STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------------------------------
-- Bill
-- -----------------------------------------------------------------------------

ALTER TABLE Bill ADD COLUMN deductibleIVAPercentage TINYINT NOT NULL DEFAULT 100;

UPDATE Bill SET deductibleIVAPercentage = 50
WHERE Bill.number IN (SELECT Bill.number FROM Organization AS o
WHERE Bill.providerId = o.id AND (o.id = 865 OR o.id = 834 OR o.id = 1544));

-- Los Id son organizaciones de renting, que solo se deduce el 50% del IVA

-- -----------------------------------------------------------------------------
-- Version
-- -----------------------------------------------------------------------------
--
-- Update version number
UPDATE Version SET version='0.38';