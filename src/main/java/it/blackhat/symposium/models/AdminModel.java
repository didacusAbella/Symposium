package it.blackhat.symposium.models;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

/**
 * Concrete Implementation of Admin Interface
 *
 * @author Diego Avella
 * @author 2Deimos
 */
public class AdminModel implements Admin {

    @NotNull
    private int id;

    @NotNull
    @Size(min = 4, max = 20)
    private String username;

    @NotNull
    private String password;

    /**
     * Create an empty Admin
     */
    public AdminModel() {
        super();
    }

    /**
     * Create a new Admin with username and password
     *
     * @param id       the id of the admin
     * @param username the username of the admin
     * @param password the password of the admin
     */
    public AdminModel(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
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
