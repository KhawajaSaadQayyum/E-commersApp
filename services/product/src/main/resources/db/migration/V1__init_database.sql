-- Create the `category` table with auto-incrementing primary key
CREATE TABLE IF NOT EXISTS category (
                                        id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
                                        description VARCHAR(255),
                                        name VARCHAR(255)
);
# INSERT INTO category (description, name)
# VALUES ('Electronics items like phones, laptops, etc.', 'Electronics'),
#        ('Furniture items like tables, chairs, etc.', 'Furniture'),
#        ('Books and other reading materials.', 'Books');
-- Create the `product` table with a foreign key to the `category` table and auto-incrementing primary key
CREATE TABLE IF NOT EXISTS product (
                                       id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
                                       available_quantity DOUBLE NOT NULL,
                                       description VARCHAR(255),
                                       name VARCHAR(255),
                                       price DECIMAL(38, 2),
                                       category_id INT,
                                       FOREIGN KEY (category_id) REFERENCES category(id)
);

# INSERT INTO product (description, name, available_quantity, price, category_id)
# VALUES ('Smartphone with 6GB RAM and 128GB storage', 'Smartphone', 50, 299.99, 1),
#        ('4K Ultra HD Smart LED TV', 'Smart TV', 30, 799.99, 1),
#        ('Ergonomic office chair', 'Office Chair', 20, 149.99, 2),
#        ('Hardcover book on data science', 'Data Science Book', 100, 39.99, 3);


# create sequence if not exists category_seq increment by 50;
# create sequence if not exists product_seq increment by 50;