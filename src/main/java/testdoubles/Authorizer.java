package testdoubles;

public interface Authorizer {
    Boolean authorise(String username, String password);
}