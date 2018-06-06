package org.testng;

/**
 * A listener that gets invoked before and after a method is invoked by TestNG.
 * This listener will only be invoked for configuration and test methods.
 */
public interface IInvokedMethodListener extends ITestNGListener {

    default void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
        // not implemented
    }

    default void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        // not implemented
    }

    /**
     * To be implemented if the method needs a handle to contextual information.
     */
    default void beforeInvocation(IInvokedMethod method, ITestResult testResult,
                                  ITestContext context) {
        // not implemented
    }

    /**
     * To be implemented if the method needs a handle to contextual information.
     */
    default void afterInvocation(IInvokedMethod method, ITestResult testResult,
                                 ITestContext context) {
        // not implemented
    }
}
