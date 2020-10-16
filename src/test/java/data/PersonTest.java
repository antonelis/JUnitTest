package data;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    public void equalsContract() {
        EqualsVerifier.simple().forClass(Person.class).verify();
    }

}