package it.blackhat.symposium.unit;

import static org.junit.Assert.fail;

import org.junit.Assert;
import org.junit.Test;

import it.blackhat.symposium.actions.Action;
import it.blackhat.symposium.actions.stats.GenerateStatsAction;
import it.blackhat.symposium.actions.stats.ShowStatsViewAction;
import it.blackhat.symposium.actions.stats.StatsActionFactory;
import it.blackhat.symposium.helpers.InvalidActionException;
/**
 * The class tests StatsActionFactoryTest
 * @author Parrilli Carminantonio
 *
 */
public class StatsActionFactoryTest {
    /**
     * The test for CreateActionGenerateStats
     */
    @Test
    public void testCreateActionGenerateStats() 
    {
        try {
            Action actionGenerateStats;
            actionGenerateStats = (Action) new StatsActionFactory().createAction("generateStats");
            Assert.assertTrue(actionGenerateStats instanceof  GenerateStatsAction);
        } catch (InvalidActionException e) {
            fail("Eccezione non gestita");
        }
    }
    /**
     * The test for CreateActionShowStats
     */
    @Test
    public void testCreateActionShowStats() {
        try {
            Action actionShowStats;
            actionShowStats = (Action) new StatsActionFactory().createAction("showStats");
            Assert.assertTrue(actionShowStats instanceof  ShowStatsViewAction);
        } catch (InvalidActionException e) {
            fail("Eccezione non gestita");
        }
    }
    /**
     * The test for the exception
     * @throws InvalidActionException 
     */
    @Test(expected=InvalidActionException.class)
    public void testInvalidActionException() throws InvalidActionException {
        new StatsActionFactory().createAction("test");
    }
}
