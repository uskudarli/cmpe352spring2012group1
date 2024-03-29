package plug.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
    public Users getLoggedInUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String email = auth.getName();
        return dummyDAO.getLoggedInUser(email);
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
    public boolean offerService(int userId, String serviceName, String description, String hiddenTagList, String beginDate, String endDate,String duration, String intervalString, int cityId, int townId, int districtId) {
        return dummyDAO.offerService(userId,serviceName,description,hiddenTagList,beginDate,endDate,duration,intervalString,cityId,townId,districtId);
    }

    @Override
    public boolean createService(int userId, String serviceName, String description, String hiddenTagList, String begin, String end,String duration, String intervalString, int serviceAnyone, int cityId, int townId, int districtId) {
        return dummyDAO.createService(userId,serviceName,description,hiddenTagList,begin,end,duration,intervalString,serviceAnyone,cityId,townId,districtId);
    }

    @Override
    public List<RequestedServices> getRequestedServicesSearhResult(String serviceQuery) {
        return dummyDAO.getRequestedServicesSearhResult(serviceQuery);
    }

    @Override
    public List<OfferedServices> getOfferedServicesSearchResult(String serviceQuery) {
        return dummyDAO.getOfferedServicesSearchResult(serviceQuery);
    }

    @Override
    public boolean enableDisableOffer(int serviceId, int enabled) {
        return dummyDAO.enableDisableOffer(serviceId,enabled);
    }

    @Override
    public boolean enableDisableRequest(int serviceId, int enabled) {
        return dummyDAO.enableDisableRequest(serviceId,enabled);
    }

    @Override
    public boolean deleteOfferedService(int serviceId) {
        return dummyDAO.deleteOfferedService(serviceId);
    }

    @Override
    public boolean deleteRequestedService(int serviceId) {
        return dummyDAO.deleteRequestedService(serviceId);
    }

    @Override
    public boolean applyService(ServiceType type,Integer serviceId, Integer providerId, Integer consumerId, Integer credit, String applyMsg) {
        return dummyDAO.applyService(type,serviceId,providerId,consumerId,credit,applyMsg);
    }

    @Override
    public List<ServiceStatusBean> getServiceStasuses() {
        return dummyDAO.getServiceStasuses();
    }

    @Override
    public RequestedServices getRequestedService(int serviceId) {
        return dummyDAO.getRequestedService(serviceId);
    }

    @Override
    public OfferedServices getOfferedService(int serviceId) {
        return dummyDAO.getOfferedService(serviceId);
    }

    @Override
    public List<ServiceStatusBeanWithUser> getHistory(int userId, ServiceType type) {
        return dummyDAO.getHistory(userId,type);
    }

    @Override
    public List<ServiceStatusBeanWithUser> getPendingServicesConsumedByMe(int userId) {
        return dummyDAO.getPendingServicesConsumedByMe(userId);
    }

    @Override
    public List<ServiceStatusBeanWithUser> getPendingServicesProvidedByMe(int userId) {
        return dummyDAO.getPendingServicesProvidedByMe(userId);
    }

    @Override
    public List<ServiceStatusBeanWithUser> getCurrentServicesToDo(int userId) {
        return dummyDAO.getCurrentServicesToDo(userId);
    }

    @Override
    public List<ServiceStatusBeanWithUser> getCurrentServicesWaiting(int userId) {
        return dummyDAO.getCurrentServicesWaiting(userId);
    }

    @Override
    public boolean changeServiceStatusType(int id, ServiceStatusType serviceStatusType) {
        return dummyDAO.changeServiceStatusType(id,serviceStatusType);
    }

    @Override
    public boolean updateProfile(Integer userId, String name, String surname ,String password, String avatarId) {
        return dummyDAO.updateProfile(userId,name,surname,password,avatarId);
    }

    @Override
    public boolean signup(String name, String surname, String email, String password, String avatarId) {
        return dummyDAO.signup(name,surname,email,password,avatarId);
    }

    @Override
    public Users getUser(String email) {
        return dummyDAO.getLoggedInUser(email);
    }

    @Override
    public boolean insertUserRole(Integer userId) {
        return dummyDAO.insertUserRole(userId);
    }

    @Override
    public boolean changeServiceStatusType(int id, ServiceStatusType serviceStatusType, String responseMsg) {
        return dummyDAO.changeServiceStatusType(id, serviceStatusType,responseMsg);
    }

    @Override
    public List<ServiceStatusBeanWithUser> getHistoryToMe(int userId) {
        return dummyDAO.getHistoryToMe(userId);
    }

    @Override
    public List<ServiceStatusBeanWithUser> getHistoryBeMe(int userId) {
        return dummyDAO.getHistoryBeMe(userId);
    }

    @Override
    public ServiceStatusBean getServiceStatuse(int id) {
        return dummyDAO.getServiceStatuse(id);
    }

    @Override
    public boolean complete(int id, int credit) {
        return dummyDAO.complete(id,credit);
    }
}
