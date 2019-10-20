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
  DeleteAnswerAdminActionTest.class, 
  GenerateReportListActionTest.class, 
  ChooseBestAnswerActionTest.class, 
  RetrieveQuestionAnswersActionTest.class, 
  SignoutAdminTest.class, 
  InsertAnswerActionTest.class, 
  ShowUsersActionTest.class, 
  SigninActionTest.class, 
  SigninAdminActionTest.class, 
  SignupActionTest.class, 
  ShowAnswerPageTest.class
})
public class IntegrationTestSuite {
  
}
