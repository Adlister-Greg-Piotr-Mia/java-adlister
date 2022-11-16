USE adlister_db;

DROP TABLE IF EXISTS ads;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS categories;
DROP TABLE IF EXISTS ad_category;

CREATE TABLE users (
    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    username VARCHAR(240) NOT NULL,
    email VARCHAR(240) NOT NULL,
    password VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE ads (
    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    user_id INT UNSIGNED NOT NULL,
    title VARCHAR(240) NOT NULL,
    description TEXT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (user_id) REFERENCES users(id)
        ON DELETE CASCADE
);

CREATE TABLE categories(
    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    category VARCHAR(240) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE ad_category (
     ad_id INTEGER UNSIGNED NOT NULL,
     category_id INTEGER UNSIGNED NOT NULL,
     FOREIGN KEY (ad_id) REFERENCES ads(id),
     FOREIGN KEY (category_id) REFERENCES categories(id)
);

INSERT INTO categories(category) VALUES
     ('Technology'),
     ('Home'),
     ('Pets'),
     ('Toys');

INSERT INTO ad_category(ad_id, category_id) VALUES
    (1, 1),
    (2, 4),
    (3, 2),
    (3, 3);
