-- Create the agrichain database
CREATE
DATABASE IF NOT EXISTS agrichain;
USE
agrichain;

-- Create users table
CREATE TABLE IF NOT EXISTS users
(
    user_id
    BIGINT
    AUTO_INCREMENT
    PRIMARY
    KEY,
    name
    VARCHAR
(
    100
) NOT NULL,
    email VARCHAR
(
    100
) UNIQUE NOT NULL,
    phone VARCHAR
(
    20
) NOT NULL,
    password VARCHAR
(
    255
) NOT NULL,
    role ENUM
(
    'FARMER',
    'TRADER',
    'OFFICER',
    'MANAGER',
    'ADMIN',
    'COMPLIANCE',
    'AUDITOR'
) NOT NULL,
    status ENUM
(
    'ACTIVE',
    'INACTIVE',
    'SUSPENDED',
    'PENDING_APPROVAL'
) NOT NULL DEFAULT 'ACTIVE',
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    last_login TIMESTAMP NULL,
    UNIQUE KEY unique_email
(
    email
),
    INDEX idx_role
(
    role
),
    INDEX idx_status
(
    status
)
    );

-- Create audit_logs table
CREATE TABLE IF NOT EXISTS audit_logs
(
    audit_id
    BIGINT
    AUTO_INCREMENT
    PRIMARY
    KEY,
    user_id
    BIGINT
    NOT
    NULL,
    action
    VARCHAR
(
    100
) NOT NULL,
    resource VARCHAR
(
    255
) NOT NULL,
    description VARCHAR
(
    500
),
    timestamp TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    ip_address VARCHAR
(
    50
),
    user_agent VARCHAR
(
    255
),
    audit_action ENUM
(
    'CREATE',
    'READ',
    'UPDATE',
    'DELETE',
    'LOGIN',
    'LOGOUT',
    'DOWNLOAD',
    'UPLOAD',
    'APPROVE',
    'REJECT',
    'EXPORT'
) NOT NULL,
    status VARCHAR
(
    20
) NOT NULL DEFAULT 'SUCCESS',
    INDEX idx_user_id
(
    user_id
),
    INDEX idx_resource
(
    resource
),
    INDEX idx_action
(
    audit_action
),
    INDEX idx_timestamp
(
    timestamp
)
    );

-- Insert sample users for testing
INSERT INTO users (name, email, phone, password, role, status)
VALUES ('Admin User', 'admin@agrichain.com', '9876543210', '$2a$10$example_hash_1', 'ADMIN', 'ACTIVE'),
       ('John Farmer', 'farmer@agrichain.com', '9876543211', '$2a$10$example_hash_2', 'FARMER', 'ACTIVE'),
       ('Trader User', 'trader@agrichain.com', '9876543212', '$2a$10$example_hash_3', 'TRADER', 'ACTIVE'),
       ('Officer User', 'officer@agrichain.com', '9876543213', '$2a$10$example_hash_4', 'OFFICER', 'ACTIVE'),
       ('Manager User', 'manager@agrichain.com', '9876543214', '$2a$10$example_hash_5', 'MANAGER', 'ACTIVE'),
       ('Compliance User', 'compliance@agrichain.com', '9876543215', '$2a$10$example_hash_6', 'COMPLIANCE', 'ACTIVE'),
       ('Auditor User', 'auditor@agrichain.com', '9876543216', '$2a$10$example_hash_7', 'AUDITOR', 'ACTIVE');

-- Create index for better query performance
CREATE INDEX idx_users_role_status ON users (role, status);
CREATE INDEX idx_audit_logs_user_timestamp ON audit_logs (user_id, timestamp);

