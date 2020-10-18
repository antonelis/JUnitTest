package testdoubles.classic;

import org.junit.jupiter.api.Test;
import testdoubles.Authorizer;
import testdoubles.System;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


public class WhenUsingADummy {

    @Test
    public void we_do_not_worry_about_the_value_it_returns_because_we_know_it_will_never_be_used() {
        System system = new testdoubles.System(dummyAuthorizer());

        assertThat(system.numberOfActiveUsers()).isEqualTo(0);
    }

    @Test
    public void we_can_make_it_return_a_null_so_that_it_does_not_get_used_accidentally() {
        System system = new System(dummyAuthorizer());

        assertThatThrownBy(() -> system.login("bob", "SecretPassword")).isInstanceOf(NullPointerException.class);
    }

    private Authorizer dummyAuthorizer() {
        return (username, password) -> null;
    }
}