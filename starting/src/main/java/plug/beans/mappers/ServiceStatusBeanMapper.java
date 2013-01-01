package plug.beans.mappers;

import org.springframework.jdbc.core.RowMapper;
import plug.beans.ServiceStatusType;
import plug.beans.ServiceStatusBean;
import plug.beans.ServiceType;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * User: alperen
 * Date: 31.12.2012
 * Time: 00:16
 * To change this template use File | Settings | File Templates.
 */
public class ServiceStatusBeanMapper implements RowMapper<ServiceStatusBean> {
    @Override
    public ServiceStatusBean mapRow(ResultSet rs, int rowNum) throws SQLException {

        ServiceStatusBean bean=new ServiceStatusBean();
        bean.setApplyMsg(rs.getString("apply_msg"));
        bean.setConsumerId(rs.getInt("consumer_id"));
        bean.setCredit(rs.getInt("credit"));
        bean.setProviderId(rs.getInt("provider_id"));
        bean.setResponseMsg(rs.getString("response_msg"));
        bean.setServiceId(rs.getInt("service_id"));
        bean.setType(ServiceType.valueOf(rs.getString("type")));
        bean.setStatus(ServiceStatusType.valueOf(rs.getString("status")));
        bean.setInteractionId(rs.getInt("interaction_id"));

        return bean;
    }
}
