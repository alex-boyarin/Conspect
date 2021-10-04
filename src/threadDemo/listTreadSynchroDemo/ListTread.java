package threadDemo.listTreadSynchroDemo;

import java.util.List;

public class ListTread extends Thread {
    private final List<Integer> list;

    public ListTread(List<Integer> list) {
        this.list = list;
    }

    //    @Override
//    public void run() {
//        for (int i = 0; i < 400; i++) {
//            synchronized (list){  // такая синхр. не гарантирует что какой-нибудь поток не
//                list.add(i);      // не воспользуется другими методами листа
//            }
//
//        }
//    }
    @Override
    public void run() {// После добавления обертки Collections.synchronizedList(new ArrayList<>())
        for (int i = 0; i < 400; i++) {
            list.add(i);
        }
    }
}
