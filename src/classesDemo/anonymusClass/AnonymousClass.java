package classesDemo.anonymusClass;

public class AnonymousClass {
    public static void main(String[] args) {
        Service service = new Service() {//анонимный клас
            @Override
            public void service1() {
                System.out.println("anom ser1");
            }

            @Override
            public void service2() {
                System.out.println("anom ser2");
            }
        };
        service.service1();
    }
}
