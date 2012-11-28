package servicetest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import plug.beans.City;
import plug.service.DummyService;

import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

/**
 * Created with IntelliJ IDEA.
 * User: alperen
 * Date: 28.11.2012
 * Time: 21:42
 * To change this template use File | Settings | File Templates.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/testContext.xml")
public class ServiceTest {

    @Autowired
    DummyService dummyService;

    @Test
    public void checkService() {
        assertNotNull(dummyService);
    }

    @Test
    public void testName() throws Exception {
        List<City> cities=dummyService.getCities();
        assertEquals(81,cities.size());
        assertEquals("Adana",cities.get(0).getName());
    }

}
