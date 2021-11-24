package reflectionAPI;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * Reflection API-это не так уж и сложно, на самом деле это всего лишь работа с обьектом типа Class class
 * Мы углубляемся в обьекты типа Class class потому-что они нам позволяют работать на прямую с тем что
 * мы описали в наших классах, например можно извлечь название класса, модификатор доступа, все его поля,
 * методы, конструкторы. Так же и из методов можно извлечь все данные.
 * Все это часто используется в фреймворках таких как spring или хибернейт.
 * Теперь как достучаться до обьекта класса Класс, мы знаем 2 варианта т.е. обьект знает тот шаблон на
 * основании которого он был создан, по сути это наш класс т.е. getClass().
 * так же мы можем напрямую к нему обратиться назвав его User.class это так же будет наш User. И если
 * мы их сравним на равенство, то мы увидим что ссылки будут равны, таким образом мы удостоверились
 * что эти обькты равны друг другу, и они являются синглтонами.
 * <p>
 * Теперь пройдем в Debug и обратимся к нашему User при помощи Alt+F8
 * userClass.getName()-получаем название класса и пакет в котором находится класс.
 * userClass.getSimpleName()-только имя класса.
 * Test1.class.getCanonicalName()-ели у нас есть вложеные классы, то при помощи такой конструкции
 * мы получим его имя с полным путем расположения.
 * userClass.getDeclaredFields()-через этот метод мы получаем доступ ко всем полям класса.
 * userClass.getSuperclass().getDeclaredFields()-получаем поля супер класса.
 * userClass.getMethods()-получаем все методы, не только методы которые у нас есть в нашем классе
 * userClass но и все унаследованые методы.
 * userClass.getDeclaredMethods()-получаем методы которые есть только у класса userClass.
 * userClass.getInterfaces()-получаем интерфейсы которые реализовывает наш класс.
 * userClass.getGenericInterfaces()-можем обратиться к интерфейсам более подробно, т.е. если это
 * обычный интерфейс то мы так же получаем класс но если это не обычный т.е. generic то мы получаем
 * parameterizedType  и мы можем извлеч тот параметр которым параметризован наш интерфейс Comparable
 * в данном случае это Comparable<learn.apiReflection.User>.
 * userClass.getConstructors()-получаем все конструкторы которые есть.
 * userClass.getConstructors()[0].getModifiers()-получаем модификаторы доступа, он нам возвращает цифру,
 * это побитовое число.
 * userClass.getEnclosingClass()-если это внутренниий или вложенный класса, то можем получить внешний.
 * userClass.getClassLoader()-это обьект класса ClassLoader который загружает в JVM  обьект класса Class
 * как только он впервые встретит их в нашем приложении.
 * userClass.getPackageName()-получаем покет в котором находится наш класс.
 */
public class ReflectionApiExample {
    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        User user = new User(25L, "ivan", 24);
        Class<? extends User> userClass = user.getClass();
        Class<User> userClass1 = User.class;
        System.out.println(userClass1 == userClass);
        //testConstructor();
        testFields(user);
        testMethods(user);
    }

    /*
  У нас есть конструктор нашего класса User.class.getConstructor(Long.class, String.class)
  впринципе нет ни какой разницы между getConstructors и getDeclaredConstructors и более того мы можем
  получить определенный конструктор просто передав параметры которые он принимает, в данном случае
  мы знаем что у нашего констр. два параметра, который принимает id и name, поэтому мы можем напрямую
  его получить, мы так же знаем что не возможно создать два метода и два конструктора с одинаковыми
  параметрами. Все что связано с  Reflection API сопрежено с Exception, потому-что у нас может не быть
  такого конструктора. Этот конструктор позволяет нам создавать экземпляры этого класса т.е. newInstance()
  и мы просто передаем параметры, и он возвращает обьект класса User. Просто мы можем динамически
  передавать сюда класс в наш метод и он может быть совершенно любой, главное чтобы у него был определенный
  констр. с определ. кол-ом параметров, чаще всего делают конструкторы по умолчанию, например так работает
  Hibernate, для того чтобы динамич. создавать Instance любого класса, поэтому вызываем newInstance()
  и передаем (5L, "Petr") и он нам возвращает нашего "Petr". так же может быть Exception. И выводим
  инфу про нашего "Petr". В методе main вызываем testConstructor(). Таким образом мы можем использовать
  констр. для создания обьектов нашего класса
     */
//    private static void testConstructor() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
//        Constructor<User> constructor = User.class.getConstructor(Long.class, String.class);
//        User petr = constructor.newInstance(5L, "Petr");//Instance-экземпляр
//        System.out.println(petr);
//    }

    /*
    Так же у нашего класса можно получить все Fields, вызывается через getDeclaredFields() мы можем
    получить все его значения,т.е. даже не вызывая методы get() set() и тому подобное. Передадим в метод
    User user, теперь пройдем по каждому Field с помощью iterator. Вызываем declaredField.get(user),
    метод get() позволяет нам получить значение этого Field у обьекта которого мы передали, в данном случае
    получается как буд-то наоборот поиска записей, мы сначало берем Field значение которых мы хотим получить
    и через метод get() получаем значение у обьекта переданого в этот метод. Будут так же Exception.
    IllegalAccessException-означет что мы не можем просто так получить значение у нашего Field если он
    например имеет модификатор доступа privat. В данном случае у нас так и есть и мы получим Exception.
    Для того чтобы нам это исправить нам нужно сделать следующие  declaredField.setAccessible(true)
    мы теперь как будто сделали из privat public. Если бы у нас было больше классов то мы могли бы
    сделать getSuperclass().getDeclaredFields() в таком случае мы получим поле "id" нашего "ivan"
    Если же мы хотим сделать это более универсально мы можем здесь передавать любой обьект нам не важно
    какой он будет, пускай это будет Object, и тогда мы можем брать у нашего обьекта класс getClass()
    и теперь мы можем в testFields(Object object) передавать любой ОБЬЕКТ любого класса и он будет работать.
        Таким образом и работают фреймворки, им не нужно знать про какие-то интерфейсы либо базовые классы
    которые должен реализовывать либо extends наш обьект все что нам нужно это просто Reflection API
    и работа через обьект типа Class класс. У полей есть модиф.доступа, мы их так же можем получить
    declaredField.getModifiers() И чтобы как-то использовать эту инфу у нас есть утилитный класс Modifier.
    Это работает так, здесь используется обычная побитовая маска [0,0,0,0,0,0,1,1]
    т.е. выбирается к примеру 1 байт или 2 в зависимости кол-ва модификаторов и т.к. это обычные "0" b "1"
    далее мы решаем что бит в нашей ячейке будет означать public, следователь если кто-то заполнит
    ее в "1" значит он будет public, 2 бит к примеру будет для final и т.д.

     */
    private static void testFields(Object object) throws IllegalAccessException {
        Field[] declaredFields = object.getClass().getSuperclass().getDeclaredFields();
        for (Field declaredField : declaredFields) {
            declaredField.setAccessible(true);//setAccessible-установить доступный
            Object value = declaredField.get(object);
            System.out.println(declaredField.getModifiers());
            System.out.println(Modifier.isPrivate(declaredField.getModifiers()));
            System.out.println(value);
//        Field[] declaredFields = User.class.getSuperclass().getDeclaredFields();
//        for (Field declaredField : declaredFields) {
//            declaredField.setAccessible(true);//setAccessible-установить доступный
//            Object value = declaredField.get(user);
//            System.out.println(value);
        }
    }

    /*
    Мы знаем что у User есть множество методов как своих так и унаследованых, поэтому если мы хотим получить
    именно свои то вызываем getDeclaredMethods, если мы хотим получить конкретный метод то можем его получить
    передав в метод название getDeclaredMethod("getName") который ничего не принимает т.к. это обычный
    get() но возвращает мне обьект этого класса. И можно например вызвать его method.invoke(user) у любого
    обьекта, и передать те параметры которые необходимы для вызова этого обьекта. Так же нужно обрабатывать
    Exception, обычно у фреймворков таких как spring есть утилитный метод который просто оборачивает все эти
    методы и отлавливает Exception, тогда не нужно каждый раз их обрабатывать на уровень выше. Так же мы
    можем вызывать любой другой метод, напримет "setName" т.е. мы можем поменять имя нашего User
    не только через  Field но и через методы, в основном так и происходит.
     */
    private static void testMethods(User user) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        // Method method = user.getClass().getDeclaredMethod("getName");
        Method method = user.getClass().getDeclaredMethod("setName", String.class);
        method.invoke(user, "sveta");
        System.out.println(user);//invoke-вызывать
    }

    private class Test1 {
    }

    private static class Test2 {
    }

    private enum Test3 {
        ONE, TWO
    }
}
