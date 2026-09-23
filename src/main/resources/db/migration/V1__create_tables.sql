CREATE TABLE tb_user (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255),
    email VARCHAR(255),
    phone VARCHAR(255),
    password VARCHAR(255)
);

CREATE TABLE tb_category (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255)
);

CREATE TABLE tb_product (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255),
    description TEXT,
    price DOUBLE PRECISION,
    img_url VARCHAR(255)
);

CREATE TABLE tb_product_category (
    product_id BIGINT NOT NULL REFERENCES tb_product(id),
    category_id BIGINT NOT NULL REFERENCES tb_category(id),
    PRIMARY KEY (product_id, category_id)
);

CREATE TABLE tb_order (
    id BIGSERIAL PRIMARY KEY,
    moment TIMESTAMP,
    order_status INTEGER,
    client_id BIGINT REFERENCES tb_user(id)
);

CREATE TABLE tb_order_item (
    order_id BIGINT NOT NULL REFERENCES tb_order(id),
    product_id BIGINT NOT NULL REFERENCES tb_product(id),
    quantity INTEGER,
    price DOUBLE PRECISION,
    PRIMARY KEY (order_id, product_id)
);

CREATE TABLE tb_payment (
    order_id BIGINT PRIMARY KEY REFERENCES tb_order(id),
    date TIMESTAMP
);