package exampleJunit5.tests;

import Taski.calculator.Calculator;
import enums.Months;
import exampleJunit5.providers.CustomArgumentsProvider;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
//@TestMethodOrder(MethodOrderer.)
public class ParameterizedTests {

    @ParameterizedTest
    @EmptySource //аннотация, которая передает пустое значение
    public void testStringIsEmpty(String a) {
        assertTrue(a.isEmpty());
    }

    @ParameterizedTest
    @NullAndEmptySource //аннотация, которая передает пустое значение и NULL
    public void testStringIsEmptyAndNull(String a) {
        assertTrue(a.isEmpty());
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, -3, 15, Integer.MAX_VALUE}) //аннотация
    public void testParameterizedPrimitives(int number) {

        assertTrue(isOdd(number));
    }

    @ParameterizedTest
    @EnumSource(value = Months.class)
    public void testParameterizedEnum(Months months) {
        assertTrue(months.getNumber() >= 1 && months.getNumber() <= 12);
    }

    @ParameterizedTest
    @EnumSource(value = Months.class, names = {"APRIL", "MAY"})
    public void testParameterizedCustomNamesEnum(Months month) {
        assertTrue(month.getNumber() >= 1 && month.getNumber() <= 12);
    }

    @ParameterizedTest
    @EnumSource(value = Months.class, names = {"APRIL", "MAY"})
    public void testParameterizedExcludeCustomNamesEnum(Months month) {
        assertTrue(month.getNumber() >= 1 && month.getNumber() <= 12);
    }

    @ParameterizedTest
    @ArgumentsSource(CustomArgumentsProvider.class)// если мы хотим передать кастомный класс, то для этого
    //нужно писать свой провайдер для класса, он будет выглядеть как стрим обьектов
    public void testParameterizedCustomProvider(Calculator calculator) {
        assertEquals(0, calculator.calculate('/'));
    }

    private boolean isOdd(Number number) {
        return number.intValue() % 2 != 0;
    }
}
