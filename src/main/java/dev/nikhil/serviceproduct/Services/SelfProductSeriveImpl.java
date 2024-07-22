package dev.nikhil.serviceproduct.Services;

import dev.nikhil.serviceproduct.dtos.GenericProductDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("SelfProductServiceImpl")
public class SelfProductSeriveImpl implements ProductService{
    @Override
    public GenericProductDto getProductById(Long id) {
        return null;
    }

     public   GenericProductDto createProduct(GenericProductDto product){
            return null;
        }

    @Override
    public List<GenericProductDto> getAllProducts() {
        return null;
    }

    @Override
    public GenericProductDto deleteProduct(Long id) {
        return null;
    }
}
