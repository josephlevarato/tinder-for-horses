CREATE TABLE matches (
    horse_1_id INT,
    horse_2_id INT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT CK_DifferentHorses CHECK (horse_1_id < horse_2_id),
    CONSTRAINT FK_Horse1 FOREIGN KEY (horse_1_id) REFERENCES horses(id),
    CONSTRAINT FK_Horse2 FOREIGN KEY (horse_2_id) REFERENCES horses(id)
);