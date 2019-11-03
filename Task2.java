public class Task2 {
	public static void main(String[] args){
		String inS = "Programming is the good, but something is better";
		System.out.println(inS);
		reverse(inS);
	}
	
	public static void reverse(String inStr){
		String[] words = inStr.replaceAll(", ", " ,").split(" ");
		String[] newWords = new String[words.length];
		for(int i = words.length-1; i >=0; i--){
			if (words[i].startsWith(","))
				words[i] = words[i].substring(1) + ",";
			newWords[words.length-1-i] = words[i];
		}
		System.out.println(String.join(" ", newWords));
	}
}