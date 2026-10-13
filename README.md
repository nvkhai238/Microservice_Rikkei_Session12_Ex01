# Session 12 - Bai 1: Product cache

Chay `docker compose up -d --wait` va `./gradlew :product-service:bootRun`. Goi `GET /api/products/1` hai lan; SQL chi xuat hien o lan dau. Cache JSON co TTL 30 phut. Cap nhat bang `PUT /api/products` voi JSON `{"id":1,"name":"Laptop Moi","description":"Mo ta moi","imageUrl":"https://example.com/laptop.png","price":11000000}` se xoa `products::1`. Goi GET tiep se thay SQL va gia moi. Moc 200ms/10ms chi la muc tieu, phu thuoc moi truong.
