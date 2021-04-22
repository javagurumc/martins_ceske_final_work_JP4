package lv.lu.finalwork.config;

import lv.lu.finalwork.model.repository.Product;
import lv.lu.finalwork.repository.ProductRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
@ComponentScan("lv.lu.finalwork")
public class AppConfiguration {

    @Bean
    public Map<Long, Product> repository() {
        return new HashMap<>();
    }

    @Bean
    public ProductRepository productRepository() {
        return new ProductRepository(repository());
    }

}
