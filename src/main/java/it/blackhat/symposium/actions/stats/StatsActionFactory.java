package it.blackhat.symposium.actions.stats;

import it.blackhat.symposium.actions.Action;
import it.blackhat.symposium.actions.ActionFactory;
import it.blackhat.symposium.helpers.InvalidActionException;
import javax.sql.DataSource;

/**
 * Factory for create StatsAction
 *
 * @author SDelPiano
 */
public class StatsActionFactory implements ActionFactory {
  
    private final DataSource ds;
    
    public StatsActionFactory(DataSource ds) {
      this.ds = ds;
    }

    @Override
    public Action createAction(String actionType) throws InvalidActionException {
        switch (actionType) {
            case "generateStats":
                return new GenerateStatsAction(this.ds);
            case "showStats":
                return new ShowStatsViewAction();
            default:
                throw new InvalidActionException("Azione non supportata");
        }
    }

}
