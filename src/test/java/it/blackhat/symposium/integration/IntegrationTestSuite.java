package it.blackhat.symposium.integration;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author didacus
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
  it.blackhat.symposium.integration.IntegrationTestCase.class, 
  it.blackhat.symposium.integration.AnswerModelManagerTest.class, 
  it.blackhat.symposium.integration.StatsModelManagerTest.class, 
  it.blackhat.symposium.integration.TagManagerTest.class, 
  it.blackhat.symposium.integration.ReportManagerTest.class, 
  it.blackhat.symposium.integration.QuestionManagerTest.class, 
  it.blackhat.symposium.integration.UserModelManagerTest.class, 
  it.blackhat.symposium.integration.AdminManagerTest.class
})
public class IntegrationTestSuite {
  
}
