package exampleJunit5;

import org.junit.jupiter.api.extension.*;

public class AnotherCondition implements BeforeEachCallback, BeforeAllCallback, AfterEachCallback, AfterAllCallback, BeforeTestExecutionCallback, AfterTestExecutionCallback {
    @Override
    public void afterAll(ExtensionContext extensionContext) throws Exception {
        System.out.println("Listening after callBack" + extensionContext.getTestClass());
    }

    @Override
    public void afterEach(ExtensionContext extensionContext) throws Exception {
        System.out.println("Listening after callBack" + extensionContext.getTestMethod());
    }

    @Override
    public void afterTestExecution(ExtensionContext extensionContext) throws Exception {
        System.out.println("Listening after test Execution callBack" + extensionContext.getTestClass());
    }

    @Override
    public void beforeAll(ExtensionContext extensionContext) throws Exception {
        System.out.println("Listening before callBack" + extensionContext.getTestClass());
    }

    @Override
    public void beforeEach(ExtensionContext extensionContext) throws Exception {
        System.out.println("Listening before callBack" + extensionContext.getTestMethod());
    }

    @Override
    public void beforeTestExecution(ExtensionContext extensionContext) throws Exception {
        System.out.println("Listening before test Execution callBack" + extensionContext.getTestClass());
    }
}
