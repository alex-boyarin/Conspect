package exampleJunit4;

import exampleJunit4.tests.BasicJunitTest;
import exampleJunit4.tests.OrderedTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/** Можно обьединять тесты в Suite так сказать для запуска определенных тестов.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({BasicJunitTest.class, OrderedTest.class})
public class SuiteJ {

}
