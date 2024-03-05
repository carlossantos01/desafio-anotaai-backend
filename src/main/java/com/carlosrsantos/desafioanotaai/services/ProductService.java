package com.carlosrsantos.desafioanotaai.services;


import com.carlosrsantos.desafioanotaai.domain.category.Category;
import com.carlosrsantos.desafioanotaai.domain.category.exceptions.CategoryNotFoundException;
import com.carlosrsantos.desafioanotaai.domain.product.Product;
import com.carlosrsantos.desafioanotaai.domain.product.ProductDTO;
import com.carlosrsantos.desafioanotaai.domain.product.exceptions.ProductNotFoundException;
import com.carlosrsantos.desafioanotaai.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final CategoryService categoryService;
    private final ProductRepository productRepository;

    public ProductService(CategoryService categoryService, ProductRepository productRepository){
        this.categoryService = categoryService;
        this.productRepository = productRepository;
    }

    public Product insert(ProductDTO productData){
        Category category = this.categoryService.getById(productData.categoryId()).orElseThrow(CategoryNotFoundException::new);
        Product newProduct = new Product(productData);
        newProduct.setCategory(category);
        this.productRepository.save(newProduct);
        return newProduct;
    }

    public Product update(String id, ProductDTO productData){
        Product product = this.productRepository.findById(id).orElseThrow(ProductNotFoundException::new);

        if(productData.categoryId() != null) {
            this.categoryService.getById(productData.categoryId()).ifPresent(product::setCategory);
        }

        if(!productData.title().isEmpty()) product.setTitle(productData.title());
        if(!productData.description().isEmpty()) product.setDescription(productData.description());
        if(!(productData.price() == null)) product.setPrice(productData.price());

        this.productRepository.save(product);

        return product;
    }
    public void delete(String id){
        Product product = this.productRepository.findById(id).orElseThrow(CategoryNotFoundException::new);

        this.productRepository.delete(product);
    }


    public List<Product> getAll(){
        return this.productRepository.findAll();
    }
}
