package fr.afpa.restapi.web.controller;

import fr.afpa.restapi.dao.AccountDao;
import fr.afpa.restapi.dao.impl.InMemoryAccountDao;
import fr.afpa.restapi.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * TODO ajouter la/les annotations nécessaires pour faire de "AccountRestController" un contrôleur de REST API
 */
@RestController
@RequestMapping("/api/accounts") // Add a base request mapping to avoid repeating the base path
public class AccountRestController {

    private final AccountDao accountDao;

    // Constructor injection with @Autowired annotation

    public AccountRestController(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    /**
     * Handles GET requests and returns a list of accounts.
     */

    @GetMapping
    public List<Account> getAll() {

        ((InMemoryAccountDao) accountDao).createAccountTest();

        return accountDao.findAll();
    }

    /**
     * Handles GET requests with a path variable ID and returns the associated account information.
     * For more information on path variables, see: https://www.baeldung.com/spring-pathvariable
     *RECUPERE DES DONEES
     */
    @GetMapping("/{id}")


    public ResponseEntity<Account> getById(@PathVariable long id) {
        return accountDao.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Handles POST requests, saves the account in memory, and returns its information (in JSON).
     * Returns HTTP status code 201 Created upon success.
     * Interesting tutorial: https://stackabuse.com/get-http-post-body-in-spring/
     *ENVOIE DES DONNES
     */
    @PostMapping
    public ResponseEntity<Account> postAccount(@RequestBody Account account) {
        Account savedAccount = accountDao.save(account);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedAccount);
    }


    /**
     * TODO implémenter une méthode qui traite les requêtes PUT
     * METS A JOURS LES DONNES
     */
     @PutMapping("/{id}")
    public ResponseEntity<Account> putAccount(@PathVariable Long id, @RequestBody Account account) {
        Optional<Account> existingAccount = accountDao.findById(id);

        if (existingAccount.isPresent()) {
            Account modifAccount = existingAccount.get();

            // Mise à jour des champs fournis
            modifAccount.setFirstName(account.getFirstName());
            modifAccount.setLastName(account.getLastName());
            modifAccount.setEmail(account.getEmail());
            modifAccount.setBirthday(account.getBirthday());
            modifAccount.setBalance(account.getBalance());

            // On ne met pas à jour l'ID ni la date de création (générés automatiquement lors de la création)

            // Sauvegarde du compte modifié
            accountDao.save(modifAccount);

            // Retourne le compte modifié avec un status 200 OK
            return ResponseEntity.ok(modifAccount);
        } else {
            // Retourne une réponse 404 si le compte avec l'ID donné n'est pas trouvé
            return ResponseEntity.notFound().build();
        }
    }


    /**
     * TODO implémenter une méthode qui traite les requêtes  DELETE
     * L'identifiant du compte devra être passé en "variable de chemin" (ou "path variable")
     * Dans le cas d'un suppression effectuée avec succès, le serveur doit retourner un status http 204 (No content)
     * SUPPRIME
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAccount(@PathVariable long id) {
        return accountDao.findById(id)
                .map(account -> {
                    accountDao.delete(account);
                    return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
                })
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

}

