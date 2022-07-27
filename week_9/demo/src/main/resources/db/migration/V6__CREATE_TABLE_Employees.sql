CREATE TABLE Employees
(
    employee_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    address VARCHAR(255) NOT NULL,
    phone VARCHAR(255) NOT NULL,
    post BIGINT,
    FOREIGN KEY (post) REFERENCES Posts (post_id)
);