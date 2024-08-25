import allclasses.Course;
import allclasses.FileManagement;
//import allclasses.Pickle;
import java.util.Scanner;
import java.util.HashMap;

public class Main {
    static int cindex = 0;
    public static Course allcourses[] = new Course[1];
    static HashMap<String, Course> allc = new HashMap<>();
    private static FileManagement fm = new FileManagement();

    private static String createId(){
        return "C0";
    }
    private static String addCourse(String name, String teacher){
        String id = createId();
        allc.put(id, new Course(id, name, teacher));
        return id;
    }
    public static void main(String[] args) {
        // yes we starting new project =(
        fm.writeData("DATA trust");
        addCourse("robotics", "nice guy");
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter ID to check: ");
        String _id =  reader.nextLine();

        try {
            String _n = allc.get(_id).getName();
            String _t = allc.get(_id).getT();
            System.out.println(_n + ":" + _t);
        } catch(Exception e) {
            System.out.println(e + ": went wrong");
        }
        

        for (String key : allc.keySet()){
            System.out.println(allc.get(key).getName());
        }
        reader.close();
    }
}