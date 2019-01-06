package it.blackhat.symposium.actions.report;

import it.blackhat.symposium.actions.Action;
import it.blackhat.symposium.actions.ActionFactory;
import it.blackhat.symposium.helpers.InvalidActionException;

/**
 *
 * @author didacus
 */
public class ReportActionFactory implements ActionFactory {

    @Override
    public Action createAction(String actionType) throws InvalidActionException {
        switch(actionType){
            case "showInsertReport":
                return new ShowInsertReportAction();
            default:
                throw new InvalidActionException("Azione non supportata");
        }
    }
    
    
    
}
