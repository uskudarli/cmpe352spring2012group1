package edu.cmpe451.soda.dao;

import edu.cmpe451.soda.entity.OfferedServices;
import edu.cmpe451.soda.entity.RequestedServices;
import edu.cmpe451.soda.entity.Users;
import edu.cmpe451.soda.mapper.UsersMapper;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: aurora
 * Date: 11/7/12
 * Time: 11:02 AM
 * To change this template use File | Settings | File Templates.
 */
public class SimpleDAOImpl implements SimpleDAO {
    JdbcTemplate jdbcTemplate;

    UsersMapper userMapper=new UsersMapper();

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
