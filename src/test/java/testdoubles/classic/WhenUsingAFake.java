package testdoubles.classic;

import org.junit.jupiter.api.Test;
import testdoubles.Authorizer;
import testdoubles.System;

import static org.assertj.core.api.Assertions.assertThat;

public class WhenUsingAFake {

    @Test
    public void we_want_to_control_the_behaviour_of_the_mock_depending_on_the_parameters() {
        System system = new System(fakeAuthorizer());

        system.login("bob", "SecretPassword");
        system.login("kevin", "OtherSecretPassword");

        assertThat(system.numberOfActiveUsers()).isEqualTo(1);
    }

    private Authorizer fakeAuthorizer() {
        return (username, password) -> "bob".equalsIgnoreCase(username);
    }
}