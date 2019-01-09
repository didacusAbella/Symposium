package it.blackhat.symposium.unit;

import it.blackhat.symposium.helpers.QuestionTag;
import it.blackhat.symposium.models.Question;
import it.blackhat.symposium.models.Tag;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author MemoSzopian
 */
public class QuestionTagTest {
    Question question;
    QuestionTag questionTag;
    List<Tag> tags;
    
    @Before
    public void setUp(){
        questionTag = new QuestionTag(question, tags);
    }
    
    @Test
    public void testGetQuestion(){
        Assert.assertEquals(question, question);
    }
    
    @Test
    public void testSetQuestion(){
        questionTag.setQuestion(question);
        Assert.assertEquals(question, question);
    }
    @Test
    public void testGetTags(){
        Assert.assertEquals(tags, tags);
    }
    
    @Test
    public void testSetTags(){
        questionTag.setTags(tags);
        Assert.assertEquals(tags, tags);
    }
}
