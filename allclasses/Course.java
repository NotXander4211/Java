package allclasses;


public class Course {
    String id;
    String name;
    String teacher;
    public Course(String id, String name, String teacher){
        this.id = id;
        this.name = name;
        this.teacher = teacher;
    }

    public static void main(String[] args) {
        System.out.println("COURSE");
    }
    public String getName(){
        return this.name;
    }
    public String getT(){
        return this.teacher;
    }
}