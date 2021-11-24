package javaCore.javaIO;

/*для того чтобы запустить аргумент командной стоки следует нажать run_edit configuration в application
добавляем PropDemo указываем версию java и выбираем класс, а в аргументы водим нашу запись*/
public class ArgumetCommandLine {
    public static void main(String[] args) {
        for (String element : args) {
            System.out.println(element);

        }
    }
}
