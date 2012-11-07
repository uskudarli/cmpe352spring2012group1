package edu.cmpe451.soda.mapper;

import edu.cmpe451.soda.entity.Users;
import org.springframework.jdbc.core.RowMapper;

import javax.resource.cci.ResultSet;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * User: aurora
 * Date: 11/7/12
 * Time: 10:47 AM
 * To change this template use File | Settings | File Templates.
 */
public class UsersMapper implements RowMapper<Users> {

    @Override
    public Users mapRow(ResultSet resultSet, int i) throws SQLException {
        Users userBean = new Users();
        userBean.setUserId(resultSet.getInt("user_id"));
        userBean.setEmail(resultSet.getString("email"));
        userBean.setPassword(resultSet.getString("password"));
        userBean.setEnabled(resultSet.getBoolean("enabled"));
        userBean.setName(resultSet.getString("name"));
        userBean.setSurname(resultSet.getString("surname"));
        return userBean;
    }


}
