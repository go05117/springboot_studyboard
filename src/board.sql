DROP DATABASE IF EXISTS board;
CREATE DATABASE IF NOT EXISTS board;

USE board;

DROP TABLE IF EXISTS board;
CREATE TABLE IF NOT EXISTS board (
    id int NOT NULL AUTO_INCREMENT,
    title varchar(45) NOT NULL,
    content text NOT NULL,
    PRIMARY KEY (id)
);

DELIMITER $$
CREATE PROCEDURE testDataInsert()
BEGIN
    DECLARE i INT DEFAULT 1;

    WHILE i <= 120 DO
        INSERT INTO board(title, content) VALUES(concat('제목',i), concat('내용',i));
        SET i = i + 1;
    END WHILE;
END$$
DELIMITER ;

call testDataInsert;

-- DROP TABLE IF EXISTS t_sales;
-- CREATE TABLE IF NOT EXISTS t_sales (
--     sales_date DATETIME NOT NULL,
--     product_code int NOT NULL,
--     quantity int NOT NULL,
--     register_datetime DATETIME,
--     update_datetime DATETIME,
--     foreign key(product_code) references m_product(product_code)
-- );

-- INSERT INTO m_product (product_name, price, register_datetime, update_datetime) VALUES ('デスクトップ PC', 150000, '2022-05-10', '2022-05-10');