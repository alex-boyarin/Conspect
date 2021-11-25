package exampleJunit4.listeners;

import org.junit.AssumptionViolatedException;
import org.junit.runner.Description;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;

public class ExampleListener extends RunListener {
    /**
     * Вызывается перед запуском всех тестов.
     *
     * @param description описание класса, который будет запущен.
     */
    @Override
    public void testRunStarted(Description description) throws Exception {
        System.out.println("----LISTENER----");
        System.out.println("Before tests run: " + description);
        System.out.println("-------------------------------");
    }

    /**
     * Вызывается когда все тесты завершены
     *
     * @param result результат выполнения тестов
     */
    @Override
    public void testRunFinished(Result result) throws Exception {
        System.out.println("----LISTENER----");
        System.out.println("result of the test run: ");
        System.out.println("Run time: " + result.getRunTime() + " ms");
        System.out.println("Run count: " + result.getRunCount());
        System.out.println("Failure count: " + result.getFailureCount());
        System.out.println("Ignored count: " + result.getIgnoreCount());
        System.out.println("------------------------------------");
    }

    /**
     * Вызывается перед запуском каждого теста.
     *
     * @param description описание теста, который собирается запуститься
     *                    (обычно имя класса и метода)
     */
    @Override
    public void testStarted(Description description) throws Exception {
        System.out.println("----LISTENER----");
        System.out.println("Test starts: " + description);
        System.out.println("-------------------------");
    }

    /**
     * Вызывается после запуском каждого теста,
     * несмотря на результат выполнения.
     *
     * @param description описание теста, который завершился.
     */
    @Override
    public void testFinished(Description description) {
        System.out.println("----LISTENER----");
        System.out.println("Test finished: " + description);
        System.out.println("-------------------------");
    }

    /**
     * Вызывается когда тест завершился не удачей.
     *
     * @param failure описывает тест, который завершился ошибкой
     *                и полученное исключение.
     */
    @Override
    public void testFailure(Failure failure) {
        System.out.println("----LISTENER----");
        System.out.println("Test failed with: " + failure.getException());
        System.out.println("-------------------------");
    }

    /**
     * Вызывается когда не выполняется условие в классе assume.
     *
     * @param failure описывает тест, который не был выполнен
     *                и исключение {@link AssumptionViolatedException}
     */
    @Override
    public void testAssumptionFailure(Failure failure) {
        System.out.println("----LISTENER----");
        System.out.println("Test assumes: " + failure.getException());
        System.out.println("-------------------------");
    }

    /**
     * Вызывается когда тест не будет запущен,
     * в основном потому что стоит аннотация @Ignore
     *
     * @param description описание теста котрый не будет запущен
     */
    @Override
    public void testIgnored(Description description) {
        System.out.println("----LISTENER----");
        System.out.println("Test ignored: " + description);
        System.out.println("-------------------------");
    }
}
