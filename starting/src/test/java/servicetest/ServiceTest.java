package servicetest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import plug.beans.City;
import plug.beans.Town;
import plug.beans.District;
import plug.beans.OfferedServices;
import plug.beans.RequestedServices;
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
    
    @Test
    public void testTowns() throws Exception {
        List<Town> towns=dummyService.getTowns(1);
        assertEquals(15,towns.size());
        assertEquals("Ceyhan",towns.get(1).getName());
    }
    
    @Test
    public void testDistricts() throws Exception {
        List<District> districts=dummyService.getDistricts(1);
        assertEquals(2,districts.size());
        assertEquals("Karsantý",districts.get(0).getName());
    }
    
    @Test
    public void testOfferedServices() throws Exception {
        List<OfferedServices> offeredServices=dummyService.getOfferedServicesSearchResult("select title from offered_services where user_id=1");
        assertEquals("örgü örmek",offeredServices.get(0).getTitle());
        assertEquals("Guitar Lesson",offeredServices.get(1).getTitle());
        assertEquals("deneme",offeredServices.get(2).getTitle());
        assertEquals("Almanca dersi",offeredServices.get(3).getTitle());
        assertEquals("Waffle toaster",offeredServices.get(4).getTitle());
    }

       
    
    @Test
    public void testRequestedServices() throws Exception {
        List<RequestedServices> requestedServices=dummyService.getRequestedServicesSearhResult("select title from requested_services where user_id=1");
        assertEquals("perde takma",requestedServices.get(0).getTitle());
        assertEquals("math",requestedServices.get(1).getTitle());
        assertEquals("ffggf",requestedServices.get(2).getTitle());
    }
        
    
   
    

    
}
