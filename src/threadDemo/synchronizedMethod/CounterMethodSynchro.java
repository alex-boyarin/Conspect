package threadDemo.synchronizedMethod;

public class CounterMethodSynchro {
    /**
     * А что делать со static методами, ведь мы знаем чт захватив монитор определеного обьекта,
     * но допустим у нас было бы статическое поле private static String description которое
     * мы хотели-бы инициализировать только один раз. Т.е. у нас был бы метод public static void init()
     * и в нем бы мы проверяли если description==null, то просто его инициализируем.
     * Мы так же можем пометить метод как synchronized. Но если мы используем synchronized() блок
     * то нам ружно понимать что в него передать для того чтобы захватить мониторе его,
     * так ка мы проходили тему статиков, знаем что все что является статическим относится к обьекту
     * Класса.class, таким образом мы можем просто обратиться к этому обьекту CounterMethodSynchro.class
     * Таким образом это аналогия захвата монитора на уровне метода.
     */
    private static String description;// description-описание
    private int count;

    public static void init() {
        synchronized (CounterMethodSynchro.class) {
            if (description == null) {
                description = "Test description";
            }
        }
    }

    /**
     * Ключевое слово synchronized можно использовать двумя способами:
     * 1-й на уровне метода т.е. мы помечаем наш метод после модификатора доступа словом synchronized.
     * Таким образом говоря что в один и тот же момент времени, только один поток у одного и того же
     * обьекта может вызвать этот метод.
     */
    public synchronized void increment() {// 1-йпервый метод для synchronized
        count++;
    }

    /**
     * 2-й использование synchronized на уровне блока т.е. мы используем слово synchronized(this){}
     * и в круглых скобках указываем обьект который мы хотим синхронизировать, и в данном случае
     * мы хотим синхронизировать именно наш обьект Counter, т.е. мы передаем в скобки ссылку this
     * (обьект у которого вызвали метод increment), и в блоке synchronized(this){ мы можем писать
     * какой угодно код } если мы хотим чтобы этот код в этом блоке от одного и того же обьекта
     * типа Counter выполнялся только в одном потоке.
     */
//    public void increment(){  // 2-й метод для synchronized
//        synchronized (this){
//            count++ ;
//        }
//
//    }
    public void decrement() {

    }

    public int getCount() {
        return count;
    }
}
