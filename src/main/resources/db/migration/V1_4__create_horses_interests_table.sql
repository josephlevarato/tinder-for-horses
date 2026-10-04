create table horses_interests (
    horse_id INT,
    interest_id INT,
    CONSTRAINT UQ_OneInterestPerPair UNIQUE (horse_id, interest_id),
    CONSTRAINT FK_Horse FOREIGN KEY (horse_id) REFERENCES horses(id),
    CONSTRAINT FK_Interest FOREIGN KEY (interest_id) REFERENCES interests(id)
)
