/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package it.blackhat.symposium.models;

/**
 * Concrete implementation of Reason interface
 *
 * @author Przemyslaw Szopian
 */
public class ReportModel implements Report {

    private int id;
    private String category, reason, user;

    /**
     * Create an empty ReportModel
     */
    public ReportModel() {
        super();
    }

    /**
     * Create a new Report with id, category, reason and user
     *
     * @param id        the report's id
     * @param category  the report's category
     * @param reason    the report's reason
     * @param user      the report's user
     */
    public ReportModel(int id, String category, String reason, String user) {
        this.id = id;
        this.category = category;
        this.reason = reason;
        this.user = user;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String getCategory() {
        return category;
    }

    @Override
    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String getReason() {
        return reason;
    }

    @Override
    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public String getUser() {
        return user;
    }

    @Override
    public void setUser(String user) {
        this.user = user;
    }
}
