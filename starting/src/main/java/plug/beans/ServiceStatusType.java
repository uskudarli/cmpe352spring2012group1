package plug.beans;

/**
 * Created with IntelliJ IDEA.
 * User: alperen
 * Date: 16.12.2012
 * Time: 13:30
 * To change this template use File | Settings | File Templates.
 */
public enum ServiceStatusType {
    Seen("Seen"),NotSeen("NotSeen"),Approved("Approved"),Rejected("Rejected"),Completed("Completed"),Failed("Failed");

    String name;

    ServiceStatusType(String str){
        name=str;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
