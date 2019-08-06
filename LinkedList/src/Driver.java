import java.util.ArrayList;
import java.util.List;

public class Driver {

    public static void main(String[] args) {
        
        List<String> list = new LinkedList<String>();
        
        list.add("harry");
        list.add("ron");
        list.add("hermonie");
        list.add("ginny");
        list.add("harry");
        list.add("neville");
        list.add("sirus");
        list.add("ginny");
        System.out.println(list);
        System.out.println(list.lastIndexOf("harry"));
        
    }

}
