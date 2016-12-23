package service;

import com.company.Application;
import com.company.services.ExternalProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * Created by petenguy1 on 12/22/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {Application.class})
@WebAppConfiguration
public class ExternalProductServiceTest {

    @Autowired
    private ExternalProductService externalProductService;

    @Test
    public void externalGetProductNameTest() {
        String name = externalProductService.findProductName("13860428");
        assertEquals("Blu-ray BIG LEBOWSKI, THE Movies", name);
    }

}
