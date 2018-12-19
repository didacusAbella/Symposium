package it.blackhat.symposium.models;

import java.sql.Date;

/**
 * Concrete Implementation of User Interface
 *
 * @author 2Deimos
 */
public class UserModel implements User {

    private String username, firstName, lastName, password, email;
    private boolean typeGrad;
    Date banLastDate;

    /**
     * Creates an empty User
     */
    public UserModel() {
        super();
    }

    /**
     * Create a new User with username, first name, last name, password and
     * e-mail.
     *
     * @param username username of the user
     * @param firstName first name of the user
     * @param lastName last name of the user
     * @param password password of the user
     * @param email e-mail of the user
     */
    public UserModel(String username, String firstName, String lastName,
            String password, String email) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public Boolean getTypeGrad() {
        return typeGrad;
    }

    @Override
    public Date getBanLastDate() {
        return banLastDate;
    }

    @Override
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public void setTypeGrad(boolean typeGrad) {
        this.typeGrad = typeGrad;
    }

    @Override
    public void setBanLastDate(Date banLastDate) {
        this.banLastDate = banLastDate;
    }

}
