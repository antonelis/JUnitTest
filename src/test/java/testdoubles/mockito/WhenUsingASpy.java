package testdoubles.mockito;

import org.junit.jupiter.api.Test;
import testdoubles.Authorizer;
import testdoubles.System;

import static org.mockito.Mockito.*;

public class WhenUsingASpy {

    @Test
    public void we_want_to_ensure_that_the_spy_was_called() {
        var mock = mock(Authorizer.class);

        System system = new System(mock);

        system.login("bob", "SecretPassword");

        verify(mock).authorise("bob", "SecretPassword");
    }
}