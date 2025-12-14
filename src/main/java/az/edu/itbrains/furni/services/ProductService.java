package az.edu.itbrains.furni.services;

import az.edu.itbrains.furni.dtos.ProductDto;

import java.util.List;

public interface ProductService {
    List<ProductDto> getAllProduct();

    ProductDto getProductById(Long id);

}
