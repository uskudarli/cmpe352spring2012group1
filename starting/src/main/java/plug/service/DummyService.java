package plug.service;

import plug.beans.*;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: alperen
 * Date: 14.10.2012
 * Time: 23:51
 * To change this template use File | Settings | File Templates.
 */
public interface DummyService {
    public Users getLoggedInUser();

    List<RequestedServices> getRequestedServices(Integer userId);

    List<OfferedServices> getOfferedServices(Integer userId);

    List<City> getCities();

    List<Town> getTowns(int id);

    List<District> getDistricts(int id);

    boolean offerService(int userId, String serviceName, String description, String hiddenTagList, String beginDate, String endDate,String duration, String intervalString, int cityId, int townId, int districtId);

    boolean createService(int userId, String serviceName, String description, String hiddenTagList, String begin, String end,String duration, String intervalString, int serviceAnyone, int cityId, int townId, int districtId);

    List<RequestedServices> getRequestedServicesSearhResult(String serviceQuery);

    List<OfferedServices> getOfferedServicesSearchResult(String serviceQuery);

    boolean enableDisableOffer(int serviceId, int enabled);

    boolean enableDisableRequest(int serviceId, int enabled);

    boolean deleteOfferedService(int serviceId);

    boolean deleteRequestedService(int serviceId);

    boolean applyService(ServiceType type,Integer serviceId,Integer providerId,Integer consumerId,Integer credit,String applyMsg);

    List<ServiceStatusBean> getServiceStasuses();

    RequestedServices getRequestedService(int serviceId);

    OfferedServices getOfferedService(int serviceId);

    List<ServiceStatusBeanWithUser> getHistory(int userId, ServiceType type);

    List<ServiceStatusBeanWithUser> getPendingServicesConsumedByMe(int userId);

    List<ServiceStatusBeanWithUser> getPendingServicesProvidedByMe(int userId);

    List<ServiceStatusBeanWithUser> getCurrentServicesToDo(int userId);

    List<ServiceStatusBeanWithUser> getCurrentServicesWaiting(int userId);

    boolean changeServiceStatusType(int id, ServiceStatusType serviceStatusType);

    boolean updateProfile(Integer userId, String name, String surname, String password, String avatarId);

    boolean signup(String name, String surname, String email, String password, String avatarId);

    Users getUser(String email);

    boolean insertUserRole(Integer userId);
}
