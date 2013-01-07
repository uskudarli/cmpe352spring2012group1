package plug.beans.mappers;

import org.springframework.jdbc.core.RowMapper;
import plug.beans.*;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * User: alperen
 * Date: 02.01.2013
 * Time: 22:54
 * To change this template use File | Settings | File Templates.
 */
public class ServiceStatusBeanWithUserMapper implements RowMapper<ServiceStatusBeanWithUser> {
    @Override
    public ServiceStatusBeanWithUser mapRow(ResultSet rs, int rowNum) throws SQLException {
        ServiceStatusBeanWithUser bean = new ServiceStatusBeanWithUser();
        Users userBean= new Users();
        userBean.setUserId(rs.getInt("user_id"));
        userBean.setName(rs.getString("name"));
        userBean.setSurname(rs.getString("surname"));
        bean.setUsers(userBean);

        ServiceStatusBean serviceStatusBean = new ServiceStatusBean();
        serviceStatusBean.setApplyMsg(rs.getString("apply_msg"));
        serviceStatusBean.setConsumerId(rs.getInt("consumer_id"));
        serviceStatusBean.setCredit(rs.getInt("credit"));
        serviceStatusBean.setProviderId(rs.getInt("provider_id"));
        serviceStatusBean.setResponseMsg(rs.getString("response_msg"));
        serviceStatusBean.setServiceId(rs.getInt("service_id"));
        serviceStatusBean.setType(ServiceType.valueOf(rs.getString("type")));
        serviceStatusBean.setStatus(ServiceStatusType.valueOf(rs.getString("status")));
        serviceStatusBean.setInteractionId(rs.getInt("interaction_id"));
        bean.setServiceStatusBean(serviceStatusBean);

        bean.setBeginDate(rs.getString("begin_date"));
        bean.setDesc(rs.getString("desc"));
        bean.setTitle(rs.getString("title"));
        bean.setEndDate(rs.getString("end_date"));
        bean.setEnabled(rs.getInt("enabled"));
        return bean;
    }
}
