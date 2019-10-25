package it.blackhat.symposium.unit;

import it.blackhat.symposium.unit.helpers.*;
import it.blackhat.symposium.unit.factories.*;
import it.blackhat.symposium.unit.filters.AdminFilterTest;
import it.blackhat.symposium.unit.filters.UserLoginFilterTest;
import it.blackhat.symposium.unit.managers.*;
import it.blackhat.symposium.unit.models.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
  AdminActionFactoryTest.class,
  AnswerActionFactoryTest.class,
  GuestActionFactoryTest.class,
  QuestionActionFactoryTest.class,
  ReportActionFactoryTest.class,
  StatsActionFactoryTest.class,
  TagActionFactoryTest.class,
  UserActionFactoryTest.class,
  BeanValidatorTest.class,
  QuestionTagTest.class,
  TagExtractorTest.class,
  AdminModelManagerTest.class,
  AnswerModelManagerTest.class,
  QuestionModelManagerTest.class,
  ReportModelManagerTest.class,
  StatsModelManagerTest.class,
  TagModelManagerTest.class,
  UserModelManagerTest.class,
  AdminModelTest.class,
  AnswerModelTest.class,
  QuestionModelTest.class,
  ReportModelTest.class,
  StatsModelTest.class,
  TagModelTest.class,
  UserModelTest.class,
  AdminFilterTest.class,
  UserLoginFilterTest.class
})
public class UnitTestSuite {

}
