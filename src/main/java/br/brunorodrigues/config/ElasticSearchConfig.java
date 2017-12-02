package br.brunorodrigues.config;

import org.elasticsearch.client.node.NodeClient;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Configuration
@EnableElasticsearchRepositories(basePackages = "rio/brunorodrigues/repository")
public class ElasticSearchConfig {

   @Bean
    TransportClient client() throws UnknownHostException {

       Settings settings = Settings.builder().
               put("cluster.name", "elasticsearch").
               put("client.transport.ignore_cluster_name").
               put("client.transport.sniff", true).
               build();

       TransportClient transportClient = new PreBuiltTransportClient(settings).
               addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("localhost"), 9300));
       return transportClient;
   }

    @Bean
    public ElasticsearchOperations elasticsearchTemplate() throws UnknownHostException {
        return new ElasticsearchTemplate(client());
    }

}
