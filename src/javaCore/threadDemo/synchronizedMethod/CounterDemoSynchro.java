package javaCore.threadDemo.synchronizedMethod;

/**
 * Ключевое слово synchronized можно использовать двумя способами:
 * 1-й на уровне метода т.е. мы помечаем наш метод после модификатора доступа словом synchronized.
 * Таким образом говоря что в один и тот же момент времени, только один поток у одного и того же
 * обьекта может вызвать этот метод.
 * <p>
 * 2-й использование synchronized на уровне блока т.е. мы используем слово synchronized(this){}
 * и в круглых скобках указываем обьект который мы хотим синхронизировать, и в данном случае
 * мы хотим синхронизировать именно наш обьект Counter, т.е. мы передаем в скобки ссылку this
 * (обьект у которого вызвали метод increment), и в блоке synchronized(this){ мы можем писать какой
 * угодно код } если мы хотим чтобы этот код в этом блоке от одного и того же обьекта
 * типа Counter выполнялся только в одном потоке.
 * <p>
 * И если synchronized на уровне метода еще интуитивно понятен, то synchronized блок уже не совсем
 * понятен, почему мы должны передавать сюда еще какой-то обьект.
 * Дело в том что есть такое понятие как монитор. Монитор -это средство обеспечения контроля за
 * доступом к ресурсу, и у каждого обьекта есть свой монитор, т.е. если бы у нас было два обьекта
 * типа Counter у каждого из них был свой монитор. Прще всего представить монитор как обычное
 * boolean поле у нашего обьекта, следовательно если это поле true то нет никаких препятствий
 * чтобы поток выполнил какой-то synchronized-метод или synchronized-блок у этого обьекта.
 * И выставляет его сразу в false до тех пор пока он не выйдет из этого метода или блока, поэтому
 * если какой-то любой другой поток у тогоже самого обьекта пытается вызвать синхр.метод или блок
 * и все равно какой это будет метод, это не обязательно чтобы был тот же самый метод, потому-что
 * мы знаем что для того чтобы захватить монитор нашего обьекта, этот монитор должен быть свободен
 * т.е. мы всегда проверяем этот флаг, и если монитор занят (флаг выставлен в false)
 * то мы заблокированы другим потоком и ждем, возвращаясь к теме наших состояний потоков,
 * мы находимся в состоянии BLOCKED.
 * <p>
 * Почему так важно понимать, что synchronized захватывает монитор именно какого-то одного
 * определенного обьекта а не всех сразу, ведь у нас может быть несколько обьектов,
 * и если мы захватили монитор у одного из них, нам ни что не может воспрепятствовать
 * захватить монитор другого обьекта из другого потока, более того нужно понимать
 * что если у нас к примеру есть другой метод  public void decrement() и он не помечен
 * ключевым словом synchronized, следовательно нам не нужно проверять наш монитор обьекта
 * по сути проверять наш флаг для того чтобы вызвать этот метод, таким образом нужно осторожно
 * подходить к синхр. нашего обьекта, следовательно чтобы правильно работал наш Counter мы должны
 * так же метод public void decrement() пометить словом synchronized, или использ. блок
 * public synchronized void decrement(). Нужно понимать что если мы захватили в нашем потоке монитор
 * какого-то обьекта, мы в этом же потоке можем вызватьи другие синхр. методы у этого самого обьекта.
 * Т.е. мы захватили монитор и можем делать с этим обьектом все что угодно, но в тоже самое время
 * другие потоки не могут у того же самого обьекта вызвать любые из синхр. методов или блоков до тех пор
 * пока монитор не будет отпущен, по сути другие потоки просто ожидают освобождения этого монитора
 * и находятся в состоянии BLOCKED.
 * <p>
 * А что делать со static методами, ведь мы знаем чт захватив монитор определеного обьекта,
 * но допустим у нас было бы статическое поле
 */
public class CounterDemoSynchro {
    public static void main(String[] args) {
        CounterMethodSynchro counterMethodSynchro = new CounterMethodSynchro();
        CounterThreadSynchro counterThreadSynchro1 = new CounterThreadSynchro(counterMethodSynchro);
        CounterThreadSynchro counterThreadSynchro2 = new CounterThreadSynchro(counterMethodSynchro);
        CounterThreadSynchro counterThreadSynchro3 = new CounterThreadSynchro(counterMethodSynchro);
        CounterThreadSynchro counterThreadSynchro4 = new CounterThreadSynchro(counterMethodSynchro);
        CounterThreadSynchro counterThreadSynchro5 = new CounterThreadSynchro(counterMethodSynchro);
        CounterThreadSynchro counterThreadSynchro6 = new CounterThreadSynchro(counterMethodSynchro);
        CounterThreadSynchro counterThreadSynchro7 = new CounterThreadSynchro(counterMethodSynchro);
        CounterThreadSynchro counterThreadSynchro8 = new CounterThreadSynchro(counterMethodSynchro);
        CounterThreadSynchro counterThreadSynchro9 = new CounterThreadSynchro(counterMethodSynchro);

        counterThreadSynchro1.start();
        counterThreadSynchro2.start();
        counterThreadSynchro3.start();
        counterThreadSynchro4.start();
        counterThreadSynchro5.start();
        counterThreadSynchro6.start();
        counterThreadSynchro7.start();
        counterThreadSynchro8.start();
        counterThreadSynchro9.start();

        try {
            counterThreadSynchro1.join();
            counterThreadSynchro2.join();
            counterThreadSynchro3.join();
            counterThreadSynchro4.join();
            counterThreadSynchro5.join();
            counterThreadSynchro6.join();
            counterThreadSynchro7.join();
            counterThreadSynchro8.join();
            counterThreadSynchro9.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(counterMethodSynchro.getCount());
    }
}
