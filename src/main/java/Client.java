/**
 * Represents a client in the management system.
 *
 * @param id        The unique identifier for the client.
 * @param firstName The client's first name.
 * @param lastName  The client's last name.
 * @param email     The client's email address.
 * @param phoneNumber The client's phone number.
 */
public record Client(long id, String firstName, String lastName, String email, String phoneNumber) {}