-- Version 2 Migration Script

-- 1. Add a 'pseudonimo' column to the 'Titular' table
ALTER TABLE socinproapp.Titular
    ADD COLUMN pseudonimo VARCHAR;

-- 2. Add a 'usuario_id' column to the 'Titular' table for linking to 'Usuario'
ALTER TABLE socinproapp.Titular
    ADD COLUMN usuario_id BIGINT UNIQUE;

-- 3. Add a foreign key constraint from 'Titular' to 'Usuario' through 'usuario_id'
ALTER TABLE socinproapp.Titular
    ADD CONSTRAINT fk_usuario_id
        FOREIGN KEY (usuario_id) REFERENCES socinproapp.Usuario(id) ON DELETE SET NULL;

-- 4. Remove the 'titular_id' column from the 'Usuario' table
ALTER TABLE socinproapp.Usuario
DROP COLUMN IF EXISTS titular_id;

-- Note: The above steps assume that the 'titular_id' column in 'Usuario' is not yet populated with essential data.
-- If it is, you might need to create a script to migrate that relationship data to the new structure.
