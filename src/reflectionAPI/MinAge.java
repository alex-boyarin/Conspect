package reflectionAPI;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Анотация это мето-данные для нашего класса которые можно ставить как над методом так над конструктором
 * над полями, либо над параметрами либо классом. И по сути они представляют из себя какую-то метоинформ.
 * которую мы можем использовать и естественно она принадлежит обьекту класса Class.
 * Зайдем в анатацию @Override мы видим что она очень похожа на определение интерфейса, только перед
 * ключевым словом @interface идет сабака, это и есть анотации. И анотация состоит из двух основных
 * частей, и эти части помечаются еще двумя анотациями @Target, @Retention.
 *
 * @Target говорит нам где мы можем использовать нашу анатацию над которой стоит анотация @Target(в скобках
 * указывается над чем можно использовать анотацию, пример ElementType.METHOD)
 * @Retention является не обязательным, и она говорит где в какой момент мы будем видеть нашу анатацию
 * всего существует 3 разных варианта: SOURCE, CLASS, RUNTIME.
 * <p>
 * CLASS-поумолчанию, которая практически не используется, озаначает что мы эту анатацию не сможем
 * использовать во время RUNTIME т.е. во время выполн. нашей программы, но тем не мение она будет после
 * компиляции в нашем коде, но мы никак не сможем ею возпользоваться.
 * <p>
 * SOURCE-анотация которая доступна нам только в исходном коде, после компиляции в классе она пропадет.
 * Это пример нашей анотации @Override. Как только мы скомпилируем наш класс, @Override пропала и мы ни
 * как не сможем получить к ней доступ.
 * <p>
 * RUNTIME-чаще всего используется т.е. это те анотации которые видны даже во время выполнения,
 * так же она очень часто использ. в  фреймворках spring and Hibernate.
 * Зайдем в @Target и посмотрим что еще в нем может быть, и мы видим что в анотациях еще есть своего
 * рода методы ElementType[] value() очень похожие на определение интерфейса, мы видим название метода
 * value() и возвращаемое знаечение ElementType[]. Но тут есть много ограничений, мы не можем возвращать
 * какой угодно тип, тут только возможно использование enum, примитивные типы, обьекты класса Class,
 * строки, либо массивы из все этих типов. Принимать эти методы ничего не могут, еще есть ключевое слово
 * default только он ставить в самом конце  ElementType[] value() default() и оно будет проинициализированно
 * у нас в нашей анотации.
 */
@Target({ElementType.TYPE,// мы выбираем где мы будем использовать, в данном случае это класс
        ElementType.FIELD})//можно добавлять где будет использоваться и другие варианты, например поля.
@Retention(RetentionPolicy.RUNTIME)// добавляем для того чтобы во время выполнения мы могли получить
public @interface MinAge {//различные данные через Reflection Api

    int age();// В свойства аннотации мы ничего не передаем т.к. это не методы нашего интерфейса,
    // следовательно они могут только возвращать какое-то значение.
}