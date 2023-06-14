package com.tabula.rasa.project.mapper;

import com.tabula.rasa.project.dto.ProductDTO;
import com.tabula.rasa.project.entities.Product;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductDTO toDto(Product product);
    List<ProductDTO> toDtoList(Iterable<Product> products);
    Product toEntity(ProductDTO productDTO);
    List<Product> toEntityList(Iterable<ProductDTO> productDTOS);

}
