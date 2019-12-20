public class Task2 {
	public static void main(String[] args){
		Logger logger = new Logger();
//		logger.write(new Log("gggg", "testAction", "тестируем запись в лог"));
//		logger.write(new Log("testUser4", "teeeest", "tttteeeeesssst тестируем запись в лог - 2"));
		logger.printInfoByDays();
		System.out.println();
		logger.printInfoByUser("testUser");
	}
}