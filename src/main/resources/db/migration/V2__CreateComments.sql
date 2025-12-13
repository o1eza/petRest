CREATE TABLE IF NOT EXISTS comments (
                          id BIGSERIAL PRIMARY KEY,
                          text TEXT NOT NULL,

                          author_id BIGINT NOT NULL,
                          receiver_id BIGINT NOT NULL,

                          FOREIGN KEY (author_id) REFERENCES userr(id),
                          FOREIGN KEY (receiver_id) REFERENCES userr(id)
);
