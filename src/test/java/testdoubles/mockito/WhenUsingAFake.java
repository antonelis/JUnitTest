package testdoubles.mockito;

import org.junit.jupiter.api.Test;
import testdoubles.Authorizer;
import testdoubles.System;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class WhenUsingAFake {

    @Test
    public void we_want_to_control_the_behaviour_of_the_mock_depending_on_the_parameters() {

        var mock = mock(Authorizer.class);
        when(mock.authorise(eq("bob"), anyString())).thenReturn(true);
        System system = new System(mock);

        system.login("bob", "SecretPassword");
        system.login("kevin", "OtherSecretPassword");

        assertThat(system.numberOfActiveUsers()).isEqualTo(1);
    }
}