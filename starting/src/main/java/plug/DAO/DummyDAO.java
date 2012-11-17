package plug.DAO;

import org.springframework.security.core.userdetails.User;
import plug.beans.*;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: alperen
 * Date: 14.10.2012
 * Time: 23:51
 * To change this template use File | Settings | File Templates.
 */
public interface DummyDAO {
    Users getLoggedInUser(String userName);

    List<RequestedServices> getRequestedServices(Integer userId);

    List<OfferedServices> getOfferedServices(Integer userId);

    List<City> getCities();

    List<Town> getTowns(int id);

    List<District> getDistricts(int id);

    boolean offerService(int userId, String serviceName, String description, String hiddenTagList, String beginDate, String endDate);

    boolean createService(int userId, String serviceName, String description, String hiddenTagList, String begin, String end, int serviceAnyone);
}
