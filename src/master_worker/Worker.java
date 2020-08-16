package master_worker;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.logging.Handler;

public class Worker implements Runnable {

    //引用master的所有任务
    private ConcurrentLinkedQueue<Task> tasks;
    //将执行完成的结果放入结果集当中
    private ConcurrentHashMap<String, Object> resters;
    
    @Override
    public void run() {
        
        
        // 因为要一直循环的去拿任务执行
        while (true) {
            Task task = tasks.poll();
            if(task == null) {
               break; 
            }
           Object obj = Handler(task);
           this.resters.put(Integer.toString(task.getId()), obj);
           
        }
        
       
        
        
        
    }

    private Object Handler(Task task) {

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return task.getJg();
    }

    public void setTask(ConcurrentLinkedQueue<Task> tasks) {

        this.tasks = tasks;
        
    }

    public void setResters(ConcurrentHashMap<String, Object> resters) {
        this.resters = resters;
        
    }

}
