package plug.DAO.Impl;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import plug.DAO.DummyDAO;
import plug.beans.*;
import plug.beans.mappers.OfferedServiceMap;
import plug.beans.mappers.RequestedServiceMap;
import plug.beans.mappers.ServiceStatusBeanMapper;
import plug.beans.mappers.UserMapper;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: alperen
 * Date: 14.10.2012
 * Time: 23:52
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class DummyDAOImpl implements DummyDAO {

     JdbcTemplate jdbcTemplate;

     UserMapper userMapper=new UserMapper();
     RequestedServiceMap requestedServiceMap=new RequestedServiceMap();
     OfferedServiceMap offeredServiceMap=new OfferedServiceMap();
     ServiceStatusBeanMapper serviceStatusBeanMapper=new ServiceStatusBeanMapper();

     public void setDataSource(DataSource dataSource)
     {
         this.jdbcTemplate = new JdbcTemplate(dataSource);
     }

    @Override
    public Users getLoggedInUser(String email) {
       return jdbcTemplate.queryForObject("select * from users where email=?",userMapper,email);
    }

    @Override
    public List<RequestedServices> getRequestedServices(Integer userId) {
        return jdbcTemplate.query("select * from requested_services where user_id=?",requestedServiceMap,userId);
    }

    @Override
    public List<OfferedServices> getOfferedServices(Integer userId) {
        return jdbcTemplate.query("select * from offered_services where user_id=?",offeredServiceMap,userId);
    }

    @Override
    public List<City> getCities() {
        return jdbcTemplate.query("select * from city",new BeanPropertyRowMapper<City>(City.class));
    }

    @Override
    public List<Town> getTowns(int id) {
        return jdbcTemplate.query("select * from town where city_id=?",new BeanPropertyRowMapper<Town>(Town.class),id);
    }

    @Override
    public List<District> getDistricts(int id) {
        return jdbcTemplate.query("select * from district where town_id=?",new BeanPropertyRowMapper<District>(District.class),id);
    }

    @Override
    public boolean offerService(int userId, String serviceName, String description, String hiddenTagList, String beginDate, String endDate, String intervalString, int cityId, int townId, int districtId) {
        return jdbcTemplate.update("insert into offered_services (user_id,title,`desc`,tag,begin_date,end_date,`time`,city_id,town_id,district_id) values(?,?,?,?,?,?,?,?,?,?)",
                userId,serviceName,description,hiddenTagList,beginDate,endDate,intervalString,cityId,townId,districtId)>0;
    }

    @Override
    public boolean createService(int userId, String serviceName, String description, String hiddenTagList, String begin, String end, int serviceAnyone, int cityId, int townId, int districtId) {
        return jdbcTemplate.update("insert into requested_services (user_id,title,`desc`,tag,begin_date,end_date,service_everyone,city_id,town_id,district_id) values(?,?,?,?,?,?,?,?,?,?)",
                userId,serviceName,description,hiddenTagList,begin,end,serviceAnyone,cityId,townId,districtId)>0;
    }

    @Override
    public List<RequestedServices> getRequestedServicesSearhResult(String serviceQuery) {
        return jdbcTemplate.query(serviceQuery,requestedServiceMap);
    }

    @Override
    public List<OfferedServices> getOfferedServicesSearchResult(String serviceQuery) {
        return jdbcTemplate.query(serviceQuery,offeredServiceMap);
    }

    @Override
    public boolean enableDisableOffer(int serviceId, int enabled) {
        return jdbcTemplate.update("update offered_services set enabled=? where id=?",enabled,serviceId)>0;
    }

    @Override
    public boolean enableDisableRequest(int serviceId, int enabled) {
        return jdbcTemplate.update("update requested_services set enabled=? where id=?",enabled,serviceId)>0;
    }

    @Override
    public boolean deleteOfferedService(int serviceId) {
        return jdbcTemplate.update("delete from offered_services where id=?",serviceId)>0;
    }

    @Override
    public boolean deleteRequestedService(int serviceId) {
        return jdbcTemplate.update("delete from requested_services where id=?",serviceId)>0;
    }

    @Override
    public boolean applyService(ServiceType type,Integer serviceId, Integer providerId, Integer consumerId, Integer credit, String applyMsg) {
        return jdbcTemplate.update("insert into service_status (`type`,service_id,provider_id,consumer_id,credit,status,apply_msg,response_msg) values(?,?,?,?,?,?,?,'')",type.toString(),serviceId,providerId,consumerId,credit,
                ServiceStatusType.NotSeen.toString(),applyMsg)>0;
    }

    @Override
    public List<ServiceStatusBean> getServiceStasuses() {
        return jdbcTemplate.query("select * from service_status",serviceStatusBeanMapper);
    }

    @Override
    public RequestedServices getRequestedService(int serviceId) {
        try{
        return jdbcTemplate.queryForObject("select * from requested_services where id=?",requestedServiceMap ,serviceId);
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public OfferedServices getOfferedService(int serviceId) {
        try{
            return jdbcTemplate.queryForObject("select * from offered_services where id=?",new BeanPropertyRowMapper<OfferedServices>(OfferedServices.class) ,serviceId);
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public List<ServiceStatusBean> getHistory(int userId, ServiceType type) {
        if(type.equals(ServiceType.offered)){
            return jdbcTemplate.query("select * from service_status where type='offered' and provider_id=?",serviceStatusBeanMapper,userId);
        }
        else if(type.equals(ServiceType.requested)){
            return jdbcTemplate.query("select * from service_status where type='requested' and consumer_id=?",serviceStatusBeanMapper,userId);
        }
        return new ArrayList<ServiceStatusBean>();
    }

}
