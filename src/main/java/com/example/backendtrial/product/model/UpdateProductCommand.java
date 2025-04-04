package com.example.backendtrial.product.model;

public class UpdateProductCommand {
    private Integer id;
    private Product product;

    public UpdateProductCommand(Integer id, Product product) {
        this.id = id;
        this.product = product;
    }

    public Integer getId() {
        return this.id;
    }

    public Product getProduct() {
        return this.product;
    }
}
