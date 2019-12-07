public class Task1 {
    public static void main(String[] args) {
        Queue<Integer> intQueue = new Queue<>();
        //добавляем в дочередь елемент 1
        System.out.println("offer 1");
        intQueue.offer(1);
        //добавляем в очередь елемент 2
        System.out.println("offer 2");
        intQueue.offer(2);
        try {
            //получаем первый элемент в очереди без удаления
            System.out.println("peek: " + intQueue.peek());
            System.out.println("element: " + intQueue.element());
            //получаем первый элемент в очереди с удалением
            System.out.println("poll: " + intQueue.poll());
            System.out.println("remove: " + intQueue.remove());
            //т.к. обьектов не должно остаться - здесь должен быть Null
            System.out.println("peek: " + intQueue.peek());
            //добавляем в очередь елемент 3
            System.out.println("offer 3");
            intQueue.offer(3);
            //получаем с удалением элемент из очереди с удалением
            System.out.println("element: " + intQueue.element()); //должно быть 3
            System.out.println("poll: " + intQueue.poll()); //должно быть Null
            System.out.println("remove: " + intQueue.remove()); //ошибка
        } catch (Exception e){
            System.out.println("Ошибка типа " + e.getClass().toString());
        }
    }
}
