package Queur;

import java.util.concurrent.atomic.AtomicInteger;

public class VolatileNoAtomic extends Thread {
    
   // private volatile static int count = 0;
    private volatile static AtomicInteger count = new AtomicInteger(0);
    @Override
    public void run() {
        
        addCount();
        
    }
    
    public static void addCount() {
       // synchronized(VolatileNoAtomic.class) {
            for (int i = 0; i < 1000; i++) {
                count.incrementAndGet();
            }
            System.out.println(count); 
        //}
       
        
    }
    public static void main(String[] args) {
        
        VolatileNoAtomic[] atomics = new VolatileNoAtomic[1000];
        for (int i = 0; i < atomics.length; i++) {
            atomics[i]  = new VolatileNoAtomic();
        }
            
        for (VolatileNoAtomic volatileNoAtomic : atomics) {
                volatileNoAtomic.start();
        }
        
    }
    
}
