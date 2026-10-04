create table users_interests (
    user_id INT,
    interest_id INT,
    CONSTRAINT UQ_OneInterestPerPair UNIQUE (user_id, interest_id),
    CONSTRAINT FK_User FOREIGN KEY (user_id) REFERENCES users(id),
    CONSTRAINT FK_Interest FOREIGN KEY (interest_id) REFERENCES interests(id)
)
