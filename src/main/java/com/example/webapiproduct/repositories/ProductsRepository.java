package com.example.webapiproduct.repositories;


import com.example.webapiproduct.Entities.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsRepository extends CrudRepository<Product,Integer>{
}
