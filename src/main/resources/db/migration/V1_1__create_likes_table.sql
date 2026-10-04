CREATE TABLE likes (
    from_user_id INT,
    to_user_id INT,
    CONSTRAINT CK_NoSelfLike CHECK (from_user_id != to_user_id),
    CONSTRAINT UQ_OneLikePerPair UNIQUE (from_user_id, to_user_id),
    CONSTRAINT FK_From FOREIGN KEY (from_user_id) REFERENCES users(id),
    CONSTRAINT FK_To FOREIGN KEY (to_user_id) REFERENCES users(id)
);