package com.shop.products.service;

import com.shop.products.dto.ProductDTO;
import com.shop.products.model.Product;
import com.shop.products.repository.ProductRepository;
import com.shop.products.util.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product createNewProduct(ProductDTO product) {
        if (!validateProductData(product)) {
            throw new ValidationException("Product data is not valid. Please check the fields and try again");
        }
        Product newProduct = productRepository.save(
                new Product(product.getTitle(), product.getPrice(), product.getDescription(), product.getImage())
        );
        return newProduct;
    }

    public Product findProductById(Long productId) {
        return productRepository.findById(productId).orElse(null);
    }

    private boolean validateProductData(ProductDTO dto) {
        return StringUtils.hasLength(dto.getTitle())
                && dto.getPrice() != null
                && StringUtils.hasLength(dto.getDescription())
                && StringUtils.hasLength(dto.getImage());
    }
}
