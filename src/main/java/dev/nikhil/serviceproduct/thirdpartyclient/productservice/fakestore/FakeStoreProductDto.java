package dev.nikhil.serviceproduct.thirdpartyclient.productservice.fakestore;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class FakeStoreProductDto {
    private long id;
    private String title;

    private double price;
    private String category ;
    private  String image;

}
