import java.time.LocalDateTime;

/**
 * Created by chris on 29/11/2016.
 */
class User {
    private String name, password;
    private boolean connected = false;
    private LocalDateTime connectTime;

    User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    String getName() {
        return name;
    }

    String getPassword() {
        return password;
    }

    void setConnected(boolean connected) {
        this.connected = connected;
    }

    boolean isConnected() {
        return connected;
    }

    void setConnectTime(LocalDateTime connectTime) {
        this.connectTime = connectTime;
    }

    LocalDateTime getConnectTime() {
        return connectTime;
    }
}
