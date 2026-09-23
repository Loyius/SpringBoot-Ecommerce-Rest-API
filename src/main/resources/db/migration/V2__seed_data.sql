-- USERS
INSERT INTO tb_user (id, name, email, phone, password) VALUES
(1, 'Maria Silva', 'maria@gmail.com', '988888888', '$2a$10$examplehashedpassword1'),
(2, 'Alex Green', 'alex@gmail.com', '977777777', '$2a$10$examplehashedpassword2'),
(3, 'Bob Brown', 'bob@gmail.com', '966666666', '$2a$10$examplehashedpassword3');

-- CATEGORIES
INSERT INTO tb_category (id, name) VALUES
(1, 'Electronics'),
(2, 'Books'),
(3, 'Computers');

-- PRODUCTS
INSERT INTO tb_product (id, name, description, price, img_url) VALUES
(1, 'The Lord of the Rings', 'Lorem ipsum dolor sit amet, consectetur.', 90.5, 'https://example.com/lotr.jpg'),
(2, 'Smart TV', 'Nulla eu imperdiet purus. Maecenas ante.', 2190.0, 'https://example.com/tv.jpg'),
(3, 'Macbook Pro', 'Nam eleifend maximus tortor, at mollis.', 1250.0, 'https://example.com/macbook.jpg'),
(4, 'PC Gamer', 'Donec aliquet odio ac rhoncus cursus.', 1200.0, 'https://example.com/pcgamer.jpg'),
(5, 'Rails for Dummies', 'Cras fringilla convallis sem, non.', 100.99, 'https://example.com/rails.jpg');

-- PRODUCT_CATEGORY (many-to-many)
INSERT INTO tb_product_category (product_id, category_id) VALUES
(1, 2),
(2, 1),
(3, 1), (3, 3),
(4, 1), (4, 3),
(5, 2);

-- ORDERS (order_status: 1=WAITING_PAYMENT, 2=PAID, 3=SHIPPED, 4=DELIVERED, 5=CANCELED)
INSERT INTO tb_order (id, moment, order_status, client_id) VALUES
(1, '2019-06-20T19:53:07Z', 3, 1),
(2, '2019-07-21T03:42:10Z', 1, 1),
(3, '2019-07-22T15:21:22Z', 4, 2);

-- ORDER_ITEMS
INSERT INTO tb_order_item (order_id, product_id, quantity, price) VALUES
(1, 1, 2, 90.5),
(1, 3, 1, 1250.0),
(2, 3, 1, 1250.0),
(3, 5, 3, 100.99);

-- PAYMENTS
INSERT INTO tb_payment (order_id, date) VALUES
(1, '2019-06-20T21:53:07Z'),
(3, '2019-07-22T17:21:22Z');

-- BIGSERIAL
SELECT setval('tb_user_id_seq', (SELECT MAX(id) FROM tb_user));
SELECT setval('tb_category_id_seq', (SELECT MAX(id) FROM tb_category));
SELECT setval('tb_product_id_seq', (SELECT MAX(id) FROM tb_product));
SELECT setval('tb_order_id_seq', (SELECT MAX(id) FROM tb_order));