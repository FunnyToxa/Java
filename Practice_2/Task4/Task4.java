public class Task4 {
	public static void main(String[] args){
		Calculator calc = new Calculator();
		calc.calculate("5 - 4");
		calc.calculate("4 + 2 / 2");
		calc.calculate("4 + 2 / 2 + 3 * 2 - 1");
		calc.calculate("5 * 3 / 2");

		//вывод из истории последне 10 выражений (выведет все что есть, если меньше)
		calc.printHistroy(10);
		//вывод из истории последнее выражение
		calc.printLast();

		System.out.println("добавляем еще в историю...");
		calc.calculate("1");
		calc.calculate("2");
		calc.calculate("3");
		calc.calculate("4");
		calc.calculate("5");
		calc.calculate("6");
		calc.calculate("7");

		//проверяем что самое первое добавленное не сохранилось
		calc.printHistroy(10);
	}
}