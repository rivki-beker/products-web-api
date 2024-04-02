package com.example.webapiproduct.repositories;
import com.example.webapiproduct.Entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
@Repository
public class ProductRepositoy2 {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public List<Product> getProductByPrice(double minprice,double maxprice)
    {   String productRangeQuery="select * from product where price > '" + minprice +"' and price <= ' "+ maxprice+ " ' ";
        List<Map<String,Object>> productDb=jdbcTemplate.queryForList(productRangeQuery);
        List<Product> products=new ArrayList<Product>();
        for(Map<String,Object> productRow:productDb)
        {
            Product p=new Product((String)productRow.get("name"), (int)productRow.get("id"),(double)productRow.get("price") );
            products.add(p);
        }
        return products;
    }
}
