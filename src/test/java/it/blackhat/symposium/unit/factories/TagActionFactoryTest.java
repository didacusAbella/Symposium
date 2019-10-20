package it.blackhat.symposium.unit.factories;

import it.blackhat.symposium.actions.Action;
import it.blackhat.symposium.actions.tag.ChangeTagAction;
import it.blackhat.symposium.actions.tag.RetrieveQuestionTagsAction;
import it.blackhat.symposium.actions.tag.TagActionFactory;
import it.blackhat.symposium.helpers.InvalidActionException;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

public class TagActionFactoryTest {

  private static DataSource ds;

  @BeforeClass
  public static final void setUpClass() {
    ds = Mockito.mock(BasicDataSource.class);
  }

  @Test
  public void createActionChangeTagTest() throws InvalidActionException {

    Action actionChangeTag;
    actionChangeTag = new TagActionFactory(ds).createAction("changeTag");
    Assert.assertTrue(actionChangeTag instanceof ChangeTagAction);

  }

  @Test
  public void showEditTagTest() throws InvalidActionException {

    Action actionChangeTag;
    actionChangeTag = new TagActionFactory(ds).createAction("showEditTag");
    Assert.assertTrue(actionChangeTag instanceof RetrieveQuestionTagsAction);

  }

  @Test(expected = InvalidActionException.class)
  public void createInvalidActionExceptionTest() throws InvalidActionException {
    new TagActionFactory(ds).createAction("pollo");
  }
}
