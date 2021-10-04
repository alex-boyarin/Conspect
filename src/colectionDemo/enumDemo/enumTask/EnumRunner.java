package colectionDemo.enumDemo.enumTask;

/*
 * Метод values () возвращает массив, содержащий список констант перечислимого типа.
 * метод valueOf () возвращает константу перечислимого типа, значение
 * которой соответствует символьной строке, переданной в качестве аргумента
 * строка.
 */
public class EnumRunner {
    public static void main(String[] args) {
        MusicType musicType = MusicType.JAZZ;
//        MusicType musicType1 = MusicType.valueOf("ROCK");
//        String value = "Jazz  "; // если вдруг параметр приходит в так ом виде, то для
//        //правельности вызывается доп. метод для изменения регистра строки. toUpperCase()
//        //так же могут быть лишние пробелы по краям, то метод trim() их удаляет.
//        MusicType musicType2 = MusicType.valueOf(value.toUpperCase().trim());
//        System.out.println(musicType);
//        System.out.println(musicType1);
//        System.out.println(musicType2);
        /*
         * Как только появились перечисления их сразу разрешили использовать
         * в операторе swich-case
         */
        String name = musicType.getRealName();
        switch (musicType) {
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
