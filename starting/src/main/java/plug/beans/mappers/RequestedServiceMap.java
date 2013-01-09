package plug.beans.mappers;

import org.springframework.jdbc.core.RowMapper;
import plug.beans.RequestedServices;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * User: alperen
 * Date: 30.12.2012
 * Time: 23:05
 * To change this template use File | Settings | File Templates.
 */
public class RequestedServiceMap implements RowMapper<RequestedServices> {
    @Override
    public RequestedServices mapRow(ResultSet rs, int rowNum) throws SQLException {
        RequestedServices services=new RequestedServices();
        services.setBeginDate(rs.getDate("begin_date"));
        services.setCityId(rs.getInt("city_id"));
        services.setDesc(rs.getString("desc"));
        services.setDistrictId(rs.getInt("district_id"));
        services.setDuration(rs.getInt("duration"));
        services.setEnabled(rs.getBoolean("enabled"));
        services.setEndDate(rs.getDate("end_date"));
        services.setServiceEveryone(rs.getBoolean("service_everyone"));
        services.setTag(rs.getString("tag"));
        services.setTime(rs.getString("time"));
        services.setTitle(rs.getString("title"));
        services.setTownId(rs.getInt("town_id"));
        services.setUserId(rs.getInt("user_id"));
        services.setId(rs.getInt("id"));

        return services;
    }
}
