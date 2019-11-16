public class Task3 {
	public static void main(String[] args){
		String inS = "Programming is the good, but something is better";
		System.out.println(inS);
		getCharStatPerebor(inS, 'o');
		getCharStat(inS, 'o');
	}
	
	//Решение с перебором
	public static void getCharStatPerebor(String inStr, char ch){
		char[] arrCh = inStr.toCharArray();
		int chCount = 0;
		StringBuilder strCntOut = new StringBuilder();
		for(int i = 0; i < arrCh.length; i++){
			if(arrCh[i] == ch){
				chCount++;
				strCntOut.append(i + " ");
			}
		}
		System.out.println("Symbol " + ch + " count in str: " + chCount);
		if (chCount > 0){
			System.out.println("Positions: " + strCntOut);
		}
	}
	
	//Решение без перебора через String.indexOf 
	public static void getCharStat(String inStr, char ch){
		int startInd = 0;
		int chCount = 0;
		StringBuilder strCntOut = new StringBuilder();
		while(true){
			int ind = inStr.indexOf(String.valueOf(ch), startInd);
			if(ind >= 0){
				chCount++;
				startInd = ind + 1;
				strCntOut.append(ind + " ");
			}
			else
			{
				break;
			}
		}
		System.out.println("Symbol " + ch + " count in str: " + chCount);
		if (chCount > 0){
			System.out.println("Positions: " + strCntOut);
		}
	}
}