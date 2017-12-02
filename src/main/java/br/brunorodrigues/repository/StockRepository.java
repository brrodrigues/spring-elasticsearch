package br.brunorodrigues.repository;

import br.brunorodrigues.domain.Stock;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface StockRepository extends ElasticsearchCrudRepository<Stock, String> {


    Flux<Stock> findByName(Mono<String> firstName);

}
