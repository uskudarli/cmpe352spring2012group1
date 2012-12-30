package plug.beans;

/**
 * Created with IntelliJ IDEA.
 * User: alperen
 * Date: 16.12.2012
 * Time: 13:35
 * To change this template use File | Settings | File Templates.
 */
public enum ServiceType {
    offered("offered"),requested("requested");

    String type;

    ServiceType(String type){
        type=type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
