import java.util.*;

public class Task2 {
    public static void main(String[] args) {
        String text = "Hello, my dear friend! What can i help you, bro?";

        Map<Character, Integer> dict = getFreqDict(text);

        System.out.println(dict);
    }

    public static Map<Character, Integer> getFreqDict (String inText){
        Map<Character, Integer> dict = new HashMap();
        char[] charsOfText = inText.toLowerCase().replaceAll("[^a-z]+", "").toCharArray();
        for(char ch: charsOfText) {
            if (dict.containsKey(ch))
                dict.put(ch, dict.get(ch) + 1);
            else
                dict.put(ch, 1);
        }
        return dict;
    }
}
