package classesDemo.proInterfece;

/*
Создаем метод и в этот раз мы будем передавать в него не Computer а интерфейс Printable.  Теперь мы
можем оперировать не только классами но и интерфейсами, дело в том что интерфейс как и класс это как
будто новый тип данных, следовательно мы без проблем можем вызвать метод  print() и передать в него
(laptop, mobile). Т.к. эти два класса реализуют интерфейс ошибки не будет, по сути реализует наш
класс Computer, тем не менее Laptop и Mobile наследуются от нашего Computer следовательно все что
реализовал наш родитель так же наследовалось для наших Laptop и Mobile.
Так как в метод мы можем передавать все что является Printable то мы можем сказать что laptop и mobile
могут иметь ссылки типа Printable.
Подытожим интерфейсы мы используем тогда когда мы хотим принисти какой-то функционал
в наш класс, потому-что интерфейсы они по сути public abstract т.е. все их методы
публичны и абстрактные.
 */
public class OopRunner {
    public static void main(String[] args) {
        Computer laptop = new Laptop(new Ssd(120), new Ram(1024), 3);
        Computer mobile = new Mobile(new Ssd(60), new Ram(2024));
        //  Printable laptop = new Laptop(new Ssd(120), new Ram(1024), 3);
        // Printable mobile = new Mobile(new Ssd(60), new Ram(2024));
        print(laptop, mobile);
    }

    /*
    И в Printable у нас есть ограничения только к тому что нам предоставляет интерфейс Printable
    следовательно все что мы можем сделать это у printable вызвать метод print()
     */
    public static void print(Printable... object) {
        for (Printable printable : object) {
            printable.print();
            System.out.println();
        }
    }
}
