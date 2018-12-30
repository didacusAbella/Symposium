package it.blackhat.symposium.models;




public class ReportModel implements Report {

    private String id, category, reason, userEmail;
   
    /**
     * Concrete implementation of Report Interface
     *
     * @author SDelPiano
     */

   
    public ReportModel() {
        super();
    }

    /**
     * Create a new Report with id, category, reason, user_email.
     *
     * @param id id of the question
     * @param category category of the report
     * @param reason reason of the report
     * @param userEmail email of the user who called the report
     */
    public ReportModel(String id, String category, String reason, String userEmail) {
        this.id = id;
        this.category = category;
        this.reason = reason;
        this.userEmail = userEmail;
    }

    @Override
    public String getId() {
        return id;
    }



    @Override
	public String getCategory() {
        return category;
    }
    @Override
	public String getReason() {
        return reason;
    }

    @Override
	public String getUser() {
    	return userEmail;
    }
}

