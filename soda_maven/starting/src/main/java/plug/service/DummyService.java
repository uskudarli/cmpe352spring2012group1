package plug.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import plug.beans.OfferedServices;
import plug.beans.RequestedServices;
import plug.beans.UserBean;
import plug.beans.Users;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: alperen
 * Date: 14.10.2012
 * Time: 23:51
 * To change this template use File | Settings | File Templates.
 */
public interface DummyService {
    public Users getLoggedInUser(String userName);

    List<RequestedServices> getRequestedServices(Integer userId);

    List<OfferedServices> getOfferedServices(Integer userId);
}
