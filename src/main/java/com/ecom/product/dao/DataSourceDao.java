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
import io.searchbox.action.Action;
import io.searchbox.client.JestClient;
import io.searchbox.client.JestResult;
import io.searchbox.core.Delete;
import io.searchbox.core.Index;
import io.searchbox.core.Search;
import io.searchbox.core.Update;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

/**
 * Created by jcordones13 on 9/16/16.
 */
@Component
public class DataSourceDao {

    private static Logger LOG = LoggerFactory.getLogger(DataSourceDao.class);

    @Autowired
    private JestClient jestClient;
    private JestResult jestResult;

    @Value("${es.index}")
    private static String PRODUCT_INDEX_NAME;

    @Value("${es.type}")
    private static String PRODUCT_TYPE_NAME;

    private String idsQuery = "{\n" +
            "  \"ids\":{\n" +
            "    \"type\": %s,\n" +
            "    \"values\":[%s]\n" +
            "  }\n" +
            "}";

    public JestResult searchProduct(String id) {

        return null;
    }

    public Product getProductById(String id) {

        Product product = null;
            SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder().
                    query(QueryBuilders.matchQuery("_id", id));

            Search search = new Search.Builder(searchSourceBuilder.toString())
                    .addIndex(PRODUCT_INDEX_NAME)
                    .addType(PRODUCT_TYPE_NAME)
                    .build();

        return clientExecute(search).getSourceAsObject(Product.class);
    }

    public List<Product> getProducts() {return null;}

    public Product createProduct(Product product) {

        Index create = new Index.Builder(product)
                .index(PRODUCT_INDEX_NAME)
                .type(PRODUCT_TYPE_NAME)
                .build();

        return clientExecute(create).getSourceAsObject(Product.class);
    }

    public Product updateProduct(Product product) {

        Update update = new Update.Builder(product)
                .index(PRODUCT_INDEX_NAME)
                .type(PRODUCT_TYPE_NAME)
                .build();

        return clientExecute(update).getSourceAsObject(Product.class);
    }

    public int deleteProduct(String id) {

        //delete document by id
        Delete delete = new Delete.Builder(id)
                .index(PRODUCT_INDEX_NAME)
                .type(PRODUCT_TYPE_NAME)
                .build();

        return clientExecute(delete).getResponseCode();
    }

    private JestResult clientExecute(Action clientRequest){
        JestResult jestResult = null;
        try {
            jestResult = jestClient.execute(clientRequest);
        } catch (IOException ioe) {
            LOG.error("**** ERROR: " + ioe.getMessage(), ioe);
        }

        return jestResult;
    }
}
