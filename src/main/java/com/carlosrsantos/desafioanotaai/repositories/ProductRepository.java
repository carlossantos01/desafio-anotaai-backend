package com.carlosrsantos.desafioanotaai.repositories;

import com.carlosrsantos.desafioanotaai.domain.product.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {
}
