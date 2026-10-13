package com.rikkei.session12.ex01;

import java.math.BigDecimal;
import java.time.Duration;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.redis.cache.*;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.serializer.*;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


@Service
class ProductWriter {
 private final ProductRepository repository;
 ProductWriter(ProductRepository repository) { this.repository=repository; }
 @Transactional public ProductView save(ProductRequest product) {
  Product p=repository.findById(product.id()).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Khong tim thay san pham"));
  p.name=product.name();p.description=product.description();p.imageUrl=product.imageUrl();p.price=product.price();
  return new ProductView(p.id,p.name,p.description,p.imageUrl,p.price);
 }
}
