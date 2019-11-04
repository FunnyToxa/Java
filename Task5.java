public class Task5 {
	public static void main(String[] args){
		String inS = "ACW1048576"; //ACW - 777, проверил в excel :)
		getNumeric(inS);
	}
	
	public static void getNumeric(String inStr){
		int rowNum = Integer.valueOf(inStr.replaceAll("[a-zA-Z]+", ""));
		
		char[] colChs = inStr.replaceAll("[0-9]+", "").toCharArray();
		int colNum = 0;
		for (int i = 0; i < colChs.length; i++){
			//символ A имеет код 65, поэтому при приобразовании вычитаем 64
			colNum += ((int)colChs[i] - 64) * Math.pow(26, colChs.length - i - 1); 
		}
		
		System.out.println("Row number: " + rowNum + ", Column number: " + colNum);
	}
}