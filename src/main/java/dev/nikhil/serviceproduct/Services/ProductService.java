package dev.nikhil.serviceproduct.Services;

import dev.nikhil.serviceproduct.dtos.GenericProductDto;
import dev.nikhil.serviceproduct.exceptions.NotFoundException;

import java.util.List;

public interface ProductService {


    GenericProductDto createProduct(GenericProductDto product);

    GenericProductDto getProductById(Long id) throws NotFoundException;
     List<GenericProductDto> getAllProducts();

     GenericProductDto deleteProduct(Long id);

}
