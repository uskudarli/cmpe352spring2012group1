package plug.beans;

/**
 * Created with IntelliJ IDEA.
 * User: alperen
 * Date: 16.12.2012
 * Time: 14:30
 * To change this template use File | Settings | File Templates.
 */
public class ServiceStatusBean {
    int interactionId;
    ServiceType type;
    int serviceId;
    int providerId;
    int consumerId;
    int credit;
    ServiceStatusType status;
    String applyMsg;
    String responseMsg;

    public int getInteractionId() {
        return interactionId;
    }

    public void setInteractionId(int interactionId) {
        this.interactionId = interactionId;
    }

    public ServiceType getType() {
        return type;
    }

    public void setType(ServiceType type) {
        this.type = type;
    }

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    public int getProviderId() {
        return providerId;
    }

    public void setProviderId(int providerId) {
        this.providerId = providerId;
    }

    public int getConsumerId() {
        return consumerId;
    }

    public void setConsumerId(int consumerId) {
        this.consumerId = consumerId;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public ServiceStatusType getStatus() {
        return status;
    }

    public void setStatus(ServiceStatusType status) {
        this.status = status;
    }

    public String getApplyMsg() {
        return applyMsg;
    }

    public void setApplyMsg(String applyMsg) {
        this.applyMsg = applyMsg;
    }

    public String getResponseMsg() {
        return responseMsg;
    }

    public void setResponseMsg(String responseMsg) {
        this.responseMsg = responseMsg;
    }
}
