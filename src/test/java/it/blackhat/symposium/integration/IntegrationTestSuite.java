package it.blackhat.symposium.integration;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import it.blackhat.symposium.integration.actions.*;
import it.blackhat.symposium.integration.managers.*;

/**
 *
 * @author didacus
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
  AdminManagerTest.class,
  AnswerModelManagerTest.class,
  QuestionManagerTest.class,
  ReportManagerTest.class,
  ReportManagerTest.class,
  StatsModelManagerTest.class,
  TagManagerTest.class,
  UserModelManagerTest.class,
  AddFavouriteActionTest.class,
  ChooseBestAnswerActionTest.class,
  DeleteAnswerAdminActionTest.class,
  DeleteQuestionActionTest.class,
  DeleteQuestionTagActionTest.class,
  GenerateReportListActionTest.class,
  GenerateStatsActionTest.class,
  InsertAnswerActionTest.class,
  InsertQuestionActionTest.class,
  ReportQuestionActionTest.class,
  RetrieveQuestionAnswersActionTest.class,
  ShowAnswerPageTest.class,
  ShowFavouriteActionTest.class,
  ShowInsertReportActionTest.class,
  ShowMyQuestionTest.class,
  ShowNewQuestionActionTest.class,
  ShowQuestionsActionTest.class,
  ShowStatsViewActionTest.class,
  ShowUsersActionTest.class,
  SigninActionTest.class,
  SigninAdminActionTest.class,
  SignoutAdminTest.class,
  SignupActionTest.class
})
public class IntegrationTestSuite {
  
}
