package lv.lu.finalwork.controller;

import lv.lu.finalwork.domain.Product;
import lv.lu.finalwork.model.ui.ProductData;
import lv.lu.finalwork.model.ui.ProductInputData;
import lv.lu.finalwork.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;


    @GetMapping(value = "/allproducts")
    public List<ProductData> getAllProducts(){
        return productService.findAll();
    }

    @PostMapping(value = "/setproduct")
    void saveProducts(@RequestBody Product product){
        productService.save(product);
    }
}
