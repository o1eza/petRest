CREATE TABLE comments (
                          id SERIAL PRIMARY KEY,
                          text TEXT NOT NULL,

                          author_id INT NOT NULL,
                          receiver_id INT NOT NULL,

                          FOREIGN KEY (author_id) REFERENCES userr(id),
                          FOREIGN KEY (receiver_id) REFERENCES userr(id)
);
