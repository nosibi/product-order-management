package com.example.product_order_app.service.impl;

import com.example.product_order_app.dao.ProductDAO;
import com.example.product_order_app.data.dto.ProductDTO;
import com.example.product_order_app.data.entity.Product;
import com.example.product_order_app.data.responseDTO.ProductResponseDTO;
import com.example.product_order_app.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDAO productDAO;

    @Override
    public void saveProduct(ProductDTO productDTO) {
        Product product = new Product();
        product.setName(productDTO.getName());
        product.setPrice(productDTO.getPrice());
        product.setStock(productDTO.getStock());
        productDAO.saveProduct(product);
    }

    @Override
    public void updateProductPrice(Long id, Integer price) {
        productDAO.updateProductPrice(id, price);
    }

    @Override
    public void updateProductStock(Long id, Integer stock) {
        productDAO.updateProductStock(id, stock);
    }

    @Override
    public ProductResponseDTO findProduct(Long id) {
        ProductResponseDTO productResponseDTO = new ProductResponseDTO();
        Product product = productDAO.findProduct(id);
        productResponseDTO.setId(product.getId());
        productResponseDTO.setName(product.getName());
        productResponseDTO.setPrice(product.getPrice());
        productResponseDTO.setStock(product.getStock());
        return productResponseDTO;
    }

    @Override
    public void deleteProduct(Long id) {
        productDAO.deleteProduct(id);
    }
}
