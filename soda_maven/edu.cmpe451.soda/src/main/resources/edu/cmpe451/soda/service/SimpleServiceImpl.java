package edu.cmpe451.soda.service;

import edu.cmpe451.soda.dao.SimpleDAO;
import edu.cmpe451.soda.entity.OfferedServices;
import edu.cmpe451.soda.entity.RequestedServices;
import edu.cmpe451.soda.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * User: aurora
 * Date: 11/7/12
 * Time: 10:58 AM
 * To change this template use File | Settings | File Templates.
 */
@Service
public class SimpleServiceImpl implements SimpleService{

    @Autowired
    SimpleDAO simpleDAO;

    @Override
    public Users getLoggedInUser(String userName) {
        return simpleDAO.getLoggedInUser(userName);
    }

    @Override
    public List<RequestedServices> getRequestedServices(Integer userId) {
        return simpleDAO.getRequestedServices(userId);
    }

    @Override
    public List<OfferedServices> getOfferedServices(Integer userId) {
        return simpleDAO.getOfferedServices(userId);
    }
}
