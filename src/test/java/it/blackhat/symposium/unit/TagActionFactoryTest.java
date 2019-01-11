package it.blackhat.symposium.unit;

import it.blackhat.symposium.actions.Action;
import it.blackhat.symposium.actions.tag.ChangeTagAction;
import it.blackhat.symposium.actions.tag.RetrieveQuestionTagsAction;
import it.blackhat.symposium.actions.tag.TagActionFactory;
import it.blackhat.symposium.helpers.InvalidActionException;
import org.junit.Assert;
import org.junit.Test;

public class TagActionFactoryTest {

    @Test
    public void createActionChangeTagTest() throws InvalidActionException {


            Action actionChangeTag;
            actionChangeTag = new TagActionFactory().createAction("changeTag");
            Assert.assertTrue(actionChangeTag instanceof ChangeTagAction);

    }

    @Test
    public void showEditTagTest() throws InvalidActionException {


        Action actionChangeTag;
        actionChangeTag = new TagActionFactory().createAction("showEditTag");
        Assert.assertTrue(actionChangeTag instanceof RetrieveQuestionTagsAction);

    }


    @Test(expected = InvalidActionException.class)
    public void createInvalidActionExceptionTest() throws InvalidActionException {
        new TagActionFactory().createAction("pollo");
    }
}
