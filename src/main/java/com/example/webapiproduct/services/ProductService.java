package com.example.webapiproduct.services;

import com.example.webapiproduct.Entities.Product;
import com.example.webapiproduct.repositories.ProductsRepository;
import com.example.webapiproduct.repositories.ProductRepositoy2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductsRepository productsRepository;
    @Autowired
    ProductRepositoy2 productRepository2;
    public List<Product> getProducts(){
        return productRepository2.getProductByPrice(10.5,30.2);
    }
    public Product getProductById(int id){
        return productsRepository.findById(id).orElse(null);
    }
    public  void  addProduct(Product product)
    {
        productsRepository.save(product);
    }
    public  void  deleteProduct(int id)
    {
        productsRepository.deleteById(id);
    }
    public  void  updateProduct(int id, Product product)
    {
        Product p1= productsRepository.findById(id).orElse(null);
        if(p1==null)
            productsRepository.save(product);
        else
        {
            p1.setName(product.getName());
            p1.setPrice(product.getPrice());
        }
    }
}
