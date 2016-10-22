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

import com.ecom.product.bootstrap.AppConfig;
import com.ecom.product.dao.DataSourceDao;
import com.ecom.product.model.Product;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.spring.integration.test.annotation.SpringAnnotationConfiguration;
import org.jboss.shrinkwrap.api.ArchivePaths;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import static org.junit.Assert.assertNotNull;

/**
 * Created by jcordones13 on 10/17/16.
 */
@RunWith(Arquillian.class)
@SpringAnnotationConfiguration(classes = {AppConfig.class})
public class ProductServiceImpTest {
    private static Logger LOG = LoggerFactory.getLogger(ProductServiceImpTest.class);

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClasses(AppConfig.class, ProductServiceImp.class, DataSourceDao.class, Product.class)
                .addPackage("com.ecom.product")
                .addAsManifestResource(EmptyAsset.INSTANCE, ArchivePaths.create("applicationContext.xml"));
    }

    @Autowired
    private ProductServiceImp productServiceImp;

    @Test
    public void testGetProductById() throws Exception {
        Product prod = productServiceImp.getProductById("1");
        LOG.info("************** PROD ID " + prod.getId() + " PROD NAME: " + prod.getName());
        assertNotNull(prod);
    }
}