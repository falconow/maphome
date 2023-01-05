ALTER TABLE entrance DROP COLUMN floor;

CREATE TABLE floor(
  id                SERIAL PRIMARY KEY,
  entrance_id       BIGINT,
  floor_number      BIGINT,
  CONSTRAINT fk_floor_entrance_id FOREIGN KEY (entrance_id) REFERENCES entrance (id)
);

CREATE TABLE floor_flats(
   floor_id     BIGINT,
   order_id        BIGINT,
   flats           VARCHAR(500),
   CONSTRAINT fk_entrance_flats_entrance_id FOREIGN KEY (floor_id) REFERENCES floor (id)
);

DROP TABLE entrance_flats;