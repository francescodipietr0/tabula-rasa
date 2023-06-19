package com.tabula.rasa.project.controller;

import com.tabula.rasa.project.dto.ProductDTO;
import com.tabula.rasa.project.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/warehouse/")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/products/")
    public ProductDTO getProduct(@RequestParam Long id) {
        return productService.getProduct(id);
    }

    @GetMapping("/products/")
    public List<ProductDTO> getAllProducts() {
        return productService.getAllProducts();
    }

    @PostMapping("/products/")
    public ProductDTO insertProduct(@RequestBody ProductDTO productDTO) {
        return productService.insertProduct(productDTO);
    }

    @PutMapping("/products/")
    public ProductDTO updateProduct(@RequestParam Long id, @RequestBody ProductDTO productDTO) {
        return productService.updateProduct(id, productDTO);
    }

    @DeleteMapping("/products/")
    public void deleteProduct(@RequestParam Long id) {
        productService.deleteProduct(id);
    }

}
