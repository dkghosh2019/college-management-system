CREATE TABLE department (
                            id BIGSERIAL PRIMARY KEY,
                            name VARCHAR(100) NOT NULL UNIQUE,
                            description VARCHAR(500),
                            created_at TIMESTAMP,
                            updated_at TIMESTAMP
);