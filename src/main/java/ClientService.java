import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Service class for managing client data.
 * It provides core business logic for handling a list of Client objects,
 * including adding, retrieving, and searching for clients.
 */
public class ClientService {

    private final List<Client> clients = new ArrayList<>();

    /**
     * Retrieves all clients stored in the service.
     *
     * @return A new {@link List} containing all client objects.
     */
    public List<Client> getAllClients() {
        return new ArrayList<>(clients);
    }

    /**
     * Adds a new client to the service.
     * The client is only added if the provided object is not null.
     *
     * @param client The {@link Client} object to add.
     */
    public void addClient(Client client) {

        if (client != null) {
            clients.add(client);
        }
    }

    /**
     * Searches for a client by their unique ID.
     *
     * @param id The unique ID of the client to find.
     * @return An {@link Optional} containing the {@link Client} if found,
     * or an empty Optional if no client with the given ID exists.
     */
    public Optional<Client> findClientById(long id) {
        return clients.stream()
                .filter(client -> client.id() == id)
                .findFirst();
    }

    /**
     * Updates the information of an existing client.
     * (To be implemented)
     */
    public void updateClient(){
        // TODO
    }

    /**
     * Deletes a client from the service by their unique ID.
     * (To be implemented)
     */
    public void deleteClient(){
        // TODO
    }

}