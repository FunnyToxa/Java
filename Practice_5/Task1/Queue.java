import java.util.NoSuchElementException;

public class Queue<T> {

    //внутренний класс узла
    private class Node{
        public T obj;
        public Node next;

        public Node(T t){
            obj = t;
        }
    }

    //последний обьект
    private Node last = null;
    //первый обьект
    private Node first = null;

    //возвращает но не удаляет элемент из начала очереди
    //если очередь пуста - возвращает null
    public T peek(){
        if (first == null)
            return null;
        else
            return first.obj;
    }

    //возвращает но не удаляет элемент из начала очереди
    //если очередь пуста - генерирует исключение NoSuchElementException
    public T element() throws NoSuchElementException {
        T t = peek();
        if (t == null)
            throw new NoSuchElementException();
        else
            return t;
    }

    //возвращает с удалением элемент из начала очереди
    //если очередь пуста - возвращает null
    public T poll(){
        T t = peek();
        if (t != null)
        {
            removeFirst();
            return t;
        }
        return null;
    }

    //возвращает с удалением элемент из начала очереди
    //если очередь пуста - генерирует исключение NoSuchElementException
    public T remove() throws NoSuchElementException {
        T t = element(); //если элемента нет то будет ошибка NoSuchElementException
        removeFirst();
        return t;
//        throw new NoSuchElementException();
    }

    //добавляет элемент в конец очереди
    //если добавление удачно - возвращает true, иначе false
    public boolean offer(T obj){
        //создаем обьект узла
        Node node = new Node(obj);
        //если нету последнего, значит элементов вообще нет, добавляем начальному и последнему созданный
        if (last == null){
            first = node;
            last = node;
            return true;
        } else { //иначе у последнего элемента указываем следующим соданный новый узел, и после делаем созданный последним
            last.next = node;
            last = node;
            return true;
        }
//        return false;
    }

    //метод удаления первого элемента
    private void removeFirst(){
        if (first != null){
            Node newFirst = first.next;
            first.next = null;
            first = newFirst;
            if (first == null)
                last = null;
        }
    }
}
