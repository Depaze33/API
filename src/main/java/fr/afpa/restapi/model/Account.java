package fr.afpa.restapi.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Classe représentant le compte bancaire d'un utilisateur
 */
public class Account {
    /**
     * Identifiant unique du compte
     */
    private Long id;
    /**
     * Prénom du propriétaire
     */
    private String firstName;
    /**
     * Nom du propriétaire
     */
    private String lastName;
    /**
     * Adresse email (unique) du propriétaire
     */
    private String email;
    /**
     * Date d'anniversaire du prop
     */
    private LocalDate birthday;

    /**
     * Date de création du compte
     */
    private LocalDateTime creationTime;

    /**
     * Montant disponible
     */
    private BigDecimal balance = BigDecimal.ZERO;

    public Account() {
        // Constructeur vide pour permettre à Spring d'instancier les objets.
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        return result;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Account other = (Account) obj;
        if (email == null) {
            if (other.email != null)
                return false;
        } else if (!email.equals(other.email))
            return false;
        return true;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirthday() {
        return this.birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public LocalDateTime getCreationTime() {
        return this.creationTime;
    }

    public void setCreationTime(LocalDateTime creationTime) {
        this.creationTime = creationTime;
    }

    public BigDecimal getBalance() {
        return this.balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
    
    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", firstName='" + getFirstName() + "'" +
            ", lastName='" + getLastName() + "'" +
            ", email='" + getEmail() + "'" +
            ", birthday='" + getBirthday() + "'" +
            ", creationTime='" + getCreationTime() + "'" +
            ", balance='" + getBalance() + "'" +
            "}";
    }
}
