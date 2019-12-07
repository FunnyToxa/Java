public class Task2 {
    public static void main(String[] args) {
        Stack<Integer> intStack = new Stack<>();
        //добавляем в дочередь елемент 1
        System.out.println("push 1");
        intStack.push(1);
        //добавляем в очередь елемент 2
        System.out.println("push 2");
        intStack.push(2);
        System.out.println("push 3");
        intStack.push(3);
        try {
            //ищем елемент 1
            System.out.println("Search pos elem 1: " + intStack.search(1));
            //ищем елемент 0
            System.out.println("Search pos elem 0: " + intStack.search(0));
            //получаем  елемент без удаления
            System.out.println("peek: " + intStack.peek());
            //получаем элемент с удалением
            System.out.println("pop: " + intStack.pop());
            //получаем елементы с удалением пока не пустой стек
            while (!intStack.empty())
                System.out.println("pop: " + intStack.pop());
            //проверяем есть ли елементы
            System.out.println("Is Empty ? - " + intStack.empty());
            //пропуем получить еще раз елемент
            System.out.println("pop: " + intStack.pop());
        } catch (Exception e){
            System.out.println("Ошибка типа " + e.getClass().toString());
        }
    }
}
