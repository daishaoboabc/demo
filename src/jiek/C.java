package jiek;

public class C implements A, B {

    @Override
    public void test(A a) {
       
      System.out.println(2);

    }

    
    public static void main(String[] args) {
        
      //  String temp = "hello";
        String str1 = new StringBuilder("hel").append("lo").toString();

        String str2 = new StringBuilder("ja").append("va").toString();

        String intern = str1.intern();

        System.out.println(intern == str1); // true

        System.out.println(str2.intern() == str2); // false
        
        
    }


    @Override
    public void test() {
        // TODO Auto-generated method stub
        
    }
}
