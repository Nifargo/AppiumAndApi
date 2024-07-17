package helpers.TestSuites;

import org.dkvProject.ui.guestFlow.homePageProject.HomePageTest;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

@Suite
@SuiteDisplayName("Home Page Test Suite")
@SelectClasses({HomePageTest.class})

public class HomePageTestSuite {
}
