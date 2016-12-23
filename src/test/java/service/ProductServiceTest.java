package service;

import com.company.Application;
import com.company.domains.CurrentPrice;
import com.company.domains.Product;
import com.company.repositories.CurrentPriceRepository;
import com.company.services.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
/**
 * Created by petenguy1 on 12/23/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {Application.class})
@WebAppConfiguration
public class ProductServiceTest {

    @Autowired
    private ProductService productService;

    @Autowired
    private CurrentPriceRepository currentPriceRepository;

    @Test
    public void listAllProductsTest(){
        List<Product> productList = (List<Product>) productService.listAllProducts();
        assertEquals(2, productList.size());
    }

    @Test
    public void getProductByIdTest(){
        Product product = productService.getProductById((long)13860428);
        assertEquals("The Big Lebowski (Blu-ray) (Widescreen)", product.getName());
        assertEquals(1, product.getCurrent_price().getId(), 0);

    }

    @Test
    public void saveProductTest(){
        assertNull(productService.getProductById((long)12345678));
        saveProduct();
        assertNotNull(productService.getProductById((long) 12345678));
    }

    @Test
    public void saveProductListTest(){
        List<Product> productList = (List<Product>) productService.listAllProducts();
        assertEquals(2, productList.size());

        saveProductList();

        List<Product> updatedProductList = (List<Product>) productService.listAllProducts();
        assertEquals(5, updatedProductList.size());
    }

    @Test
    public void deleteProductTest(){
        saveProduct();
        assertNotNull(productService.getProductById((long)12345678));
        productService.deleteProduct((long)12345678);
        assertNull(productService.getProductById((long)12345678));
    }

    public void saveProduct() {
        CurrentPrice currentPrice = new CurrentPrice();
        currentPrice.setValue(12.34);
        currentPrice.setCurrency_code("TEST");
        currentPriceRepository.save(currentPrice);

        Product newProduct = new Product();
        newProduct.setId((long)12345678);
        newProduct.setName("Test Product");
        newProduct.setCurrent_price(currentPrice);
        productService.saveProduct(newProduct);
    }

    public void saveProductList() {
        CurrentPrice currentPrice = new CurrentPrice();
        currentPrice.setValue(12.34);
        currentPrice.setCurrency_code("TEST");
        currentPriceRepository.save(currentPrice);

        List<Product> newProductList = new ArrayList<Product>();
        for (int i = 0; i < 3; i++) {
            newProductList.add(new Product((long)i, "TEST", currentPrice));
        }

        productService.saveProductList(newProductList);
    }

}
