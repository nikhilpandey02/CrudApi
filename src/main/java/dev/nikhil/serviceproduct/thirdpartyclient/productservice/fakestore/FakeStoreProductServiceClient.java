package dev.nikhil.serviceproduct.thirdpartyclient.productservice.fakestore;

import dev.nikhil.serviceproduct.dtos.GenericProductDto;
import dev.nikhil.serviceproduct.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Service
public class FakeStoreProductServiceClient  {
    private RestTemplateBuilder restTemplateBuilder;


     @Value("${fakestore.api.url}")
    private String fakeStoreApiUrl;

    @Value("${fakestore.api.paths.product")
    private  String fakeStoreProductsApiPath;
    private String specificProductRequestUrl =fakeStoreApiUrl+fakeStoreProductsApiPath+"/{id}";
    private String productRequestsBaseUrl=fakeStoreApiUrl+fakeStoreProductsApiPath;

     /*@Value("${fakestore.api.url}")
     private String fakeStoreApiUrl;

    @Value("${fakestore.api.paths.product}")
    private String fakeStoreProductsApiPath;*/

    public FakeStoreProductServiceClient(
            RestTemplateBuilder restTemplateBuilder,
            @Value("${fakestore.api.url}") String fakeStoreApiUrl,
            @Value("${fakestore.api.paths.product}") String fakeStoreProductsApiPath) {
//        this.restTemplateBuilder = restTemplateBuilder;
        this.restTemplateBuilder = restTemplateBuilder;
        this.productRequestsBaseUrl  = fakeStoreApiUrl + fakeStoreProductsApiPath;
        this.specificProductRequestUrl = fakeStoreApiUrl + fakeStoreProductsApiPath + "/{id}";
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
    public FakeStoreProductDto createProduct(GenericProductDto product)
    {
        RestTemplate restTemplate=restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> response=restTemplate.postForEntity
                (productRequestsBaseUrl,product, FakeStoreProductDto.class);
        return response.getBody();
    }


    public FakeStoreProductDto getProductById(Long id) throws NotFoundException {

        RestTemplate restTemplate= restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> response=
                restTemplate.getForEntity(specificProductRequestUrl, FakeStoreProductDto.class,id);

        FakeStoreProductDto fakeStoreProductDto= response.getBody();
        //  response.getStatusCode();
        if(fakeStoreProductDto==null)
        {
            throw  new NotFoundException("product with"+id+"not exits");

        }
        return fakeStoreProductDto;
        //return null;
    }


    public List<FakeStoreProductDto> getAllProducts() {
        RestTemplate restTemplate=restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto[]> response=
                restTemplate.getForEntity(productRequestsBaseUrl, FakeStoreProductDto[].class);

        List<GenericProductDto> answer=new ArrayList<>();

        return Arrays.stream(response.getBody()).toList();
    }


    public FakeStoreProductDto deleteProduct(Long id) {
        RestTemplate restTemplate=restTemplateBuilder.build();
        //   restTemplate.delete(specificProductRequestUrl,);

        RequestCallback requestCallback = restTemplate.acceptHeaderRequestCallback(FakeStoreProductDto.class);
        ResponseExtractor<ResponseEntity<FakeStoreProductDto>> responseExtractor =
                restTemplate.responseEntityExtractor(FakeStoreProductDto.class);
        ResponseEntity<FakeStoreProductDto> response=
                restTemplate.execute(specificProductRequestUrl, HttpMethod.DELETE, requestCallback, responseExtractor, id);


       // FakeStoreProductDto fakeStoreProductDto= response.getBody();

        return response.getBody();
    }
}
