package plug.DAO.Impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Repository;
import plug.DAO.DummyDAO;
import plug.beans.OfferedServices;
import plug.beans.RequestedServices;
import plug.beans.UserBean;
import plug.beans.Users;
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


}
