package it.blackhat.symposium.actions.question;


import it.blackhat.symposium.actions.Action;
import it.blackhat.symposium.managers.QuestionManager;
import it.blackhat.symposium.managers.QuestionModelManager;
import it.blackhat.symposium.models.Question;


import org.apache.commons.dbutils.QueryRunner;



import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import static it.blackhat.symposium.queries.QuestionQuery.INSERT_QUESTION;




/**
 * Describes the guest's signin action
 *
 * @author Del Piano Salvatore
 */
@WebServlet ("/InsertQuestion")
public class InsertQuestionAction implements Action {
    private QuestionManager question;
	
    /**
     * Find a user in the database and if it can't be found return with null
     */
    public InsertQuestionAction() {
        question = new QuestionModelManager();
    }
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) {
        String content = req.getParameter("contenent");
        String title = req.getParameter("title");
        
        
        
        
         
    	
    
    }
}
