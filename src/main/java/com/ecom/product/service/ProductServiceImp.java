/*
 * Copyright (c) $today.year
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>http://www.apache.org/licenses/LICENSE-2.0<p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.ecom.product.service;

import com.ecom.product.dao.DataSourceDao;
import com.ecom.product.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by jcordones13 on 9/6/16.
 */
@Service
public class ProductServiceImp implements ProductService{

    @Autowired
    private DataSourceDao dataSourceDao;

    public ProductServiceImp(){}

    /**
     *
     * @param id
     * @return
     */
    public Product getProductById(String id){
        return dataSourceDao.getProductById(id);
    }

    /**
     *
     * @return
     */
    public List<Product> getProducts(){

        return null;
    }

    /**
     * Create new Product
     * @param product
     * @return
     */
    public Product createProduct(Product product){

        return dataSourceDao.createProduct(product);
    }

    /**
     *
     * @return
     */
    public Product updateProduct(Product product){

        return null;
    }

    /**
     *
     * @return
     */
    public long deleteProduct(){

        return 0L;
    }
}
