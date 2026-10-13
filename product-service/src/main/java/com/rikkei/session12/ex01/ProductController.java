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


@RestController
@RequestMapping("/api/products")
class ProductController {
 private final ProductReader reader;
 private final ProductUpdateService updater;
 ProductController(ProductReader reader,ProductUpdateService updater) { this.reader=reader;this.updater=updater; }
 @GetMapping("/{id}") ProductView get(@PathVariable Long id) { return reader.get(id); }
 @PutMapping ProductView update(@Valid @RequestBody ProductRequest product) { return updater.update(product); }
}
