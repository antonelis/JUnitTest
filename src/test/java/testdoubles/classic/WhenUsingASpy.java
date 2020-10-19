package testdoubles.classic;

import org.junit.jupiter.api.Test;
import testdoubles.Authorizer;
import testdoubles.System;

import static org.assertj.core.api.Assertions.assertThat;

public class WhenUsingASpy {

    @Test
    public void we_want_to_ensure_that_the_spy_was_called() {
        AcceptingAuthorizerSpy spy = new AcceptingAuthorizerSpy();
        System system = new System(spy);

        system.login("bob", "SecretPassword");

        assertThat(spy.authoriseWasCalled).isTrue();
    }

    static class AcceptingAuthorizerSpy implements Authorizer {
        public boolean authoriseWasCalled = false;

        @Override
        public Boolean authorise(String username, String password) {
            authoriseWasCalled = true;
            return true;
        }
    }
}