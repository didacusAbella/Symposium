package it.blackhat.symposium.models;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Concrete implementation of Reason interface
 *
 * @author Przemyslaw Szopian
 */
public class ReportModel implements Report {

    @NotNull
    private int id;

    @NotNull
    private String category;

    @NotNull
    @Size(max = 250)
    private String reason;

    @NotNull
    private String userFk;

    @NotNull
    private int questionFk;

    @NotNull
    private int year;

    /**
     * Create an empty ReportModel
     */
    public ReportModel() {
        super();
    }

    /**
     * Create a new Report with id, category, reason and user
     *
     * @param id the report's id
     * @param category the report's category
     * @param reason the report's reason
     * @param userFk the user foreign key
     * @param year the report's year
     * @param questionFk the question's id
     */
    public ReportModel(int id, String category, String reason, int year, 
            String userFk, int questionFk) {
        this.id = id;
        this.category = category;
        this.reason = reason;
        this.questionFk = questionFk;
        this.userFk = userFk;
        this.year = year;
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
    public String getUserFk() {
        return userFk;
    }

    @Override
    public void setUserFk(String userFk) {
        this.userFk = userFk;
    }

    @Override
    public int getYear() {
        return year;
    }

    @Override
    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public int getQuestionFk() {
        return questionFk;
    }

    @Override
    public void setQuestionFk(int questionFk) {
        this.questionFk = questionFk;
    }

    @Override
    public String toString() {
        return "ReportModel{" + "id=" + id + ", category=" + category 
                + ", reason=" + reason + ", userFk=" + userFk + ", questionFk=" 
                + questionFk + ", year=" + year + '}';
    }
  
}
