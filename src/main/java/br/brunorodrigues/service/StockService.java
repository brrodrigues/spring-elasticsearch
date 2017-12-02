package br.brunorodrigues.service;

import br.brunorodrigues.domain.Stock;
import br.brunorodrigues.repository.StockRepository;
import org.reactivestreams.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.stream.Stream;

@Component
public class StockService {

    @Autowired
    private StockRepository stockRepository;

    public Flux<Stock> stocks = Flux.empty();

    public void save(Stock stock) {
        stockRepository.save(stock);
    }

    public void delete(String stockName) {
        stockRepository.deleteById(stockName);
    }

}
