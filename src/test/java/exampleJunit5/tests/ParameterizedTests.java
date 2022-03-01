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

    @ParameterizedTest//если мы хотим параметризовать тест то его нужно пометить такой аннатацией
    @EmptySource //аннотация, которая передает пустое значение. Это значит что ч мы передаем пустое значение
    //в переменную String a, а далее можем ее передать в метод или сравнивать с другим значение из
    //метода который тестируем.
    public void testStringIsEmpty(String a) {
        assertTrue(a.isEmpty());
    }

    @ParameterizedTest
    @NullAndEmptySource //аннотация, которая передает пустое значение и NULL, аналогично как и в примере выше
    public void testStringIsEmptyAndNull(String a) {
        assertTrue(a.isEmpty());
    }

    @ParameterizedTest//
    @ValueSource(ints = {1, 3, 5, -3, 15, Integer.MAX_VALUE}) //аннотация для передачи примитивов
    public void testParameterizedPrimitives(int number) {
        assertTrue(isOdd(number));
    }

    @ParameterizedTest
    @EnumSource(value = Months.class)// В этом варианте передадутся все значения enum
    public void testParameterizedEnum(Months months) {
        assertTrue(months.getNumber() >= 1 && months.getNumber() <= 12);
    }

    @ParameterizedTest
    @EnumSource(value = Months.class, names = {"APRIL", "MAY"})// а здесь конкретные значения
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
        assertEquals(0,calculator.calculate('/'));
    }

    private boolean isOdd(Number number) {
        return number.intValue() % 2 != 0;
    }
}
