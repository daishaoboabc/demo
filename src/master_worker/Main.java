package master_worker;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
            
        
        System.out.println(Runtime.getRuntime().availableProcessors());
        
        
        
        // 创建一个master实列
        Worker worker = new Worker();
        Master master = new Master(worker, Runtime.getRuntime().availableProcessors());

        Random random = new Random();
        // 提交100个任务
        for (int i = 0; i < 100; i++) {
            Task task = new Task();
            task.setId(i);
            task.setName(i + "任务");
            task.setJg(random.nextInt(1000));
            master.commitTask(task);
        }
        // 启动master
        
        long start = System.currentTimeMillis();
        master.start();
        while (true) {

            if (master.isOK()) {
                int result = master.getResult();
                System.out.println("最终结果集是:" + result + "---" + "执行时间是:" + (System.currentTimeMillis() - start));
                break;
            }

        }

    }

}
