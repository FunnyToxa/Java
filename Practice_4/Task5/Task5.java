import java.util.*;

public class Task5 {
    public static void main(String[] args) {
        HashMap<Integer, String> inMap = new HashMap<>();
        inMap.put(1, "test1");
        inMap.put(2, "test2");
        inMap.put(3, "test3");
        inMap.put(4, "test1");
        inMap.put(5, "test99");

        Map outMap = reverseMap(inMap);
        System.out.println(outMap);
    }

    public static <K,V>Map<V, Collection<K>> reverseMap(Map<K, V> map){
        Map<V, Collection<K>> retMap = new HashMap();
        for(K k: map.keySet()){
            V newKey = map.get(k);
            if (retMap.containsKey(newKey)) {
                retMap.get(newKey).add(k);
            } else {
                ArrayList<K> newValList = new ArrayList();
                newValList.add(k);
                retMap.put(newKey, newValList);
            }
        }
        return retMap;
    }
}
