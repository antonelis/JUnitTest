package testdoubles.mockito;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import testdoubles.Authorizer;
import testdoubles.System;

import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class WhenUsingAMock {

    @Mock
    Authorizer mock;

    @InjectMocks
    System system;

    @Test
    public void we_want_to_move_the_test_logic_from_the_test_to_the_mock_object() {

        system.login("bob", "SecretPassword");

        verify(mock).authorise("bob", "SecretPassword");
    }
}