
public class Main {

    public static void main(String[] args) {

        String s1 = "abcd";
        String s2 = new String("abcd");
        String s3 = "ab" + "cd";
        System.out.println(s1 == s2);
        System.out.println(s2 == s3);
        System.out.println(s1 == s3);
        
        System.out.println(test2(9));
    }

    public static int test() {
        int i = 10;
        try {
            System.out.println(i);

            return --i;
        } catch (Exception e) {
            --i;
            System.out.println(i);
            return --i;
        } finally {
            System.out.println(i);
            --i;
        }

    }

    
    public static int test2(int i) {
        if(i < 3) {
            return  1;
        }
        return test2(i-1)+test2(i-2);
    }
    
    public static int noException() {
        int i = 10;
        try {
            System.out.println(i);
            return --i;
        } catch (Exception e) {
            --i;
            System.out.println(i);
            return --i;
        } finally {

            System.out.println(i);
            --i;
        }

    }

    
}














