package it.blackhat.symposium.unit;

import it.blackhat.symposium.managers.QuestionManager;
import it.blackhat.symposium.managers.QuestionModelManager;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class QuestionModelManagerTest {

    @Test
    public void testQuestionModelManager() {
        QuestionManager test = new QuestionModelManager();
        assertTrue(test instanceof QuestionModelManager);
    }
}