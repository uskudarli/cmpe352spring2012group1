package plug.beans.mappers;

import org.springframework.jdbc.core.RowMapper;
import plug.beans.UserBean;
import plug.beans.Users;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * User: alperen
 * Date: 16.10.2012
 * Time: 20:48
 * To change this template use File | Settings | File Templates.
 */
public class UserMapper implements RowMapper<Users> {
    @Override
    public Users mapRow(ResultSet resultSet, int i) throws SQLException {
        Users userBean=new Users();
        userBean.setUserId(resultSet.getInt("user_id"));
        userBean.setEmail(resultSet.getString("email"));
        userBean.setPassword(resultSet.getString("password"));
        userBean.setEnabled(resultSet.getBoolean("enabled"));
        userBean.setName(resultSet.getString("name"));
        userBean.setSurname(resultSet.getString("surname"));
        userBean.setAvatar_link(resultSet.getString("avatar_link"));
        return  userBean;
    }
}
