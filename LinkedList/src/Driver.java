import java.util.ArrayList;
import java.util.List;

public class Driver {

    public static void main(String[] args) {
        
        List<String> list = new LinkedList<String>();
        System.out.println(list);
        System.out.println();
        
        list.add("Apples");
        System.out.println(list);
        System.out.println();
        
        list.add(0, "Oranges");
        list.add("Pineapple");
        System.out.println(list);
        System.out.println();
        
        list.add(2, "Kiwi");
        list.add("Pineapple");
        System.out.println(list);
        System.out.println();
        

        list.add(null);
        System.out.println(list);
        System.out.println();
        System.out.println(list.indexOf(null));
        
    }

}
