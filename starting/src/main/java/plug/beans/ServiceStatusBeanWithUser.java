package plug.beans;


/**
 * Created with IntelliJ IDEA.
 * User: alperen
 * Date: 02.01.2013
 * Time: 22:55
 * To change this template use File | Settings | File Templates.
 */
public class ServiceStatusBeanWithUser  {
    public Users users;
    public ServiceStatusBean serviceStatusBean;
    public String title;
    public String desc;
    public String beginDate;
    public String endDate;
    public int enabled;

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public ServiceStatusBean getServiceStatusBean() {
        return serviceStatusBean;
    }

    public void setServiceStatusBean(ServiceStatusBean serviceStatusBean) {
        this.serviceStatusBean = serviceStatusBean;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(String beginDate) {
        this.beginDate = beginDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public int getEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }
}
