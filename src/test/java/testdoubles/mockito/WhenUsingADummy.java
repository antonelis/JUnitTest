package testdoubles.mockito;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import testdoubles.Authorizer;
import testdoubles.System;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class WhenUsingADummy {

    @Test
    @Disabled("Implement me, please ...")
    public void we_do_not_worry_about_the_value_it_returns_because_we_know_it_will_never_be_used() {
        var mock = mock(Authorizer.class);
        System system = new testdoubles.System(mock);

        assertThat(system.numberOfActiveUsers()).isEqualTo(0);
    }

    @Test
    public void we_make_it_return_a_null_so_that_it_does_not_get_used_accidentally() {
        var mock = mock(Authorizer.class);
        System system = new System(mock);
        when(mock.authorise(anyString(), anyString())).thenReturn(null);
        assertThatThrownBy(() -> system.login("bob", "SecretPassword")).isInstanceOf(NullPointerException.class);
    }
}