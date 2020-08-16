package Queur;

import java.util.concurrent.PriorityBlockingQueue;

public class Queue {
        
    
    
    public static void main(String[] args) throws InterruptedException {
        
        PriorityBlockingQueue<Task> q = new PriorityBlockingQueue<>();
        
        Task t3 = new Task();
        Task t2 = new Task();
        Task t1 = new Task();
        t3.setId(3);
        t2.setId(2);
        t1.setId(1);
        q.add(t3);
        q.add(t2);
        q.add(t1);
        System.out.println(q.take().getId());
        for (Task task : q) {
            
            System.out.println(task.getId());
        }
    }
}
