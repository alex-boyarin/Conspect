package javaCore.threadDemo.taskToThread;

import java.util.Queue;

public class ConsumerThread implements Runnable{
    private final Queue<Integer> list;

    public ConsumerThread(Queue<Integer> list) {
        this.list = list;
    }

    @Override
    public void run() {
        synchronized (list) {
            while (true) {
                //isEmpty-пустой, проверяет список пустой или нет. ЕСли пустой то True, если нет False
                if (!list.isEmpty()) {
                    Integer removedValue = list.remove();//метод удаляет элем. в порядке очереди
                    System.out.println("Consumer get value " + removedValue + ". size: " + list.size());
                } else {
                    System.out.println("Consumer is waiting, list is empty");
                }
                try {
                    int random = RandomUtil.getRandom();
                    System.out.println("Consumer wait: " + random);
                    list.notifyAll();
                    list.wait(random);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
