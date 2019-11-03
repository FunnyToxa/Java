public class Task1 {
	public static void main(String[] args){
		String[] inStr = {"Z11-100", "Z12-150", "Z13-120", "Z11-80", "Z12-50", "Z13-40", "Z11-200", "Z12-0", "Z13-10", "Z11-170"};
		getGSMStat(inStr);
	}
	
	public static void getGSMStat(String[] params){
		double sumZ11, sumZ12, sumZ13;
		sumZ11 = sumZ12 = sumZ13 = 0;
		for(String param: params){
			String[] arrP = param.split("-");
			int probeg = Integer.parseInt(arrP[1]);
			switch(arrP[0]){
				case ("Z11"): 
					sumZ11+=getSum(probeg, 46.10, 12.5);
					break;
				case ("Z12"):
					sumZ12+=getSum(probeg, 47.50, 12);				
					break;
				case ("Z13"):
					sumZ13+=getSum(probeg, 48.90, 11.5);
					break;
			}
		}
		
		System.out.println(sumZ11 + " " + sumZ12 + " " + sumZ13);
		
		System.out.println("Sum: " + (sumZ11+sumZ12+sumZ13));
		if (sumZ11 > sumZ12 && sumZ11 > sumZ13)
			System.out.println("Max sum - Z11:" + sumZ11);
		else if(sumZ12 >sumZ11 && sumZ12 > sumZ13)
			System.out.println("Max sum - Z12:" + sumZ12);
		else
			System.out.println("Max sum - Z13:" + sumZ13);
			
	}
	
	public static double getSum(int prob, double pr, double rash){
			if (prob == 0) 
				return 0;
			else
				return prob * pr * rash;
	}
}


