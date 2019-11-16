public class Task6 {
	public static void main(String[] args){
		String str1 = "abbdc";
		String str2 = "ckke";
		System.out.println(getSum(str1, str2));
	}
	
	public static String getSum(String str1, String str2){
		StringBuilder tmpStr = new StringBuilder();
		
		for(char ch: (str1+str2).toCharArray()){
			if (tmpStr.indexOf(String.valueOf(ch)) < 0)
				tmpStr.append(ch);
		}
		return tmpStr.toString();
	}
}