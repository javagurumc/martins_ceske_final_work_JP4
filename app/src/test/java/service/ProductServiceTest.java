package service;

import lv.lu.finalwork.model.repository.Product;
import lv.lu.finalwork.model.ui.ProductInputData;
import lv.lu.finalwork.repository.Repository;
import lv.lu.finalwork.service.ProductMapper;
import lv.lu.finalwork.service.ProductService;
import lv.lu.finalwork.validation.ProductValidator;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verifyNoMoreInteractions;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceTest {

    @InjectMocks
    private ProductService service;

    @Mock
    private Repository<Product> repository;

    @Mock
    private ProductMapper mapper;

    @Mock
    private ProductValidator validator;

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void shouldStoreProduct() {
        final ProductInputData inputData = new ProductInputData();
        final Product product = new Product();

        given(mapper.mapFrom(inputData)).willReturn(product);
        service.save(inputData);

        InOrder inOrder = Mockito.inOrder(mapper, repository, validator);
        inOrder.verify(validator).validate(inputData);
        inOrder.verify(mapper).mapFrom(inputData);
        inOrder.verify(repository).save(product);

        verifyNoMoreInteractions(mapper, repository, validator);
    }

    @Test
    public void shouldThrowErrorWhenFindByNull() {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Product Id can't be null");

        service.findById(null);
    }
}