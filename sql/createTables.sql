CREATE TABLE category (
 id bigint(20) NOT NULL AUTO_INCREMENT,
 name varchar(100) NOT NULL,
 PRIMARY KEY (id),
 UNIQUE KEY name (name)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8

CREATE TABLE article (
 id bigint(20) NOT NULL AUTO_INCREMENT,
 category_id bigint(20) NOT NULL,
 name varchar(100) NOT NULL,
 price double,
 PRIMARY KEY (id),
 KEY category_id (category_id),
 CONSTRAINT fk_categoryId FOREIGN KEY (category_id) REFERENCES category (id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8


INSERT INTO category(id,name) VALUES(null,"Food");
INSERT INTO category(id,name) VALUES(null,"Drink");
INSERT INTO category(id,name) VALUES(null,"Clothes");
INSERT INTO category(id,name) VALUES(null,"Toys");


INSERT INTO article(id, category_id, name, price) VALUES(null, (SELECT id from category WHERE name='Clothes'), 'T-Shirt', 25.50);
INSERT INTO article(id,category_id, name, price) VALUES(null, (SELECT id from category WHERE name='Clothes'), 'Pants', 75.50);
INSERT INTO article(id,category_id, name, price) VALUES(null, (SELECT id from category WHERE name='Clothes'), 'Cap', 35.50);
INSERT INTO article(id,category_id, name, price) VALUES(null, (SELECT id from category WHERE name='Clothes'), 'Vest', 80.50);

INSERT INTO article(id, category_id, name, price) VALUES(null, (SELECT id from category WHERE name='Drink'), 'Mojito', 8.0);
INSERT INTO article(id, category_id, name, price) VALUES(null, (SELECT id from category WHERE name='Drink'), 'Coffee', 8.0);
INSERT INTO article(id, category_id, name, price) VALUES(null, (SELECT id from category WHERE name='Drink'), 'Ice Tea', 8.0);

INSERT INTO article(id, category_id, name, price) VALUES(null, (SELECT id from category WHERE name='Food'), 'Spaghetti', 5.2);
INSERT INTO article(id, category_id, name, price) VALUES(null, (SELECT id from category WHERE name='Food'), 'Steak', 28.40);
INSERT INTO article(id, category_id, name, price) VALUES(null, (SELECT id from category WHERE name='Food'), 'Risotto', 12.0);


INSERT INTO article(id, category_id, name, price) VALUES(null, (SELECT id from category WHERE name='Toys'), 'Hot wheel', 5.2);
INSERT INTO article(id, category_id, name, price) VALUES(null, (SELECT id from category WHERE name='Toys'), 'Hot wheel', 5.2);
INSERT INTO article(id, category_id, name, price) VALUES(null, (SELECT id from category WHERE name='Toys'), 'Hot wheel', 5.2);
INSERT INTO article(id, category_id, name, price) VALUES(null, (SELECT id from category WHERE name='Toys'), 'Hot wheel', 5.2);