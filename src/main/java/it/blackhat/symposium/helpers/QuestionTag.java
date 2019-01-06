
package it.blackhat.symposium.helpers;

import it.blackhat.symposium.models.Question;
import it.blackhat.symposium.models.Tag;
import java.util.List;

/**
 * Classes for map question and tag
 * @author didacus
 */
public final class QuestionTag {
    
    private Question question;
    private List<Tag> tags;

    /**
     * Create a new question tag
     * @param question the question
     * @param tags the list of tags associated
     */
    public QuestionTag(Question question, List<Tag> tags) {
        this.question = question;
        this.tags = tags;
    }

    /**
     * Retrieve the question
     * @return the question
     */
    public Question getQuestion() {
        return question;
    }

    /**
     * Set a new Question
     * @param question 
     */
    public void setQuestion(Question question) {
        this.question = question;
    }

    /**
     * Get a tag list associated
     * @return the tag list
     */
    public List<Tag> getTags() {
        return tags;
    }

    /**
     * Set a new tag list
     * @param tags the tag list
     */
    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }  

}
