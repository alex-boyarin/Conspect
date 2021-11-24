package javaCore.classesDemo.instanceOf;

//Computer laptop - Тип сылки
//new Laptop - Тип обьекта
public class Start2 {
    public static void main(String[] args) {
        Computer2 laptop2 = new Laptop2(new Ssd2(500), new Ram2(8000), 3);
        Computer2 mobile2 = new Mobile2(new Ssd2(100), new Ram2(4000));
        Laptop2 laptop = new Laptop2(new Ssd2(1000), new Ram2(16000), 4);
    }

    /*
Проверяем действительно ли ссылка computer ведет на Laptop и если это так, то мы можем сделать
((Laptop) computer).open() т.е. привести наш computer к типу Laptop.
Или создать переменную типа Laptop. И после приведения ссылки computer к типу Laptop мы можем
вызвать метод непосредственно расположеный в классе Laptop. На приктике редко используется
оператор instanceof,потому-что редко нужно приводить ссылку к обьекту.
               */
    public static void print(Computer2[] computer2s) {
        for (Computer2 computer2 : computer2s) {
            computer2.print();
            if (computer2 instanceof Laptop2) {
                Laptop2 laptop2 = (Laptop2) computer2;
                laptop2.open();
            }
        }
    }
}
