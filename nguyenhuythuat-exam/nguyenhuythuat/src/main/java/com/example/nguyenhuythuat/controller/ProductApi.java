package com.example.nguyenhuythuat.controller;

import com.example.nguyenhuythuat.entity.Product;
import com.example.nguyenhuythuat.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/products")
@CrossOrigin("*")
public class ProductApi {
    @Autowired
    private ProductRepository productRepository;

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Product> getAllProducts(){
        return productRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Product addProduct(@RequestBody Product product){
        productRepository.save(product);
        return product;
    }

    @RequestMapping(path = "{id}", method = RequestMethod.PUT)
    public Product sellProduct(@RequestBody Product updateProduct, @PathVariable String id){
        Optional<Product> optionalProduct = productRepository.findById(String.valueOf(id));
        if(optionalProduct.isPresent()){
            Product existingProduct = optionalProduct.get();
            existingProduct.setQuantity(updateProduct.getQuantity());
            productRepository.save(existingProduct);
        }
        return null;
    }
}

