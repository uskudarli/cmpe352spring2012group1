package edu.cmpe451.soda.dao;

import edu.cmpe451.soda.entity.OfferedServices;
import edu.cmpe451.soda.entity.RequestedServices;
import edu.cmpe451.soda.entity.Users;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: aurora
 * Date: 11/7/12
 * Time: 11:02 AM
 * To change this template use File | Settings | File Templates.
 */
public interface SimpleDAO {
    Users getLoggedInUser(String userName);

    List<RequestedServices> getRequestedServices(Integer userId);

    List<OfferedServices> getOfferedServices(Integer userId);
}
