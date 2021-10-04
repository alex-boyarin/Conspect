package packageList;

public class ListRunner {
    public static void main(String[] args) {
        ListDemo<String> list = new ListDemo<>(10);
        list.add("1");
        list.add("25");
        list.add("3");
        String element = list.get(1);
        System.out.println(element);
    }
}
