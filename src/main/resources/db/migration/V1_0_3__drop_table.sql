DROP TABLE rooms;

CREATE TABLE entrance(
    id              BIGSERIAL PRIMARY KEY,
    home_id         BIGINT,
    floor           VARCHAR(5),
    CONSTRAINT fk_entrance_home_id FOREIGN KEY (home_id) REFERENCES home (id)
);

CREATE TABLE entrance_flats(
    entrance_id     BIGINT,
    order_id        BIGINT,
    flats           VARCHAR(500),
    CONSTRAINT fk_entrance_flats_entrance_id FOREIGN KEY (entrance_id) REFERENCES entrance (id)
);