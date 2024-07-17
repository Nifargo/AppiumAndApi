package common.listener;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestExecutionExceptionHandler;

public class TestListener implements TestExecutionExceptionHandler {
    @Override
    public void handleTestExecutionException(ExtensionContext context, Throwable throwable) {
        System.out.println("Test failed: " + context.getDisplayName());
        System.out.println("Problem is: " + throwable.getMessage());

        throwable.printStackTrace();
    }
}
