package dev.nikhil.serviceproduct.Services;

import dev.nikhil.serviceproduct.thirdpartyclient.productservice.fakestore.FakeStoreProductDto;
import dev.nikhil.serviceproduct.dtos.GenericProductDto;
import dev.nikhil.serviceproduct.exceptions.NotFoundException;
import dev.nikhil.serviceproduct.thirdpartyclient.productservice.fakestore.FakeStoreProductServiceClient;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Primary
@Service("FakeStoreProductService")
public class FakeStoreProductService implements ProductService {

    private FakeStoreProductServiceClient fakeStoreProductServiceClient;


    public FakeStoreProductService(FakeStoreProductServiceClient fakeStoreProductServiceClient){
        this.fakeStoreProductServiceClient=fakeStoreProductServiceClient;

    }

    private GenericProductDto convertFakeStoreIntoGenericProduct(FakeStoreProductDto fakeStoreProductDto)
    {
        GenericProductDto product=new GenericProductDto();
           product.setId(fakeStoreProductDto.getId());
        product.setImage(fakeStoreProductDto.getImage());
        //   product.setDescription(fakeStoreProductDto.getDescription());
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setPrice(fakeStoreProductDto.getPrice());
        product.setCategory(fakeStoreProductDto.getCategory());

        //  response.getStatusCode();
        return product;

    }

    @Override
    public GenericProductDto createProduct(GenericProductDto product)
    {
                return convertFakeStoreIntoGenericProduct(fakeStoreProductServiceClient.createProduct(product));
    }

    @Override
    public GenericProductDto getProductById(Long id) throws NotFoundException {

       return convertFakeStoreIntoGenericProduct(fakeStoreProductServiceClient.getProductById(id));
    }

    @Override
    public List<GenericProductDto> getAllProducts() {
        List<GenericProductDto> genericProductDtos=new ArrayList<>();
        for(FakeStoreProductDto fakeStoreProductDto:fakeStoreProductServiceClient.getAllProducts())
        {
            genericProductDtos.add(convertFakeStoreIntoGenericProduct(fakeStoreProductDto));
        }
      return genericProductDtos;
    }

    @Override
    public GenericProductDto deleteProduct(Long id) {
       return convertFakeStoreIntoGenericProduct(fakeStoreProductServiceClient.deleteProduct(id));
    }
}
