import java.util.EmptyStackException;

public class Stack<T> {

    public Node last = null;

    //внутренний класс узла
    private class Node{
        public T obj;
        public Node prev; //предыдущий елемент узла

        public Node(T t){
            obj = t;
        }
    }

    //для проверки стека на наличие елементов
    public boolean empty(){
        if (last == null)
            return true;
        return false;
    }

    //возвращает верхний елемент не удаляя его из стека
    public T peek() throws EmptyStackException {
        if (last == null)
            throw new EmptyStackException();
        return last.obj;
    }

    //возвращает верхний елемент удаляя его из стека
    public T pop() throws EmptyStackException {
        T obj = peek();
        last = last.prev;
        return obj;
    }

    //помещает елемент в вершину стека
    public void push(T elem){
        Node newNode = new Node(elem);
        newNode.prev = last;
        last = newNode;
    }

    //поиск елемента в стеке
    //возвращает количество операций pop до елемента
    //выводи -1 если элемент не найден
    public int search(T elem){
        if (empty()) //проверяем пустой ли стек
            return -1;
        int i = 1;
        Node node = last;
        while (node != null){
            T obj = node.obj;
            if (obj.equals(elem)){
                break;
            }
            node = node.prev;
            i++;
            if (node == null)
                i = -1;
        }
        return i;
    }
}
