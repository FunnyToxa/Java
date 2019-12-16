import com.sun.xml.internal.ws.api.message.ExceptionHasMessage;

import java.util.function.DoubleToIntFunction;

public class Calculator implements ICalculator {
	private String[] history = new String[10];
	private int historyPos = 0;

	// рассчет выражения
	@Override
	public void calculate(String expression) {
		String[] paramsExpr = expression.split(" "); //разбиваем выражение через пробелы
		StringBuilder tmpExpr = new StringBuilder(); //временное хранилище частично пересчитанного выражения
		boolean isBeforeCalc = false; //флаг - был ли рассчет в предыдущем шаге
		String beforeCalcResult = ""; //результат предыдущего шага
		String result; //для записи в историю и вывода
		//пробегаемся по циклу и сначала считаем * и /
		try {
			for (int i = 1; i < paramsExpr.length; i += 2) {
				//Проверяем что параметры являются цифрами
//				checkNumeric(paramsExpr[i-1]);
//				checkNumeric(paramsExpr[i+1]);


				//если знак + или -, то
				if (paramsExpr[i].equals("+") || paramsExpr[i].equals("-")) {
					if (!isBeforeCalc) //если не было рассчетов в предыдущем шаге то просто берем параметр перед выражением
						beforeCalcResult = paramsExpr[i - 1];
					tmpExpr.append(beforeCalcResult + " " + paramsExpr[i] + " ");
					isBeforeCalc = false;
				} else {
					if (!isBeforeCalc)
						beforeCalcResult = paramsExpr[i - 1];
					beforeCalcResult = calcOne(Double.valueOf(beforeCalcResult), Double.valueOf(paramsExpr[i + 1]), paramsExpr[i]).toString();
					isBeforeCalc = true;
				}
			}
			if (!isBeforeCalc) {
//				checkNumeric(paramsExpr[paramsExpr.length-1]); //проверяем на число
				beforeCalcResult = paramsExpr[paramsExpr.length - 1];
			}
			tmpExpr.append(beforeCalcResult);

			//считаем новое выражение с оставшимися знаками + и -
			double resultExpr = 0;
			paramsExpr = tmpExpr.toString().trim().split(" ");
			resultExpr = Double.valueOf(paramsExpr[0]);
			for (int i = 1; i < paramsExpr.length; i += 2) {
				resultExpr = calcOne(resultExpr, Double.valueOf(paramsExpr[i + 1]), paramsExpr[i]);
			}
			result = expression + " = " + resultExpr;
//		} catch (ExpressionException e) {
//			result = expression + " = Ошибка: " + e.getMessage();
		} catch (Exception e) {
			result = expression + " = Ошибка: " + e.getMessage() ;
		}
		//добавление в историю
		addToHistory(result);

		//вывод результата
		System.out.println(result);
	}

	//проверяем является ли строка числом
//	private void checkNumeric(String str) throws ExpressionException {
//		if (str.replaceAll("\\/", "\\\\/").matches("\\D+"))
//			throw new ExpressionException("Ошибка в параметрах выражения - не являются числом!");
//	}

	//вывод истории из countLast элементов
	@Override
	public void printHistroy(int countLast){
		System.out.println("Print history last " + countLast + " elems:");
		if (countLast > historyPos)
			countLast = historyPos;
		for (int i = 0; i < countLast; i++)
			System.out.println(history[historyPos - i - 1]);
	}

	//вывод последней записи в истории
	@Override
	public void printLast(){
		printHistroy(1);
	}

	//рассчет одного выражени
	private Double calcOne(double param1, double param2, String operation)
			throws ExpressionException, ArithmeticException {
		switch(operation){
			case("+"):
				return param1 + param2;
			case("-"):
				return param1 - param2;
			case("*"):
				return param1 * param2;
			case("/"):
				if (param2 == 0)
					throw new ArithmeticException("Деление на ноль");
				return param1 / param2;
		}
		throw new ExpressionException("Неподдерживаемый оператор или ошибка в операторе!");
	}

	//добавление в историю
	private void addToHistory(String expr) {
		if (historyPos < 10) {
			history[historyPos] = expr;
			historyPos++;
		} else {
			for (int i = 1; i < history.length; i++)
				history[i - 1] = history[i];
			history[historyPos - 1] = expr;
		}
	}

	//очистка истории
	@Override
	public void clearHistory(){
		history = new String[10];
		historyPos = 0;
	}
}