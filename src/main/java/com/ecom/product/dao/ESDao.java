package com.ecom.product.dao;

import io.searchbox.client.JestClient;
import io.searchbox.client.JestResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by jcordones13 on 9/16/16.
 */
@ComponentScan
public class ESDao {
    @Autowired private JestClient jestClient;

    public JestResult searchProduct(String id){
        return null;
    }

    public JestResult getProduct(String id){ return null; }

    public JestResult getProducts(){ return null; }

    public JestResult createProduct(){
        return null;
    }

    public JestResult updateProduct(){
        return null;
    }

    public JestResult deleteProduct(){
        return null;
    }

}
