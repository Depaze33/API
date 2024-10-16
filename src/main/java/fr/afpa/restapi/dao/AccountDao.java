package fr.afpa.restapi.dao;

import java.util.List;
import java.util.Optional;

import fr.afpa.restapi.model.Account;

/**
 * Interface du DAO définissant les actions pouvant être effectuées sur les objets de "Account".
 */
public interface AccountDao {
    /**
     * @return Tous les comptes enregistrés
     */
    List<Account> findAll();

    /**
     * @param id Identifiant du compte à retrouver
     * @return Un objet de compte correspondant à l'identifiant en paramètre 
     */
    Optional<Account> findById(long id);

    /**
     * Enregistre les informations d'un compte
     * @param account Le compte à enregistrer
     * @return L'objet enregistré
     */
    Account save(Account account);

    /**
     * Suppression d'un compte
     * @param account
     */
    void delete(Account account);
}
