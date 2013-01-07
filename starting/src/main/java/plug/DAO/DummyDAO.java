package plug.DAO;

import plug.beans.*;
import plug.beans.mappers.ServiceStatusBeanWithUserMapper;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: alperen
 * Date: 14.10.2012
 * Time: 23:51
 * To change this template use File | Settings | File Templates.
 */
public interface DummyDAO {
    Users getLoggedInUser(String email);

    List<RequestedServices> getRequestedServices(Integer userId);

    List<OfferedServices> getOfferedServices(Integer userId);

    List<City> getCities();

    List<Town> getTowns(int id);

    List<District> getDistricts(int id);

    boolean offerService(int userId, String serviceName, String description, String hiddenTagList, String beginDate, String endDate, String intervalString, int cityId, int townId, int districtId);

    boolean createService(int userId, String serviceName, String description, String hiddenTagList, String begin, String end, int serviceAnyone, int cityId, int townId, int districtId);

    List<RequestedServices> getRequestedServicesSearhResult(String serviceQuery);

    List<OfferedServices> getOfferedServicesSearchResult(String serviceQuery);

    boolean enableDisableOffer(int serviceId, int enabled);

    boolean enableDisableRequest(int serviceId, int enabled);

    boolean deleteOfferedService(int serviceId);

    boolean deleteRequestedService(int serviceId);

    boolean applyService(ServiceType type,Integer serviceId, Integer providerId, Integer consumerId, Integer credit, String applyMsg);

    List<ServiceStatusBean> getServiceStasuses();

    RequestedServices getRequestedService(int serviceId);

    OfferedServices getOfferedService(int serviceId);

    List<ServiceStatusBeanWithUser> getHistory(int userId, ServiceType type);

    List<ServiceStatusBeanWithUser> getPendingServicesConsumedByMe(int userId);

    List<ServiceStatusBeanWithUser> getPendingServicesProvidedByMe(int userId);

    List<ServiceStatusBeanWithUser> getCurrentServicesToDo(int userId);

    List<ServiceStatusBeanWithUser> getCurrentServicesWaiting(int userId);

    boolean changeServiceStatusType(int id, ServiceStatusType serviceStatusType);
}
