package javaCore.colectionDemo.enumColectionDemo.enumTask;

/* Enum в java является классом, все перечисления являются подклассами класса java.lang.Enum
 * Конструктор явным образом никогда не вызывается, для создания перечисления есть определенные
 * набор методов.
 * От перечислений нельзя наследоваться, перечисл. не может быть абстрактным.
 * Перечисление может содержать абстрактные методы. */
public enum MusicType {
    ROCK("-Гитара"),
    JAZZ("-Саксофон"),
    CLASSIC();
    private String realName;

    /* Для того чтобы добавить конструктор, после перечисления ставят (  ;  )
     * У конструктора может быть доступ по дефолту (это protected) либо (privat)
     * конструктор явным образом не вызывается, он вызывается при создании объекта.
     * Перечисление имеет статическую природу, и при создании перечисления, создаются сразу все
     * элементы перечисления. */
    private MusicType() {
        //  System.out.println(this.name() + " " + this.ordinal());
    }

    /* Если мы хотим создать конструктор с параметрами, а как известно мы не можем его вызвать
     * через оператор new, то вполне справедливо написать эти параметры в скобке сразу после
     * каждого элемента перечисления ROCK(здесь будет параметр) */
    MusicType(String realName) {
        this.realName = realName;
    }

    public String getRealName() {
        return realName;
    }

    /* При помощи set() мы можем спокойно заменить значение именованой константы
     * т.е. элем перечисл. может хранить не только именован. констант. но и набор каких-то
     * значений которые связаны с этой именов. константой.
     */
    public void setRealName(String realName) {
        this.realName = realName;
    }
}
