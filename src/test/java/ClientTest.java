import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class ClientTest {

    @Test
    void shouldReturnTrueForEqualClients() {

        Client client1 = new Client(1L, "Jon", "Doe", "jon.doe@email.com", "514-000-0000");
        Client client2 = new Client(1L, "Jon", "Doe", "jon.doe@email.com", "514-000-0000");

        assertEquals(client1, client2, "Les clients devraient être égaux");
    }

    @Test
    void shouldReturnFalseForDifferentClients() {
        Client client1 = new Client(1L, "Jon", "Doe", "jon.doe@email.com", "514-000-0000");
        Client client2 = new Client(2L, "Jane", "Doe", "jane.doe@email.com", "418-111-1111");

        assertNotEquals(client1, client2, "Les clients devraient être différents");
    }

    @Test
    void shouldReturnCorrectHashCodeForEqualClients() {
        Client client1 = new Client(1L, "Jon", "Doe", "jon.doe@email.com", "514-000-0000");
        Client client2 = new Client(1L, "Jon", "Doe", "jon.doe@email.com", "514-000-0000");

        assertEquals(client1.hashCode(), client2.hashCode(), "Les codes de hachage devraient être égaux");
    }

}