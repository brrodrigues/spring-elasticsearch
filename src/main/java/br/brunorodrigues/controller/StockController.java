package br.brunorodrigues.controller;

import br.brunorodrigues.domain.Stock;
import br.brunorodrigues.service.StockService;
import org.reactivestreams.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/stock")
public class StockController {

    @Autowired
    private StockService stockService;

    @PostMapping
    public ResponseEntity<Stock> createStock(@RequestBody Stock stockStream) {
        stockService.save(stockStream);
        return ResponseEntity.ok(stockStream);
    }

    @DeleteMapping(value ="/{stockName}")
    public ResponseEntity<Stock> deleteStock(@PathVariable(name = "stockName") String stockName) {
        stockService.delete(stockName);
        return ResponseEntity.noContent().build();
    }

}
