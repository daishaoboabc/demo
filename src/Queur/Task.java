package Queur;

public class Task implements Comparable<Task> {
    
    private int id;
    
    
    
    
    public int getId() {
        return id;
    }




    public void setId(int id) {
        this.id = id;
    }




    @Override
    public int compareTo(Task o) {
        // TODO Auto-generated method stub
        return this.id-o.id;
    }
        
    
    
    
}
