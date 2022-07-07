package javaCore.colectionDemo.enumColectionDemo.enumTask;

/*
 * Метод values () возвращает массив, содержащий список констант перечислимого типа.
 * метод valueOf () возвращает константу перечислимого типа, значение
 * которой соответствует символьной строке, переданной в качестве аргумента
 * строка.
 */
public class EnumRunner {
    public static void main(String[] args) {
        MusicType musicType1 = MusicType.JAZZ;

        /* Метод valueOf () возвращает константу перечислимого типа, значение
        которой соответствует символьной строке, переданной в качестве аргумента строка.*/
        MusicType musicType2 = MusicType.valueOf("ROCK");

        String value = "Jazz  "; /* Если вдруг параметр приходит в таком виде, то для
        Правильности вызывается доп. метод для изменения регистра строки. toUpperCase()
        так же могут быть лишние пробелы по краям, то метод trim() их удаляет. */
        MusicType musicType3 = MusicType.valueOf(value.toUpperCase().trim());

        System.out.println(musicType1);
        System.out.println(musicType2);
        System.out.println(musicType3);
        /* Как только появились перечисления их сразу разрешили использовать
         * в операторе switch-case */
        String name = musicType3.getRealName();
        switch (musicType3) {
            case JAZZ:
                System.out.println("this is Jazz " + name);
                break;
            case ROCK:
                System.out.println("this is Rock " + name);
                break;
            case CLASSIC:
                System.out.println("this is Classic");
                break;
            default:
                System.out.println("don't style");
        }
    }
}
