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
package com.ecom.product.dao;

import com.ecom.product.model.Product;
import io.searchbox.client.JestClient;
import io.searchbox.client.JestClientFactory;
import io.searchbox.client.JestResult;
import io.searchbox.client.config.HttpClientConfig;
import io.searchbox.core.Index;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * Created by jcordones13 on 9/16/16.
 */
@Component
public class ESDao {

    private static Logger LOG = LoggerFactory.getLogger(ESDao.class);

    @Autowired
    private JestClient jestClient;

    private JestResult jestResult;

    private static String PRODUCT_INDEX_NAME = "products";
    private static String PRODUCT_TYPE_NAME = "product";

    public ESDao(){
        HttpClientConfig clientConfig = new HttpClientConfig
                .Builder("http://localhost:9200/")
                .multiThreaded(true)
                .build();

        JestClientFactory factory = new JestClientFactory();
        factory.setHttpClientConfig(clientConfig);
        jestClient = factory.getObject();
    }

    public JestResult searchProduct(String id){
        return null;
    }

    public JestResult getProduct(String id){ return null; }

    public JestResult getProducts(){ return null; }

    public Product createProduct(Product product){

        Index productIndex = new Index.Builder(product).index(PRODUCT_INDEX_NAME).type(PRODUCT_TYPE_NAME).build();

        return insert(productIndex).getSourceAsObject(Product.class);
    }

    public JestResult updateProduct(){
        return null;
    }

    public JestResult deleteProduct(){
        return null;
    }

    //Private interface
    private JestResult insert(Index index){

        try {
            LOG.info("--------------------- " + jestClient);
            jestResult = jestClient.execute(index);
        }
        catch (IOException iox){
            LOG.error("**** ERROR: " + iox.getMessage(), iox);
        }

        return jestResult;
    }

}
