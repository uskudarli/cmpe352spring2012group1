package plug.beans;

import org.springframework.context.annotation.Bean;

/**
 * Created with IntelliJ IDEA.
 * User: alperen
 * Date: 16.10.2012
 * Time: 20:46
 * To change this template use File | Settings | File Templates.
 */

public class UserBean {
    int userId;
    String userName;
    String password;
    boolean enabled;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
