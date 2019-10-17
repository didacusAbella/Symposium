package it.blackhat.symposium.unit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
  AdminModelTest.class,
  AdminActionFactoryTest.class,
  AdminModelManagerTest.class,
  AdminModelTest.class,
  StatsActionFactoryTest.class,
  StatsModelManagerTest.class,
  StatsModelTest.class,
  UserActionFactoryTest.class,
  UserModelManagerTest.class,
  UserModelTest.class,
  QuestionActionFactoryTest.class,
  QuestionModelManagerTest.class,
  QuestionModelTest.class,
  BeanValidatorTest.class
})
public class UnitTestSuite {

}
