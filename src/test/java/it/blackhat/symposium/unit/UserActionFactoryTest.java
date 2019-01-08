/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.blackhat.symposium.unit;

import it.blackhat.symposium.actions.Action;
import it.blackhat.symposium.actions.user.BanAction;
import it.blackhat.symposium.actions.user.EditProfileAction;
import it.blackhat.symposium.actions.user.ShowEditProfileAction;
import it.blackhat.symposium.actions.user.ShowProfileAction;
import it.blackhat.symposium.actions.user.SignoutAction;
import it.blackhat.symposium.actions.user.UserActionFactory;
import it.blackhat.symposium.helpers.InvalidActionException;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author Giuseppe Madonna
 */
public class UserActionFactoryTest {

    @Test
    public void createActionSignOutTest() throws InvalidActionException {
        Action actionSignOut;
        actionSignOut = (Action) new UserActionFactory().createAction("signOut");
        Assert.assertTrue(actionSignOut instanceof SignoutAction);
    }

    @Test
    public void createActionShowProfileTest() throws InvalidActionException {
        Action actionShowProfile;
        actionShowProfile = (Action) new UserActionFactory().createAction("showProfile");
        Assert.assertTrue(actionShowProfile instanceof ShowProfileAction);
    }

    @Test
    public void createActionEditProfileTest() throws InvalidActionException {
        Action actionEditProfile;
        actionEditProfile = (Action) new UserActionFactory().createAction("editProfile");
        Assert.assertTrue(actionEditProfile instanceof EditProfileAction);
    }

    @Test
    public void createActionShowEditProfileTest() throws InvalidActionException {

        Action actionShowEditProfile;
        actionShowEditProfile = (Action) new UserActionFactory().createAction("showEditProfile");
        Assert.assertTrue(actionShowEditProfile instanceof ShowEditProfileAction);
    }

    @Test
    public void createActionBanTest() throws InvalidActionException {
        Action actionBan;
        actionBan = (Action) new UserActionFactory().createAction("banUser");
        Assert.assertTrue(actionBan instanceof BanAction);
    }

    @Test(expected = InvalidActionException.class)
    public void createInvalidActionException() throws InvalidActionException {
        new UserActionFactory().createAction("Gianni");
    }
}
