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
package com.ecom.product.bootstrap;

import io.searchbox.client.JestClient;
import io.searchbox.client.JestClientFactory;
import io.searchbox.client.config.HttpClientConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by jcordones13 on 9/6/16.
 */
@Configuration
@ComponentScan(basePackages = "com.ecom.product")
@PropertySource(value = "classpath:application.properties")

public class AppConfig
{@Value("${dev.es.url}")
private String ec_uri;

    /*@Bean
    public JestClientWrapper jestClientWrapper(){
        return new JestClientWrapper( jestClient() );
    }*/

    @Bean
    public JestClient jestClient() {

        HttpClientConfig clientConfig = new HttpClientConfig
                .Builder(ec_uri)
                .multiThreaded(true)
                .build();
        JestClientFactory factory = new JestClientFactory();
        factory.setHttpClientConfig(clientConfig);
        return factory.getObject();
    }

}
