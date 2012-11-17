package plug.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import plug.DAO.DummyDAO;
import plug.beans.*;
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

    @Override
    public List<City> getCities() {
        return dummyDAO.getCities();
    }

    @Override
    public List<Town> getTowns(int id) {
        return dummyDAO.getTowns(id);
    }

    @Override
    public List<District> getDistricts(int id) {
        return dummyDAO.getDistricts(id);
    }

    @Override
    public boolean offerService(int userId, String serviceName, String description, String hiddenTagList, String beginDate, String endDate) {
        return dummyDAO.offerService(userId,serviceName,description,hiddenTagList,beginDate,endDate);
    }

    @Override
    public boolean createService(int userId, String serviceName, String description, String hiddenTagList, String begin, String end, int serviceAnyone) {
        return dummyDAO.createService(userId,serviceName,description,hiddenTagList,begin,end,serviceAnyone);
    }
}
