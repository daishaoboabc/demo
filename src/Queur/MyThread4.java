package Queur;

public class MyThread4 {

    private String name = "ls";
    private String word = "123";

    public synchronized void setName(String name, String word) {
        try {
            System.out.println("设置值name=" + name + "--" + "word=" + word);
        this.name = name;
        Thread.sleep(4000);
        this.word = word;
       
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public  void getName() {
        System.out.println("获取值name=" + name + "--" + "word=" + word);
    }

    public static void main(String[] args) throws InterruptedException {
        final MyThread4 myThread4 = new MyThread4();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                myThread4.setName("zs", "456");

            }
        });
        thread.start();
        Thread.sleep(11);
        myThread4.getName();
    }

}
