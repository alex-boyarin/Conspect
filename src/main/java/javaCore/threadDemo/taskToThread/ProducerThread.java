package javaCore.threadDemo.taskToThread;

import java.util.Queue;

public class ProducerThread implements Runnable {
    private final Queue<Integer> list;// первый зашел первый вышел

    public ProducerThread(Queue<Integer> list) {
        this.list = list;
    }

    @Override
    public void run() {
        synchronized (list) {
            while (true) {
                if (list.size() < 10) {
                    int random = RandomUtil.getRandom();
                    list.add(random);
                    System.out.println("Producer adds value: " + random + ". size " + list.size());
                } else {
                    System.out.println("Producer does nothing");
                }
                list.notifyAll();
                try {
                    int randomWaitValue = RandomUtil.getRandom(2);
                    System.out.println("Producer waits: " + randomWaitValue);
                    list.wait(randomWaitValue);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
