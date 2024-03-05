package com.carlosrsantos.desafioanotaai.domain.product;

public record ProductDTO(String title, String description, String owner, String ownerId, Integer price, String categoryId) {
}
