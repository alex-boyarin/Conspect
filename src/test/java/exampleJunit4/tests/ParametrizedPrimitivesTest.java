package exampleJunit4.tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
/** Для того чтобы в Junit4 параметризовать тесты нужно в Аннотации @RunWith(Parameterized.class) указать
 * класс Parameterized.class, далее если нам нужно делаем конструктор,
 * и помечаем метод который возвращает коллекцию обьектов Аннотацией @Parameterized.Parameters
 * Эта конструкция характерна для примитивов. Но если нужно работать с обьектами то смотрите ниже пример.
 */
import static org.junit.Assert.assertEquals;
@RunWith(Parameterized.class)
public class ParametrizedPrimitivesTest {
    private String str1;
    private String str2;

    public ParametrizedPrimitivesTest(String str1, String str2) {
        this.str1 = str1;
        this.str2 = str2;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][]{{"zxc", "ZXC"}, {"123", "qwe"}, {"a", "a"}, {"", null}};
        return Arrays.asList(data);
    }

    @Test
    public void testComparingString() {
        assertEquals(str1, str2);
    }
}
