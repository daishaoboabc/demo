package Queur;

public class MyThread2 {

    
    private static String  num = "";

    
    
    public  void setNum(String tag) throws InterruptedException {
        if("a".equals(tag)) {
            
            num = "100";
            
            Thread.sleep(1000);
            System.out.println(tag+"--"+num);
        }else {
            
            num = "200";
            Thread.sleep(1000);
            System.out.println(tag+"--"+num);
        }
        
        System.out.println(tag + "--over");
        
        
        
    }
    
    
    
    public static void main(String[] args) {
        
        for (int i = 0; i < 10; i++) {
            

            final MyThread2 m1 = new MyThread2();
            final MyThread2 m2 = new MyThread2();
            
            Thread t1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        m1.setNum("a");
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    
                }
            });
            

            Thread t2 = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        m2.setNum("b");
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    
                }
            });
            
            t1.start();
            t2.start();
            
            
            
        
        }
        
    }
    
    
    
    
}
