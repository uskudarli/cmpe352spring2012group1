package plug.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import plug.DAO.DummyDAO;
import plug.beans.OfferedServices;
import plug.beans.RequestedServices;
import plug.beans.UserBean;
import plug.beans.Users;
import plug.service.DummyService;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: alperen
 * Date: 14.10.2012
 * Time: 23:52
 * To change this template use File | Settings | File Templates.
 */
@Service
public class DummyServiceImpl implements DummyService {
    @Autowired
    DummyDAO dummyDAO;

    @Override
    public Users getLoggedInUser(String userName) {
        return dummyDAO.getLoggedInUser(userName);
    }

    @Override
    public List<RequestedServices> getRequestedServices(Integer userId) {
        return dummyDAO.getRequestedServices(userId);
    }

    @Override
    public List<OfferedServices> getOfferedServices(Integer userId) {
        return dummyDAO.getOfferedServices(userId);
    }
}
