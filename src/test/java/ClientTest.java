import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ClientTest {
    @BeforeEach
    void setup() {
        ClientFactory.resetIdForTesting();
    }

    @Test
    void shouldReturnTrueForEqualClients() {
        Client client1 = new Client(1L, "Jon", "Doe", "jon.doe@email.com", "514-000-0000");
        Client client2 = new Client(1L, "Jon", "Doe", "jon.doe@email.com", "514-000-0000");

        assertEquals(client1, client2, "Clients should be equal");
    }

    @Test
    void shouldReturnFalseForDifferentClients() {
        Client client1 = new Client(1L, "Jon", "Doe", "jon.doe@email.com", "514-000-0000");
        Client client2 = new Client(2L, "Jane", "Doe", "jane.doe@email.com", "418-111-1111");

        assertNotEquals(client1, client2, "Clients should not be equal");
    }

    @Test
    void shouldReturnCorrectHashCodeForEqualClients() {
        Client client1 = new Client(1L, "Jon", "Doe", "jon.doe@email.com", "514-000-0000");
        Client client2 = new Client(1L, "Jon", "Doe", "jon.doe@email.com", "514-000-0000");

        assertEquals(client1.hashCode(), client2.hashCode(), "Hash codes should be equal");
    }

    @Test
    void shouldCreateClient() {
        Client expectedClient = new Client(1L, "Jon", "Doe", "jon.doe@email.com", "514-000-0000");
        Client actualClient = ClientFactory.createClient("Jon", "Doe", "jon.doe@email.com", "514-000-0000");

        assertEquals(expectedClient, actualClient, "The created client should match the expected one.");
    }

    @Test
    void shouldIncrementId() {
        Client client1 = ClientFactory.createClient("Jon", "Doe","jon.doe@email.com","514-000-0000");
        Client client2 = ClientFactory.createClient("Jane", "Doe", "jane.doe@email.com", "418-111-1111");

        assertEquals(client1.id(), 1, "ID should be 1.");
        assertEquals(client2.id(), 2, "ID should be 2.");
    }

    @Test
    void shouldThrowExceptionForNullFirstName() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            ClientFactory.createClient(null, "Doe", "jon.doe@email.com", "514-000-0000");
        });

        assertEquals("The first name cannot be null or empty.", exception.getMessage());
    }

    @Test
    void shouldThrowExceptionForBlankFirstName() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            ClientFactory.createClient(" ", "Doe", "jon.doe@email.com", "514-000-0000");
        });

        assertEquals("The first name cannot be null or empty.", exception.getMessage());
    }

    @Test
    void shouldThrowExceptionForNullLastName() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            ClientFactory.createClient("Jon", null, "jon.doe@email.com", "514-000-0000");
        });

        assertEquals("The last name cannot be null or empty.", exception.getMessage());
    }

    @Test
    void shouldThrowExceptionForBlankLastName() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            ClientFactory.createClient("Jon", " ", "jon.doe@email.com", "514-000-0000");
        });

        assertEquals("The last name cannot be null or empty.", exception.getMessage());
    }

    @Test
    void shouldThrowExceptionForNullEmail() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            ClientFactory.createClient("Jon", "Doe", null, "514-000-0000");
        });

        assertEquals("The email cannot be null or empty.", exception.getMessage());
    }

    @Test
    void shouldThrowExceptionForBlankEmail() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            ClientFactory.createClient("Jon", "Doe", " ", "514-000-0000");
        });

        assertEquals("The email cannot be null or empty.", exception.getMessage());
    }

    @Test
    void shouldThrowExceptionForNullPhoneNumber() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            ClientFactory.createClient("Jon", "Doe", "jon.doe@email.com", null);
        });

        assertEquals("The phone number cannot be null or empty.", exception.getMessage());
    }

    @Test
    void shouldThrowExceptionForBlankPhoneNumber() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            ClientFactory.createClient("Jon", "Doe", "jon.doe@email.com", " ");
        });

        assertEquals("The phone number cannot be null or empty.", exception.getMessage());
    }


}