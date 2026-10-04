CREATE TABLE likes (
    from_horse_id INT,
    to_horse_id INT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT CK_NoSelfLike CHECK (from_horse_id != to_horse_id),
    CONSTRAINT UQ_OneLikePerPair UNIQUE (from_horse_id, to_horse_id),
    CONSTRAINT FK_From FOREIGN KEY (from_horse_id) REFERENCES horses(id),
    CONSTRAINT FK_To FOREIGN KEY (to_horse_id) REFERENCES horses(id)
);