package Thread;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CustomThread extends Thread {
    static Map<Integer, String> stringMap = new HashMap<>();
    //static Map<Integer, String> stringMap = new ConcurrentHashMap<>();
    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            System.out.println("CurrentThread name :"+Thread.currentThread().getName());
            stringMap.put(3,"C");
        } catch (InterruptedException e) {
            System.out.println("Child thread is going to add element");
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws InterruptedException {

        stringMap.put(1, "A");
        stringMap.put(2, "B");
        CustomThread customThread = new CustomThread();
        customThread.start();

        for (Object object : stringMap.entrySet()) {
            System.out.println(object);
            Thread.sleep(10000);
        }
        System.out.println(stringMap);

        stringMap.put(null,null);
        stringMap.put(null,null);
    }
}
