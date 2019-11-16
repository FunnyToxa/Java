public class Task4 {
	public static void main(String[] args){
		String inS = "5*3-2*4/4*3+2";
		calc(inS);
	}
	
	public static void calc(String str){
		System.out.print(str);
		double result = calcRecourse(str, "+");
		System.out.println(" = " + result);
	}
	
	public static double calcRecourse(String str, String operation)
	{
		if (str.indexOf(operation)>=0){
			String[] subStrs = str.split("\\"+operation);
			boolean isFirst = true;
			double result = 0;
			for(String oneStr: subStrs){
				if(isFirst){
					isFirst = false;
					result = checkZnak(oneStr, operation);
				} else {
					result = calcOne(result, checkZnak(oneStr, operation), operation);
				}
			}
			return result;
		} else {
			return checkZnak(str, operation);
		}
	}
	
	public static double checkZnak(String str, String operation){
		switch(operation){
			case("+"):
				return calcRecourse(str, "-");
			case("-"):
				return calcRecourse(str, "*");
			case("*"):
				return calcRecourse(str, "/");
			case("/"):
				return Double.valueOf(str);
			default:
				return 0;
		}		
	}
	
	public static double calcOne(double param1, double param2, String operation){
		
		switch(operation){
			case("+"):
				return param1 + param2;
			case("-"):
				return param1 - param2;
			case("*"):
				return param1 * param2;
			case("/"):
				return param1 / param2;
			default:
				return 0;
		}		
	}
}