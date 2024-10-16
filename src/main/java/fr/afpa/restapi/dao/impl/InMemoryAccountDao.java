package fr.afpa.restapi.dao.impl;

import fr.afpa.restapi.dao.AccountDao;
import fr.afpa.restapi.model.Account;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * Une implémentation de {@link AccountDao} basée sur un {@link java.util.HashMap}
 * <p>
 * TODO annoter cette classe de façon à en faire un "bean". Quelle est l'annotation à utiliser dans ce cas de figure ?
 * Pour vous aider, lisez l'article suivant -> https://www.axopen.com/blog/2019/02/java-spring-les-beans/
 */
@Component("accountDao")
public class InMemoryAccountDao implements AccountDao {
    /**
     * Table de hachage permettant de stocker les objets de {@link Account}
     */
    private Map<Long, Account> accountMap = new HashMap<>();
    private long idSequence = 1L;

    @Override
    public List<Account> findAll() {
        return new ArrayList<>(accountMap.values());
    }


    @Override
    public Optional<Account> findById(long id) {
        try {
            return Optional.of(accountMap.get(id));
        } catch (NullPointerException e) {
            System.out.println("Compte non trouvé");
        }
    return Optional.empty();
    }

    public void createAccountTest() {
        Account account1 = new Account();
        account1.setId(1L);
        account1.setFirstName("Bobby");
        account1.setLastName("Bob");

        accountMap.put(account1.getId(), account1);
    }

    @Override
    public Account save(Account account) {
        if (account.getId() == null) {
            account.setId(idSequence++);
        }
        accountMap.put(account.getId(), account);
        return account;
    }

    @Override
    public void delete(Account account) {
        accountMap.remove(account.getId());
    }

    public void clear() {
        accountMap.clear();
        idSequence = 1L;
    }
}
