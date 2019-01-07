package it.blackhat.symposium.unit;

import it.blackhat.symposium.actions.Action;
import it.blackhat.symposium.actions.tag.ChangeTagAction;
import it.blackhat.symposium.actions.tag.TagActionFactory;
import it.blackhat.symposium.helpers.InvalidActionException;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.fail;

public class TagActionFactoryTest {

    @Test
    public void createActionChangeTagTest() {

        try {
            Action actionChangeTag;
            actionChangeTag = new TagActionFactory().createAction("changeTag");
            Assert.assertTrue(actionChangeTag instanceof ChangeTagAction);
        } catch (InvalidActionException e) {
            fail("Eccezione non gestita");
        }
    }

    @Test(expected = InvalidActionException.class)
    public void createInvalidActionExceptionTest() throws InvalidActionException {
        new TagActionFactory().createAction("pollo");
    }
}
