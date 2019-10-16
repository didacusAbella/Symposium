package it.blackhat.symposium.unit;

import static org.junit.Assert.fail;

import org.junit.Assert;
import org.junit.Test;

import it.blackhat.symposium.actions.Action;
import it.blackhat.symposium.actions.stats.GenerateStatsAction;
import it.blackhat.symposium.actions.stats.ShowStatsViewAction;
import it.blackhat.symposium.actions.stats.StatsActionFactory;
import it.blackhat.symposium.helpers.InvalidActionException;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;
import org.junit.BeforeClass;
import org.mockito.Mockito;
/**
 * The class tests StatsActionFactoryTest
 * @author Parrilli Carminantonio
 *
 */
public class StatsActionFactoryTest {
  
  private static DataSource ds;
  
    @BeforeClass
    public static final void setUpClass(){
      ds = Mockito.mock(BasicDataSource.class);
    }
    /**
     * The test for CreateActionGenerateStats
     * @throws InvalidActionException 
     */
    @Test
    public void testCreateActionGenerateStats() throws InvalidActionException 
    {
            Action actionGenerateStats;
            actionGenerateStats = (Action) new StatsActionFactory(ds).createAction("generateStats");
            Assert.assertTrue(actionGenerateStats instanceof  GenerateStatsAction);
    }
    /**
     * The test for CreateActionShowStats
     * @throws InvalidActionException 
     */
    @Test
    public void testCreateActionShowStats() throws InvalidActionException {
        
            Action actionShowStats;
            actionShowStats = (Action) new StatsActionFactory(ds).createAction("showStats");
            Assert.assertTrue(actionShowStats instanceof  ShowStatsViewAction);
         
    }
    /**
     * The test for the exception
     * @throws InvalidActionException 
     */
    @Test(expected=InvalidActionException.class)
    public void testInvalidActionException() throws InvalidActionException {
        new StatsActionFactory(ds).createAction("test");
    }
}
