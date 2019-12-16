public interface ICalculator {
    // рассчет выражения
    void calculate(String expression);

    //вывод истории из countLast элементов
    void printHistroy(int countLast);

    //вывод последней записи в истории
    void printLast();

    //очистка истории
    void clearHistory();
}
