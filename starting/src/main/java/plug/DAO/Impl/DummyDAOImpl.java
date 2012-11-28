package plug.DAO.Impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Repository;
import plug.DAO.DummyDAO;
import plug.beans.*;
import plug.beans.mappers.UserMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
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

     public void setDataSource(DataSource dataSource)
     {
         this.jdbcTemplate = new JdbcTemplate(dataSource);
     }

    @Override
    public Users getLoggedInUser(String userName) {
       return jdbcTemplate.queryForObject("select * from users where email=?",userMapper,userName);
    }

    @Override
    public List<RequestedServices> getRequestedServices(Integer userId) {
        return jdbcTemplate.query("select * from requested_services where user_id=?",new BeanPropertyRowMapper<RequestedServices>(RequestedServices.class),userId);
    }

    @Override
    public List<OfferedServices> getOfferedServices(Integer userId) {
        return jdbcTemplate.query("select * from offered_services where user_id=?",new BeanPropertyRowMapper<OfferedServices>(OfferedServices.class),userId);
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
    public boolean offerService(int userId, String serviceName, String description, String hiddenTagList, String beginDate, String endDate) {
        return jdbcTemplate.update("insert into offered_services (user_id,title,`desc`,tag,begin_date,end_date) values(?,?,?,?,?,?)",
                userId,serviceName,description,hiddenTagList,beginDate,endDate)>0;
    }

    @Override
    public boolean createService(int userId, String serviceName, String description, String hiddenTagList, String begin, String end, int serviceAnyone) {
        return jdbcTemplate.update("insert into requested_services (user_id,title,`desc`,tag,begin_date,end_date,service_everyone) values(?,?,?,?,?,?,?)",
                userId,serviceName,description,hiddenTagList,begin,end,serviceAnyone)>0;
    }

    @Override
    public List<RequestedServices> getRequestedServicesSearhResult(String serviceQuery) {
        return jdbcTemplate.query(serviceQuery,new BeanPropertyRowMapper<RequestedServices>(RequestedServices.class));
    }

    @Override
    public List<OfferedServices> getOfferedServicesSearchResult(String serviceQuery) {
        return jdbcTemplate.query(serviceQuery,new BeanPropertyRowMapper<OfferedServices>(OfferedServices.class));
    }

}
