package com.ecom.product.dao;

import io.searchbox.client.JestResult;
import org.apache.tomcat.util.file.Matcher;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * Created by jcordones13 on 9/16/16.
 */
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
@RunWith(MockitoJUnitRunner.class)
public class ESDaoTest {

    @Mock ESDao ESDaoMock;

    @InjectMocks
    private ESDao esDao;


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

    }

    @Test
    public void updateProduct() throws Exception {

    }

    @Test
    public void deleteProduct() throws Exception {

    }

}