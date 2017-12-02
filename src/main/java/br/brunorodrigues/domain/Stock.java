package br.brunorodrigues.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.elasticsearch.annotations.Document;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@Document(type = "stock", indexName = "elastic.stocks")
public class Stock {

    private String name;
    private BigDecimal price;


}
