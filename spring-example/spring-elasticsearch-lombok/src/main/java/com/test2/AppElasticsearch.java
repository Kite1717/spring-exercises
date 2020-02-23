package com.test2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@SpringBootApplication
//Elasticsearch ün repository sini kullancağımız için ekledik
@EnableElasticsearchRepositories
public class AppElasticsearch {
    public static void main(String[] args) {
        SpringApplication.run(AppElasticsearch.class , args);


    }
}
