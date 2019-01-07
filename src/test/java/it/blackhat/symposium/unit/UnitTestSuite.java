package it.blackhat.symposium.unit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;


@RunWith(Suite.class)
@Suite.SuiteClasses({
        AdminModelTest.class,
        TagModelManagerTest.class,
        TagActionFactoryTest.class,
        TagModelTest.class
})
public class UnitTestSuite {
  
}
