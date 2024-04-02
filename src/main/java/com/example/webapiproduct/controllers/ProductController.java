package com.example.webapiproduct.controllers;

import com.example.webapiproduct.Entities.Product;
import com.example.webapiproduct.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {


    @Autowired
    ProductService productService;
    @GetMapping
    public List<Product> getProducts(){
        return productService.getProducts();
    }
    @GetMapping("/{id}")
    public  Product getProductById(@PathVariable int id){
        return productService.getProductById(id);
    }

    @PostMapping
    public  void  addProduct(@RequestBody Product product){
        productService.addProduct(product);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable int id)
    {
        productService.deleteProduct(id);
    }

    @PutMapping("/{id}")
    public  void  updateProduct(@PathVariable int id, @RequestBody Product product) {
        productService.updateProduct(id, product);
    }
}
