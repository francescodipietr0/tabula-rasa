package com.tabula.rasa.project.service;

import com.tabula.rasa.project.dto.ProductDTO;
import com.tabula.rasa.project.entities.Product;
import com.tabula.rasa.project.mapper.ProductMapper;
import com.tabula.rasa.project.repository.ProductDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductDAO productDAO;
    @Autowired
    ProductMapper productMapper;

    public ProductDTO getProduct(Long id) {
        return productMapper.toDto(productDAO.findById(id).get());
    }

    public List<ProductDTO> getAllProducts() {
        return productMapper.toDtoList(productDAO.findAll());
    }

    public ProductDTO insertProduct(ProductDTO product) {
        return productMapper.toDto(productDAO.save(productMapper.toEntity((product))));
    }

    public ProductDTO updateProduct(Long id, ProductDTO product) {

        productDAO.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Prodotto non trovato con ID: " + id));

        return productMapper.toDto(productDAO.save(productMapper.toEntity(product)));
    }

    public void deleteProduct(Long id) {
        productDAO.deleteById(id);
    }

}
