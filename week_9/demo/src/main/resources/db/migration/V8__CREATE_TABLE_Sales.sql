CREATE TABLE Sales
(
    sale_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    date DATETIME NOT NULL,
    book BIGINT,
    employee BIGINT,
    amount INT NOT NULL,
    sum FLOAT NOT NULL,
    FOREIGN KEY (book) REFERENCES Books (book_id),
    FOREIGN KEY (employee) REFERENCES Employees (employee_id)
);