import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

public class Task3 {
    public static void main(String[] args) {
        Integer[] integers = {11,3,2,2,5,6,1,2,7,8,8,9,9,9,9};
        ArrayList<Integer> intList = new ArrayList();
        for (Integer integer: integers){
            intList.add(integer);
        }

        Collection<Integer> coll = removeDuplicates(intList);
        System.out.println(coll);
    }

    public static <T>Collection<T> removeDuplicates(Collection<T> collection){
        return new HashSet<T>(collection);
    }
}
