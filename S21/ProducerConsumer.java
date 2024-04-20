import java.util.LinkedList;

public class ProducerConsumer {
    public static void main(String[] args) {
        LinkedList<Integer> buffer = new LinkedList<>();
        int bufferSize = 5;
        Thread producerThread = new Thread(new Producer(buffer, bufferSize), "Producer");
        Thread consumerThread = new Thread(new Consumer(buffer), "Consumer");
        producerThread.start();
        consumerThread.start();
    }
}

class Producer implements Runnable {
    private final LinkedList<Integer> buffer;
    private final int bufferSize;
    private int value = 0;

    public Producer(LinkedList<Integer> buffer, int bufferSize) {
        this.buffer = buffer;
        this.bufferSize = bufferSize;
    }

    public void run() {
        while (true) {
            synchronized (buffer) {
                if (buffer.size() < bufferSize) {
                    buffer.add(value);
                    System.out.println(Thread.currentThread().getName() + " produced " + value);
                    value++;
                    buffer.notifyAll();
                } else {
                    try {
                        buffer.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}

class Consumer implements Runnable {
    private final LinkedList<Integer> buffer;

    public Consumer(LinkedList<Integer> buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (buffer) {
                if (buffer.isEmpty()) {
                    try {
                        buffer.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    int value = buffer.removeFirst();
                    System.out.println(Thread.currentThread().getName() + " consumed " + value);
                    buffer.notifyAll();
                }
            }
        }
    }
}