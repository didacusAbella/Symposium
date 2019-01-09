package it.blackhat.symposium.unit;

import it.blackhat.symposium.helpers.BeanValidator;
import it.blackhat.symposium.models.Question;
import it.blackhat.symposium.models.QuestionModel;
import org.junit.Test;

import java.sql.Date;
import java.util.Calendar;

import static org.junit.Assert.assertEquals;

public class BeanValidatorTest {

    @Test
    public void testValidateBeanValid() {
        Question question = new QuestionModel("Test bellissimo", "test della validazione in corso",
                "a.raiola14@studenti.unisa.it", new Date(Calendar.getInstance().getTime().getTime()),
                new Date(Calendar.getInstance().getTime().getTime()), 10, 1);
        assertEquals(true, BeanValidator.validateBean(question));
    }

    @Test
    public void testValidateBeanInvalid() {
        Question question = new QuestionModel(null, "test della validazione in corso",
                "a.raiola14@studenti.unisa.it", null,
                null, 10, 1);
        assertEquals(false, BeanValidator.validateBean(question));
    }
}