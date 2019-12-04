public class Calculator implements ICalculator {
	private String[] history = new String[10];
	private int historyPos = 0;

	// рассчет выражения
	@Override
	public void calculate(String expression){
		String[] paramsExpr = expression.split(" ");
		//считаем * и / т.к. данные знаки имеют высший приоритет
		StringBuilder tmpExpr = new StringBuilder();
		boolean isBeforeCalc = false;
		String beforeCalcResult = "";
		for (int i = 1; i < paramsExpr.length; i += 2) {
			if (paramsExpr[i].equals("+") || paramsExpr[i].equals("-")){
				if (!isBeforeCalc)
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
		if (!isBeforeCalc)
			beforeCalcResult = paramsExpr[paramsExpr.length - 1];
		tmpExpr.append(beforeCalcResult);

		//считаем новое выражение с оставшимися знаками + и -
		double resultExpr = 0;
		paramsExpr = tmpExpr.toString().trim().split(" ");
		resultExpr = Double.valueOf(paramsExpr[0]);
		for (int i = 1; i < paramsExpr.length; i += 2){
			resultExpr = calcOne(resultExpr, Double.valueOf(paramsExpr[i + 1]), paramsExpr[i]);
		}

		//добавление в историю
		String result = expression + " = " + resultExpr;
		addToHistory(result);

		//вывод результата
		System.out.println(result);
	}

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
	private Double calcOne(double param1, double param2, String operation){
		switch(operation){
			case("+"):
				return param1 + param2;
			case("-"):
				return param1 - param2;
			case("*"):
				return param1 * param2;
			case("/"):
				return param1 / param2;
		}
		return 0.0;
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