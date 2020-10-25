package com.quguai.config;

import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;

import java.time.Duration;

@Configuration
public class ESConfiguration extends AbstractElasticsearchConfiguration {

    @Bean
    public RestHighLevelClient elasticsearchClient(){
        ClientConfiguration configuration = ClientConfiguration.builder()
                .connectedTo("192.168.1.103:9200")
                .withConnectTimeout(Duration.ofSeconds(5))
                .build();
        return RestClients.create(configuration).rest();
    }
}
