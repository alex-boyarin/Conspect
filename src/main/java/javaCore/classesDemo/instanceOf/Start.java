package javaCore.classesDemo.instanceOf;

//Computer laptop - Тип сылки
//new Laptop - Тип обьекта
public class Start {
    public static void main(String[] args) {
        AbstractComputer laptop = new Laptop(new Ssd(500), new Ram(8000), 3);
        AbstractComputer mobile = new Mobile(new Ssd(100), new Ram(4000));
        Laptop laptop1 = new Laptop(new Ssd(1000), new Ram(16000), 4);
        print(new AbstractComputer[]{laptop,mobile, laptop1});
    }

    /*
Проверяем действительно ли ссылка AbstractComputer ведет на Laptop и если это так, то мы можем сделать
((Laptop) computer).open() т.е. привести наш AbstractComputer к типу Laptop.
Или создать переменную типа Laptop. И после приведения ссылки computer к типу Laptop мы можем
вызвать метод непосредственно расположеный в классе Laptop. На приктике редко используется
оператор instanceof,потому-что редко нужно приводить ссылку к обьекту.
               */
    public static void print(AbstractComputer[] abstractComputers) {
        for (AbstractComputer abstractComputer : abstractComputers) {
            abstractComputer.info();
            if (abstractComputer instanceof Laptop) {
                Laptop laptop2 = (Laptop) abstractComputer;
               // laptop2.open();
                laptop2.load();
            }else {
                System.out.println("не принадлежит к Laptop");
            }
        }
    }
}
