/**
 * Représente un client dans le système de gestion.
 *
 * @param id        L'identifiant unique du client.
 * @param prenom    Le prénom du client.
 * @param nom       Le nom de famille du client.
 * @param courriel  L'adresse courriel du client.
 * @param telephone Le numéro de téléphone du client.
 */
public record Client(long id, String prenom, String nom, String courriel, String telephone) {}