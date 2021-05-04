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

    @RequestMapping(value = "/allproducts", method = RequestMethod.GET)
    public List<ProductData> getAllProducts(){
        return productService.findAll();
    }

    //Simplified REST example findAll
    @RequestMapping(value = "/allproductssimplified", method = RequestMethod.GET)
    public List<ProductData> getAllProductsSimplified(){
        return productService.findAll();
    }

    @RequestMapping(value = "/saveproduct", method = RequestMethod.POST)
    public void saveProducts(@RequestBody ProductInputData product){
        productService.save(product);
    }

    //Simplified REST example save
    @RequestMapping(value = "/saveproductsimplified", method = RequestMethod.POST)
    public Product saveProductSimplified(@RequestBody Product product){
       return productService.save(product);
    }
}
