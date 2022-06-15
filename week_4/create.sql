CREATE DATABASE bookStore;

USE bookStore;

CREATE TABLE Authors
(
	id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL
);


CREATE TABLE Genres
(
	id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL
);


CREATE TABLE Posts
(
	id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL
);


CREATE TABLE Books
(
	id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    author INT,
    genre INT,
    year YEAR NOT NULL,
    price FLOAT NOT NULL,
    FOREIGN KEY (author) REFERENCES Authors (id),
    FOREIGN KEY (genre) REFERENCES Genres (id)
);


CREATE TABLE Employees
(
	id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(55) NOT NULL,
    address VARCHAR(55) NOT NULL,
    phoneNumber VARCHAR(55) NOT NULL UNIQUE,
    post INT,
    FOREIGN KEY (post) REFERENCES Posts (id)
);


CREATE TABLE Sales
(
	id INT PRIMARY KEY AUTO_INCREMENT,
    date DATE NOT NULL,
    book INT,
    employee INT,
    amount INT NOT NULL,
    sum FLOAT NOT NULL,
    FOREIGN KEY (book) REFERENCES Books (id),
    FOREIGN KEY (employee) REFERENCES Employees (id)
);

