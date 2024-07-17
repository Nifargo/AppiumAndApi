package helpers.TestSuites;

import org.dkvProject.ui.guestFlow.servicePageProject.ServicePageTest;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

@Suite
@SuiteDisplayName("Home Page Test Suite")
@SelectClasses({ServicePageTest.class})
public class ServicePageSuite {
}
