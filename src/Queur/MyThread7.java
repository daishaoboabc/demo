package Queur;

public class MyThread7 {

    private volatile boolean isrun = true;
    
    public void isrun() {
        
        while (isrun) {
            //
        }
        System.out.println("执行完毕");
    }
    public void setRun(boolean isRun) {
        System.out.println("设置运行状态是停止");
        this.isrun = isRun;
    }
    

    public static void main(String[] args) throws InterruptedException {
        
        final MyThread7 thread7 = new MyThread7();
        
        Thread thread = new Thread(new Runnable() {
            
            @Override
            public void run() {
                thread7.isrun();
                
            }
        });
        thread.start();
        Thread.sleep(1000);
        thread7.setRun(false);
        
    }

}
