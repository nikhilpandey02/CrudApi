package dev.nikhil.serviceproduct.Controller;

import dev.nikhil.serviceproduct.Services.ProductService;
import dev.nikhil.serviceproduct.dtos.ExceptionDto;
import dev.nikhil.serviceproduct.dtos.GenericProductDto;
import dev.nikhil.serviceproduct.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;
    public ProductController( ProductService productService)
    {
        this.productService=productService;

    }
    @GetMapping
    public List<GenericProductDto> getAllProducts(){
        return productService.getAllProducts();


    }

    //localhost:8080/products/123
    @GetMapping("{id}")
    public GenericProductDto getProductById(@PathVariable("id") Long id) throws NotFoundException {
       return productService.getProductById(id);

    }
    @DeleteMapping("{id}")
    public ResponseEntity<GenericProductDto> deleteProductById(@PathVariable("id") Long id){
        return new ResponseEntity<GenericProductDto>(productService.deleteProduct(id)
        , HttpStatus.OK);


    }


     @PostMapping
    public GenericProductDto createProduct(@RequestBody GenericProductDto product){
       // System.out.print(product.name);
         return productService.createProduct(product);

       // return "";

    }
   @PutMapping("{id}")
    public void updateProductById(){

    }

}
