package az.edu.itbrains.furni.services.impl;

import az.edu.itbrains.furni.dtos.ProductDto;
import az.edu.itbrains.furni.models.Product;
import az.edu.itbrains.furni.repositories.ProductRepository;
import az.edu.itbrains.furni.services.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;

    public ProductServiceImpl(ProductRepository productRepository, ModelMapper modelMapper) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<ProductDto> getAllProduct() {
        List<ProductDto>productDtoList=productRepository.findAll().stream().limit(8).
                map(product -> modelMapper.map(product,ProductDto.class)).
                collect(Collectors.toList());
        return productDtoList;
    }

    @Override
    public ProductDto getProductById(Long id) {
        Product product=productRepository.findById(id).orElseThrow();
        return modelMapper.map(product,ProductDto.class);
    }
}
