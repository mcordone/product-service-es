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
import com.ecom.product.service.ProductServiceImp;
import io.searchbox.client.JestResult;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.times;

/**
 * Created by jcordones13 on 9/16/16.
 */
@RunWith(MockitoJUnitRunner.class)
public class ESDaoTest {

    @Mock ESDao ESDaoMock;

    @InjectMocks
    private ProductServiceImp clazzUnderTest = new ProductServiceImp(); //TODO look into this, it should be ESDao

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void searchProduct() throws Exception {
        JestResult expectedResult = mock(JestResult.class);

        when(ESDaoMock.searchProduct(anyString())).thenReturn(expectedResult);
        JestResult resultId = ESDaoMock.searchProduct("1");
        assertNotNull(resultId);

        verify(ESDaoMock, times(1)).searchProduct(anyString());
    }

    @Test
    public void createProduct() throws Exception {
        Product product = mock(Product.class);

        when(ESDaoMock.createProduct(anyObject())).thenReturn(product);
        Product prod = clazzUnderTest.createProduct(anyObject());

        assertNotNull(prod);

        verify(ESDaoMock, times(1)).createProduct(anyObject());

    }

    @Test
    public void updateProduct() throws Exception {

    }

    @Test
    public void deleteProduct() throws Exception {

    }

}