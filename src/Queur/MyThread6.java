package Queur;

public class MyThread6 {

    private int i = 10;
    
    
    public  void jianjian() {
        i--;
        System.out.println(i);
    }
    
    static  class sub extends MyThread6{
        
        public synchronized void jianjians() {
            
            while (super.i > 0) {
                super.i --;
                System.out.println(super.i);
                jianjian();
            }
            
        }
        
        
    }
    

    public static void main(String[] args) throws InterruptedException {
        final sub myThread4 = new sub();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                myThread4.jianjians();

            }
        });
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                myThread4.jianjians();
                
            }
        });
        thread.start();
        thread1.start();
        
        
    }

}
