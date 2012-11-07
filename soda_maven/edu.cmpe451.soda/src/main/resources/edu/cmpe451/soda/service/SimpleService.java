package edu.cmpe451.soda.service;

import edu.cmpe451.soda.entity.OfferedServices;
import edu.cmpe451.soda.entity.RequestedServices;
import edu.cmpe451.soda.entity.Users;

/**
 * Created with IntelliJ IDEA.
 * User: aurora
 * Date: 11/7/12
 * Time: 10:58 AM
 * To change this template use File | Settings | File Templates.
 */
public interface SimpleService {
    public Users getLoggedInUser(String userName);

    List<RequestedServices> getRequestedServices(Integer userId);

    List<OfferedServices> getOfferedServices(Integer userId);
}
