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

}
