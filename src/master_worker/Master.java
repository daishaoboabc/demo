package master_worker;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Master {

    // 1 需要一个承装任务的队列
    private ConcurrentLinkedQueue<Task> tasks = new ConcurrentLinkedQueue<>();
    // 2 需要一个承装worker的map
    private Map<String, Thread> workers = new HashMap<>();
    // 3 需要一个承装结果集的线程安全的map
    private ConcurrentHashMap<String, Object> resters = new ConcurrentHashMap<>();

    // 4需要一个构造方法来进行worker的初始化
    public Master(Worker worker, int count) {
        
        worker.setTask(tasks);
        worker.setResters(resters);
        for (int i = 0; i < count; i++) {
            workers.put(Integer.toString(i), new Thread(worker));
        }
    }

    // 5 提供一个方法来进行任务提交
    public void commitTask(Task task) {
        if (task != null) {
            tasks.add(task);
        }
    }

    // 6 需要一个方法来进行启动master
    public void start() {
        for (Map.Entry<String, Thread> en : workers.entrySet()) {
            en.getValue().start();
        }
    }

    // 7 提供一个方法判断是否执行完成
    public boolean isOK() {

        for (Map.Entry<String, Thread> en : workers.entrySet()) {
            if (en.getValue().getState() != Thread.State.TERMINATED) {
                return false;
            }
        }
        return true;
    }

    // 8 提供一个查询结果集的方法
    public int getResult() {
        int ret = 0;
        while (true) {
            if (isOK()) {
                for (Map.Entry<String, Object> em : resters.entrySet()) {
                    ret += (int) em.getValue();
                }
                return ret;
            }
        }
    }

}
