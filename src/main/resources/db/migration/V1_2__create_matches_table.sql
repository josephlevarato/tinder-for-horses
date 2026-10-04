CREATE TABLE matches (
    user_1_id INT,
    user_2_id INT,
    CONSTRAINT CK_DifferentUsers CHECK (user_1_id < user_2_id),
    CONSTRAINT FK_User1 FOREIGN KEY (user_1_id) REFERENCES users(id),
    CONSTRAINT FK_User2 FOREIGN KEY (user_2_id) REFERENCES users(id)
);