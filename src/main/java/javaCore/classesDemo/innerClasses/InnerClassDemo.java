package javaCore.classesDemo.innerClasses;

/**
 * Внешний класс не видит полей и методов внутренего класса совсем.
 * Единственный способ добраться до полей внутреннего класса это создать обьект
 * который нужно как-то создать.
 */
public class InnerClassDemo {
    private int studentId;
    private String name;
    private int group;
    private String faculty;
    private Address address;

    /**
     * Для внутреннего класса есть ограничение:
     * 1 - он не может обьявлять static поля.
     * 2 - он не может обьявлять static методы.
     * 3 - он не может обьявлять static логические блоки.
     */
    public class Address {
        // private static String country;   --     ОШИБКА static недопустим!!!
        private String city;
        private String street;
        private int houseId;
        private int flatId;
        private String email;
        private String skype;
        private long phoneNumber;

        //static {};        --      ОШИБКА static недопустим!!!

        public Address() {
        }

        //public static void action() {};    --      ОШИБКА static недопустим!!!
        public void action() {
            group = 101;//внутренний класс видит все поля внешнего класса даже если они privat
        }
    }

    public InnerClassDemo() {
    }

    public void operation() {
        address.city = "Kiiv";//Внешний класс может обращаться к полям внутренеего класса
        //только через создание обьекта.
    }
}
