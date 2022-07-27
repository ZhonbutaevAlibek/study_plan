CREATE TABLE Authors
(
    author_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL
);


CREATE TABLE Genres
(
    genre_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    genre VARCHAR(50) NOT NULL
);

CREATE TABLE Books
(
    book_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(255) NOT NULL,
    author BIGINT,
    genre BIGINT,
    year YEAR NOT NULL,
    price FLOAT NOT NULL,
    amount INT NOT NULL,
    FOREIGN KEY (author) REFERENCES Authors (author_id),
    FOREIGN KEY (genre) REFERENCES Genres (genre_id)
);