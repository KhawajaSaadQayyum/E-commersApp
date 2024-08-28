INSERT INTO category (description, name)
VALUES ('Electronics items like phones, laptops, etc.', 'Electronics'),
       ('Furniture items like tables, chairs, etc.', 'Furniture'),
       ('Books and other reading materials.', 'Books');

INSERT INTO product (description, name, available_quantity, price, category_id)
VALUES ('Smartphone with 6GB RAM and 128GB storage', 'Smartphone', 50, 299.99, 1),
       ('4K Ultra HD Smart LED TV', 'Smart TV', 30, 799.99, 1),
       ('Ergonomic office chair', 'Office Chair', 20, 149.99, 2),
       ('Hardcover book on data science', 'Data Science Book', 100, 39.99, 3);
