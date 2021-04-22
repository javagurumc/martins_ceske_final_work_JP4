package lv.lu.finalwork;

import lv.lu.finalwork.config.AppConfiguration;
import lv.lu.finalwork.repository.ProductRepository;
import lv.lu.finalwork.service.ProductMapper;
import lv.lu.finalwork.service.ProductService;
import lv.lu.finalwork.ui.ConsulUI;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class ProductAccountingApplication {

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfiguration.class);

        ProductRepository productRepository = context.getBean(ProductRepository.class);
        ProductMapper productMapper = new ProductMapper();
        ProductService service = new ProductService(productRepository, productMapper);
        Scanner scanner = new Scanner(System.in);
        ConsulUI consulUI = new ConsulUI(service, scanner);

        consulUI.startUi();
    }

}
