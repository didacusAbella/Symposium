package it.blackhat.symposium.managers;

import it.blackhat.symposium.models.Question;
import it.blackhat.symposium.models.Tag;
import java.sql.SQLException;
import org.apache.commons.dbutils.QueryRunner;



import static it.blackhat.symposium.queries.QuestionQuery.INSERT_QUESTION;
import static it.blackhat.symposium.queries.QuestionQuery.INSERT_TAG;
import static it.blackhat.symposium.queries.QuestionQuery.DELETE_QUESTION;
import static it.blackhat.symposium.queries.QuestionQuery.CHANGE_TAG;
import static it.blackhat.symposium.queries.QuestionQuery.QUESTION_REPORT;




/**
*
* @author Del Piano Salvatore
*
*/

public class QuestionModelManager extends ConnectionManager implements QuestionManager {
	
    @Override
    public int insertQuestion(Question question)throws SQLException {
    	QueryRunner run = new QueryRunner(this.dataSource);
    	int update = run.update(INSERT_QUESTION, question.getContent()) ;
        return update;
    }

    @Override
	public int insertTag(Question question, Tag tag) throws SQLException {
    	QueryRunner run = new QueryRunner(this.dataSource);
    	int upd = run.update(INSERT_TAG, tag.getTagName());
    	return upd;
    }

    @Override
	 public int deleteQuestion (Question question) throws SQLException {
    	QueryRunner run = new QueryRunner(this.dataSource);
    	int update = run.update(DELETE_QUESTION, question.getId());
    	return update;
    }

    @Override
	public int changeTag(Question question, Tag tag) throws SQLException {
    	QueryRunner run = new QueryRunner(this.dataSource);
    	int upd = run.update(CHANGE_TAG , tag.getTagName()) ;
    	return upd;
    }

    @Override
	public int questionReport(Question question) throws SQLException {
    	QueryRunner run = new QueryRunner(this.dataSource);
    	int upd = run.update(QUESTION_REPORT , question.getNumSegn());
    	return upd;
    }


	
	

}
