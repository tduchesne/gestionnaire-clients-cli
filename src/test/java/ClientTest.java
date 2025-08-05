import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
        Client client1 = ClientFactory.createClient("Jon", "Doe", "jon.doe@email.com", "514-000-0000");
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

    @Test
    void shouldAddAndReturnAllClients() {
        ClientService clientService = new ClientService();
        Client client1 = ClientFactory.createClient("Jon", "Doe", "jon.doe@email.com", "514-000-0000");
        Client client2 = ClientFactory.createClient("Jane", "Doe", "jane.doe@email.com", "418-111-1111");
        clientService.addClient(client1);
        clientService.addClient(client2);

        List<Client> expectedClients = new ArrayList<Client>();
        expectedClients.add(client1);
        expectedClients.add(client2);
        List<Client> actualClients = clientService.getAllClients();

        assertEquals(actualClients, expectedClients, "Must return a list of all the clients.");
    }

    @Test
    void shouldFindClientById() {
        ClientService clientService = new ClientService();
        Client client1 = ClientFactory.createClient("Jon", "Doe", "jon.doe@email.com", "514-000-0000");
        Client client2 = ClientFactory.createClient("Jane", "Doe", "jane.doe@email.com", "418-111-1111");
        clientService.addClient(client1);
        clientService.addClient(client2);
        Optional<Client> actualClient = clientService.findClientById(2);

        assertEquals(Optional.of(client2), actualClient, "The client must be found.");
    }

    @Test
    void findClientByIdShouldReturnFalse() {
        ClientService clientService = new ClientService();
        Client client1 = ClientFactory.createClient("Jon", "Doe", "jon.doe@email.com", "514-000-0000");
        Client client2 = ClientFactory.createClient("Jane", "Doe", "jane.doe@email.com", "418-111-1111");
        clientService.addClient(client1);
        clientService.addClient(client2);
        Optional<Client> actualClient = clientService.findClientById(3);

        assertEquals(Optional.empty(), actualClient, "The Optional container should be empty.");
    }

    // TODO Tests for updateClient() and deleteClient()

    @Test
    void shouldUpdateClient() {
        ClientService clientService = new ClientService();
        Client originalClient = ClientFactory.createClient("Jon", "Doe", "jon.doe@email.com", "514-000-0000");
        clientService.addClient(originalClient);

        Client updatedClient = new Client(originalClient.id(), "Jean", "Doe", "jean.doe@email.com", "514-123-4567");

        clientService.updateClient(originalClient.id(), updatedClient);

        Optional<Client> actualClientOptional = clientService.findClientById(originalClient.id());

        assertTrue(actualClientOptional.isPresent(), "The updated client must exist.");
        assertEquals(updatedClient, actualClientOptional.get(), "Client's information must be updated.");
    }

    @Test
    void shouldNotUpdateClientWhenIdDoesNotExist() {
        ClientService clientService = new ClientService();
        Client client1 = ClientFactory.createClient("Jon", "Doe", "jon.doe@email.com", "514-000-0000");
        clientService.addClient(client1);

        long nonExistingId = 999L;
        Client updatedClient = new Client(nonExistingId, "Jean", "Doe", "jean.doe@email.com", "514-123-4567");

        int initialSize = clientService.getAllClients().size();

        clientService.updateClient(nonExistingId, updatedClient);

        List<Client> finalClients = clientService.getAllClients();

        assertEquals(initialSize, finalClients.size(), "List's length should not change.");

        Optional<Client> actualClient = clientService.findClientById(client1.id());
        assertTrue(actualClient.isPresent(), "Original client should still exists.");
        assertEquals(client1, actualClient.get(), "Original client should not be modified.");
    }

    @Test
    void shouldDeleteExistingClient() {
        ClientService clientService = new ClientService();
        Client client1 = ClientFactory.createClient("Jon", "Doe", "jon.doe@email.com", "514-000-0000");
        Client client2 = ClientFactory.createClient("Jane", "Doe", "jane.doe@email.com", "418-111-1111");
        clientService.addClient(client1);
        clientService.addClient(client2);

        int initialSize = clientService.getAllClients().size();

        clientService.deleteClient(client1.id());

        int finalSize = clientService.getAllClients().size();

        assertEquals(initialSize - 1, finalSize, "List size should be reduced by one after deletion.");

        Optional<Client> deletedClient = clientService.findClientById(client1.id());
        assertTrue(deletedClient.isEmpty(), "Deleted client should not be present in the list.");
    }
    @Test
    void shouldNotDeleteClientWhenIdDoesNotExist() {
        ClientService clientService = new ClientService();
        Client client1 = ClientFactory.createClient("Jon", "Doe", "jon.doe@email.com", "514-000-0000");
        clientService.addClient(client1);

        long nonExistingId = 999L;
        int initialSize = clientService.getAllClients().size();

        clientService.deleteClient(nonExistingId);

        int finalSize = clientService.getAllClients().size();

        assertEquals(initialSize, finalSize, "List size should not change when deleting a non-existent client.");

        Optional<Client> actualClient = clientService.findClientById(client1.id());
        assertTrue(actualClient.isPresent(), "Original client should still be present in the list.");
    }
}