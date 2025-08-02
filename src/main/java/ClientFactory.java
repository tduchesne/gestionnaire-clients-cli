import java.util.Objects;

/**
 * Provides a static method to create instances of the Client record.
 *
 * This factory pattern centralizes the logic for creating Client objects,
 * which includes automatic ID generation and basic data validation.
 */
public class ClientFactory {
    private static long nextId = 1;

    /**
     * Creates and returns a new Client instance with a unique ID.
     *
     * The ID is automatically and incrementally generated with each call.
     *
     * @param firstName     The client's first name.
     * @param lastName      The client's last name.
     * @param email         The client's email address.
     * @param phoneNumber   The client's phone number.
     * @return A new Client instance with a unique ID.
     */
    public static Client createClient(String firstName, String lastName, String email, String phoneNumber) {
        validateString(firstName, "first name");
        validateString(lastName, "last name");
        validateString(email, "email");
        validateString(phoneNumber, "phone number");

        return new Client(nextId++, firstName, lastName, email, phoneNumber);
    }

    /**
     * Resets the client ID generator to its initial value.
     * This method is intended for testing purposes only to ensure
     * predictable and isolated test cases.
     */
    static void resetIdForTesting() {
        nextId = 1;
    }

    /**
     * Validates that a string is not null or blank (contains only whitespaces).
     *
     * @param value     The string to validate.
     * @param paramName The name of the parameter, used for a more specific error message.
     * @throws IllegalArgumentException if the string is null or blank.
     */
    private static void validateString(String value, String paramName) {
        if (Objects.isNull(value) || value.isBlank()) {
            throw new IllegalArgumentException("The " + paramName + " cannot be null or empty.");
        }
    }
}