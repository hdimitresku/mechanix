-- Create car table
CREATE TABLE IF NOT EXISTS car (

    id BIGSERIAL PRIMARY KEY,
    creation_date TIMESTAMP NOT NULL,
    last_updated_date TIMESTAMP NOT NULL,
    make VARCHAR(255),
    model VARCHAR(255),
    vin VARCHAR(255) NOT NULL,
    plate_no VARCHAR(255) NOT NULL,
    owner VARCHAR(255)
    );

-- Create service table
CREATE TABLE IF NOT EXISTS service (

    id BIGSERIAL PRIMARY KEY,
    creation_date TIMESTAMP NOT NULL,
    last_updated_date TIMESTAMP NOT NULL,
    work_done VARCHAR(255),
    hours_worked DOUBLE PRECISION, -- Use DOUBLE PRECISION for DOUBLE in PostgreSQL
    start_date TIMESTAMP,
    handle_date TIMESTAMP,
    total_cost DOUBLE PRECISION,
    notes VARCHAR(255),
    car_id BIGINT REFERENCES car(id) -- Change "car_entity(id)" to "car(id)"
    );

-- Create parts table
CREATE TABLE IF NOT EXISTS parts (

    id BIGSERIAL PRIMARY KEY,
    creation_date TIMESTAMP NOT NULL,
    last_updated_date TIMESTAMP NOT NULL,
    name VARCHAR(255) NOT NULL,
    serial_number VARCHAR(255),
    price DOUBLE PRECISION,
    service_id BIGINT REFERENCES service(id)

    );
