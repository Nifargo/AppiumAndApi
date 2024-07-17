package helpers.TestSuites;

import org.dkvProject.ui.guestFlow.anOnboardingPageProject.OnboardingFlowTest;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

@Suite
@SuiteDisplayName("Home Page Test Suite")
@SelectClasses({OnboardingFlowTest.class})

public class OnboardingTestSuite {
}
