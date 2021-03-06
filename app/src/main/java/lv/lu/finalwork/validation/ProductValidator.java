package lv.lu.finalwork.validation;

import lv.lu.finalwork.model.ProductValidationException;
import lv.lu.finalwork.domain.ProductCategory;
import lv.lu.finalwork.model.ui.ProductInputData;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class ProductValidator {

    public void validate(ProductInputData productInputData) {

        if (!StringUtils.hasLength(productInputData.getName())) {
            throw new ProductValidationException("Field 'name' should not be empty");
        }

        if (productInputData.getPrice() < 0) {
            throw new ProductValidationException("Field 'price' should not be negative");
        }

        try {
            ProductCategory.valueOf(productInputData.getCategory());
        } catch (IllegalArgumentException ex) {
            throw new ProductValidationException("Field 'productCategory' is unrecognized");
        }

        if (productInputData.getDiscount() != null && productInputData.getDiscount() < 0) {
            throw new ProductValidationException("Field 'discount' should not be negative");
        }

    }
}
