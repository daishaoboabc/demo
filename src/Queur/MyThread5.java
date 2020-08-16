package Queur;

public class MyThread5 {

    
    
    public synchronized void test1() {
        System.out.println("test1");
        test2();
    }
    public synchronized void test2() {
        System.out.println("test2");
        test3();
    }
    public synchronized void test3() {
        System.out.println("test3");
    }

    public static void main(String[] args) throws InterruptedException {
        final MyThread5 myThread4 = new MyThread5();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                myThread4.test1();

            }
        });
        thread.start();
    }

}
