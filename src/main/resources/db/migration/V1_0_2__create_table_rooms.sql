CREATE TABLE rooms (
    id SERIAL PRIMARY KEY,
    room_number VARCHAR(5),
    room_color VARCHAR(15),
    home_id BIGINT,
    CONSTRAINT fk_home_id FOREIGN KEY (home_id) REFERENCES home (id)
)