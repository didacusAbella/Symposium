package it.blackhat.symposium.models;

import java.util.Objects;

/**
 * Concrete Implementation of Admin Interface
 *
 * @author Diego Avella
 */
public class AdminModel implements Admin {

    private String username, password;

    /**
     * Create an empty Admin
     */
    public AdminModel() {
        super();
    }
    
    /**
     * Create a new Admin with username and password
     * @param username the username of the admin
     * @param password the password of the admin
     */
    public AdminModel(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.username);
        hash = 37 * hash + Objects.hashCode(this.password);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (obj == null) {
            return false;
        } else if (getClass() != obj.getClass()) {
            return false;
        } else {
            final AdminModel other = (AdminModel) obj;
            return Objects.equals(this.getUsername(), other.getUsername())
                    && Objects.equals(this.getPassword(), other.getPassword());
        }
    }

    @Override
    public String toString() {
        return "AdminModel{" + "username=" + username + ", password=" + password + '}';
    }
}
