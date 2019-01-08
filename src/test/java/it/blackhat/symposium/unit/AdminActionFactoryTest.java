/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.blackhat.symposium.unit;

import it.blackhat.symposium.actions.Action;
import it.blackhat.symposium.actions.admin.AdminActionFactory;
import it.blackhat.symposium.actions.admin.GenerateReportListAction;
import it.blackhat.symposium.actions.admin.ShowUsersAction;
import it.blackhat.symposium.actions.admin.SignoutAdmin;
import it.blackhat.symposium.helpers.InvalidActionException;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author Przemyslaw Szopian
 */
public class AdminActionFactoryTest {

    @Test
    public void testAdminSignout() throws InvalidActionException {

        Action actionAdminSignout;
        actionAdminSignout = (Action) new AdminActionFactory().createAction("adminSignout");
        Assert.assertTrue(actionAdminSignout instanceof SignoutAdmin);

    }

    @Test
    public void testShowUsersAction() throws InvalidActionException {

        Action actionShowUsers;
        actionShowUsers = (Action) new AdminActionFactory().createAction("showUsersAction");
        Assert.assertTrue(actionShowUsers instanceof ShowUsersAction);

    }

    @Test
    public void testGenereteList() throws InvalidActionException {

        Action actionGenerateReportList;
        actionGenerateReportList = (Action) new AdminActionFactory().createAction("generateReportListAction");
        Assert.assertTrue(actionGenerateReportList instanceof GenerateReportListAction);

    }

    @Test(expected = InvalidActionException.class)
    public void testInvalidAction() throws InvalidActionException {
        new AdminActionFactory().createAction("test");
    }
}
