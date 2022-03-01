package exampleJunit4.runners;

import exampleJunit4.listeners.ExampleListener;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.InitializationError;
/** У нас есть например class ExampleRunner наследуемся от BlockJUnit4ClassRunner,
 * добавляем ему в слушатели (лисенер) наш кастомный класс ExampleListener
 */

public class ExampleRunner extends BlockJUnit4ClassRunner {
    private final ExampleListener exampleListener;//кастомный класс с нашим описанием
/* И в конструктор нашего ExampleRunner добавляем вызов нашего ранера и добавляем вызов
ExampleListener
 */
    public ExampleRunner(Class klass) throws InitializationError {
        super(klass);
        exampleListener = new ExampleListener();
    }
/* А так же в методе run который переопределен у BlockJUnit4ClassRunner, перед тем как стартануть тест
в RunNotifier-это специальный класс который мониторит Listener, добавляем свой exampleListener и потом
запускаем родительский класс super.run(notifier). Далее ставим аннотацию @RunWith(ExampleRunner.class)
с нашим классом ранером над классом в котором реализованы наши тесты
 */
    public void run(final RunNotifier notifier) {
        notifier.addListener(exampleListener);
        super.run(notifier);
    }
}
