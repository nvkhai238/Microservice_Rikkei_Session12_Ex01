INSERT INTO products (id,name,description,image_url,price) VALUES (1,'Laptop','Laptop 14 inch','https://example.com/laptop.png',10000000) ON CONFLICT (id) DO NOTHING;
SELECT setval(pg_get_serial_sequence('products','id'), GREATEST((SELECT MAX(id) FROM products),1));
