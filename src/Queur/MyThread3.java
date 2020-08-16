package Queur;

public class MyThread3 {
    
    public synchronized  void test1(String tag) throws InterruptedException {
        
        System.out.println(Thread.currentThread().getName());
        Thread.sleep(4000);
        
    }
    public synchronized  void test2(String tag) throws InterruptedException {
        
        System.out.println(Thread.currentThread().getName());
    }
    
    
    
    public static void main(String[] args) {

            final MyThread3 m1 = new MyThread3();
            
            Thread t1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        m1.test1("a");
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            },"t1");
            

            Thread t2 = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        m1.test2("b");
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    
                }
            },"t2");
            
            t1.start();
            t2.start();
            
            
            
        
        }
        
    }
    
    
    
    
