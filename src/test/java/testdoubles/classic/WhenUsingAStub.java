package testdoubles.classic;

import org.junit.jupiter.api.Test;
import testdoubles.Authorizer;
import testdoubles.System;

import static org.assertj.core.api.Assertions.assertThat;

public class WhenUsingAStub {

    @Test
    public void we_want_to_control_the_returned_value_to_make_the_system_under_test_accept_the_login_attempt() {
        System system = new System(acceptingAuthorizer());

        system.login("bob", "SecretPassword");

        assertThat(system.numberOfActiveUsers()).isEqualTo(1);
    }

    @Test
    public void we_want_to_control_the_returned_value_to_make_the_system_under_test_reject_the_login_attempt() {
        System system = new System(rejectingAuthorizer());

        system.login("bob", "SecretPassword");

        assertThat(system.numberOfActiveUsers()).isEqualTo(0);
    }

    private Authorizer acceptingAuthorizer() {
        return (username, password) -> true;
    }

    private Authorizer rejectingAuthorizer() {
        return (username, password) -> false;
    }
}