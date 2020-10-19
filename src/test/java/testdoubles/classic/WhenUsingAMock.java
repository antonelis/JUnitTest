package testdoubles.classic;

import org.junit.jupiter.api.Test;
import testdoubles.Authorizer;
import testdoubles.System;

import static org.assertj.core.api.Assertions.assertThat;

public class WhenUsingAMock {

    @Test
    public void we_want_to_move_the_test_logic_from_the_test_to_the_mock_object() {
        AcceptingAuthorizerVerificationMock mock = new AcceptingAuthorizerVerificationMock();
        System system = new System(mock);

        system.login("bob", "SecretPassword");

        assertThat(mock.verify()).isTrue();
    }

    static class AcceptingAuthorizerVerificationMock implements Authorizer {
        private boolean authoriseWasCalled = false;
        private boolean loggedInAsBob = false;

        @Override
        public Boolean authorise(String username, String password) {
            authoriseWasCalled = true;
            loggedInAsBob = "bob".equalsIgnoreCase(username);

            return true;
        }

        public boolean verify() {
            return authoriseWasCalled && loggedInAsBob;
        }
    }
}