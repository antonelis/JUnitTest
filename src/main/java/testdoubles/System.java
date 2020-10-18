package testdoubles;

public class System {

    private Authorizer authorizer;
    private int activeUsers = 0;

    public System(Authorizer authorizer) {
        this.authorizer = authorizer;
    }

    public void login(String username, String password) {
        if (authorizer.authorise(username, password)) {
            ++activeUsers;
        }
    }

    public int numberOfActiveUsers() {
        return activeUsers;
    }
}